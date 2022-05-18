package model.order;

import java.sql.Date;

public class Payment {

	private int paymentID;
	private String typeID;
	private String payType;
	private Date payDate;
	
	public Payment(){
		
	}

	public Payment(int paymentID, String typeID, String payType, Date payDate) {
		super();
		this.paymentID = paymentID;
		this.typeID = typeID;
		this.payType = payType;
		this.payDate = payDate;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	
}
