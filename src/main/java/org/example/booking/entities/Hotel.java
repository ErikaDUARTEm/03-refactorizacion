package org.example.booking.entities;


import java.util.List;

public class Hotel extends Accommodation {

    private Boolean sunnyDay;

    public Hotel(String type, String name, String city, String description, Double rating, Double adjustmentPrice, List<Room> availableRooms, Boolean sunnyDay) {
        super(type, name, city, description, rating, adjustmentPrice, availableRooms);
        this.sunnyDay = sunnyDay;
    }


    @Override
    public String viewAccommodation() {
        String hotelDetails = String.format(
                "************** Detalles del Hotel **********************%n" +
                        "Nombre: %s, " +
                        "Ciudad: %s%n" +
                        "Descripción: %s%n" +
                        "Calificación: %.1f%n" +
                        "Habitaciones disponibles: %d%n",
                this.getName(),
                this.getCity(),
                this.getDescription(),
                this.getRating(),
                this.getAvailableRooms().size()
        );

        hotelDetails += "****************************************************";

        return hotelDetails;
    }

    public Boolean getSunnyDay() {
        return sunnyDay;
    }

    public void setSunnyDay(Boolean sunnyDay) {
        this.sunnyDay = sunnyDay;
    }
}
