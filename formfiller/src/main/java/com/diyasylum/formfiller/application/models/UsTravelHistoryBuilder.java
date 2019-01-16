package com.diyasylum.formfiller.application.models;

import java.util.List;

public class UsTravelHistoryBuilder {
  private List<UsTravelEvent> travelEvents;
  private String lastLeftHomeCountry;
  private String i94Number;
  private String dateStatusExpires;

  public UsTravelHistoryBuilder setTravelEvents(List<UsTravelEvent> travelEvents) {
    this.travelEvents = travelEvents;
    return this;
  }

  public UsTravelHistoryBuilder setLastLeftHomeCountry(String lastLeftHomeCountry) {
    this.lastLeftHomeCountry = lastLeftHomeCountry;
    return this;
  }

  public UsTravelHistoryBuilder setI94Number(String i94Number) {
    this.i94Number = i94Number;
    return this;
  }

  public UsTravelHistoryBuilder setDateStatusExpires(String dateStatusExpires) {
    this.dateStatusExpires = dateStatusExpires;
    return this;
  }

  public UsTravelHistory createUsTravelHistory() {
    return new UsTravelHistory(travelEvents, lastLeftHomeCountry, i94Number, dateStatusExpires);
  }
}
