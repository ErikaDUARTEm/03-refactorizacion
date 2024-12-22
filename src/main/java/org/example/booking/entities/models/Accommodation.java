package org.example.booking.entities.models;

import java.util.List;

public abstract class Accommodation {

    private String type;
    private String name;
    private String city;
    private String description;
    private Double rating;
    private Double price;
    private List<Room> availableRooms;


    public Accommodation(
            String type,
            String name,
            String city,
            String description,
            Double rating,
            Double price,
            List<Room> availableRooms)

    {
        this.type = type;
        this.name = name;
        this.city = city;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.availableRooms = availableRooms;
    }
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

    public String getType() {return type; }
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public Double getRating() {
        return rating;
    }

    public Double getPrice() {
        return price;
    }

    public List<Room> getAvailableRooms() {
        return availableRooms;
    }

}





