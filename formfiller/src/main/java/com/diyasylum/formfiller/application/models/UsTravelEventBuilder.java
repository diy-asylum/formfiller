package com.diyasylum.formfiller.application.models;

public class UsTravelEventBuilder {
    private String date;
    private String place;
    private String status;

    public UsTravelEventBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public UsTravelEventBuilder setPlace(String place) {
        this.place = place;
        return this;
    }

    public UsTravelEventBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public UsTravelEvent createUsTravelEvent() {
        return new UsTravelEvent(date, place, status);
    }
}