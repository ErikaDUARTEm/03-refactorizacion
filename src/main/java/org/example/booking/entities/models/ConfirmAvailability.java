package org.example.booking.entities.models;

import org.example.booking.entities.services.accommodation.AccommodationService;
import org.example.booking.entities.services.interfaces.IConfirmAvailability;

import java.util.ArrayList;
import java.util.List;

public class ConfirmAvailability implements IConfirmAvailability {
  private final AccommodationService accommodationService;

  public ConfirmAvailability(AccommodationService accommodationService) {
    this.accommodationService = accommodationService;
  }
  @Override
  public List<String> confirmAvailableRooms(List<Object> listAll, AvailabilityRequest availabilityRequest) {
    if (!accommodationService.isValidAccommodationType(availabilityRequest.getAccommodationType())) {
      System.out.println("Tipo de alojamiento inválido o vacío.");
      return new ArrayList<>();
    }
    return getAvailableRooms(listAll, availabilityRequest);
  }

  private List<String> getAvailableRooms(List<Object> listAll, AvailabilityRequest availabilityRequest) {
    List<String> availableRooms = new ArrayList<>();
    List<Object> accommodations = accommodationService.findAccomodationType(availabilityRequest.getAccommodationType(), listAll);
    for (Object accommodation : accommodations) {
      processAccommodation(accommodation, availabilityRequest, availableRooms);
    }
    return availableRooms;
  }

  private void processAccommodation(Object accommodation, AvailabilityRequest availabilityRequest, List<String> availableRooms) {
    if (accommodation instanceof Accommodation validAccommodation) {
      if (hasAvailableRoom(validAccommodation, availabilityRequest)) {
        addAccommodationIfValid(validAccommodation, availableRooms, availabilityRequest);
      }
    } else {
      System.out.println("Alojamiento no encontrado o tipo no válido.");
    }
  }

  private Boolean hasAvailableRoom(Accommodation accommodation, AvailabilityRequest request) {
    return accommodation.getAvailableRooms().stream()
      .anyMatch(room -> isRoomAvailable(room, request));
  }

  private boolean isRoomAvailable(Room room, AvailabilityRequest request) {
    int requiredCapacity = request.getNumberOfAdults() + request.getNumberOfChildren();
    return hasSufficientCapacity(room, requiredCapacity) && isAvailableDate(room, request);
  }

  private boolean hasSufficientCapacity(Room room, int requiredCapacity) {
    int totalCapacity = (room.getAdultsCapacity() + room.getChildrenCapacity()) * room.getQuantity();
    return totalCapacity >= requiredCapacity;
  }

  private boolean isAvailableDate(Room room, AvailabilityRequest availabilityRequest) {
    return !availabilityRequest.getCheckInDate().isBefore(room.getAvailableFrom()) &&
      !availabilityRequest.getCheckOutDate().isAfter(room.getAvailableTo());
  }
  private void addAccommodationIfValid(Accommodation accommodation, List<String> availableRooms, AvailabilityRequest availabilityRequest) {
    if (accommodation instanceof Apartament || accommodation instanceof Finca) {
      showAccommodationsOtherHotels(accommodation, availableRooms, availabilityRequest);
    } else {
      Double totalPrice = calculateTotalPrice(accommodation, availabilityRequest);
      Double adjustedPrice = accommodationService.calculatePriceAdjustment(
        availabilityRequest.getCheckInDate(),
        availabilityRequest.getCheckOutDate(),
        totalPrice
      );
      String view = formatAccommodationInfo(accommodation, availabilityRequest, totalPrice, adjustedPrice);
      availableRooms.add(view);
    }
  }

  private Double calculateTotalPrice(Accommodation accommodation, AvailabilityRequest availabilityRequest) {
    int days = accommodationService.calculateDays(availabilityRequest.getCheckInDate(),availabilityRequest.getCheckOutDate());
    int numberOfRooms = availabilityRequest.getNumberOfRooms();
    return accommodation.getAvailableRooms().stream()
      .filter(room -> isRoomAvailable(room, availabilityRequest))
      .map(room -> room.getPrice() * days * numberOfRooms)
      .findFirst()
      .orElse(0.0);
  }

  private String formatAccommodationInfo(Accommodation accommodation, AvailabilityRequest availabilityRequest, Double totalPrice, Double adjustedPrice) {
    List<String> availableRoomDetails = accommodation.getAvailableRooms().stream()
      .filter(room -> isRoomAvailable(room, availabilityRequest))
      .map(room -> String.format("Habitación %s, Capacidad: %d adultos, %d niños, Precio: %.2f",
        room.getName(), room.getAdultsCapacity(), room.getChildrenCapacity(), room.getPrice()))
      .toList();

    String roomsInfo = String.join("\n", availableRoomDetails);
    return String.format(
      "************** Hoteles disponibles **********************%n" +
        "Nombre: %s, Calificación: %.1f, Precio por noche: %.2f, Precio total: %.2f%n" +
        "Precio Ajustado: %.2f %n"  +
        "Habitaciones Disponibles: %s%n" +
        "****************************************************",
      accommodation.getName(),
      accommodation.getRating(),
      accommodation.getPrice(),
      totalPrice,
      adjustedPrice,
      roomsInfo
    );
  }
  private void showAccommodationsOtherHotels(Accommodation accommodation, List<String> availableRooms, AvailabilityRequest availabilityRequest) {
    Double adjustedPrice = accommodationService.calculatePriceAdjustment(
      availabilityRequest.getCheckInDate(),
      availabilityRequest.getCheckOutDate(),
      accommodation.getPrice()
    );
    String view = String.format(
      "************** Alojamiento disponible **********************%n" +
        "Nombre: %s, Calificación: %.1f, Precio total: %.2f%n" +
        "Precio Ajustado: %.2f %n" +
        "****************************************************",
      accommodation.getName(),
      accommodation.getRating(),
      accommodation.getPrice(),
      adjustedPrice
    );
    availableRooms.add(view);
  }
}

