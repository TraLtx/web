package model.book;

import java.sql.Date;

public class Author {

	private int authorID;
	private String typeID;
	private String name;
	private String country;
	private Date birthDay;
	private String infor;
	
	public Author(){
		
	}

	public Author(int authorID, String typeID, String name, String country, Date birthDay, String infor) {
		super();
		this.authorID = authorID;
		this.typeID = typeID;
		this.name = name;
		this.country = country;
		this.birthDay = birthDay;
		this.infor = infor;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}
	
	
}
