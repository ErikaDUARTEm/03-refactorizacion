package org.example.booking.entities.utils;

import org.example.booking.entities.models.AvailabilityRequest;
import org.example.booking.entities.models.ConfirmAvailability;
import org.example.booking.entities.services.accommodation.AccommodationService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Menu {
  private ConsoleUtils console;
  private AccommodationService accommodationService;
  private ConfirmAvailability confirmAvailability;

  public Menu(ConsoleUtils console, AccommodationService accommodationService, ConfirmAvailability confirmAvailability) {
    this.console = console;
    this.accommodationService = accommodationService;
    this.confirmAvailability = confirmAvailability;
  }

  public Menu(ConsoleUtils console) {
  }

  public void viewMenuMain() {
    System.out.println("********************************");
    System.out.println("1. Listar Alojamientos.");
    System.out.println("2. Consultar disponibilidad por tipo de alojamiento.");
    System.out.println("3. Confirmar Habitaciones.");
    System.out.println("4. Hacer Reserva.");
    System.out.println("0. Salir.");
    System.out.println("********************************");
  }
  public AvailabilityRequest menuTypeAccommodation(ConsoleUtils console) {
    Integer option = getOptionFromConsole(console);
    String typeAccommodation = getAccommodationType(option);
    if (accommodationService.isValidAccommodationType(typeAccommodation)) {

      return new AvailabilityRequest(typeAccommodation);
    } else {
      System.out.println("Tipo de alojamiento inválido o vacío.");
      return null;
    }
  }

  private Integer getOptionFromConsole(ConsoleUtils console) {
    return console.getInteger("Selecciona un tipo de alojamiento:\n" +
      "1. Hotel\n" +
      "2. Apartamento\n" +
      "3. Finca");
  }

  private String getAccommodationType(Integer option) {
    Map<Integer, String> accommodationTypes = Map.of(
      1, "Hotel",
      2, "Apartamento",
      3, "Finca"
    );
    return accommodationTypes.get(option);
  }
  public void handleAccommodationOptions(ConsoleUtils console, List<Object> listAll, AvailabilityRequest availabilityRequest) {
    String accommodationType = availabilityRequest.getAccommodationType();
    System.out.println("Selecciona una opción:");

    if ("Hotel".equalsIgnoreCase(accommodationType)) {
      System.out.println("1. Estadía por noche");
      System.out.println("2. Día de sol");
      int option = console.getInteger("Ingresa el número de tu elección:");

      switch (option) {
        case 1 -> accommodationService.allHotels(listAll);
        case 2 -> accommodationService.displaySunnyDayHotels(accommodationType, listAll);
        default -> System.out.println("Opción inválida.");
      }
    } else if ("Apartamento".equalsIgnoreCase(accommodationType)){
      accommodationService.allApartaments(listAll);
    } else if ("Finca".equalsIgnoreCase(accommodationType)) {
      accommodationService.allFincas(listAll);
    } else {
      System.out.println("Tipo de alojamiento inválido.");
    }
  }
  public AvailabilityRequest menuConfirm(ConsoleUtils console){
    System.out.println("********************************");
    System.out.println("Para ver la disponibilidad de hoteles ingresa los siguientes datos:");
    String city = console.getString("Ciudad:").toLowerCase().trim();
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
