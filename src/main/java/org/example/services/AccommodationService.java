package org.example.services;

import org.example.models.Accommodation;
import org.example.repositories.AccommodationRepository;

import java.util.ArrayList;
import java.util.List;

public class AccommodationService {
  private static AccommodationRepository repository;

  public AccommodationService(AccommodationRepository repository) {
    this.repository = repository;
  }


  public List<Accommodation> searchByCity(String nameCity){
    List<Accommodation> listSearchByCity = new ArrayList<>();
    for(Accommodation oneAccommodation : repository.getListAccommodation()) {
      if(oneAccommodation.getName().equalsIgnoreCase(nameCity)){
        listSearchByCity.add(oneAccommodation);
      }
    }
    return listSearchByCity;
  }
}
