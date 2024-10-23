package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Payment;

public class Ticket {
    private Long id;
    private Customer customer;
    private Itinerary itinerary;
    private Payment paymentMethod;
    //Price


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Ticket(Long id, Customer customer, Itinerary itinerary, Payment paymentMethod) {
        this.id = id;
        this.customer = customer;
        this.itinerary = itinerary;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customer=" + customer +
                ", itinerary=" + itinerary +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
