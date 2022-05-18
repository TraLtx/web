package model.order;

import java.sql.Date;

public class Order {

	private int orderID;
	private String typeID;
	private Date createDate;
	private String status;
	private String shipddress;
	
	private Cart cart;
	
	private int amount;
	private float totalPrice;
	
	public Order(){
		
	}

	public Order(int orderID, String typeID, Date createDate, String status, Cart cart, Payment payment,
			Shipment shipment) {
		super();
		this.orderID = orderID;
		this.typeID = typeID;
		this.createDate = createDate;
		this.status = status;
		this.cart = cart;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShipddress() {
		return shipddress;
	}

	public void setShipddress(String shipddress) {
		this.shipddress = shipddress;
	}
	
	
	
	
}
