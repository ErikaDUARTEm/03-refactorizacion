package org.example.booking.entities;

import java.util.List;

public class Apartament extends Accommodation{

    public Apartament(
            String type,
            String name,
            String city,
            String description,
            Double rating,
            Double adjustmentPrice,
            List<Room> availableRooms) {
        super(type, name, city, description, rating, adjustmentPrice, availableRooms);
    }

    @Override
    public String viewAccommodation() {
        return String.format(
                "************** Apartamentos disponibles **********************%n" +
                        "Nombre: %s%n" +
                        "Ciudad: %s%n" +
                        "Descripción: %s%n" +
                        "Calificación: %.1f%n" +
                        "Consta de : %d%n Habitaciones" +
                        "****************** Detalles ***********************%n",
                this.getName(),
                this.getCity(),
                this.getDescription(),
                this.getRating(),
                this.getAvailableRooms().size()
        ) + roomsDetails(this.getAvailableRooms()) +
                "**************************************************************";
    }

}
