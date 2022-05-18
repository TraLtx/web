package logicApplication.orderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logicApplication.DAO;
import logicApplication.bookDAO.BookDAOImpl;
import model.book.BookItem;
import model.order.Cart;

public class CartDAOImpl extends DAO implements CartDAO{

	@Override
	public void CartDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int createCart(Cart cart) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO storebook.cart "
				+ "(typeID,customercustomerid,createdate,status) VALUES "
				+ "(?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "Cart");
		ps.setInt(2, cart.getCustomer().getCustomerID()); System.out.println("cusID:"+cart.getCustomer().getCustomerID());
		ps.setDate(3, cart.getCreateDate());
		ps.setString(4, cart.getStatus());
		
		int lastid = 0;
		ps.executeUpdate();
		ResultSet rs=ps.getGeneratedKeys();
		if(rs.next()){
			lastid=rs.getInt(1);
		}
//		if(ps.executeUpdate() > 0){
//			String sqlGetId = "select last_insert_id() as last_id FROM storebook.cart";
//			PreparedStatement ps2 = con.prepareStatement(sql);
//			ResultSet rs = ps2.executeQuery();
//			lastid = rs.getInt("last_id");
//		}
		
		return lastid;
	}

	@Override
	public boolean addItem(int cartId, int bookId) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "UPDATE storebook.bookitem SET CartCartID = ? WHERE ID = ?";
		  
		
		PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, cartId);
        ps.setInt(2, bookId);
         
        boolean result = ps.executeUpdate() > 0;
        
        return result;
	}

	@Override
	public boolean removeItem(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE storebook.bookitem SET CartCartID = NULL WHERE ID = ?";
		  
		
		PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
         
        boolean result = ps.executeUpdate() > 0;
        
        return result;
	}

	@Override
	public boolean deleteCart(Cart cart) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<BookItem> listBook = cart.getListBook();
		
		for(int i=0; i<listBook.size(); i++){
			BookItem b = listBook.get(i);
			if(removeItem(b.getBook().getBookID()) == false) return false;
		}
		String sql = "DELETE FROM `storebook`.`cart` WHERE (`CartID` = ?);";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cart.getCartID());

		boolean result = ps.executeUpdate() > 0;
		return result;
	}
	
public Cart getOrderedCart(int cartid) throws SQLException{
		
		Cart cart = null;
		
		BookDAOImpl bookDAO = new BookDAOImpl();
		
		String sql = "SELECT * FROM storebook.cart WHERE cartID = ? AND status = 'ordered';";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cartid);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			cart = new Cart();
			
			cart.setListBook(bookDAO.getCartItem(rs.getInt("cartID")));
			
			cart.setCartID(rs.getInt("cartID"));
			cart.setCreateDate(rs.getDate("createDate"));
			cart.setStatus(rs.getString("status"));
			cart.setTypeID("cart");
			
		}
		
		return cart;
	}

	@Override
	public Cart getCart(int id) throws SQLException {
		// TODO Auto-generated method stub
		Cart cart = null;
		
		BookDAOImpl bookDAO = new BookDAOImpl();
		
		String sql = "SELECT * FROM storebook.cart WHERE CustomerCustomerID = ? AND status = 'new';";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){System.out.println("Have cart");
			cart = new Cart();
			
			cart.setListBook(bookDAO.getCartItem(rs.getInt("cartID")));
			
			cart.setCartID(rs.getInt("cartID"));
			cart.setCreateDate(rs.getDate("createDate"));
			cart.setStatus(rs.getString("status"));
			cart.setTypeID("cart");
			
		}
		
		return cart;
	}

}
