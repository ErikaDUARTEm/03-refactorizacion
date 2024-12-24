package org.example.utils;

import org.example.services.interfaces.ICommand;

import java.time.LocalDate;

public class DataSearch {

  private String city;
  private String typeAccomodation;
  private String nameAccomodation;
  private LocalDate startDate;
  private LocalDate endDate;
  private Integer numberAdults;
  private Integer getNumberChildren;
  private Integer numberRoom;


  public void setNameAccomodation(String nameAccomodation) {
    this.nameAccomodation = nameAccomodation;
  }

  public DataSearch(String city, String typeAccomodation, String nameAccomodation, LocalDate startDate, LocalDate endDate, Integer numberAdults, Integer getNumberChildren, Integer numberRoom) {
    this.city = city;
    this.typeAccomodation = typeAccomodation;
    this.nameAccomodation = nameAccomodation;
    this.startDate = startDate;
    this.endDate = endDate;
    this.numberAdults = numberAdults;
    this.getNumberChildren = getNumberChildren;
    this.numberRoom = numberRoom;
  }

  public DataSearch() {
  }

  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getTypeAccomodation() {
    return typeAccomodation;
  }

  public String getNameAccomodation() {
    return nameAccomodation;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public Integer getNumberAdults() {
    return numberAdults;
  }

  public Integer getGetNumberChildren() {
    return getNumberChildren;
  }

  public Integer getNumberRoom() {
    return numberRoom;
  }


  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("DataSearch{");
    sb.append("city='").append(city).append('\'');
    sb.append(", typeAccomodation='").append(typeAccomodation).append('\'');
    sb.append(", nameAccomodation='").append(nameAccomodation).append('\'');
    sb.append(", startDate=").append(startDate);
    sb.append(", endDate=").append(endDate);
    sb.append(", numberAdults=").append(numberAdults);
    sb.append(", getNumberChildren=").append(getNumberChildren);
    sb.append(", numberRoom=").append(numberRoom);
    sb.append('}');
    return sb.toString();
  }

  public void setTypeAccomodation(String typeAccomodation) {
    this.typeAccomodation = typeAccomodation;
  }
}
