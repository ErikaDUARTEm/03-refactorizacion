package org.example.booking.entities.services.interfaces;

import org.example.booking.entities.models.Usuario;

import java.time.LocalDate;

public interface IReserva {

    String reserve(Usuario user, String estimatedArrivalTime, String accommodationName, String accommodationType,
                   LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren,
                   Integer numberOfRooms, String roomType);
}
