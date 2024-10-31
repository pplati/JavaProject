package com.travelcompany.eshop;

import com.travelcompany.eshop.Services.*;
import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Airlines;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.enumeration.Payment;
import com.travelcompany.eshop.exception.CustomerEmailException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravelCompanyEShop {
    public static void main(String[] args) {
        // Προσθήκη Πελατών
        CustomerService customerService = new CustomerServiceImpl();

        try {
            customerService.add(new CustomerBusiness(1L, "Yiota Plati",
                    "yiotap@gmail.com", "Athens", Nationality.GREEK));
            customerService.add(new CustomerIndividual(2L, "Maria Iordanou", "miordanou@gmail.com",
                    "Athens", Nationality.GREEK));
            customerService.add(new CustomerIndividual(3L, "Dimitriou Dimitrios", "dimitriou@gmail.com",
                    "Athens", Nationality.GREEK));
            customerService.add(new CustomerBusiness(4L, "Antonio Molinari", "antonio@travelcompany.com",
                    "Rome", Nationality.ITALIAN));
        }catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        List<Customer> customerList = customerService.findAll();

        // Προσθήκη Δρομολογίων
        ItineraryService itineraryService = new ItineraryServiceImpl();

        itineraryService.add(new Itinerary(1L, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:35",
                Airlines.SkyLines, 300.00));
        itineraryService.add(new Itinerary(2L, AirportCode.ATH, AirportCode.LON, "22/02/2022 13:40",
                Airlines.SkyLines, 420.00));
        itineraryService.add(new Itinerary(3L, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:45",
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

//        totalItinerariesDest(itineraryList);
//        System.out.println();
//        totalItinerariesDep(itineraryList);

//        maxTickets(customerList, ticketList);
//        System.out.println();
//        maxExpenses(customerList, ticketList);

//        zeroTickets(customerList, ticketList);
    }

    //Συνολικά εισιτήρια για κάθε πελάτη
    public static void totalTickets(List<Ticket> ticketList, List<Customer> customerList) {
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

    //Συνολικό Κόστος εισιτηρίων για κάθε πελάτη
    public static void totalCost(List<Ticket> ticketList, List<Customer> customerList) {
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

    //Συνολικός αριθμός δρομολογίων προορισμών
    public static void totalItinerariesDest(List<Itinerary> itineraryList) {
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

    //Συνολικός αριθμός δρομολογίων αναχωρήσεων
    public static void totalItinerariesDep(List<Itinerary> itineraryList) {
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

    //Πελάτης με τα περισσότερα εισιτήρια
    public static void maxTickets (List<Customer> customerList, List<Ticket> ticketList){
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

    //Πελάτης με τα περισσότερα έξοδα
    public static void maxExpenses (List<Customer> customerList, List<Ticket> ticketList) {
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

    //Πελάτες με 0 εισιτήρια
    public static void zeroTickets (List<Customer> customerList, List<Ticket> ticketList) {
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
