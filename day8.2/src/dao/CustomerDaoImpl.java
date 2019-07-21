package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Customer;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public Customer validateCustomer(String email, String password) {
		System.out.println("dao : validate query");
		String jpql = "select c from Customer c where c.email=:em and c.password=:pass";
		Customer c = null;
		// HS
		Session hs = getSf().getCurrentSession();
		// Tx
		Transaction tx = hs.beginTransaction();
		try {
			c=hs.createQuery(jpql, Customer.class).setParameter("em", email).
					setParameter("pass", password).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();//L1 cache destroyed n pooled out db cn rets to the pool
			throw e;
		}
		System.out.println("customer dao ret : "+c);
		return c;
	}

	@Override
	public String registerCustomer(Customer c) {
		System.out.println("cust reg "+c);
	String mesg="Customer reg failed...";
		//HS
		Session hs=getSf().getCurrentSession();
		//Tx
		Transaction tx=hs.beginTransaction();
		try {
			hs.save(c);
			tx.commit();
			mesg ="Customer reged successfully with ID "+c.getId();
		}catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	
	}

}
