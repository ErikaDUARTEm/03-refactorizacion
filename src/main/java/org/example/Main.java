package org.example;

import org.example.booking.entities.data.AccommodationData;
import org.example.booking.entities.models.AvailabilityRequest;
import org.example.booking.entities.models.ConfirmAvailability;
import org.example.booking.entities.services.accommodation.AccommodationService;
import org.example.booking.entities.utils.ConsoleUtils;
import org.example.booking.entities.utils.Menu;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final ConsoleUtils console = new ConsoleUtils();
        AccommodationData accommodationData = new AccommodationData();
        List<Object> listAll = accommodationData.getAccommodations();
        AccommodationService accommodationService = new AccommodationService();
        ConfirmAvailability confirmAvailability = new ConfirmAvailability(accommodationService);
        Menu menu = new Menu(console, accommodationService,confirmAvailability);

        while (true) {
            menu.viewMenuMain();
            int opcion = console.getInteger("******* Bienvenid@ ingresa el número de la opción ********");

            switch (opcion) {
                case 1 -> {
                    System.out.println("Lista de alojamientos disponibles:");
                    accommodationService.allAccommodation(listAll);
                }
                case 2 -> {
                    AvailabilityRequest availabilityRequest = menu.menuTypeAccommodation(console);

                    if (availabilityRequest != null) {

                        menu.handleAccommodationOptions(console, listAll, availabilityRequest);
                    } else {
                        System.out.println("No se pudo procesar el tipo de alojamiento.");
                    }
                }
                case 3->{

                    AvailabilityRequest availability = menu.menuConfirm(console);
                    System.out.println(confirmAvailability.confirmAvailableRooms(listAll,availability));

                }
                case 4->{

                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }


}
