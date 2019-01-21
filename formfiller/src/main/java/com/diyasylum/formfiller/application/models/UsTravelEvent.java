package com.diyasylum.formfiller.application.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class UsTravelEvent {
  private final String date;
  private final String place;
  private final String status;

  @JsonCreator
  public UsTravelEvent(
      @JsonProperty("date") String date,
      @JsonProperty("place") String place,
      @JsonProperty("status") String status) {
    this.date = date;
    this.place = place;
    this.status = status;
  }

  public String getDate() {
    return date;
  }

  public String getPlace() {
    return place;
  }

  public String getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UsTravelEvent that = (UsTravelEvent) o;
    return Objects.equals(date, that.date)
        && Objects.equals(place, that.place)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, place, status);
  }

  @Override
  public String toString() {
    return "UsTravelEvent{"
        + "date='"
        + date
        + '\''
        + ", place='"
        + place
        + '\''
        + ", status='"
        + status
        + '\''
        + '}';
  }
}
