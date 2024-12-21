package org.example.booking.entities.models;

import org.example.booking.entities.services.interfaces.IReserva;

import java.time.LocalDate;


public class ReservaImplementation implements IReserva {


   @Override
    public String reserve(Usuario user, String estimatedArrivalTime, String accommodationName, String accommodationType, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren, Integer numberOfRooms, String roomType) {
        return "";
    }



}
