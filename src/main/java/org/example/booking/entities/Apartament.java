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
        String apartamentDetails = String.format(
                "************** Apartamentos disponibles **********************%n" +
                        "Nombre: %s%n" +
                        "Ciudad: %s%n" +
                        "Calificación: %.1f%n" +
                        "Detalles del apartamento: %d habitaciones disponibles%n" +
                        "****************** Paquetes Disponibles ***********************%n",
                this.getName(),
                this.getCity(),
                this.getRating(),
                this.getAvailableRooms().size()
        );

        apartamentDetails += "**************************************************************";

        return apartamentDetails;
    }
}
