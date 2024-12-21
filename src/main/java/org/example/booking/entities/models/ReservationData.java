package org.example.booking.entities.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationData {

    private Usuario user;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer numberOfAdults;
    private Integer numberOfChildren;
    private Integer numberOfRooms;
    private String roomType;
    private String hotelName;
    private LocalTime estimatedArrivalTime;
    private Room reservedRoom;
    private Hotel hotel;


    protected ReservationData() {
    }

    public ReservationData(Usuario user, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren, Integer numberOfRooms, String roomType, LocalTime estimatedArrivalTime, String hotelName, Room reservedRoom, Hotel hotel) {
        this.user = user;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.hotelName = hotelName;
        this.reservedRoom = reservedRoom;
        this.hotel = hotel;
    }

}

