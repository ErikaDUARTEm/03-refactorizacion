package org.example.controller;

import org.example.services.AccommodationService;

public class AccommodationController {

  private AccommodationService service;

  public AccommodationController(AccommodationService service) {
    this.service = service;
  }

  public void searchAccommodationByCity(){
    service.searchByCity("San gil");
  }
}
