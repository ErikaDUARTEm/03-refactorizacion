package org.example.booking.entities.models;

public class SunnyDay {
    private Double pricePeople;
    private String activitis;

    public SunnyDay(Double pricePeople, String activitis) {
        this.pricePeople = pricePeople;
        this.activitis = activitis;
    }

    @Override
    public String toString() {
        return "SunnyDay{" +
                "Precio: " + pricePeople +
                ", Actividades: " + activitis + '\'' +
                '}';
    }
}
