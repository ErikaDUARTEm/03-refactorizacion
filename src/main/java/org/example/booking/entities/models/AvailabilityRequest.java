package org.example.booking.entities.models;

import java.time.LocalDate;

public class AvailabilityRequest {
    private String city;
    private String accommodationName;
    private String accommodationType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer numberOfAdults;
    private Integer numberOfChildren;
    private Integer numberOfRooms;
    private String estimatedArrivalTime;



    public AvailabilityRequest(String city, String accommodationType, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren, Integer numberOfRooms) {
        this.city = city;
        this.accommodationType = accommodationType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.numberOfRooms = numberOfRooms;
    }

    public AvailabilityRequest(String accommodationName, String city, String accommodationType, LocalDate checkInDate, LocalDate checkOutDate, Integer numberOfAdults, Integer numberOfChildren, Integer numberOfRooms, String estimatedArrivalTime) {
        this.accommodationName = accommodationName;
        this.city = city;
        this.accommodationType = accommodationType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.numberOfRooms = numberOfRooms;
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

  public AvailabilityRequest() {

  }

  public AvailabilityRequest(String accommodationType) {
    if (accommodationType == null || accommodationType.isEmpty()) {
      throw new IllegalArgumentException("El tipo de alojamiento no puede ser nulo o vacío.");
    }
    this.accommodationType = accommodationType;
  }

  public String getCity() {
        return city;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }
}
