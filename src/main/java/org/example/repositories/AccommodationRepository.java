package org.example.repositories;

import org.example.models.Accommodation;
import org.example.models.Apartament;
import org.example.models.Finca;
import org.example.models.Hotel;
import org.example.models.Room;
import org.example.models.SunnyDay;
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

    SunnyDay sunnyDay2 = new SunnyDay(50.0, "Acceso por un día con servicios básicos y acceso a áreas comunes.");
    LinkedList<Room> habitacionesHotel1 = new LinkedList<>();
    habitacionesHotel1.add(new Room("Habitación sencilla", "Cama individual, aire acondicionado, baño privado", 1, 0 ,50.0, 5, true));
    habitacionesHotel1.add(new Room("Habitación doble", "2 camas dobles, vista a la piscina, aire acondicionado, baño privado", 2, 2 ,60.0, 5, true));
    habitacionesHotel1.add(new Room("Habitación cuádruple", "4 camas, vista al jardín, aire acondicionado, baño privado, minibar", 4, 2 ,80.0, 2, false));
    habitacionesHotel1.add(new Room("Habitación familiar", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 4, 2 ,100.0, 3, false));
    habitacionesHotel1.add(new Room("Suite", "Cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2 ,150.0, 3, false));
    Hotel hotel1 = new Hotel("Hotel","Hotel Castillo Resort", "san gil", "Hotel Castillo Resort se encuentra en San Gil...",4.5, sunnyDay2, habitacionesHotel1);

    SunnyDay sunnyDay3 = new SunnyDay( 50.0, "Acceso por un día con servicios básicos y acceso a áreas comunes.");
    LinkedList<Room> habitacionesHotel2 = new LinkedList<>();
    habitacionesHotel2.add(new Room("Habitación sencilla", "Cama individual, baño privado, aire acondicionado", 1, 2 ,100.0, 3, true));
    habitacionesHotel2.add(new Room("Habitación doble", "2 camas dobles, vista al jardín, aire acondicionado, baño privado", 2, 2 ,100.0, 3, true));
    habitacionesHotel2.add(new Room("Habitación cuádruple", "4 camas, aire acondicionado, baño privado, minibar", 4, 2 ,100.0, 3, true));
    habitacionesHotel2.add(new Room("Habitación familiar", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 4, 2, 180.0, 2, false));
    habitacionesHotel2.add(new Room("Suite", "Cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2 ,100.0, 3, true));
    Hotel hotel2 = new Hotel("Hotel", "Meson del Cuchicute", "San Gil", "60 confortables habitaciones.",4.3, sunnyDay3, habitacionesHotel2);

    SunnyDay sunnyDay4 = new SunnyDay(50.0, "Acceso por un día con servicios básicos y acceso a áreas comunes.");
    LinkedList<Room> habitacionesHotel3 = new LinkedList<>();
    habitacionesHotel3.add( new Room("colonial room", "decoración colonial, cama queen size", 2, 0, 80.0, 5, true));
    habitacionesHotel3.add(new Room("suite colonial", "cama king size, balcón, baño con jacuzzi", 2, 0, 150.0, 2, true));
    habitacionesHotel3.add(new Room("Habitación cuádruple", "4 camas, aire acondicionado, baño privado, minibar", 4, 2 ,100.0, 3, false));
    habitacionesHotel3.add(new Room("Habitación familiar", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 4, 2, 180.0, 2, false));
    habitacionesHotel3.add(new Room("Suite", "Cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2 ,100.0, 3, true));
    Hotel hotel3 = new Hotel("Hotel", "Posada del Campanario", "san gil","Ubicado en el corazón de San Gil, ofrece una experiencia colonial con todas las comodidades modernas.",4.7, sunnyDay4, habitacionesHotel2);

    SunnyDay sunnyDay1 = new SunnyDay( 30.0,"Acceso por un día con servicios básicos y acceso a áreas comunes.");
    LinkedList<Room> habitacionesHotel4 = new LinkedList<>();
    habitacionesHotel3.add( new Room("colonial room", "decoración colonial, cama queen size", 2, 0, 80.0, 5, true));
    habitacionesHotel3.add(new Room("suite colonial", "cama king size, balcón, baño con jacuzzi", 2, 0, 150.0, 2, true));
    habitacionesHotel3.add(new Room("Habitación cuádruple", "4 camas, aire acondicionado, baño privado, minibar", 4, 2 ,100.0, 3, false));
    habitacionesHotel3.add(new Room("Habitación familiar", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 4, 2, 180.0, 2, false));
    habitacionesHotel3.add(new Room("Suite", "Cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2 ,100.0, 3, true));
    Hotel hotel4 = new Hotel("Hotel", "Hotel Oviedo real", "bucaramanga","Ubicado en el corazón de bucaramanga, ofrece una experiencia colonial con todas las comodidades modernas.",4.7,  sunnyDay1, habitacionesHotel2);


    listAccommodation.add(hotel1);
    listAccommodation.add(hotel2);
    listAccommodation.add(hotel3);
    listAccommodation.add(hotel4);


    // CREACIÓN DE APARTAMENTOS

    Apartament apartamento1 = new Apartament("Apartamento", "San Gil Natural", "San Gil",  "San Gil Natural ofrece un entorno tranquilo", 4.5, 300.0, 3);
    Apartament apartamento2 = new Apartament("Apartamento", "Puente de la Villa", "san gil", "Puente de la Villa ofrece apartamentos modernos con vistas al puente y la ciudad desde sus balcones.", 4.6, 310.0, 4);

    listAccommodation.add(apartamento1);
    listAccommodation.add(apartamento2);


    // CREACIÓN DE FINCAS

    Finca finca1 = new Finca("Finca", "Finca Sol y Luna", "San Gil", "Finca se encuentra en San Gil...", 4.3, 520.0, 6);
    Finca finca2 = new Finca("Finca", "Finca La Salvación", "san gil", "Finca se encuentra en San Gil...", 4.1, 410.0, 10);

    listAccommodation.add(finca1);
    listAccommodation.add(finca2);

  }
}
