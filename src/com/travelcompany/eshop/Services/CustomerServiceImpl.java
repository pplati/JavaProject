package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer customer) {
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    public Customer get(Long id){
        for (Customer customer : customers) {
            if(customer.getId().equals(id)){
                return customer;
            }

        }
        return null;
    }
}
