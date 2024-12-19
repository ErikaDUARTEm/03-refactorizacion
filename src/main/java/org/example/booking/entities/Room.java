package org.example.booking.entities;

public class Room {
   private String name;
   private String description;
   private Integer adultsCapacity;
   private Integer childrenCapacity;
   private Double price;
   private Integer quantity;

    public Room(String name, String description, Integer adultsCapacity, Integer childrenCapacity, Double price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.adultsCapacity = adultsCapacity;
        this.childrenCapacity = childrenCapacity;
        this.price = price;
        this.quantity = quantity;
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


}
