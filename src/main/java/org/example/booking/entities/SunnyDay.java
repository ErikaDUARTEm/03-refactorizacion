package org.example.booking.entities;

public class SunnyDay {
    private Double pricePeople;
    private String activitis;

    public SunnyDay(Double pricePeople, String activitis) {
        this.pricePeople = pricePeople;
        this.activitis = activitis;
    }

    public Double getPricePeople() {
        return pricePeople;
    }

    public void setPricePeople(Double pricePeople) {
        this.pricePeople = pricePeople;
    }

    public String getActivitis() {
        return activitis;
    }

    public void setActivitis(String activitis) {
        activitis = activitis;
    }

    @Override
    public String toString() {
        return "SunnyDay{" +
                "Precio: " + pricePeople +
                ", Actividades: " + activitis + '\'' +
                '}';
    }
}
