package beans;

import java.util.ArrayList;
import java.util.List;

import dao.BookDaoImpl;
import pojos.Book;

public class BookBean {
//properties
	private BookDaoImpl dao;
	// clnt conv state
	private String cat;
	private int[] bkId;// selected book ids.
	// property to store the cart
	private List<Integer> cart;
	//cart value
	private double total;

	// constr
	public BookBean() throws Exception {
		System.out.println("in book bean constr");

		// dao inst
		dao = new BookDaoImpl();
		cart = new ArrayList<>();
		System.out.println("created empty cart");
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getCat() {
		return cat;
	}

	public void setBkId(int[] bkId) {
		this.bkId = bkId;
	}
	
	

	public double getTotal() {
		return total;
	}

	// B.L method to get all categories of bks
	public List<String> listCategories() throws Exception {
		System.out.println("JB : book bean : list cats");
		return dao.getAllCategories();
	}

	// B.L method to get list of books by a category
	public List<Book> getBooks() throws Exception {
		System.out.println("JB : book bean : get bks by cat");
		return dao.findBooksByCategory(cat);
	}

	// B.L method to populate the cart
	public String populateCart() throws Exception {
		// read from int[] ---> List
		for (int id : bkId)
			cart.add(id);// auto boxing
		System.out.println("in JB : populate cart " + cart);
		return "category";
	}
	//B.L method to get purchase book details
	public List<Book> getPurchasedBooks() throws Exception
	{
		//invoke dao's method
		List<Book> bks=dao.getCartDetails(cart);
		total=0;
		for(Book b : bks)
			total += b.getPrice();
		return bks;
	}
}
