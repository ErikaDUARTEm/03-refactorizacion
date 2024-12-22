package org.example.booking.entities.models;

import org.example.booking.entities.services.accommodation.AccommodationService;
import org.example.booking.entities.services.interfaces.IConfirmAvailability;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConfirmAvailability implements IConfirmAvailability {
  private final AccommodationService accommodationService;

  public ConfirmAvailability(AccommodationService accommodationService) {
    this.accommodationService = accommodationService;
  }
  @Override
  public List<String> confirmAvailableRooms(List<Object> listAll, AvailabilityRequest availabilityRequest) {
    List<String> availableRooms = new ArrayList<>();
    String typeAccommodation = availabilityRequest.getAccommodationType();

    if (accommodationService.isValidAccommodationType(typeAccommodation)) {
      System.out.println("true");
      List<Object> accommodations = accommodationService.findAccomodationType(typeAccommodation, listAll);
      for (Object accommodation : accommodations) {
        processAccommodation(accommodation, availabilityRequest, availableRooms);
      }
    } else {
      System.out.println("Tipo de alojamiento inválido o vacío.");
    }
    return availableRooms;
  }

  private void processAccommodation(Object accommodation, AvailabilityRequest availabilityRequest, List<String> availableRooms) {
    if (accommodation instanceof Accommodation validAccommodation) {
      boolean hasAvailableRoom = validAccommodation.getAvailableRooms().stream()
        .anyMatch(room -> isRoomAvailable(room, availabilityRequest));

      if (hasAvailableRoom) {
        addAccommodationIfValid(validAccommodation, availableRooms, availabilityRequest);
      }
    } else {
      System.out.println("Alojamiento no encontrado o tipo no válido.");
    }
  }



  private Boolean isRoomAvailable(Room room, AvailabilityRequest availabilityRequest) {
    int totalCapacity = (room.getAdultsCapacity() + room.getChildrenCapacity()) * room.getQuantity();
    boolean isDateAvailable = isAvailableDate(
      availabilityRequest.getCheckInDate(),
      availabilityRequest.getCheckOutDate(),
      room.getAvailableFrom(),
      room.getAvailableTo()
    );
    return totalCapacity >= (availabilityRequest.getNumberOfAdults() + availabilityRequest.getNumberOfChildren())
      && isDateAvailable;
  }

  private Boolean isAvailableDate(LocalDate startDate, LocalDate endDate, LocalDate roomAvailableFrom, LocalDate roomAvailableTo) {

    return (startDate.isAfter(roomAvailableFrom) || startDate.isEqual(roomAvailableFrom)) &&
      (endDate.isBefore(roomAvailableTo) || endDate.isEqual(roomAvailableTo));
  }


  private void addAccommodationIfValid(Object accommodation, List<String> availableRooms, AvailabilityRequest availabilityRequest) {
    if (accommodation instanceof Hotel || accommodation instanceof Apartament || accommodation instanceof Finca) {
      Accommodation validAccommodation = (Accommodation) accommodation;

      Double totalPrice = calculateTotalPrice(validAccommodation, availabilityRequest);
      Double adjustedPrice = accommodationService.calculatePriceAdjustment(
        availabilityRequest.getCheckInDate(),
        availabilityRequest.getCheckOutDate(),
        totalPrice
      );
      String view = formatAccommodationInfo(validAccommodation, totalPrice, adjustedPrice);
      availableRooms.add(view);
    } else {
      System.out.println("El objeto no es un tipo válido de Alojamiento.");
    }
  }

  private Double calculateTotalPrice(Accommodation accommodation, AvailabilityRequest availabilityRequest) {
    double totalPrice =0.0;
    int days = accommodationService.calculateDays(
      availabilityRequest.getCheckInDate(),
      availabilityRequest.getCheckOutDate()
    );
    Integer numberOfRooms = availabilityRequest.getNumberOfRooms();
    for (Room room : accommodation.getAvailableRooms()) {
      boolean isRoomAvailable = isRoomAvailable(room, availabilityRequest);
      if (isRoomAvailable) {
        totalPrice += room.getPrice() * days * numberOfRooms;
        break;
      }
    }
    return totalPrice;
  }

  private String formatAccommodationInfo(Accommodation accommodation, Double totalPrice, Double adjustedPrice) {
    return "************** Hoteles disponibles **********************\n" +
      "Nombre: " + accommodation.getName() + ", " +
      "Calificación: " + accommodation.getRating() + ", " +
      "Precio por noche: " + accommodation.getprice() + ", " +
      "Precio total: " + totalPrice + "\n" +
      "Precio Ajustado: " + adjustedPrice + "\n" +
      "****************************************************";
  }


}

