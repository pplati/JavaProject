package com.travelcompany.eshop;

import com.travelcompany.eshop.Services.*;
import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Airlines;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.enumeration.Payment;

import java.util.List;

public class TravelCompanyEShop {
    public static void main(String[] args) {
        // Προσθήκη Πελατών
        CustomerService customerService = new CustomerServiceImpl();

        customerService.add(new CustomerBusiness(1L, "Yiota Plati",
                "yiotap@gmail.com", "Athens", Nationality.GREEK));
        customerService.add(new CustomerIndividual(2L, "Maria Iordanou", "miordanou@gmail.com",
                "Athens", Nationality.GREEK));
        customerService.add(new CustomerIndividual(3L, "Dimitriou Dimitrios", "dimitriou@gmail.com",
                "Athens", Nationality.GREEK));
        List<Customer> customerList = customerService.findAll();

        // Προσθήκη Δρομολογίων
        ItineraryService itineraryService = new ItineraryServiceImpl();

        itineraryService.add(new Itinerary(1L, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:35",
                Airlines.SkyLines, 300.00));
        itineraryService.add(new Itinerary(2L, AirportCode.ATH, AirportCode.LON, "22/02/2022 13:40",
                Airlines.SkyLines, 420.00));
        itineraryService.add(new Itinerary(3L, AirportCode.ATH, AirportCode.AMS, "22/02/2022 13:45",
                Airlines.SkyLines, 280.00));
        List<Itinerary> itineraryList = itineraryService.findAll();

        // Προσθήκη Εισιτηρίων
        TicketService ticketService = new TicketServiceImpl();

        ticketService.add(new Ticket(1L, customerList.get(0), itineraryList.get(0), Payment.CREDIT_CARD));
        ticketService.add(new Ticket(2L, customerList.get(1), itineraryList.get(1), Payment.CASH));
        ticketService.add(new Ticket(3L, customerList.get(0), itineraryList.get(2), Payment.CREDIT_CARD));
        List<Ticket> ticketList = ticketService.findAll();

//        totalTickets(ticketList,customerList);
//        System.out.println();
//        totalCost(ticketList,customerList);
    }

    //Συνολικά εισιτήρια για κάθε πελάτη
    public static void totalTickets(List<Ticket> ticketList, List<Customer> customerList) {
        for (Customer customer : customerList) {
            int totalTickets = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()){
                    totalTickets = totalTickets + 1;
                }
            }
            System.out.println(customer.getName() + " has " + totalTickets + " tickets");
        }
    }

    //Συνολικό Κόστος εισιτηρίων για κάθε πελάτη
    public static void totalCost (List<Ticket> ticketList, List<Customer> customerList) {
        for (Customer customer : customerList) {
            double totalCost = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()){
                    totalCost = totalCost + ticket.getPaymentAmount();
                }
            }
            System.out.println(customer.getName() + " paid " + totalCost + " euros");
        }
    }


}
