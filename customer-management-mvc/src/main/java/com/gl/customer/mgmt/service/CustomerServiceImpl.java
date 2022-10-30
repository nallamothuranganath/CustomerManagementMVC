package com.gl.customer.mgmt.service;

import com.gl.customer.mgmt.dao.CustomerDAO;
import com.gl.customer.mgmt.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
         customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int custId) {
        return customerDAO.getCustomer(custId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int custId) {
         customerDAO.deleteCustomer(custId);
    }
}
