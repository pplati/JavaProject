package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.AirportCode;

public class Itinerary {
    private Long id;
    private AirportCode departureCode;
    private AirportCode destinationCode;
    private String date;
    private String airline;
    private double price;

    public Itinerary(Long id, AirportCode departureCode, AirportCode destinationCode, String date, String airline, double price) {
        this.id = id;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
        this.date = date;
        this.airline = airline;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirportCode getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(AirportCode departureCode) {
        this.departureCode = departureCode;
    }

    public AirportCode getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(AirportCode destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
