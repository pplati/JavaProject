# TravelCompany E-Shop Application

## Introduction

This project is a basic version of a ticket purchasing and reporting application for an e-shop. It has been implemented in Java and allows customers to purchase tickets for various itineraries offered by a travel company called TravelCompany.

## Features

- **Customer Categories**: Distinguishes between individual and business customers, applying appropriate discounts.
- **Discount Policies**: Implements a discount system based on customer type and payment method.
- **Exception Handling**: Custom exceptions for various error scenarios.
- **Reporting**: Provides reports on customer purchases and itineraries.

## Requirements

- JDK 23
- IntelliJ IDEA (recommended for development)

## Classes and Packages
The project is organized into the following packages:

- **com.travelcompany.eshop.domain**: Contains the domain classes for the application, such as Customer, Ticket, and Itinerary.
- **com.travelcompany.eshop.service**: Contains the service classes, including CustomerService, ItineraryService, and TicketService, that handle business logic.
- **com.travelcompany.eshop.enumeration**: Contains enumerations for Airlines, AirportCode, Nationality, and Payment.
- **com.travelcompany.eshop.exception**: Contains custom exception classes such as CustomerEmailException, ItineraryAirportException, and TicketIssuingException.
- **com.travelcompany.eshop.report**: Contains classes for generating reports.

