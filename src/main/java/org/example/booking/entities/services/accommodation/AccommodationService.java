package org.example.booking.entities.services.accommodation;

import org.example.booking.entities.models.Accommodation;
import org.example.booking.entities.models.Apartament;
import org.example.booking.entities.models.Finca;
import org.example.booking.entities.models.Hotel;
import org.example.booking.entities.services.interfaces.IAccommodationService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class AccommodationService implements IAccommodationService {

  public AccommodationService() {
  }
  public Boolean isValidAccommodationType(String typeAccommodation) {
    return typeAccommodation != null
      && !typeAccommodation.trim().isEmpty()
      && ("Hotel".equalsIgnoreCase(typeAccommodation.trim())
      || "Apartamento".equalsIgnoreCase(typeAccommodation.trim())
      || "Finca".equalsIgnoreCase(typeAccommodation.trim()));
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
  public <T extends Accommodation> void handleAccommodationType(List<Object> listAll, Class<T> accommodationClass) {
    listAll.stream()
      .filter(accommodationClass::isInstance)
      .map(accommodationClass::cast)
      .forEach(accommodation -> System.out.println(accommodation.viewAccommodation()));
  }
  public void allApartaments(List<Object> listAll) {
    handleAccommodationType(listAll, Apartament.class);
  }

  public void allFincas(List<Object> listAll) {
    handleAccommodationType(listAll, Finca.class);
  }

  public void allHotels(List<Object> listAll) {
    handleAccommodationType(listAll, Hotel.class);
  }

  public void displaySunnyDayHotels(String availabilityRequest, List<Object> listAll) {
    System.out.println("Hoteles con Día de Sol disponibles:");

    if (isValidAccommodationType(availabilityRequest)) {
      findAccomodationType(availabilityRequest, listAll).stream()
        .filter(hotel -> hotel instanceof Hotel)
        .forEach(hotel -> System.out.printf(
          "Nombre: %s%nDescripción: %s%nActividades: %s%n",
          ((Hotel) hotel).getName(),
          ((Hotel) hotel).getDescription(),
          ((Hotel) hotel).getSunnyDay().toString()
        ));
    } else {
      System.out.println("Tipo de alojamiento inválido.");
    }
  }

  @Override
  public List<Object> findAccomodationType(String accommodationType, List<Object> listAll) {
    return listAll.stream()
      .filter(obj -> obj.getClass().getSimpleName().equalsIgnoreCase(accommodationType))
      .collect(Collectors.toList());
  }

  public Integer calculateDays(LocalDate startDate, LocalDate endDate) {
    return (int) ChronoUnit.DAYS.between(startDate, endDate);
  }

  public Double calculatePriceAdjustment(LocalDate availableCheckInDate, LocalDate availableCheckOutDate, Double totalPrice) {
    int startDay = availableCheckInDate.getDayOfMonth();
    int endDay = availableCheckOutDate.getDayOfMonth();

    Double adjustment;
    if (startDay >= 26) {

      adjustment = totalPrice * 1.15;
    } else if (startDay >= 10 && endDay <= 15) {
      adjustment = totalPrice * 1.10;
    } else if (startDay >= 5 && endDay <= 10) {
      adjustment = totalPrice * 0.92;
    } else {
      adjustment = totalPrice;
    }

    return adjustment;
  }


}
