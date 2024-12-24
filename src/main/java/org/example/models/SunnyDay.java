package org.example.models;

public class SunnyDay {
    private Double pricePeople;
    private String activitis;

    public SunnyDay(Double pricePeople, String activitis) {
      this.pricePeople = pricePeople;
        this.activitis = activitis;
    }

    @Override
    public String toString() {
        return String.format(
          """
          🌞🌞🌞******************************************************
          ***                   Detalles del Día de Sol              ***
          *************************************************************
      
          💲 Precio por persona:   $%.2f
          🎉 Actividades incluidas: %s
      
          *************************************************************
          """,
          pricePeople,
          activitis
        );

    }

    public Double getPricePeople() {
        return pricePeople;
    }

    public String getActivitis() {
        return activitis;
    }
}
