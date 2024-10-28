package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Airlines;
import com.travelcompany.eshop.enumeration.AirportCode;

public class Itinerary {
    private Long id;
    private AirportCode departureCode;
    private AirportCode destinationCode;
    private String date;
    private Airlines airline;
    private double price;

    public Itinerary(Long id, AirportCode departureCode, AirportCode destinationCode, String date, Airlines airline, double price) {
        this.id = id;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
        this.date = date;
        this.airline = airline;
        this.price = price;
    }

    public Itinerary (Itinerary other){
        this.id = other.getId();
        this.departureCode = other.getDepartureCode();
        this.destinationCode = other.getDestinationCode();
        this.date = other.getDate();
        this.airline = other.getAirline();
        this.price = other.getPrice();
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

    public Airlines getAirline() {
        return airline;
    }

    public void setAirline(Airlines airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", departureCode=" + departureCode +
                ", destinationCode=" + destinationCode +
                ", date='" + date + '\'' +
                ", airline='" + airline + '\'' +
                ", price=" + price +
                '}';
    }

}
