package com.gl.customer.mgmt.dao;

import com.gl.customer.mgmt.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = currentSession.createQuery("from Customer order by first_name", Customer.class);
        List<Customer> customersList = customerQuery.list();
        return customersList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int custId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, custId);
        return customer;
    }

    @Override
    public void deleteCustomer(int custId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", custId);
        query.executeUpdate();

    }


}
