package model.order;

public class Cash extends Payment{

	private float cashTendered;
	private float receipt;
	
	public Cash(){
		
	}
	
	public Cash(float cashTendered, float receipt) {
		super();
		this.cashTendered = cashTendered;
		this.receipt = receipt;
	}

	public float getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(float cashTendered) {
		this.cashTendered = cashTendered;
	}

	public float getReceipt() {
		return receipt;
	}

	public void setReceipt(float receipt) {
		this.receipt = receipt;
	}
	
	
}
