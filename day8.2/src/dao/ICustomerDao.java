package dao;

import pojos.Customer;

public interface ICustomerDao {
	// validate customer
	Customer validateCustomer(String email, String password) ;
	//register customer
	String registerCustomer(Customer c) ;
}
