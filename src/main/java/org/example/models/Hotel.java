package org.example.models;


import java.util.List;

public class Hotel extends Accommodation {

  private List<Room> availableRooms;

    public Hotel(String type, String name, String city, String description, Double rating, List<Room> availableRooms) {
        super(type, name, city, description, rating);
        this.availableRooms = availableRooms;
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
      Calificación:          %.1f
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
      this.getAvailableRooms().size(),
      roomsDetails(this.getAvailableRooms())
    );
  }

  public List<Room> getAvailableRooms() {
    return availableRooms;
  }
}
