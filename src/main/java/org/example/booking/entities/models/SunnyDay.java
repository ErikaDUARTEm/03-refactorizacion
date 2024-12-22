package org.example.booking.entities.models;

import org.example.booking.entities.services.interfaces.ISunnyDay;

import java.util.List;

public class SunnyDay implements ISunnyDay {
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
          🌞🌞🌞*************************************************************
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


    @Override
    public List<String> confirmSunnyDay() {
        return List.of();
    }
}
