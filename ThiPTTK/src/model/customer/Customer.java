package model.customer;

import java.sql.Date;

public class Customer {

	private int customerID;
	private String typeID;
	private String email;
	private String phone;
	
	private Account account;
	private Fullname fullname;
	private Address address;
	
	public Customer(){
		
	}
	
	public Customer(int customerID, String typeID, String email, Account account, Fullname fullname,
			Address address) {
		super();
		this.customerID = customerID;
		this.typeID = typeID;
		this.email = email;
		this.account = account;
		this.fullname = fullname;
		this.address = address;
	}
	
	public Customer(String email, Account account, Fullname fullname,
			Address address) {
		super();
		this.email = email;
		this.account = account;
		this.fullname = fullname;
		this.address = address;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Fullname getFullname() {
		return fullname;
	}

	public void setFullname(Fullname fullname) {
		this.fullname = fullname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
