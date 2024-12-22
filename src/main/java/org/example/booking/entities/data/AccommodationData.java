package org.example.booking.entities.data;

import org.example.booking.entities.models.Hotel;
import org.example.booking.entities.models.Apartament;
import org.example.booking.entities.models.Finca;
import org.example.booking.entities.models.Room;
import org.example.booking.entities.models.SunnyDay;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccommodationData {
    private final List<Object> accommodations;

    public AccommodationData() {
        this.accommodations = initializeAccommodations();
    }

    private List<Object> initializeAccommodations() {
        List<Object> accommodations = new ArrayList<>();
        accommodations.addAll(listHotels());
        accommodations.addAll(listApartaments());
        accommodations.addAll(listFincas());
        return accommodations;
    }

  public List<Hotel> listHotels() {
    return List.of(
      new Hotel("Hotel", "Hotel Castillo Resort", "san gil",
        "Hotel Castillo Resort se encuentra en San Gil...", 4.5, 50.0,
        List.of(
          new Room("single room", "cama individual, aire acondicionado, baño privado", 1, 0, 50.0, 5,
            LocalDate.of(2024, 12, 24), LocalDate.of(2025, 1, 24)),
          new Room("double room", "2 camas dobles, vista a la piscina, aire acondicionado, baño privado", 2, 2,
            80.0, 6, LocalDate.of(2024, 12, 24), LocalDate.of(2024, 12, 28)),
          new Room("quadruple room", "4 camas, vista al jardín, aire acondicionado, baño privado, minibar", 2,
            2, 100.0, 3, LocalDate.of(2024, 12, 24), LocalDate.of(2025, 1, 24)),
          new Room("family room", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado",
            4, 4, 120.0, 2, LocalDate.of(2024, 12, 24), LocalDate.of(2025, 1, 24)),
          new Room("suite", "cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2,
            0, 150.0, 2, LocalDate.of(2024, 12, 24), LocalDate.of(2025, 1, 24))
        ),
        new SunnyDay(50.0, "Acceso por un día con servicios básicos y acceso a áreas comunes.")
      ),

      new Hotel("Hotel", "Meson del Cuchicute", "san gil",
        "60 confortables habitaciones...", 4.3, 60.0,
        List.of(
          new Room("single room", "cama individual, baño privado, aire acondicionado", 1, 0, 60.0, 5,
            LocalDate.of(2024, 12, 24), LocalDate.of(2025, 1, 24)),
          new Room("double room", "2 camas dobles, vista al jardín, aire acondicionado, baño privado", 2, 2,
            100.0, 6, LocalDate.of(2025, 1, 5), LocalDate.of(2025, 1, 15)),
          new Room("quadruple room", "4 camas, aire acondicionado, baño privado, minibar", 2, 2,
            150.0, 3, LocalDate.of(2025, 1, 5), LocalDate.of(2025, 1, 15)),
          new Room("family room", "4 camas matrimoniales, sala de estar, aire acondicionado, baño privado",
            4, 4, 180.0, 2, LocalDate.of(2025, 1, 5), LocalDate.of(2025, 1, 15)),
          new Room("suite", "cama king size, sala de estar, jacuzzi, aire acondicionado, baño privado", 2,
            0, 200.0, 2, LocalDate.of(2025, 1, 5), LocalDate.of(2025, 1, 15))
        ),
        new SunnyDay(50.0, "Acceso por un día con servicios básicos y acceso a áreas comunes.")
      ),

      new Hotel("Hotel", "Posada del Campanario", "san gil",
        "Ubicado en el corazón de San Gil, ofrece una experiencia colonial con todas las comodidades modernas.",
        4.7, 80.0,
        List.of(
          new Room("colonial room", "decoración colonial, cama queen size", 2, 2, 80.0, 5,
            LocalDate.of(2025, 2, 20), LocalDate.of(2025, 4, 30)),
          new Room("suite colonial", "cama king size, balcón, baño con jacuzzi", 2, 0, 150.0, 2,
            LocalDate.of(2025, 2, 10), LocalDate.of(2025, 4, 30))
        ),
        new SunnyDay(50.0, "Acceso por un día con servicios básicos y acceso a áreas comunes.")
      ),

      new Hotel("Hotel", "Boutique La Casona", "san gil",
        "Un hotel boutique exclusivo con atención personalizada y vista panorámica a la ciudad.",
        4.8, 90.0,
        List.of(
          new Room("familiar room", "cama matrimonial + 2 camas sencillas", 2, 2, 90.0, 6,
            LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 18)),
          new Room("eco suite", "decoración ecológica, cama queen size, vista a la montaña", 2, 0, 100.0, 3,
            LocalDate.of(2025, 2, 20), LocalDate.of(2025, 3, 30))
        ),
        new SunnyDay(50.0, "Acceso por un día con servicios básicos y acceso a áreas comunes.")
      )
    );
  }

  public List<Apartament> listApartaments() {
    return List.of(
      new Apartament("Apartamento", "San Gil Natural", "san gil", "San Gil Natural ofrece un entorno tranquilo...", 4.8, 400.0,
        List.of(
          new Room("Habitación principal", "cama king size, aire acondicionado, baño privado", 2, 2, 0.0, 1, LocalDate.of(2025, 2, 18), LocalDate.of(2025, 4, 30)),
          new Room("Habitaciones secundarias", "camas dobles, aire acondicionado, baño compartido", 2, 2, 0.0, 2, LocalDate.of(2025, 2, 18), LocalDate.of(2025, 4, 30)),
          new Room("Sala de estar", "espaciosa con sofá, TV, acceso directo a la cocina", 0, 0, 0.0, 1, LocalDate.of(2025, 2, 18), LocalDate.of(2025, 4, 30)),
          new Room("Cocina equipada", "utensilios completos, horno, nevera", 0, 0, 0.0, 1, LocalDate.of(2025, 2, 18), LocalDate.of(2025, 4, 30)),
          new Room("Area exterior", "vista al río, zona de descanso al aire libre", 0, 0, 0.0, 1, LocalDate.of(2025, 2, 18), LocalDate.of(2025, 4, 30))
        )
      ),
      new Apartament("Apartamento", "Puente de la Villa", "san gil", "Puente de la Villa ofrece apartamentos modernos con vistas al puente y la ciudad desde sus balcones.", 4.6, 310.0,
        List.of(
          new Room("Habitación principal", "cama matrimonial, aire acondicionado, baño privado", 2, 2, 90.0, 1, LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
          new Room("Habitaciones secundarias", "camas individuales, aire acondicionado, baño compartido", 2, 1, 0.0, 2, LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
          new Room("Sala de estar", "sofá amplio, TV, acceso a cocina equipada", 0, 0, 0.0, 1, LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
          new Room("Cocina equipada", "utensilios básicos, horno, nevera", 0, 0, 0.0, 1, LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
          new Room("Terraza", "vista al puente, zona de descanso al aire libre", 0, 0, 0.0, 1, LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30))
        )
      )
    );
  }

  public List<Finca> listFincas() {
        return List.of(
                new Finca("Finca", "Finca Sol y Luna", "san gil", "Finca Sol y Luna se encuentra en San Gil...", 4.3, 510.0,
                        List.of(new Room("single room", "cama individual, baño privado, aire acondicionado",1, 1, 0.0, 1,LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
                                new Room("double room", "2 camas dobles, aire acondicionado, baño privado, vista al jardín", 4, 2, 0.0, 1,LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
                                new Room("quadruple room", "4 camas, baño privado, aire acondicionado, vista al campo", 4, 4, 0.0, 2,LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
                                new Room("family room","4 camas matrimoniales, sala de estar, aire acondicionado, baño privado",  8, 4,0.0, 1,LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30)),
                                new Room("matrimonial","cama matrimonial, baño privado, aire acondicionado",  2, 2, 0.0, 1, LocalDate.of(2024, 12, 18), LocalDate.of(2025, 3, 30))
                        )
                )
        );
    }

    public List<Object> getAccommodations() {
        return accommodations;
    }
}

