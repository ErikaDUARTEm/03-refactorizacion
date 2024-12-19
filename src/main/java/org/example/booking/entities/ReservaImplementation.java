package org.example.booking.entities;

import java.time.LocalDate;
import java.util.List;


public class ReservaImplementation implements Ireserva{
    AccommodationData accommodationData = new AccommodationData();


    @Override
    public List<String> confirmAvailableRooms(String accommodationName, String accommodationType, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren, Integer numberOfRooms) {
      return List.of();
    }

    @Override
    public String reserve(Usuario user, String estimatedArrivalTime, String accommodationName, String accommodationType, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren, Integer numberOfRooms, String roomType) {
        return "";
    }
}
