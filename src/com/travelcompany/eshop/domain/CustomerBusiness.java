package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;

public class CustomerBusiness extends Customer {
    private Category category = Category.BUSINESS;

        public CustomerBusiness(Long id, String name, String email, String address, Nationality nationality) {
        super(id, name, email, address, nationality);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() +
                "category=" + category +
                '}';
    }
}
