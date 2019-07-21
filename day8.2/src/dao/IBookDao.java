package dao;

import java.util.List;

import pojos.Book;

public interface IBookDao {
	// list all category names
	List<String> getAllCategories() ;

	// list books available under chosen category
	List<Book> findBooksByCategory(String category) ;

	// get complete cart details
	List<Book> getCartDetails(List<Integer> bookIds) ;
}
