package logicApplication.orderDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.order.Order;

public interface OrderDAO {

	public void OrderDAO();
	
	public boolean createOrder(Order order) throws SQLException;
	public ArrayList<Order> getNewOrder()throws SQLException;
	public ArrayList<Order> getAllOrder(int cusId)throws SQLException; 
}
