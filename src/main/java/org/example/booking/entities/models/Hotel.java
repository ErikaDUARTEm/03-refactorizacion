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
            if (this.getSunnyDay() != null) {
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
                  this.getRating(),
                  this.getPrice(),
                  this.getAvailableRooms().size(),
                  roomsDetails(this.getAvailableRooms())
                );
            } else {
                return String.format(
                  """
                  🌞🌞🌞*************************************************************
                  ***           Hoteles con Día de Sol disponibles          ***
                  *************************************************************
              
                  Nombre:                 %s
                  Ciudad:                 %s
                  Descripción:            %s
                   Calificación:         %.1f
                  💲 Precio por noche:    $%.2f
                  🌴 Día de Sol incluye:  %s
              
                  *************************************************************
                  """,
                  this.getName(),
                  this.getCity(),
                  this.getDescription(),
                  this.getRating(),
                  this.getPrice(),
                  this.getSunnyDay()
                );
            }

    }

    public SunnyDay getSunnyDay() {
        return sunnyDay;
    }

}
