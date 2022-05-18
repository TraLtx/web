package logicApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

public static Connection con;
	
	public DAO(){
		if(con == null){
			String jdbcURL = "jdbc:mysql://localhost:3306/storebook?useSSL=false";
			String jdbcUsername = "root";
			String jdbcPassword = "12345";
			String jdbcClass = "com.mysql.cj.jdbc.Driver";
			
			try{
				Class.forName(jdbcClass);
				con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
