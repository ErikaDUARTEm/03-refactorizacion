package org.example.booking.entities.models;

import org.example.booking.entities.services.interfaces.IConfirmAvailability;
import org.example.booking.entities.utils.ConsoleUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConfirmAvailability implements IConfirmAvailability {


  public ConfirmAvailability() {}

  @Override
  public List<String> confirmAvailableRooms(List<Object> listAll, AvailabilityRequest availabilityRequest) {
    List<String> availableRooms = new ArrayList<>();
    String typeAccommodation = availabilityRequest.getAccommodationType();

    if (isValidAccommodationType(typeAccommodation)) {
      Object accommodation = findAccommodation(typeAccommodation, listAll);
      processAccommodation(accommodation, availabilityRequest, availableRooms);
    } else {
      System.out.println("Tipo de alojamiento inválido o vacío.");
    }

    return availableRooms;
  }

  private boolean isValidAccommodationType(String typeAccommodation) {
    return typeAccommodation != null && !typeAccommodation.isEmpty();
  }

  private Object findAccommodation(String typeAccommodation, List<Object> listAll) {
    Object accommodation = findAccomodationType(typeAccommodation, listAll);
    if (accommodation == null) {
      System.out.println("Tipo de alojamiento no encontrado.");
    }
    return accommodation;
  }

  private void processAccommodation(Object accommodation, AvailabilityRequest availabilityRequest, List<String> availableRooms) {
    if (accommodation != null) {
      if (isRoomAvailable(accommodation, availabilityRequest)) {
        addAccommodationIfValid(accommodation, availableRooms);
      } else {
        System.out.println("Habitación no disponible.");
      }
    }
  }

  private void addAccommodationIfValid(Object accommodation, List<String> availableRooms) {
    if (accommodation instanceof Hotel || accommodation instanceof Apartament || accommodation instanceof Finca) {
      availableRooms.add(((Accommodation) accommodation).viewAccommodation());
    } else {
      System.out.println("El objeto no es un tipo válido de Alojamiento.");
    }
  }

  private boolean isRoomAvailable(Object alojamiento, AvailabilityRequest availabilityRequest) {
    if (alojamiento instanceof Accommodation accommodation) {
      for (Room room : accommodation.getAvailableRooms()) {
        if (room.getQuantity() > 0 &&
          room.getAdultsCapacity() >= availabilityRequest.getNumberOfAdults() &&
          room.getChildrenCapacity() >= availabilityRequest.getNumberOfChildren()) {
          return true;
        }
      }
    }
    return false;
  }
  private Object findAccomodationType(String accommodationType, List<Object> listAll) {
    return listAll.stream()
      .filter(obj -> obj.getClass().getSimpleName().equalsIgnoreCase(accommodationType))
      .findFirst()
      .orElse(null);
  }
  public void allAccommodation(List<Object> listAll){
    for (Object accommodation : listAll) {
      if (accommodation instanceof Accommodation) {
        System.out.println(((Accommodation) accommodation).viewAccommodation());
      } else {
        System.out.println("Tipo de alojamiento desconocido.");
      }
    }
  }
  public AvailabilityRequest MenuConfirm(ConsoleUtils console){
    System.out.println("********************************");
    System.out.println("Para ver la disponibilidad de hoteles ingresa los siguientes datos:");
    String city = console.getString("Ciudad:").toLowerCase();
    console.getString("");
    String typeOfAccommodation = console.getString("Tipo de alojamiento:").toLowerCase();
    String startDate = console.getString("Fecha de ingreso en formato yyyyMMdd:");
    LocalDate checkIn = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
    String endDate = console.getString("Fecha de salida en formato yyyyMMdd:");
    LocalDate checkOut = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
    Integer numbersAdults = console.getInteger("Cantidad de adultos:");
    Integer numbersChildrens = console.getInteger("Cantidad de niños:");
    Integer numberOfRooms = console.getInteger("Cantidad de habitaciones:");
    System.out.println("********************************");
    return new AvailabilityRequest(
      city, typeOfAccommodation, checkIn, checkOut, numbersAdults, numbersChildrens, numberOfRooms);
  }

}

