package model.staff;

public class Staff {

	private int staffID;
	private String typeID;
	private String name;
	private String username;
	private String password;
	private String position;
	
	public Staff(){
		
	}

	public Staff(int staffID, String typeID, String name, String username, String password, String position) {
		super();
		this.staffID = staffID;
		this.typeID = typeID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.position = position;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
