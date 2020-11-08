/*****************************************************************c******************o*******v******id********
 * File: CustomerService.java
 * Course materials (20F) CST 8277
 *
 * @author (original) Mike Norman
 *
 *update by : Karanjeet Kaur 040914436
 *
 */
package com.algonquincollege.cst8277.customers2.ejb;

import static com.algonquincollege.cst8277.customers2.model.CustomerPojo.ALL_CUSTOMERS_QUERY_NAME;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.algonquincollege.cst8277.customers2.model.CustomerPojo;

/**
 * Stateless Singleton Session Bean - CustomerService
 */
@Singleton
public class CustomerService implements Serializable{
	private static final long serialVersionUID = 1L;

    public static final String CUSTOMER_PU = "acmeCustomers-PU";

    @PersistenceContext(name = CUSTOMER_PU)
    protected EntityManager em;
    
	public List<CustomerPojo> getAllCustomers() {
        TypedQuery<CustomerPojo> allCustomersQuery = em.createNamedQuery(ALL_CUSTOMERS_QUERY_NAME, CustomerPojo.class);
        return allCustomersQuery.getResultList();		
	}

	@Transactional
	public CustomerPojo insertNewCustomer(CustomerPojo customerToBeCreated) {
		em.persist(customerToBeCreated);
		return customerToBeCreated;
	}

	public CustomerPojo getCustomerByID(Class<CustomerPojo> class1, int customerId) {
		return em.find(class1, customerId);
	}
	
	@Transactional
	public CustomerPojo updateCustomer(CustomerPojo customerWithUpdates) {
		CustomerPojo customerToBeUpdated = getCustomerByID(CustomerPojo.class,customerWithUpdates.getId());
		if(customerToBeUpdated != null) {
			em.merge(customerWithUpdates);
		}
		return customerWithUpdates;
	}
	
	@Transactional
	public void refresh(CustomerPojo customer) {
		em.refresh(customer);
		
	}
	
	@Transactional
	public void remove(CustomerPojo customer) {
		em.remove(customer);
		
	}

	

}
