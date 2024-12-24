package org.example.services.accommodation;

import org.example.models.Accommodation;
import org.example.models.Hotel;
import org.example.models.Room;
import org.example.models.SunnyDay;
import org.example.repositories.AccommodationRepository;
import org.example.services.interfaces.ICommand;
import org.example.utils.ConsoleUtils;
import org.example.utils.DataSearch;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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
    String typeAccommodation = console.getString("Ingresa el tipo de alojamiento (Hotel, apartamento o finca):");

    if (city.trim().isEmpty() || typeAccommodation.trim().isEmpty()) {
      System.out.println("Ingresa datos válidos.");
      return List.of();
    }

    dataSearch.setCity(city);
    dataSearch.setTypeAccomodation(typeAccommodation);

    if (isHotel(typeAccommodation)) {
      return handleHotelOptions(city);
    } else {
      return selectAccommodation(searchByCityAndType(city, typeAccommodation));
    }
  }

  private boolean isHotel(String typeAccommodation) {
    return typeAccommodation.equalsIgnoreCase("hotel");
  }

  private List<Accommodation> handleHotelOptions(String city) {
    int option = console.getInteger("Selecciona una opción:\n1. Estadía por noche\n2. Día de sol");

    Map<Integer, ICommand<List<Accommodation>>> options = Map.of(
      1, () -> selectAccommodation(searchByCityAndType(city, "hotel")),
      2, () -> selectAccommodation(searchSunnyDayHotels(city))
    );

    ICommand<List<Accommodation>> command = options.get(option);
    if (command != null) {
      return command.execute();
    } else {
      System.out.println("Opción inválida.");
      return List.of();
    }
  }

  public List<Accommodation> searchSunnyDayHotels(String city) {
    return repository.getListAccommodation().stream()
      .filter(accommodation -> accommodation instanceof Hotel &&
        accommodation.getCity().equalsIgnoreCase(city) &&
        ((Hotel) accommodation).hasSunnyDay())
      .toList();
  }

  public List<Accommodation> searchByCityAndType(String nameCity, String type) {
    return repository.getListAccommodation().stream()
      .filter(accommodation ->
        accommodation.getCity().equalsIgnoreCase(nameCity) &&
          accommodation.getType().equalsIgnoreCase(type))
      .toList();
  }
  private List<Accommodation> selectAccommodation(List<Accommodation> accommodations) {
    if (accommodations.isEmpty()) {
      showNoAccommodationsMessage();
      return null;
    }

    showAccommodations(accommodations);
    int selectedIndex = getSelectedIndex(accommodations.size());
    return processSelection(accommodations, selectedIndex);
  }

  private void showNoAccommodationsMessage() {
    System.out.println("\n Alojamiento no encontrado bajo los criterios de busqueda.");
  }

  private void showAccommodations(List<Accommodation> accommodations) {
    System.out.println("\nAlojamientos encontrados:");
    IntStream.range(0, accommodations.size()).forEach(i -> System.out.printf(
      "%d. %s (%s, %s)%n", i + 1, accommodations.get(i).getName(),
      accommodations.get(i).getCity(), accommodations.get(i).getType()));
  }

  private int getSelectedIndex(int size) {
    return console.getInteger("Seleccione el numero del alojamiento (o 0 para cancelar):");
  }

  private List<Accommodation> processSelection(List<Accommodation> accommodations, int selectedIndex) {
    if (isSelectionValid(selectedIndex, accommodations.size())) {
      Accommodation selectedAccommodation = accommodations.get(selectedIndex - 1);
      showAccommodationDetails(selectedAccommodation);
      dataSearch.setNameAccomodation(selectedAccommodation.getName());
      return accommodations;
    } else {
      System.out.println("Operación cancelada.");
      return null;
    }
  }

  private boolean isSelectionValid(int selectedIndex, int size) {
    return selectedIndex > 0 && selectedIndex <= size;
  }


  private void showAccommodationDetails(Accommodation accommodation) {
    System.out.println("\nDetalles del alojamiento seleccionado:");
    System.out.println("Nombre: " + accommodation.getName());
    System.out.println("Ciudad: " + accommodation.getCity());
    System.out.println("Tipo: " + accommodation.getType());
    System.out.println("Descripción: " + accommodation.getDescription());

    if (accommodation instanceof Hotel) {
      showDetailsRooms(((Hotel) accommodation).getAvailableRooms());
    }
    if((accommodation.getType().equals("Hotel"))) {
      showDetailsSunnyDay(accommodation);
    } }

    private void showDetailsSunnyDay(Accommodation accommodation){
    SunnyDay sunnyDay = ((Hotel) accommodation).getSunnyDay();
    System.out.println("\n___________Detalles del Día de Sol_______________________");
    System.out.println("Precio: " + sunnyDay.getPricePeople());
    System.out.println("Actividades: " + sunnyDay.getActivitis());
  }
  private void showDetailsRooms(List<Room> rooms){
    System.out.println("\nDetalles de las habitaciones:");
    for (Room room : rooms) {
      System.out.println(" - Habitación: " + room.getName());
      System.out.println(" Descripción: " + room.getDescription());
      System.out.println(" Capacidad (adultos + niños): " + (room.getAdultsCapacity() + room.getChildrenCapacity()));
      System.out.println(" Precio: " + room.getPrice()); }
  }
}
