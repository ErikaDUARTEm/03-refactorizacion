package org.example.repositories;

import org.example.models.Accommodation;
import org.example.models.Apartament;
import org.example.models.Finca;
import org.example.models.Hotel;
import org.example.models.Room;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccommodationRepository {

  private static AccommodationRepository instance;
  private final List<Accommodation> listAccommodation;

  private AccommodationRepository() {
    this.listAccommodation = new ArrayList<>();
    try { cargarDatos(); }
    catch (Exception e) { System.err.println("Error al cargar los datos: " + e.getMessage()); }
  }

  public static synchronized AccommodationRepository getInstance(){
    if(instance == null){
      instance = new AccommodationRepository();
    }
    return instance;
  }
  public List<Accommodation> getListAccommodation(){
    return listAccommodation;
  }

  public void cargarDatos() {
    // CREACIÓN DE HOTELES

    LinkedList<Room> habitacionesHotel1 = new LinkedList<>();
    habitacionesHotel1.add(new Room("Habitación sencilla", "Cama individual, aire acondicionado, baño privado", 1, 0 ,50.0, 5, true));
    habitacionesHotel1.add(new Room("Habitación doble", "2 camas dobles, vista a la piscina, aire acondicionado, baño privado", 2, 2 ,60.0, 5, true));
    habitacionesHotel1.add(new Room("Habitación cuádruple", "4 camas, vista al jardín, aire acondicionado, baño privado, minibar", 4, 2 ,80.0, 2, false));
    habitacionesHotel1.add(new Room("Habitación familiar", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 4, 2 ,100.0, 3, false));
    habitacionesHotel1.add(new Room("Suite", "Cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2 ,150.0, 3, false));
    Hotel hotel1 = new Hotel("Hotel","Hotel Castillo Resort", "san gil", "Hotel Castillo Resort se encuentra en San Gil...",4.5, habitacionesHotel1);

    LinkedList<Room> habitacionesHotel2 = new LinkedList<>();
    habitacionesHotel2.add(new Room("Habitación sencilla", "Cama individual, baño privado, aire acondicionado", 1, 2 ,100.0, 3, true));
    habitacionesHotel2.add(new Room("Habitación doble", "2 camas dobles, vista al jardín, aire acondicionado, baño privado", 2, 2 ,100.0, 3, true));
    habitacionesHotel2.add(new Room("Habitación cuádruple", "4 camas, aire acondicionado, baño privado, minibar", 4, 2 ,100.0, 3, true));
    habitacionesHotel2.add(new Room("Habitación familiar", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 4, 2, 180.0, 2, false));
    habitacionesHotel2.add(new Room("Suite", "Cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2 ,100.0, 3, true));
    Hotel hotel2 = new Hotel("Hotel", "Meson del Cuchicute", "San Gil", "60 confortables habitaciones.",4.3, habitacionesHotel2);

    listAccommodation.add(hotel1);
    listAccommodation.add(hotel2);

    // CREACIÓN DE APARTAMENTOS

    Apartament apartamento1 = new Apartament("Apartamento", "San Gil Natural", "San Gil",  "San Gil Natural ofrece un entorno tranquilo", 4.5, 300.0, 3);

    listAccommodation.add(apartamento1);

    // CREACIÓN DE FINCAS

    Finca finca1 = new Finca("Finca", "Finca Sol y Luna", "San Gil", "Finca se encuentra en San Gil...", 4.3, 520.0, 4);

    listAccommodation.add(finca1);
  }
}
