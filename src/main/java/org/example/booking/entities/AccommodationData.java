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
                new Hotel("Hotel", "Hotel Castillo Resort", "San Gil", "Hotel Castillo Resort se encuentra en San Gil...", 4.5, 0, List.of(), true),
                new Hotel("Hotel", "Meson del Cuchicute", "San Gil, Santander", "60 confortables habitaciones...", 4.3, 0, List.of(), true),
                new Hotel("Hotel"," Posada del Campanario", "San Gil","Ubicado en el corazón de San Gil, ofrece una experiencia colonial con todas las comodidades modernas.", 4.7, 0, List.of(), true),
                new Hotel("Hotel", "Boutique La Casona", "San Gil","Un hotel boutique exclusivo con atención personalizada y vista panorámica a la ciudad.", 4.8, 0, List.of(),true)

        );

    }

    public List<Apartament> listApartaments() {
        return List.of(
                new Apartament("Apartamento", "San Gil Natural", "San Gil", "San Gil Natural ofrece un entorno tranquilo...", 4.8, List.of()),
                new Apartament("Apartamento","Puente de la Villa","San Gil","Puente de la Villa ofrece apartamentos modernos con vistas al puente y la ciudad desde sus balcones.", 4.6, List.of())

        );
    }

    public List<Finca> listFincas() {
        return List.of(
                new Finca("Finca", "Finca Sol y Luna", "San Gil", "Finca Sol y Luna se encuentra en San Gil...", 4.3, List.of())
        );
    }

    public List<Object> getAccommodations() {
        return accommodations;
    }
}

