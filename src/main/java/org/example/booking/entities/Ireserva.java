package org.example.booking.entities;

import java.time.LocalDate;
import java.util.List;

public interface Ireserva {
    List<String> confirmAvailableRooms(String accommodationName, String accommodationType, LocalDate checkInDate,
                                       LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren, Integer numberOfRooms);

    String reserve(Usuario user, String estimatedArrivalTime, String accommodationName, String accommodationType,
                   LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren,
                   Integer numberOfRooms, String roomType);
}
