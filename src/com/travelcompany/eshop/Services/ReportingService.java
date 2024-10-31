package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.domain.Ticket;

import java.util.List;

public interface ReportingService {
    //Συνολικά εισιτήρια για κάθε πελάτη
    void totalTickets(List<Ticket> ticketList, List<Customer> customerList);
    //Συνολικό Κόστος εισιτηρίων για κάθε πελάτη
    void totalCost(List<Ticket> ticketList, List<Customer> customerList);
    //Συνολικός αριθμός δρομολογίων προορισμών
    void totalItinerariesDest(List<Itinerary> itineraryList);
    //Συνολικός αριθμός δρομολογίων αναχωρήσεων
    void totalItinerariesDep(List<Itinerary> itineraryList);
    //Πελάτης με τα περισσότερα εισιτήρια
    void maxTickets (List<Customer> customerList, List<Ticket> ticketList);
    //Πελάτης με τα περισσότερα έξοδα
    void maxExpenses (List<Customer> customerList, List<Ticket> ticketList);
    //Πελάτες με 0 εισιτήρια
    void zeroTickets (List<Customer> customerList, List<Ticket> ticketList);
}
