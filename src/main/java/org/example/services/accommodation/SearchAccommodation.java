package org.example.services.accommodation;

import org.example.models.Accommodation;
import org.example.repositories.AccommodationRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.ConsoleUtils;
import org.example.utils.DataSearch;

import java.util.ArrayList;
import java.util.List;

public class SearchAccommodation implements ICommand<List<Accommodation>> {
  private final AccommodationRepository repository;
  private final ConsoleUtils console;

  public SearchAccommodation(AccommodationRepository repository, ConsoleUtils console) {
    this.repository = repository;
    this.console = console;
  }

  @Override
  public List<Accommodation> execute() {
    String city = console.getString("Ingresa la ciudad donde te quieres hospedar:");
    String typeAccommodation = console.getString("Ingresa el tipo de alojamiento (Hotel, apartamento o finca)");
    if (city.trim().isEmpty()) {
      System.out.println("Ingresa datos válidos.");
      return List.of();
    } else {
      DataSearch dataSearch = new DataSearch();
      dataSearch.setCity(city);
      dataSearch.setTypeAccomodation(typeAccommodation);
    }

    return searchByCityAndType(city, typeAccommodation);
  }

  public List<Accommodation> searchByCityAndType(String nameCity, String type) {
    return repository.getListAccommodation().stream()
      .filter(accommodation ->
        accommodation.getCity().equalsIgnoreCase(nameCity) &&
          accommodation.getType().equalsIgnoreCase(type))
      .peek(accommodation ->
        System.out.println(type + " encontrado: " + accommodation.getName()))
      .toList();
  }

}
