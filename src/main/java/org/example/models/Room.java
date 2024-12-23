package org.example.models;

import java.time.LocalDate;

public class Room {
   private String name;
   private String description;
   private Integer adultsCapacity;
   private Integer childrenCapacity;
   private Double price;
   private Integer quantity;
   private Boolean available;

    public Room(String name, String description, Integer adultsCapacity, Integer childrenCapacity, Double price, Integer quantity, Boolean available) {
        this.name = name;
        this.description = description;
        this.adultsCapacity = adultsCapacity;
        this.childrenCapacity = childrenCapacity;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
    }

    protected Room() {
    }
    @Override
    public String toString() {
        return "Room{" +
                "Nombre: '" + name + '\'' +
                ", Description:'" +  description + '\'' +
                ", Capacidad de adultos =" + adultsCapacity +
                ", Capacidad de niños:" + childrenCapacity +
                ", Precio: " + price +
                ", Cantidad" + quantity +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAdultsCapacity() {
        return adultsCapacity;
    }

    public Integer getChildrenCapacity() {
        return childrenCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public Boolean getAvailable() {
      return available;
    }


}
