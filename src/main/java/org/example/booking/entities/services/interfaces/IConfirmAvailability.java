package org.example.booking.entities.services.interfaces;

import org.example.booking.entities.models.AvailabilityRequest;

import java.util.List;

public interface IConfirmAvailability {
  List<String> confirmAvailableRooms(List<Object> listAll, AvailabilityRequest availabilityRequest);
}
