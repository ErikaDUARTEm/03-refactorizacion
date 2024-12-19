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
        String fincaDetails = String.format(
                "************** Fincas disponibles **********************%n" +
                        "Nombre: %s%n" +
                        "Ciudad: %s%n" +
                        "Calificación: %.1f%n" +
                        "Precio por noche: $%.2f%n" +
                        "Precio total: $%.2f%n" +
                        "Detalles del apartamento: %d habitaciones disponibles%n" +
                        "****************** Paquetes Disponibles ***********************%n",
                this.getName(),
                this.getCity(),
                this.getRating(),
                this.getAvailableRooms().size()
        );

        fincaDetails += "**************************************************************";

        return fincaDetails;
    }

    public static Finca createFinca(
            String name,
            String city,
            String description,
            double rating,
            double basePrice,
            int availableCheckInDate,
            int availableCheckOutDate,
            int totalRooms,
            List<Room> rooms,
            List<StayPackage> packages
    ) {
        return new Finca(
                "finca",
                name,
                city,
                description,
                rating,
                basePrice,
                availableCheckInDate,
                availableCheckOutDate,
                totalRooms,
                rooms,
                packages
        );
    }
}
