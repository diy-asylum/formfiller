package com.diyasylum.formfiller.application.models;

public class AddressBuilder {
    private String inCareOf;
    private String streetName;
    private String streetNumber;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zipCode;
    private String areaCode;
    private String phoneNumber;

    public AddressBuilder setInCareOf(String inCareOf) {
        this.inCareOf = inCareOf;
        return this;
    }

    public AddressBuilder setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AddressBuilder setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public AddressBuilder setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
        return this;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressBuilder setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public AddressBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Address createAddress() {
        return new Address(inCareOf, streetName, streetNumber, apartmentNumber, city, state, zipCode, areaCode, phoneNumber);
    }
}