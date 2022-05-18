package logicApplication.orderDAO;

import java.sql.SQLException;

import model.book.BookItem;
import model.order.Cart;

public interface CartDAO {

	public void CartDAO();
	
	public int createCart(Cart cart) throws SQLException;
	public boolean addItem(int cartId, int bookId) throws SQLException;
	public boolean removeItem(int id) throws SQLException;
	public boolean deleteCart(Cart cart) throws SQLException;
	
	public Cart getCart(int id) throws SQLException;
	
}
