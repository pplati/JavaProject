package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Payment;

public class Ticket {
    private Long id;
    private Customer customer;
    private Itinerary itinerary;
    private Payment paymentMethod;
    private double paymentAmount;

    public Ticket(Long id, Customer customer, Itinerary itinerary, Payment paymentMethod) {
        this.id = id;
        this.customer = customer;
        this.itinerary = itinerary;
        this.paymentMethod = paymentMethod;
    }

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

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customer id=" + customer.getId() +
                ", itinerary id=" + itinerary.getId() +
                ", paymentMethod=" + paymentMethod +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
