package org.example.booking.entities;

import java.util.List;

public class AccommodationData<T> {
    private final List<T> accommodations;

    public AccommodationData(List<T> accommodations) {
        this.accommodations = accommodations;
    }

    public List<T> getAccommodations() {
        return accommodations;
    }
}
