package org.example.booking.entities;

import java.util.List;

public abstract class Accommodation {
    private String type;
    private String name;
    private String city;
    private String description;
    private Double rating;
    private Double adjustmentPrice;
    private List<Room> availableRooms;


    public Accommodation(
            String type,
            String name,
            String city,
            String description,
            Double rating,
            Double adjustmentPrice,
            List<Room> availableRooms)

    {
        this.type = type;
        this.name = name;
        this.city = city;
        this.description = description;
        this.rating = rating;
        this.adjustmentPrice = adjustmentPrice;
        this.availableRooms = availableRooms;
    }
/*
    public void calculateTotalPrice(double basePrice, double totalDays, int numberOfConfirmedRooms) {
        this.totalPrice = PriceCalculation.calculateTotalPrice(basePrice, totalDays, numberOfConfirmedRooms);
    }

    public void adjustTotalPrice(int availableCheckInDate, int availableCheckOutDate, double totalPrice) {
        this.adjustmentPrice = PriceCalculation.calculatePriceAdjustment(availableCheckInDate, availableCheckOutDate, totalPrice);
    }
*/
protected String roomsDetails(List<Room> rooms) {
    StringBuilder details = new StringBuilder();
    for (Room room : rooms) {
        int capacityTotal = room.getAdultsCapacity() + room.getChildrenCapacity();
        details.append(String.format(
                "  - Habitación: %s%n" +
                        "    Descripción: %s%n" +
                        "    Capacidad (adultos + niños): %d%n" +
                        "    Precio: %.2f%n",
                room.getName(),
                room.getDescription(),
                capacityTotal,
                room.getPrice()
        ));
    }

    return details.toString();

}
    public abstract String viewAccommodation();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getAdjustmentPrice() {
        return adjustmentPrice;
    }

    public void setAdjustmentPrice(Double adjustmentPrice) {
        this.adjustmentPrice = adjustmentPrice;
    }

    public List<Room> getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(List<Room> availableRooms) {
        this.availableRooms = availableRooms;
    }


}





