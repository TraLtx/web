package model.order;

import java.sql.Date;

public class Shipment {
	
	private int shipmentID;
	private String typeID;
	private float shipWeight;
	private String note;
	private String status;
	private String shipType;
	private float price;
	private Date createDate;
	private Date deliveryDate;
	
	private DeliveryInfor deliveryInfor;
	
	public Shipment(){
		
	}

	public Shipment(int shipmentID, String typeID, float shipWeight, String note, String status, String shipType, float price,
			Date createDate, Date deliveryDate, DeliveryInfor deliveryInfor) {
		super();
		this.shipmentID = shipmentID;
		this.typeID = typeID;
		this.shipWeight = shipWeight;
		this.note = note;
		this.status = status;
		this.shipType = shipType;
		this.price = price;
		this.createDate = createDate;
		this.deliveryDate = deliveryDate;
		this.deliveryInfor = deliveryInfor;
	}

	public int getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(int shipmentID) {
		this.shipmentID = shipmentID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public float getShipWeight() {
		return shipWeight;
	}

	public void setShipWeight(float shipWeight) {
		this.shipWeight = shipWeight;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public DeliveryInfor getDeliveryInfor() {
		return deliveryInfor;
	}

	public void setDeliveryInfor(DeliveryInfor deliveryInfor) {
		this.deliveryInfor = deliveryInfor;
	}
	
	
}
