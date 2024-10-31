package com.travelcompany.eshop;

import com.travelcompany.eshop.Services.*;
import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Airlines;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.enumeration.Payment;
import com.travelcompany.eshop.exception.CustomerEmailException;
import com.travelcompany.eshop.exception.ItineraryAirportException;
import com.travelcompany.eshop.exception.TicketIssuingException;

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

        for (Customer customer : customerList){
            System.out.println(customer);
        }
        System.out.println();
        // Προσθήκη Δρομολογίων
        ItineraryService itineraryService = new ItineraryServiceImpl();

        try {
            itineraryService.add(new Itinerary(1L, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:35",
                    Airlines.SkyLines, 300.00));
            itineraryService.add(new Itinerary(2L, AirportCode.ATH, AirportCode.LON, "22/02/2022 13:40",
                    Airlines.SkyLines, 420.00));
            itineraryService.add(new Itinerary(3L, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:45",
                    Airlines.SkyLines, 280.00));
            itineraryService.add(new Itinerary(4L, AirportCode.ATH, AirportCode.ATH, "22/02/2022 13:45",
                    Airlines.SkyLines, 280.00));
        }catch (ItineraryAirportException e){
            System.out.println(e.getMessage());
        }
        List<Itinerary> itineraryList = itineraryService.findAll();

        for (Itinerary itinerary : itineraryList){
            System.out.println(itinerary);
        }
        System.out.println();

        // Προσθήκη Εισιτηρίων
        TicketService ticketService = new TicketServiceImpl();

        try {
            ticketService.add(new Ticket(1L, customerList.get(0), itineraryList.get(0), Payment.CREDIT_CARD), customerList, itineraryList);
            ticketService.add(new Ticket(2L, customerList.get(1), itineraryList.get(1), Payment.CASH), customerList, itineraryList);
            ticketService.add(new Ticket(3L, customerList.get(0), itineraryList.get(2), Payment.CREDIT_CARD), customerList, itineraryList);
            ticketService.add(new Ticket(4L, new CustomerBusiness(4L, "Antonio Molinari", "amolinari@mail.com",
                    "Rome", Nationality.ITALIAN), itineraryList.get(2), Payment.CREDIT_CARD), customerList, itineraryList);
        }catch (TicketIssuingException e){
            System.out.println(e.getMessage());
        }
        List<Ticket> ticketList = ticketService.findAll();

        for (Ticket ticket : ticketList){
            System.out.println(ticket);
        }
        System.out.println();

        // Reportings
        ReportingService reportingService = new ReportingServiceImpl();

        reportingService.totalTickets(ticketList,customerList);
        System.out.println();
        reportingService.totalCost(ticketList,customerList);
        System.out.println();

        reportingService.totalItinerariesDest(itineraryList);
        System.out.println();
        reportingService.totalItinerariesDep(itineraryList);
        System.out.println();

        reportingService.maxTickets(customerList, ticketList);
        System.out.println();
        reportingService.maxExpenses(customerList, ticketList);
        System.out.println();

        reportingService.zeroTickets(customerList, ticketList);
    }
}
