package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.*;

import pojos.Book;

public class BookDaoImpl implements IBookDao {

	@Override
	public List<String> getAllCategories() {
		List<String> categories = null;
		String jpql = "select distinct b.category from Book b";
		// HS
		Session hs = getSf().getCurrentSession();
		// Tx
		Transaction tx = hs.beginTransaction();
		try {
			categories = hs.createQuery(jpql, String.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("dao cats : " + categories);
		return categories;
	}

	@Override
	public List<Book> findBooksByCategory(String category) {
		List<Book> books = null;
		String jpql = "select b from Book b where b.category=:cat";
		// HS
		Session hs = getSf().getCurrentSession();
		// Tx
		Transaction tx = hs.beginTransaction();
		try {
			books = hs.createQuery(jpql, Book.class).setParameter("cat", category).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("dao reted bks by cat " + books);
		return books;
	}

	@Override
	public List<Book> getCartDetails(List<Integer> bookIds) {
		// empty list of books
		List<Book> purchasedBooks = null;
		String jpql = "select b from Book b where b.bookId in (:ids)";
		// HS
		Session hs = getSf().getCurrentSession();
		// Tx
		Transaction tx = hs.beginTransaction();
		try {
			purchasedBooks = hs.createQuery(jpql, Book.class).setParameterList("ids", bookIds).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("dao : purchased bks "+purchasedBooks);
		return purchasedBooks;
	}

}
