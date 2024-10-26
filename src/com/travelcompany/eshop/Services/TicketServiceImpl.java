package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Ticket;
import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Payment;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketService{
    List<Ticket> tickets = new ArrayList<>();
    @Override
    public void add(Ticket ticket) {
        double basicPrice = ticket.getItinerary().getPrice();
        double discount = 0.0;
        double surcharge = 0.0;
        if (ticket.getCustomer().getCategory() == Category.BUSINESS){
            discount = 0.1;
        } else {
            surcharge = 0.2;
        }
        if (ticket.getPaymentMethod() == Payment.CREDIT_CARD){
            discount = discount + 0.1;
        }
        double totalAmount = basicPrice + (basicPrice*surcharge) - (basicPrice*discount);
        ticket.setPaymentAmount(totalAmount);
        this.tickets.add(ticket);
    }

    @Override
    public Ticket getById(Long id) {
        for (Ticket ticket : tickets){
            if (ticket.getId().equals(id)){
                return ticket;
            }
        }
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return tickets;
    }
}
