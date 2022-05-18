package logicApplication.orderDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logicApplication.DAO;
import logicApplication.customerDAO.CustomerDAOImpl;
import model.book.Book;
import model.book.BookItem;
import model.order.Cart;
import model.order.Cash;
import model.order.Credit;
import model.order.DeliveryInfor;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;

public class OrderDAOImpl extends DAO implements OrderDAO{

	@Override
	public void OrderDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		
		String sql = "INSERT INTO `storebook`.`order` (`TypeID`,`CreateDate`,`status`,`shipaddress`,`totalPrice`,`amount`) "
				+ "VALUES ('Order_',?,?,?,?,?);";
		
		PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setDate(1, order.getCreateDate());
		ps.setString(2, order.getStatus());
		ps.setString(3, order.getShipddress());
		ps.setFloat(4, order.getTotalPrice());
		ps.setInt(5, order.getAmount());
		
		int lastid = 0;
		ps.executeUpdate();
		ResultSet rs=ps.getGeneratedKeys();
		if(rs.next()){
			lastid=rs.getInt(1);
			result = true;
			
			updateCart(lastid, order.getCart().getCartID());
			
		}
		
		return result;
	}
	
	public boolean updateCart(int orderId, int cartId)throws SQLException{
		String sql = "UPDATE `storebook`.`cart` SET `OrderOrderID` = ?, status = 'ordered' WHERE (`CartID` = ?);";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, orderId);
		ps.setInt(2, cartId);
		
		boolean result = ps.executeUpdate() > 0;
		return result;
	}
	
//	public boolean addShipment(int orderId, Shipment shipment) throws SQLException{
//		String sql = "INSERT INTO `storebook`.`shipment` (`OrderOrderID`,`TypeID`,`Note`,`Status`,`Shiptype`,`CusPhone`, `CusName`, `CusAddress`) "
//				+ "VALUES (?,?,?,?,?,?,?,?);";
//		
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, orderId);
//		ps.setString(2, "Ship");
//		ps.setString(3, shipment.getNote());
//		ps.setString(4, shipment.getStatus());
//		ps.setString(5, shipment.getShipType());
//		ps.setString(6, shipment.getDeliveryInfor().getCusPhone());
//		ps.setString(7, shipment.getDeliveryInfor().getCusName());
//		ps.setString(8, shipment.getDeliveryInfor().getCusAddress());
//		
//		boolean result = ps.executeUpdate() > 0;
//		return result;
//	}
	
//	public boolean addCash(int orderId, Cash payment) throws SQLException{
//		
//		String sql = "INSERT INTO `storebook`.`payment` (`OrderOrderID`,`TypeID`,`PayType`) "
//				+ "VALUES (?,?,?);";
//		
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, orderId);
//		ps.setString(2, "Pay");
//		ps.setString(3, payment.getPayType());
//		
//		boolean result = ps.executeUpdate() > 0;
//		return result;
//	}

//	public boolean addCredit(int orderId, Credit payment) throws SQLException{
//		
//		String sql = "INSERT INTO `storebook`.`payment` (`OrderOrderID`,`TypeID`,`PayType`,`Bank`,`Number`,`Type`,`ExpDate`) "
//				+ "VALUES (?,?,?,?,?,?,?);";
//		
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, orderId);
//		ps.setString(2, "Pay");
//		ps.setString(3, payment.getPayType());
//		ps.setString(4, payment.getBank());
//		ps.setString(5, payment.getNumber());
//		ps.setString(6, payment.getType());
//		ps.setDate(7, payment.getExpDate());
//		
//		boolean result = ps.executeUpdate() > 0;
//		return result;
//	}

	@Override
	public ArrayList<Order> getNewOrder() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getAllOrder(int cusId) throws SQLException {
		// TODO Auto-generated method stub
		//CustomerDAOImpl cusDAO = new CustomerDAOImpl();
		CartDAOImpl cartDAO = new CartDAOImpl();
		ArrayList<Order> listOrder = new ArrayList<>();
		
		String sql = "SELECT * FROM storebook.cart WHERE customercustomerId=? AND status = 'ordered'; ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cusId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			int orderId = rs.getInt("orderorderId");//Tim order theo cusid va cart da order	
			Order order = getOrder(orderId);
			
			int cartId = rs.getInt("cartId"); //Lay cart va listItem theo cartId de cho vao Order
			Cart cart = cartDAO.getOrderedCart(cartId);
			order.setCart(cart);
			
			int amount = cart.getListBook().size();
			
			int totalPrice = 0;
			for(BookItem b : cart.getListBook()) totalPrice += b.getPrice();
			
			
			listOrder.add(order);
			
		}
		return listOrder;
	}
	
	public Order getOrder(int orderId) throws SQLException{
		
		System.out.println("Get order with id: " + orderId);
		
		Order order = null;
		
		String sql = "SELECT * FROM storebook.order WHERE orderId=? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, orderId);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			order = new Order();
			
			Date createDate = rs.getDate("createDate");
			String status = rs.getString("status");
			String address = rs.getString("shipaddress");
			float totalPrice = rs.getFloat("totalPrice");
			int amount = rs.getInt("amount");
			
			order.setOrderID(orderId);
			order.setCreateDate(createDate);
			order.setStatus(status);
			order.setShipddress(address);
			order.setAmount(amount);
			order.setTotalPrice(totalPrice);
		}
		
		return order;
	}
	
//	public Shipment getShipment(int orderId) throws SQLException{
//		
//		Shipment shipment = null;
//		
//		String sql = "SELECT * FROM storebook.shipment WHERE orderorderId=? ";
//		
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, orderId);
//		ResultSet rs = ps.executeQuery();
//		
//		if(rs.next()){
//			
//			int id = rs.getInt("shipmentID");
//			
//			String cusName = rs.getString("cusName");
//			String cusPhone = rs.getString("cusPhone");
//			String cusAddress = rs.getString("cusAddress");
//			DeliveryInfor deliveryInfor = new DeliveryInfor(cusPhone, cusName, cusAddress);
//			
//			String shipType = rs.getString("shipType");
//			String note = rs.getString("note");
//			String status = rs.getString("status");
//			
//			shipment = new Shipment();
//			shipment.setDeliveryInfor(deliveryInfor);
//			shipment.setNote(note);
//			shipment.setShipType(shipType);
//			shipment.setShipmentID(id);
//			shipment.setStatus(status);
//		}
//		
//		return shipment;
//	}
	
//	public Payment getPayment(int orderId) throws SQLException{
//		
//		Payment payment = null;
//		
//		String sql = "SELECT * FROM storebook.payment WHERE orderorderId=? ";
//		
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, orderId);
//		ResultSet rs = ps.executeQuery();
//		
//		if(rs.next()){
//			
//			int id = rs.getInt("paymentID");
//			
//			String payType = rs.getString("paytype");
//			
//			payment = new Payment();
//			payment.setPayType(payType);
//		}
//		
//		return payment;
//	}
	
}
