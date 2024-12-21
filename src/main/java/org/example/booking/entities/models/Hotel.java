package org.example.booking.entities.models;


import java.util.List;

public class Hotel extends Accommodation {

    private SunnyDay sunnyDay;

    public Hotel(String type, String name, String city, String description, Double rating, Double price, List<Room> availableRooms, SunnyDay sunnyDay) {
        super("Hotel", name, city, description, rating, price, availableRooms);
        this.sunnyDay = sunnyDay;
    }

    @Override
    public String viewAccommodation() {

        return String.format(
                "************** Detalles del Hotel **********************%n" +
                        "Nombre: %s%n" +
                        "Ciudad: %s%n" +
                        "Descripción: %s%n" +
                        "Calificación: %.1f%n" +
                        "Precio total ajustado: %.2f%n" +
                        "Habitaciones disponibles:%n",
                this.getName(),
                this.getCity(),
                this.getDescription(),
                this.getRating(),
                this.getprice()
        ) + roomsDetails(this.getAvailableRooms()) +
                "****************************************************";
    }

    public SunnyDay getSunnyDay() {
        return sunnyDay;
    }

    public void setSunnyDay(SunnyDay sunnyDay) {
        this.sunnyDay = sunnyDay;
    }
}
