package org.example.booking.entities;

import java.util.List;

public class Finca extends Accommodation{

    public Finca(
            String type,
            String name,
            String city,
            String description,
            Double rating,
            Double adjustmentPrice,
            List<Room> availableRooms
    ){

            super(type, name, city, description, rating, adjustmentPrice, availableRooms);
    };

    @Override
    public String viewAccommodation() {

        return String.format(
                "************** Fincas disponibles **********************%n" +
                        "Nombre: %s%n" +
                        "Ciudad: %s%n" +
                        "Descripción: %s%n" +
                        "Calificación: %.1f%n" +
                        "Precio por noche: $%.2f%n" +
                        "Detalles de la finca, consta de: %d habitaciones 1%n" +
                        "****************** Detalles ***********************%n",
                this.getName(),
                this.getCity(),
                this.getDescription(),
                this.getRating(),
                this.getAdjustmentPrice(),
                this.getAvailableRooms().size()
        ) + roomsDetails(this.getAvailableRooms()) +
                "**************************************************************";
    }


}
