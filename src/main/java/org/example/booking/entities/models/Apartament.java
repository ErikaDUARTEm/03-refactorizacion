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
          """
          *************************************************************
          ***                 Apartamentos Disponibles                ***
          *************************************************************
      
           Nombre:              %s
           Ciudad:              %s
           Descripción:         %s
           Calificación:         %.1f
          💲 Precio por noche:    $%.2f
           Habitaciones:        %d disponibles
      
          *************************************************************
          %s
          *************************************************************
          """,
          this.getName(),
          this.getCity(),
          this.getDescription(),
          this.getRating(),
          this.getPrice(),
          this.getAvailableRooms().size(),
          roomsDetails(this.getAvailableRooms())
        );

    }

}
