package org.example.booking.entities;

import java.util.ArrayList;
import java.util.List;

public class AccommodationData {
    private final List<Object> accommodations = new ArrayList<>();

    public List<Object> initializeAccommodations() {
        accommodations.addAll(listHotels());
        accommodations.addAll(listApartaments());
        accommodations.addAll(listFincas());
        return accommodations;
    }

    public List<Hotel> listHotels() {
        return List.of(
                new Hotel("Hotel", "Hotel Castillo Resort", "San Gil", "Hotel Castillo Resort se encuentra en San Gil...", 4.5, 0.0,
                        List.of(
                        new Room("single room", "cama individual, aire acondicionado, baño privado", 1, 1, 50.0, 5),
                        new Room("double room", "2 camas dobles, vista a la piscina, aire acondicionado, baño privado", 4, 2, 80.0, 6),
                        new Room("quadruple room", "4 camas, vista al jardín, aire acondicionado, baño privado, minibar", 4, 2, 100.0, 3),
                        new Room("family room", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 8, 4, 120.0, 2),
                        new Room("suite", "cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2, 150.0, 2)), true),
                new Hotel("Hotel", "Meson del Cuchicute", "San Gil, Santander", "60 confortables habitaciones...", 4.3, 0.0,
                        List.of(
                        new Room("single room", "cama individual, baño privado, aire acondicionado", 1, 1,  60.0, 5),
                        new Room("double room", "2 camas dobles, vista al jardín, aire acondicionado, baño privado", 4, 2, 100.0, 6),
                        new Room("quadruple room", "4 camas, aire acondicionado, baño privado, minibar", 4, 2, 150.0, 3),
                        new Room("family room", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado", 8, 4, 180.0, 2),
                        new Room("suite", "cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2, 2,  200.0, 2)), true),
                new Hotel("Hotel"," Posada del Campanario", "San Gil","Ubicado en el corazón de San Gil, ofrece una experiencia colonial con todas las comodidades modernas.", 4.7, 0.0,
                        List.of(
                        new Room("colonial room", "decoración colonial, cama queen size", 2, 2, 80.0, 5),
                        new Room("suite colonial", "cama king size, balcón, baño con jacuzzi", 2, 2,  150.0, 2)), true),
                new Hotel("Hotel", "Boutique La Casona", "San Gil","Un hotel boutique exclusivo con atención personalizada y vista panorámica a la ciudad.", 4.8, 0.0,
                        List.of(
                        new Room("familiar room", "cama matrimonial + 2 camas sencillas", 4, 2, 90.0, 6),
                        new Room("eco suite", "decoración ecológica, cama queen size, vista a la montaña", 2, 2,  100.0, 3)),true)

        );

    }

    public List<Apartament> listApartaments() {
        return List.of(
                new Apartament("Apartamento", "San Gil Natural", "San Gil", "San Gil Natural ofrece un entorno tranquilo...", 4.8,
                        List.of(
                                new Room("Habitación principal", "cama king size, aire acondicionado, baño privado", 2, 2, 120.0, 1),
                                new Room("Habitaciones secundarias", "camas dobles, aire acondicionado, baño compartido", 4, 2, 100.0, 2),
                                new Room("Sala de estar", "espaciosa con sofá, TV, acceso directo a la cocina", 0, 0, 60.0, 1),
                                new Room("Cocina equipada", "utensilios completos, horno, nevera", 0, 0,70.0, 1),
                                new Room("Area exterior", "vista al río, zona de descanso al aire libre", 0,0, 50.0, 1),
                new Apartament("Apartamento","Puente de la Villa","San Gil","Puente de la Villa ofrece apartamentos modernos con vistas al puente y la ciudad desde sus balcones.", 4.6,
                        List.of(new Room("Habitación principal", "cama matrimonial, aire acondicionado, baño privado", 2, 2, 90.0, 1),
                                new Room("Habitaciones secundarias", "camas individuales, aire acondicionado, baño compartido", 2, 1, 70.0, 2),
                                new Room("Sala de estar", "sofá amplio, TV, acceso a cocina equipada", 0, 0,50.0, 1),
                                new Room("Cocina equipada", "utensilios básicos, horno, nevera", 0, 0, 60.0, 1),
                                new Room("Terraza", "vista al puente, zona de descanso al aire libre", 0, 0, 40.0, 1)

        );
    }

    public List<Finca> listFincas() {
        return List.of(
                new Finca("Finca", "Finca Sol y Luna", "San Gil", "Finca Sol y Luna se encuentra en San Gil...", 4.3,
                        List.of(new Room("single room", "cama individual, baño privado, aire acondicionado",1, 1, 45.0, 1),
                                new Room("double room", "2 camas dobles, aire acondicionado, baño privado, vista al jardín", 4, 2, 75.0, 1 ),
                                new Room("quadruple room", "4 camas, baño privado, aire acondicionado, vista al campo", 4, 2, 110.0, 2),
                                new Room("family room","4 camas matrimoniales, sala de estar, aire acondicionado, baño privado",  8, 4,130.0, 1),
                                new Room("matrimonial","cama matrimonial, baño privado, aire acondicionado",  2, 2, 150.0, 1 )
        );
    }

    public List<Object> getAccommodations() {
        return accommodations;
    }
}

