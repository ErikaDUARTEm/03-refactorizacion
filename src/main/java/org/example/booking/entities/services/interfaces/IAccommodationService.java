package org.example.booking.entities.services.interfaces;

import java.time.LocalDate;
import java.util.List;

public interface IAccommodationService {

  List<Object> findAccomodationType(String accommodationType, List<Object> listAll);

  Integer calculateDays(LocalDate startDate, LocalDate endDate);

}
