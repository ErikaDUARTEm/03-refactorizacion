package org.example.booking.entities.models;

import java.util.List;

public class Apartament extends Accommodation {

    public Apartament(
            String type,
            String name,
            String city,
            String description,
            Double rating,
            Double price,
            List<Room> availableRooms) {
        super(type, name, city, description, rating, price, availableRooms);
    }

    @Override
    public String viewAccommodation() {
        return String.format(
                "************** Apartamentos disponibles **********************%n" +
                        "Nombre: %s%n" +
                        "Ciudad: %s%n" +
                        "Descripción: %s%n" +
                        "Calificación: %.1f%n" +
                        "Precio: %.2f%n" +
                        "Consta de : %d%n Habitaciones" +
                        "****************** Detalles ***********************%n",
                this.getName(),
                this.getCity(),
                this.getDescription(),
                this.getRating(),
                this.getprice(),
                this.getAvailableRooms().size()
        ) + roomsDetails(this.getAvailableRooms()) +
                "**************************************************************";
    }

}
