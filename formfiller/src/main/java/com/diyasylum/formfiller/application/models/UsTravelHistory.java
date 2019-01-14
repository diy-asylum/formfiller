package com.diyasylum.formfiller.application.models;

import java.util.List;
import java.util.Objects;

public class UsTravelHistory {
  private final List<UsTravelEvent> travelEvents;
  private final String lastLeftHomeCountry;
  private final String i94Number;
  private final String dateStatusExpires;

  public UsTravelHistory(
      List<UsTravelEvent> travelEvents,
      String lastLeftHomeCountry,
      String i94Number,
      String dateStatusExpires) {
    this.travelEvents = travelEvents;
    this.lastLeftHomeCountry = lastLeftHomeCountry;
    this.i94Number = i94Number;
    this.dateStatusExpires = dateStatusExpires;
  }

  public List<UsTravelEvent> getTravelEvents() {
    return travelEvents;
  }

  public String getLastLeftHomeCountry() {
    return lastLeftHomeCountry;
  }

  public String getI94Number() {
    return i94Number;
  }

  public String getDateStatusExpires() {
    return dateStatusExpires;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UsTravelHistory that = (UsTravelHistory) o;
    return Objects.equals(travelEvents, that.travelEvents)
        && Objects.equals(lastLeftHomeCountry, that.lastLeftHomeCountry)
        && Objects.equals(i94Number, that.i94Number)
        && Objects.equals(dateStatusExpires, that.dateStatusExpires);
  }

  @Override
  public int hashCode() {
    return Objects.hash(travelEvents, lastLeftHomeCountry, i94Number, dateStatusExpires);
  }

  @Override
  public String toString() {
    return "UsTravelHistory{"
        + "travelEvents="
        + travelEvents
        + ", lastLeftHomeCountry='"
        + lastLeftHomeCountry
        + '\''
        + ", i94Number='"
        + i94Number
        + '\''
        + ", dateStatusExpires='"
        + dateStatusExpires
        + '\''
        + '}';
  }
}
