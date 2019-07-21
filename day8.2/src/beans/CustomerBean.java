package beans;

import dao.CustomerDaoImpl;
import pojos.Customer;

public class CustomerBean {
	// properties of JB --represents clnt's state
	private String email, password;
	// result holding property
	private Customer validCustomer;
	private String message;
	// internal working of JB
	private CustomerDaoImpl dao;

	// def constr
	public CustomerBean() throws Exception {
		// inst DAO
		dao = new CustomerDaoImpl();
	}

	// getters n setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getValidCustomer() {
		return validCustomer;
	}

	public void setValidCustomer(Customer validCustomer) {
		this.validCustomer = validCustomer;
	}

	public CustomerDaoImpl getDao() {
		return dao;
	}

	public void setDao(CustomerDaoImpl dao) {
		this.dao = dao;
	}

	public String getMessage() {
		return message;
	}

	// B.L method for customer validation
	public String validateCustomer() throws Exception {
		System.out.println("in JB : validate" + email + " " + password);
		// invoke dao's method
		try {
			validCustomer = dao.validateCustomer(email, password);
		} catch (RuntimeException e) {
			System.out.println("in JB : validate " + e);
			message = "Invalid Login ,Pls Retry";
			return "login";
		}

		message = "Successful Login";
		return "category";// dyn navigational outcome
	}

}
