package org.example;

import org.example.booking.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccommodationData accommodationData = new AccommodationData();
        accommodationData.initializeAccommodations();

        while (true) {
            viewMenu();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    List<Object> listAll = accommodationData.getAccommodations();

                    if (listAll.isEmpty()) {
                        System.out.println("No hay alojamientos disponibles.");
                    } else {
                        listAll.stream()
                                .map(alojamiento -> showAccommodationInfo(alojamiento))
                                .toList()
                                .forEach(System.out::println);
                    }
                }
                case 2 -> {


                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static String showAccommodationInfo(Object alojamiento) {
        if (alojamiento instanceof Hotel) {
            return ((Hotel) alojamiento).viewAccommodation();
        } else if (alojamiento instanceof Apartament) {
            return ((Apartament) alojamiento).viewAccommodation();
        } else if (alojamiento instanceof Finca) {
            return ((Finca) alojamiento).viewAccommodation();
        }
        return "Tipo de alojamiento desconocido.";
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
