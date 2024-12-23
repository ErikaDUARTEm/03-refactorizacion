package org.example.models;

import java.util.List;

public class Finca extends Accommodation {

    private Double price;
    private Integer numberRooms;

    public Finca(
            String type,
            String name,
            String city,
            String description,
            Double rating,
            Double price,
            Integer numberRooms

    ){
            super(type, name, city, description, rating);
            this.price = price;
            this.numberRooms = numberRooms;
    };

    @Override
    public String viewAccommodation() {

        return String.format(
          """
          🌳🌳🌳*************************************************************
          ***                     Fincas Disponibles                    ***
          *************************************************************
      
           Nombre:              %s
           Ciudad:              %s
           Descripción:         %s
           Calificación:         %.1f
          💲 Precio por noche:   $%.2f
          
           Habitaciones:        %d disponibles
      
          *************************************************************
          %s
          *************************************************************
          """,
          this.getName(),
          this.getCity(),
          this.getDescription(),
          this.getRating()
        );

    }


}
