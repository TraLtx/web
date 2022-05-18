package logicApplication.customerDAO;

import java.sql.SQLException;

import model.customer.Customer;

public interface CustomerDAO {

	public void CustomerDAO();
	
	public boolean register(Customer cus) throws SQLException;
	public int checkLogin(String username, String password) throws SQLException;
	public Customer getCustomer(int id) throws SQLException;
	
}
