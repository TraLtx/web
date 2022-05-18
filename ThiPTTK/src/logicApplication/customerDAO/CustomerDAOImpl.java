package logicApplication.customerDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logicApplication.DAO;
import logicApplication.bookDAO.BookDAOImpl;
import model.book.BookItem;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.Fullname;
import model.order.Cart;
import model.staff.Staff;

public class CustomerDAOImpl extends DAO implements CustomerDAO{

	@Override
	public void CustomerDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean register(Customer cus) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO storebook.customer "
				+ "(typeID,firstname,midname,lastname,username,password,email,phonenumber,"
				+ "numberhouse,street, district, city, country) VALUES "
				+ "(?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "Cus_");
		ps.setString(2, cus.getFullname().getFirstName());
		ps.setString(3, cus.getFullname().getMidName());
		ps.setString(4, cus.getFullname().getLastName());
		ps.setString(5, cus.getAccount().getUsername());
		ps.setString(6, cus.getAccount().getPassword());
		ps.setString(7, cus.getEmail());
		ps.setString(8, cus.getPhone());
		
		ps.setString(9, cus.getAddress().getNumberHouse());
		ps.setString(10, cus.getAddress().getStreet());
		ps.setString(11, cus.getAddress().getDistrict());
		ps.setString(12, cus.getAddress().getCity());
		ps.setString(13, cus.getAddress().getCountry());
		
		boolean result = ps.executeUpdate() > 0;
		return result;
	}

	@Override
	public int checkLogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "SELECT customerID FROM storebook.customer WHERE username = ? AND password = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			result = rs.getInt("customerID");
			
		}
		
		return result;
	}

	@Override
	public Customer getCustomer(int id) throws SQLException {
		// TODO Auto-generated method stub
		Customer cus = null;
		String sql = "SELECT * FROM storebook.customer WHERE customerID = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			String firstName = rs.getString("firstName");
			String midName = rs.getString("midName");
			String lastName = rs.getString("lastName");
			Fullname fullname = new Fullname(firstName, midName, lastName);
			
			String username = rs.getString("username");
			String password = rs.getString("password");
			Account account = new Account(username, password);
			
			String numberHouse = rs.getString("numberHouse");
			String street = rs.getString("street");
			String district = rs.getString("district");
			String city = rs.getString("city");
			String country = rs.getString("country");
			Address address = new Address(numberHouse, street, district, city, country);
			
			String email = rs.getString("email");
			String phone = rs.getString("phoneNumber");
			
			cus = new Customer(email, account, fullname, address);
			cus.setPhone(phone);
			cus.setCustomerID(id);
			
		}
		return cus;
	}
	
}
