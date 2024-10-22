package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Nationality;

public class CustomerBusiness extends Customer {

    private String category;

        public CustomerBusiness(Long id, String name, String email, String address, Nationality nationality) {
        super(id, name, email, address, nationality);
    }

}
