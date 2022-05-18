package model.order;

import java.sql.Date;
import java.util.ArrayList;

import model.book.BookItem;
import model.customer.Customer;

public class Cart {

	private int cartID;
	private String typeID;
	private Date createDate;
	private String status;
	
	private Customer customer;
	private ArrayList<BookItem> listBook;
	
	public Cart(){
		
	}

	public Cart(int cartID, String typeID, Date createDate, String status, Customer customer,
			ArrayList<BookItem> listBook) {
		super();
		this.cartID = cartID;
		this.typeID = typeID;
		this.createDate = createDate;
		this.status = status;
		this.customer = customer;
		this.listBook = listBook;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<BookItem> getListBook() {
		return listBook;
	}

	public void setListBook(ArrayList<BookItem> listBook) {
		this.listBook = listBook;
	}
	
	
}
