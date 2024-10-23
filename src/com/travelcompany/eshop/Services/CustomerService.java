package com.travelcompany.eshop.Services;

import com.travelcompany.eshop.domain.Customer;

import java.util.List;

public interface CustomerService {
    void add(Customer customer);
    List<Customer> findAll();
    Customer get(Long id);

}
