package org.example;

import org.example.repositories.AccommodationRepository;
import org.example.services.accommodation.SearchAccommodation;
import org.example.services.interfaces.ICommand;
import org.example.utils.ConsoleUtils;
import org.example.utils.DataSearch;

import java.util.Map;

public class Main {
  public static void main(String[] args) {
    ConsoleUtils console = new ConsoleUtils();
    AccommodationRepository accommodationRepository = AccommodationRepository.getInstance();
    DataSearch dataSearch;



    Map<Integer, ICommand> commands = Map.of(
      1, new SearchAccommodation(accommodationRepository,console)

    );
    Integer option = console.getInteger("Bienvenid@ a booking accomodation\n¿Que deseas hacer?\n1.Buscar disponibilidad\n2.Reservar\n3.Salir ");
    do{
      commands.get(option).execute();
      console.getInteger("Bienvenid@ a booking accomodation\n¿Que deseas hacer?\n1.Buscar disponibilidad\n2.Salir ");
    }while(option != 3);

  }
}