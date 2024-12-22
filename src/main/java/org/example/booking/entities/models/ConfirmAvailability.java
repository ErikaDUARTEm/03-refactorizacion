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
    List<String> availableRooms = new ArrayList<>();
    String typeAccommodation = availabilityRequest.getAccommodationType();

    if (accommodationService.isValidAccommodationType(typeAccommodation)) {
      Object accommodation = accommodationService.findAccomodationType(typeAccommodation, listAll);
      processAccommodation(accommodation, availabilityRequest, availableRooms);
    } else {
      System.out.println("Tipo de alojamiento inválido o vacío.");
    }
    return availableRooms;
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

  private Boolean isRoomAvailable(Object alojamiento, AvailabilityRequest availabilityRequest) {
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



}

