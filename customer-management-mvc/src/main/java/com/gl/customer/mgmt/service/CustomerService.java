package com.gl.customer.mgmt.service;

import com.gl.customer.mgmt.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int custId);

    public void deleteCustomer(int custId);
}
