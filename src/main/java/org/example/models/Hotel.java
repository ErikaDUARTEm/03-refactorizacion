package org.example.models;


import java.util.List;

public class Hotel extends Accommodation {

    private List<Room> availityRooms;

    public Hotel(String type, String name, String city, String description, Double rating, List<Room> availityRooms) {
        super(type, name, city, description, rating);
        this.availityRooms = availityRooms;
    }

    @Override
    public String viewAccommodation() {
                return String.format(
                  """
                  *************************************************************
                  ***                      Hoteles disponibles              ***
                  *************************************************************
              
                  Nombre:                 %s
                  Ciudad:                 %s
                  Descripción:            %s
                  Calificación:         %.1f
                  💲 Precio por noche:    $%.2f
                   Número de habitaciones: %d
              
                  *************************************************************
                  Detalles de las habitaciones:
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
