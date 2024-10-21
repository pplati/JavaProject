package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Nationality;

public class CustomerBusiness extends Customer {

    public CustomerBusiness(Long id, String name, String email, String address, Nationality nationality) {
        super(id, name, email, address, nationality);
    }
}
