package model.customer;

public class Address {

	private String numberHouse;
	private String street;
	private String district;
	private String city;
	private String country;
	
	public Address(){
		
	}

	public Address(String numberHouse, String street, String district, String city, String country) {
		super();
		this.numberHouse = numberHouse;
		this.street = street;
		this.district = district;
		this.city = city;
		this.country = country;
	}

	public String getNumberHouse() {
		return numberHouse;
	}

	public void setNumberHouse(String numberHouse) {
		this.numberHouse = numberHouse;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
