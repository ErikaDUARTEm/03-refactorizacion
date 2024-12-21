package org.example;

import org.example.booking.entities.data.AccommodationData;
import org.example.booking.entities.models.AvailabilityRequest;
import org.example.booking.entities.models.ConfirmAvailability;
import org.example.booking.entities.utils.ConsoleUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final ConsoleUtils console = new ConsoleUtils();
        AccommodationData accommodationData = new AccommodationData();
        List<Object> listAll = accommodationData.getAccommodations();
        AvailabilityRequest availabilityRequest = new AvailabilityRequest();
        ConfirmAvailability confirmAvailability = new ConfirmAvailability();

        while (true) {
            viewMenu();
            int opcion = console.getInteger("******* Bienvenis@ ingresa el número de la opción ********");

            switch (opcion) {
                case 1 -> {
                    System.out.println("Lista de alojamientos disponibles:");
                    confirmAvailability.allAccommodation(listAll);
                }
                case 2 -> {
                    AvailabilityRequest availability = confirmAvailability.MenuConfirm(console);
                    System.out.println(confirmAvailability.confirmAvailableRooms(listAll,availability));
                }
                case 3->{

                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public static void viewMenu() {
        System.out.println("********************************");
        System.out.println("1. Listar Alojamientos.");
        System.out.println("2. Consultar disponibilidad de fechas, habitaciones y precio.");
        System.out.println("4. Confirmar Habitaciones.");
        System.out.println("5. Ver Reserva.");
        System.out.println("0. Salir.");
        System.out.println("********************************");
    }
}
