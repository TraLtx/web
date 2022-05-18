package logicApplication.staffDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicApplication.DAO;
import model.book.Author;
import model.staff.Staff;

public class StaffDAOImpl extends DAO implements StaffDAO{

	@Override
	public void StaffDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkLogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "SELECT staffID FROM storebook.staff WHERE username = ? AND password = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			result = rs.getInt("staffID");
			
		}
		
		return result;
	}

	@Override
	public Staff getStaff(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		Staff staff = null;
		String sql = "SELECT * FROM storebook.staff WHERE staffID = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			String typeID = "Staff";
			String name = rs.getString("fullname");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String position = rs.getString("position");
			
			staff = new Staff(id, typeID, name, username, password, position);
		}
		return staff;
	}

}
