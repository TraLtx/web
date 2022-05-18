package logicApplication.staffDAO;

import java.sql.SQLException;

import model.staff.Staff;

public interface StaffDAO {

	public void StaffDAO();
	
	public int checkLogin(String username, String password) throws SQLException;
	public Staff getStaff(int id) throws SQLException;
	
}
