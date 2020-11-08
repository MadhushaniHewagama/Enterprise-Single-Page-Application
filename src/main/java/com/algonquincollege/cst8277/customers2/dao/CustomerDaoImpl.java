/*****************************************************************c******************o*******v******id********
 * File: CustomerDaoImpl.java
 * Course materials (20F) CST 8277
 *
 * @author (original) Mike Norman
 * 
 * update by : Karanjeet Kaur 040914436
 *
 */
package com.algonquincollege.cst8277.customers2.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import com.algonquincollege.cst8277.customers2.ejb.CustomerService;
import com.algonquincollege.cst8277.customers2.model.CustomerPojo;

/**
* Description: Implements the C-R-U-D API for the database
*/
@Named
@ApplicationScoped
public class CustomerDaoImpl implements CustomerDao, Serializable {
    /** explicitly set serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    @EJB
    protected CustomerService customerService;

    public static final String CUSTOMER_PU = "acmeCustomers-PU";

    protected EntityManager em;
    
    protected ServletContext sc;

    @Inject
    public CustomerDaoImpl(ServletContext sc) {
        super();
        this.sc = sc;
    }
    
    protected void logMsg(String msg) {
        sc.log(msg);
    }
    

    // delegate all C-R-U-D operations to EntityManager

    @Override
    public List<CustomerPojo> readAllCustomers() {
        logMsg("reading all customers");
        return customerService.getAllCustomers();
    }

    @Override
    public CustomerPojo createCustomer(CustomerPojo customerToBeCreated) {
        logMsg("creating an customer");
        return customerService.insertNewCustomer(customerToBeCreated);
    }

    @Override
    public CustomerPojo readCustomerById(int customerId) {
        logMsg("read a specific customer");
        return customerService.getCustomerByID(CustomerPojo.class, customerId);
    	
    }

    @Override
    @Transactional
    public CustomerPojo updateCustomer(CustomerPojo customerWithUpdates) {
        logMsg("updating a specific customer");
        CustomerPojo mergedCustomerPojo = customerService.updateCustomer(customerWithUpdates);
        return mergedCustomerPojo;
    }

    @Override
    @Transactional
    public void deleteCustomerById(int customerId) {
        logMsg("deleting a specific customer");
        CustomerPojo customer = readCustomerById(customerId);
        if (customer != null) {
        	customerService.refresh(customer);
        	customerService.remove(customer);
        }
    }

}