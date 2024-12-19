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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdultsCapacity() {
        return adultsCapacity;
    }

    public void setAdultsCapacity(Integer adultsCapacity) {
        this.adultsCapacity = adultsCapacity;
    }

    public Integer getChildrenCapacity() {
        return childrenCapacity;
    }

    public void setChildrenCapacity(Integer childrenCapacity) {
        this.childrenCapacity = childrenCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
