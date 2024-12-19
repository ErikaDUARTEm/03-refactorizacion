package org.example.booking.entities;

public class SunnyDay {
    private Double price;
    private String activitis;

    public SunnyDay(Double price, String activitis) {
        this.price = price;
        this.activitis = activitis;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
                "Precio: " + price +
                ", Actividades: " + activitis + '\'' +
                '}';
    }
}
