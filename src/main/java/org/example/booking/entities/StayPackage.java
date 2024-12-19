package org.example.booking.entities;

public class StayPackage {
    private String name;
    private Double price;
    private String description;

    public StayPackage(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public StayPackage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
