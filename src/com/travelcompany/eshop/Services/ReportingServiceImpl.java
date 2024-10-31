package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ReportingServiceImpl implements ReportingService{

    public void totalTickets(List<Ticket> ticketList, List<Customer> customerList) {
        for (Customer customer : customerList) {
            int totalTickets = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    totalTickets = totalTickets + 1;
                }
            }
            System.out.println(customer.getName() + " has " + totalTickets + " tickets");
        }
    }

    public void totalCost(List<Ticket> ticketList, List<Customer> customerList) {
        for (Customer customer : customerList) {
            double totalCost = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    totalCost = totalCost + ticket.getPaymentAmount();
                }
            }
            System.out.println(customer.getName() + " paid " + totalCost + " euros");
        }
    }

    public void totalItinerariesDest(List<Itinerary> itineraryList) {
        List<Itinerary> itineraries = new ArrayList<>();
        for (Itinerary itinerary : itineraryList) {
            itineraries.add(new Itinerary(itinerary));
        }
        for (Itinerary itinerary1 : itineraryList) {
            int totalDest = 0;
            for (Itinerary itinerary2 : itineraries) {
                if (itinerary1.getDestinationCode() == itinerary2.getDestinationCode()) {
                    totalDest = totalDest + 1;
                    itinerary2.setDestinationCode(null);
                }
            }
            if (totalDest != 0) {
                System.out.println("The number of itineraries for " + itinerary1.getDestinationCode() + " is " + totalDest);
            }
        }
    }

    public void totalItinerariesDep(List<Itinerary> itineraryList) {
        List<Itinerary> itineraries = new ArrayList<>();
        for (Itinerary itinerary : itineraryList) {
            itineraries.add(new Itinerary(itinerary));
        }
        for (Itinerary itinerary1 : itineraryList) {
            int totalDep = 0;
            for (Itinerary itinerary2 : itineraries) {
                if (itinerary1.getDepartureCode() == itinerary2.getDepartureCode()) {
                    totalDep = totalDep + 1;
                    itinerary2.setDepartureCode(null);
                }
            }
            if (totalDep != 0) {
                System.out.println("The number of itineraries for " + itinerary1.getDepartureCode() + " is " + totalDep);
            }
        }
    }

    public void maxTickets (List<Customer> customerList, List<Ticket> ticketList){
        int maxTickets = 0;
        Customer maxTicketCustomer = null;
        for (Customer customer : customerList) {
            int totalTickets = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    totalTickets = totalTickets + 1;
                }
            }
            if (totalTickets > maxTickets){
                maxTickets = totalTickets;
                maxTicketCustomer = customer;
            }
        }
        System.out.println("The customer with the most tickets is " + maxTicketCustomer);
    }

    public void maxExpenses (List<Customer> customerList, List<Ticket> ticketList) {
        double  maxExpenses = 0.0;
        Customer maxExpensesCustomer = null;
        for (Customer customer : customerList) {
            double totalCost = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    totalCost = totalCost + ticket.getPaymentAmount();
                }
            }
            if ( totalCost > maxExpenses){
                maxExpenses = totalCost;
                maxExpensesCustomer = customer;
            }
        }
        System.out.println("The customer with the most expenses is " + maxExpensesCustomer);
    }

    public void zeroTickets (List<Customer> customerList, List<Ticket> ticketList) {
        for (Customer customer : customerList) {
            int totalTickets = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    totalTickets = totalTickets + 1;
                }
            }
            if (totalTickets == 0){
                System.out.println("The customer with no tickets is " + customer);
            }
        }
    }

}
