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
  DataSearch dataSearch = new DataSearch();

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
      dataSearch.setCity(city);
      dataSearch.setTypeAccomodation(typeAccommodation);
    }

    return selectAccommodation(searchByCityAndType(city, typeAccommodation));
  }

  public List<Accommodation> searchByCityAndType(String nameCity, String type) {
    return repository.getListAccommodation().stream()
      .filter(accommodation ->
        accommodation.getCity().equalsIgnoreCase(nameCity) &&
          accommodation.getType().equalsIgnoreCase(type))
      .toList();
  }
  private List<Accommodation> selectAccommodation(List<Accommodation> accommodations){
    System.out.println("\nAlojamientos encontrados:");
    for (int i = 0; i < accommodations.size(); i++) {
      System.out.printf("%d. %s (%s, %s)\n", i + 1, accommodations.get(i).getName(),
        accommodations.get(i).getCity(), accommodations.get(i).getType());
    }
    int selectedIndex = console.getInteger("Selecciona el alojamiento ingresando su número (o 0 para cancelar):");
    if (selectedIndex > 0 && selectedIndex <= accommodations.size()) {
     Accommodation selectedAccommodation = accommodations.get(selectedIndex - 1);
     showAccommodationDetails(selectedAccommodation);
     dataSearch.setNameAccomodation(selectedAccommodation.getName());
      System.out.println(dataSearch.getNameAccomodation());
     return accommodations;
    } else {
      System.out.println("Operación cancelada.");
      return null;
    }
  };

  private void showAccommodationDetails(Accommodation accommodation) {
    System.out.println("\nDetalles del alojamiento seleccionado:");
    System.out.println("Nombre: " + accommodation.getName());
    System.out.println("Ciudad: " + accommodation.getCity());
    System.out.println("Tipo: " + accommodation.getType());
    System.out.println("Descripción: " + accommodation.getDescription());
  }
}
