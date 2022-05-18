package model.order;

import java.sql.Date;

public class Credit extends Payment{

	private String bank;
	private String number;
	private String type;
	private Date expDate;
	
	public Credit(){
		
	}

	public Credit(String bank, String number, String type, Date expDate) {
		super();
		this.bank = bank;
		this.number = number;
		this.type = type;
		this.expDate = expDate;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
}
