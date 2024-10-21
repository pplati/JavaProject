package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.enumeration.Nationality;

public class TravelCompanyEShop {
    public static void main(String[] args) {
        Nationality nationality = Nationality.valueOf("italian".toUpperCase());
        System.out.println(nationality);
        Customer businessCustomer = new Customer(1L, "Dionysis", "d.petrotos@codehub.gr", "Stadiou 2", Nationality.GREEK);
    }
}
