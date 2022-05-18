package model.order;

public class DeliveryInfor {

	private String cusPhone;
	private String cusName;
	private String cusAddress;
	
	public DeliveryInfor(){
		
	}

	public DeliveryInfor(String cusPhone, String cusName, String cusAddress) {
		super();
		this.cusPhone = cusPhone;
		this.cusName = cusName;
		this.cusAddress = cusAddress;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}


	
	
}
