package web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicApplication.bookDAO.BookDAOImpl;
import logicApplication.customerDAO.CustomerDAOImpl;
import logicApplication.orderDAO.CartDAOImpl;
import logicApplication.orderDAO.OrderDAOImpl;
import logicApplication.staffDAO.StaffDAOImpl;
import model.book.Book;
import model.book.BookItem;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.Fullname;
import model.order.Cart;
import model.order.Cash;
import model.order.Credit;
import model.order.DeliveryInfor;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;
import model.staff.Staff;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookDAOImpl bookDAO;
    private StaffDAOImpl staffDAO;
    private CustomerDAOImpl cusDAO;
    private CartDAOImpl cartDAO;
    private OrderDAOImpl orderDAO;
    
    private ArrayList<Book> listBook;
    private ArrayList<BookItem> listBookItem;
    private ArrayList<BookItem> listCartItem;
    //private ArrayList<Order> listNewOrder;
    
    private Staff staff = null;
    private Customer customer= null;
    private Cart cart = null;
    private Order order = null;
    
    public void init() { 
    	
    	bookDAO = new BookDAOImpl();
    	staffDAO = new StaffDAOImpl();
    	cusDAO = new CustomerDAOImpl();
    	cartDAO = new CartDAOImpl();
    	orderDAO = new OrderDAOImpl();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/home":
            	index(request, response);
                break;
            case "/logout":
            	logout(request, response);
                break;
            case "/allBook":
            	showAllBookPage(request, response);
                break;
            case "/staff":
                showStaffPage(request, response);
                break;
            case "/wareHouse":
                showWareHousePage(request, response);
                break;
            case "/login":
                showLoginPage(request, response);
                break;
            case "/loginResult":
            	loginResult(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/editItem":
                showEditItemForm(request, response);
                break;
            case "/storeItem":
                showEditForm(request, response);
                break;
            case "/newBook":
                showNewBookForm(request, response);
                break;
            case "/addBook":
                addBook(request, response);
                break;
            case "/update":
                updateBook(request, response);
                break;
            case "/updateItem":
                updateBookItem(request, response);
                break;
            case "/push":
                showPushForm(request, response);
                break;
            case "/pushItem":
                pushItem(request, response);
                break;
            case "/webItem":
                showWebItemPage(request, response);
                break;
            case "/view":
                showViewBookPage(request, response);
                break;
            case "/register":
                showRegisterPage(request, response);
                break;
            case "/registerResult":
            	registerResult(request, response);
                break;
            case "/addToCart":
                addToCart(request, response);
                break;
            case "/viewCart":
            	showCartPage(request, response);
                break;
            case "/createCart":
            	createCart(request, response);
                break;
            case "/deleteCart":
            	deleteCart(request, response);
                break;
            case "/removeItem":
            	removeCartItem(request, response);
                break;
            case "/order":
            	showOrderHandlerPage(request, response);
                break;
            case "/confirmOrder":
            	order(request, response);
                break;
            case "/viewNewestOrder":
            	showNewestOrderPage(request, response);
                break;
            case "/viewOrder":
            	showAllOrderPage(request, response);
                break;
            case "/searchBook":
            	searchBookResult(request, response);
                break;
            default:
                index(request, response);
                break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void index(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
    	request.setAttribute("customer", customer);
        //RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    	RequestDispatcher dispatcher = request.getRequestDispatcher("orderPage.jsp");
        dispatcher.forward(request, response);
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
    	staff = null;
    	customer = null;
    	
    	request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showAllBookPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
    	listBookItem = bookDAO.getAllBookItem();
    	
    	//System.out.println("ListItem:"+listBookItem.size());
    	request.setAttribute("listBookItem", listBookItem);
    	request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("allBookPage.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showStaffPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//System.out.println("StaffPage:"+staff.getName());
    	request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staffPage.jsp");
        dispatcher.forward(request, response);
    }
// 
    private void showWareHousePage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
    	listBook = bookDAO.getAllBook();
    	System.out.println("list : "+listBook.size());
    	
        request.setAttribute("listBook", listBook);
        request.setAttribute("staff", staff);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("wareHousePage.jsp");
        dispatcher.forward(request, response);
    }
// 
    private void showLoginPage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("loginPage.jsp");
        dispatcher.forward(request, response);
    }
// 
    private void loginResult(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
    	//String[] isStaff = new String [] {"0"};
    	
    	String username = request.getParameter("username");//System.out.println("U:"+username);
		String password = request.getParameter("password");
		String[] isStaff = request.getParameterValues("checkStaff");
    	
		//System.out.println("check:"+isStaff[0]);
    	if(isStaff != null){System.out.println("Is staff");
    		
    		int id = staffDAO.checkLogin(username, password);
    		if(id != 0) {
				staff = staffDAO.getStaff(id);
				
				System.out.println(staff.getName());
				request.setAttribute("staff", staff);
				RequestDispatcher dispatcher = request.getRequestDispatcher("staffPage.jsp");
		        dispatcher.forward(request, response);
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
		        dispatcher.forward(request, response);
			}
    		
    	}else{System.out.println("Is cus");
    		int id = cusDAO.checkLogin(username, password);
    		customer = cusDAO.getCustomer(id);
    		cart = cartDAO.getCart(id);
    		if(cart != null) {System.out.println("Cus da co cart");
    			cart.setCustomer(customer);
    			listCartItem = cart.getListBook();
    		}
    		
    		request.setAttribute("customer", customer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
    	}
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Book book = null;
        System.out.println("list Size:"+listBook.size());
        for(int i = 0; i<listBook.size(); i++){
        	if(listBook.get(i).getBookID() == id){
        		book = listBook.get(i);
        		continue;
        	}
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookForm.jsp");
        request.setAttribute("book", book);
        request.setAttribute("staff", staff);
        dispatcher.forward(request, response);
    }
    
    private void showEditItemForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        BookItem bookItem = bookDAO.getBookItem(id);
        		
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookItemForm.jsp");
        request.setAttribute("bookItem", bookItem);
        request.setAttribute("staff", staff);
        dispatcher.forward(request, response);
    }
    
    private void showNewBookForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookForm.jsp");
        request.setAttribute("staff", staff);
        dispatcher.forward(request, response);
    }
    
    private void addBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
		Book book = null;
		        
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title"); System.out.println(title);
		String language = request.getParameter("language");
		int numOfPages = Integer.parseInt(request.getParameter("numOfPages"));
		String summary = request.getParameter("summary");
		int publishYear = Integer.parseInt(request.getParameter("publishYear"));
		float cost = Float.parseFloat(request.getParameter("cost"));
		String barcode = request.getParameter("barcode");
		String author = request.getParameter("author");
		
		book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setLanguage(language);
		book.setNumOfPages(numOfPages);
		book.setSummary(summary);
		book.setPublishYear(publishYear);
		book.setCost(cost);
		book.setBarcode(barcode);
		book.setAuthor(author);
		
		if(bookDAO.addBook(book))	listBook = bookDAO.getAllBook();
        
        request.setAttribute("listBook", listBook);
        request.setAttribute("staff", staff);
        response.sendRedirect("wareHouse");
    }
    
    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	
        int id = Integer.parseInt(request.getParameter("id"));
        
        Book book = null;
        
        for(int i = 0; i<listBook.size(); i++){
        	if(listBook.get(i).getBookID() == id){
        		
        		book = listBook.get(i);
        		
        		String isbn = request.getParameter("isbn");
                String title = request.getParameter("title"); System.out.println(title);
                String language = request.getParameter("language");
                int numOfPages = Integer.parseInt(request.getParameter("numOfPages"));
                String summary = request.getParameter("summary");
                int publishYear = Integer.parseInt(request.getParameter("publishYear"));
                float cost = Float.parseFloat(request.getParameter("cost"));
                String barcode = request.getParameter("barcode");
                String author = request.getParameter("author");
                //String status = request.getParameter("status");
                //System.out.println("Status: "+status);
                
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setLanguage(language);
                book.setNumOfPages(numOfPages);
                book.setSummary(summary);
                book.setPublishYear(publishYear);
                book.setCost(cost);
                book.setBarcode(barcode);
                book.setAuthor(author);
              
                //book.setStatus(status);
                
                if(bookDAO.update(book) == true)   	listBook.set(i, book);

        		continue;
        	}
        }
        
        request.setAttribute("listBook", listBook);
        request.setAttribute("staff", staff);
        response.sendRedirect("wareHouse");
    }

    private void updateBookItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {System.out.println("update ne");
    	
        int id = Integer.parseInt(request.getParameter("id"));
        
        BookItem bookItem = new BookItem();
                
        float price = Float.parseFloat(request.getParameter("price"));
        String image = request.getParameter("image");
        //String status = request.getParameter("status");
        //System.out.println("Status: "+status);  

        bookItem.setId(id);
        bookItem.setImage(image);
        bookItem.setPrice(price);
        //book.setStatus(status);
        
        if(bookDAO.updateItem(bookItem) == true)   	listBookItem = bookDAO.getAllBookItem();


        
        request.setAttribute("listBook", listBookItem);
        request.setAttribute("staff", staff);
        response.sendRedirect("webItem");
    }
    
    private void showPushForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Book book = null;
        System.out.println("list Size:"+listBook.size());
        for(int i = 0; i<listBook.size(); i++){
        	if(listBook.get(i).getBookID() == id){
        		book = listBook.get(i);
        		continue;
        	}
        }
        BookItem bookItem = new BookItem();
        bookItem.setBook(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookItemForm.jsp");
        request.setAttribute("book", book);
        request.setAttribute("bookItem", bookItem);
        dispatcher.forward(request, response);
    }
            
    private void pushItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {System.out.println("push ne");
    	
        int id = Integer.parseInt(request.getParameter("id"));
        
        Book book = null;
        
        for(int i = 0; i<listBook.size(); i++){
        	if(listBook.get(i).getBookID() == id){
        		
        		book = listBook.get(i);
        		
                float price = Float.parseFloat(request.getParameter("price"));
                String image = request.getParameter("image");
                
                BookItem bookItem = new BookItem();
                bookItem.setBook(book);
                bookItem.setPrice(price);
                bookItem.setImage(image);
                
                if(bookDAO.upToStore(bookItem) == true)   	listBook.remove(i);

        		continue;
        	}
        }
        
        request.setAttribute("listBook", listBook);
        request.setAttribute("staff", staff);
        response.sendRedirect("wareHouse");
    }
   
    private void showWebItemPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
    	listBookItem = bookDAO.getAllBookItem();
    	
        request.setAttribute("listBook", listBookItem);
        request.setAttribute("staff", staff);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("webItemPage.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showViewBookPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        BookItem bookChoose = bookDAO.getBookItem(id);
        
        request.setAttribute("bookItem", bookChoose);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewBookPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void showRegisterPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("registerPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void registerResult(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {

    	String firstName = request.getParameter("firstName");
		String midName = request.getParameter("midName");
		String lastName = request.getParameter("lastName");
		Fullname fullname = new Fullname(firstName, midName, lastName);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = new Account(username, password);
		
		String numberHouse = request.getParameter("numberHouse");
		String street = request.getParameter("street");
		String district = request.getParameter("district");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		Address address = new Address(numberHouse, street, district, city, country);
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		
		
		Customer cus = new Customer(email, account, fullname, address);
		cus.setPhone(phone);
		
		cusDAO.register(cus);
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	int totalPrice = 0;
    	
        if(cart != null){
       	 	
        	int id = Integer.parseInt(request.getParameter("id"));
            BookItem bookChoose = bookDAO.getBookItem(id);
            
            boolean duplicate = false;
            for(BookItem b : listCartItem){
            	if(b.getId() == id) duplicate = true;
            }
            if(duplicate == false){
            	System.out.println("Add id cart to bookitem");
            	cartDAO.addItem(cart.getCartID(), id);
            	listCartItem.add(bookChoose);
            	cart.setListBook(listCartItem);
            }
            
            for(BookItem b : listCartItem){
        		totalPrice += b.getPrice();
        	}
        }
        request.setAttribute("cart", cart);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cartPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void showCartPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        
    	int totalPrice = 0;
    	
    	if(cart != null){
        	for(BookItem b : listCartItem){
        		totalPrice += b.getPrice();
        	}
    	}
    	
        request.setAttribute("cart", cart);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cartPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void createCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        LocalDate dateCreateString = java.time.LocalDate.now();
        String date = dateCreateString.toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse(date);
        java.sql.Date createDate = new java.sql.Date(parsed.getTime());
        
        cart = new Cart();
        cart.setCustomer(customer);
        cart.setCreateDate(createDate);
        cart.setStatus("new");
        listCartItem = new ArrayList<>();
        cart.setListBook(listCartItem);
        
        int id = cartDAO.createCart(cart);System.out.println("CartID:"+id);
        cart.setCartID(id);
        
        request.setAttribute("cart", cart);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cartPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void deleteCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
    	if( cartDAO.deleteCart(cart) ){
    		listCartItem = null;
    		cart = null;
    	}
    	
        
        request.setAttribute("cart", cart);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cartPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void removeCartItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	if(cartDAO.removeItem(id)){
    		for(int i=0;i<listCartItem.size();i++){    			
    			if(listCartItem.get(i).getId() == id){
    				listCartItem.remove(i);
    	    		cart.setListBook(listCartItem);
    			}
    			
    		}
    	}
        
    	int totalPrice = 0;
    	
    	if(cart != null){
        	for(BookItem b : listCartItem){
        		totalPrice += b.getPrice();
        	}
    	}

        request.setAttribute("totalPrice", totalPrice);
        
        request.setAttribute("cart", cart);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cartPage.jsp");
        dispatcher.forward(request, response);
    }
        
    private void showOrderHandlerPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	    	
    	int totalPrice = 0;
    	
    	if(cart != null){
        	for(BookItem b : listCartItem){
        		totalPrice += b.getPrice();
        	}
    	}
    	
    	request.setAttribute("amount", cart.getListBook().size());
    	request.setAttribute("totalPrice", totalPrice);
    	
        request.setAttribute("cart", cart);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderHandlerPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void order(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
    	    	
    	String cusPhone = request.getParameter("phone");
    	String cusName = request.getParameter("fullname");
    	String cusAddress = request.getParameter("address");	
    	String shipType = request.getParameter("shipment");
    	String note = request.getParameter("note");
    	
//    	DeliveryInfor deliveryInfor = new DeliveryInfor(cusPhone, cusName, cusAddress);
//    	
//    	Shipment shipment = new Shipment();
//    	shipment.setDeliveryInfor(deliveryInfor);
//    	shipment.setNote(note);
//    	shipment.setShipType(shipType);
//    	shipment.setStatus("new");
    	
    	String payType;
    	Cash cash = new Cash();
    	Credit credit = new Credit();
    	
    	order = new Order();
    	
    	order.setCart(cart);
    	order.setStatus("Handling");
    	order.setShipddress(cusAddress);
    	
    	
//    	if(byCredit != null){//Use credit
//    		payType = "credit";
//        	String bank = request.getParameter("bank");
//        	String creditType = request.getParameter("type");
//        	String number = request.getParameter("number");
//        	String expDateString = request.getParameter("expDate");
//        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date parsed = format.parse(expDateString);
//            java.sql.Date expDate = new java.sql.Date(parsed.getTime());
//            
//        	credit.setPayType(payType);
//        	 credit.setBank(bank);
//        	 credit.setNumber(number);
//        	 credit.setType(creditType);
//        	 credit.setExpDate(expDate);
//
//        	order.setPayment(credit);
//    		
//    	}else{//Use cash
//    		payType = "cash";
//    		
//    		cash.setPayType(payType);
//    		
//    		order.setPayment(cash);
//    	}
    	
    	LocalDate dateCreateString = java.time.LocalDate.now();
        String date = dateCreateString.toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse(date);
        java.sql.Date createDate = new java.sql.Date(parsed.getTime());
        
        order.setCreateDate(createDate);
        
        order.setAmount(order.getCart().getListBook().size());
        
        int totalPrice = 0;    	
    	for(BookItem b: order.getCart().getListBook()) totalPrice += b.getPrice();
    	order.setTotalPrice(totalPrice);
        
    	orderDAO.createOrder(order);
    	
    	cart = null;
    	listCartItem = null;
    	
        request.setAttribute("cart", cart);
        request.setAttribute("customer", customer);
    	
    	request.setAttribute("amount", order.getCart().getListBook().size());
    	request.setAttribute("totalPrice", totalPrice);
    	
        request.setAttribute("order", order);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("newestOrderPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void showNewestOrderPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	    	
    	if(customer != null && order != null){
    		int totalPrice = 0;
        	
        	for(BookItem b: order.getCart().getListBook()) totalPrice += b.getPrice();
        	
        	request.setAttribute("amount", order.getCart().getListBook().size());
        	request.setAttribute("totalPrice", totalPrice);
            request.setAttribute("order", order);
    	}
    	
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("newestOrderPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void showAllOrderPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	  
//    	if(customer != null){
    		ArrayList<Order> listAllOrder = orderDAO.getAllOrder(customer.getCustomerID());
        	
            request.setAttribute("listOrder", listAllOrder);
            
            for(Order o : listAllOrder){
            	System.out.println("Order amount: "+ o.getAmount());
            }
    	//}
//    	int totalPrice = 0;
//    	
//    	for(BookItem b: order.getCart().getListBook()) totalPrice += b.getPrice();
    	
//    	request.setAttribute("amount", order.getCart().getListBook().size());
//    	request.setAttribute("totalPrice", totalPrice);

        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
    private void searchBookResult(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
    	String key = request.getParameter("search");System.out.println(key);
    	
    	ArrayList<BookItem> listBookSearch = bookDAO.search(key);
    	
    	int amountResult = listBookSearch.size();
    	
    	request.setAttribute("amount", amountResult);
//    	request.setAttribute("totalPrice", totalPrice);
    	
        request.setAttribute("listBookItem", listBookSearch);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchResultPage.jsp");
        dispatcher.forward(request, response);
 
    }
    
}











