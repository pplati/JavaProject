package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Nationality;

public class CustomerIndividual extends Customer {



    public CustomerIndividual(Long id, String name, String email, String address, Nationality nationality) {
        super(id, name, email, address, nationality);
    }

}
