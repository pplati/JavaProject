package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.domain.Ticket;

import java.util.List;

public interface TicketService {
    void add (Ticket ticket, List<Customer> customerList, List<Itinerary> itineraryList);
    Ticket getById(Long id);
    List<Ticket> findAll();

}
