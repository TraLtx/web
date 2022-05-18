package logicApplication.bookDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.accessibility.internal.resources.accessibility;

import logicApplication.DAO;
import model.book.Author;
import model.book.Book;
import model.book.BookItem;

public class BookDAOImpl extends DAO implements BookDAO{

	@Override
	public void BookDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Book> getAllBook() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Book> listBook = new ArrayList<>();
		
		String sql = "SELECT * FROM storebook.book WHERE status = 'received'; ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			int bookID = rs.getInt("BookID");
			String author = rs.getString("Author");
			String typeID = rs.getString("TypeID");
			String isbn = rs.getString("Isbn");
			String title = rs.getString("title");
			String language = rs.getString("Language");
			int numOfPages = rs.getInt("NumOfPages");
			String summary = rs.getString("Summary");
			int publishYear = rs.getInt("PublishYear");
			float cost = rs.getFloat("cost");
			String barCode = rs.getString("BarCode");
			String status = rs.getString("status");
			
			Book book = new Book();
			book.setBookID(bookID);
			book.setTypeID(typeID);
			book.setBarcode(barCode);
			book.setCost(cost);
			book.setLanguage(language);
			book.setIsbn(isbn);
			book.setNumOfPages(numOfPages);
			book.setTitle(title);
			book.setPublishYear(publishYear);
			book.setSummary(summary);
			book.setStatus(status);
			
			book.setAuthor(author);
			
			listBook.add(book);
		}
		return listBook;
	}

	@Override
	public ArrayList<BookItem> getAllBookItem() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<BookItem> listBookItem = new ArrayList<>();
		
		String sql = "SELECT * FROM storebook.bookitem";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			int bookID = rs.getInt("ID");
			int bookbookID = rs.getInt("bookbookID");
			
			float price = rs.getFloat("price");
			String image = rs.getString("image");
			
			BookItem bookitem = new BookItem();
			bookitem.setId(bookID);
			bookitem.setImage(image);
			bookitem.setPrice(price);
			
			Book book = getBook(bookbookID);
			
			bookitem.setBook(book);
			listBookItem.add(bookitem);
		}
		return listBookItem;
	}

	@Override
	public ArrayList<BookItem> search(String key) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<BookItem> listBookItem = new ArrayList<>();
		
		String sql = "SELECT * FROM storebook.book WHERE status = 'pushed' AND title LIKE ?; ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+key+"%");
		ResultSet rs = ps.executeQuery();
		
//		if(rs.next() == false) return null;
//		
//		else if(rs.first() == false) return null;
		while(rs.next()){
			int bookID = rs.getInt("BookID");
			String author= rs.getString("Author");
			String typeID = rs.getString("TypeID");
			String isbn = rs.getString("Isbn");
			String title = rs.getString("title");
			String language = rs.getString("Language");
			int numOfPages = rs.getInt("NumOfPages");
			String summary = rs.getString("Summary");
			int publishYear = rs.getInt("PublishYear");
			float cost = rs.getFloat("cost");
			String barCode = rs.getString("BarCode");
			String status = rs.getString("status");
			
			float price = rs.getFloat("price");
			String image = rs.getString("image");
			
			Book book = new Book();
			book.setBookID(bookID);
			book.setTypeID(typeID);
			book.setBarcode(barCode);
			book.setCost(cost);
			book.setLanguage(language);
			book.setIsbn(isbn);
			book.setNumOfPages(numOfPages);
			book.setTitle(title);
			book.setPublishYear(publishYear);
			book.setSummary(summary);
			book.setStatus(status);
			
			book.setAuthor(author);
			
			BookItem bookItem = new BookItem();
			bookItem.setBook(book);
			bookItem.setPrice(price);
			bookItem.setImage(image);
			listBookItem.add(bookItem);
		}
		return listBookItem;
	}

	@Override
	public boolean upToStore(BookItem bookItem) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO storebook.bookitem (price, image, bookbookID) VALUES (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
        ps.setFloat(1, bookItem.getPrice());
        ps.setString(2, bookItem.getImage());
        ps.setInt(3, bookItem.getBook().getBookID());
                 
        boolean result = ps.executeUpdate() > 0;
        
        return result;
	}

	@Override
	public boolean update(Book book) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE storebook.book SET "
				+ "isbn=?, title=?, language=?, numOfPages=?, summary=?, publishYear=?, cost=?, barcode=?, status=?,author=?"
				+ "WHERE bookID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book.getIsbn());
        ps.setString(2, book.getTitle());
        ps.setString(3, book.getLanguage());
        ps.setInt(4, book.getNumOfPages());
        ps.setString(5, book.getSummary());
        ps.setInt(6, book.getPublishYear());
        ps.setFloat(7, book.getCost());
        ps.setString(8, book.getBarcode());
        ps.setString(9, book.getStatus());
        ps.setString(10, book.getAuthor());
        
        ps.setInt(11, book.getBookID());
         
        boolean result = ps.executeUpdate() > 0;
        
        return result;
	}

	@Override
	public void store(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Author getAuthor(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM storebook.author WHERE authorID = ?; ";
		
		Author author = null; 
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			String typeID = rs.getString("typeID");
			String name = rs.getString("name");
			String country = rs.getString("country");
			Date birthDay = rs.getDate("birthDay");
			String infor = rs.getString("infor");
			
			author = new Author(id,typeID,name,country,birthDay,infor);
			
		}
		return author;
	}

	@Override
	public boolean addBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO storebook.book "
				+ "(isbn,title,language,numOfPages,summary,publishYear,cost,barcode,status,author,typeID) VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getIsbn());
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getLanguage());
		ps.setInt(4, book.getNumOfPages());
		ps.setString(5, book.getSummary());
		ps.setInt(6, book.getPublishYear());
		ps.setFloat(7, book.getCost());
		ps.setString(8, book.getBarcode());
		ps.setString(9, "received");
		ps.setString(10,book.getAuthor());
		ps.setString(11, "B");
		
		boolean result = ps.executeUpdate() > 0;
		return result;

	}

	@Override
	public BookItem getBookItem(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM storebook.bookitem WHERE id = ?; ";
		
		BookItem bookItem = new BookItem();
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
						
			int bookid = rs.getInt("bookbookid");
			Book b = getBook(bookid);
			float price = rs.getFloat("price");
			String image = rs.getString("image");
			
			bookItem.setPrice(price);
			bookItem.setImage(image);
			bookItem.setId(id);
			bookItem.setBook(b);
		}
		return bookItem;
	}
	

	public Book getBook(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM storebook.book WHERE bookID = ?; ";
		
		Book book = new Book();
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			int bookID = rs.getInt("BookID");
			String author = rs.getString("Author");
			String typeID = rs.getString("TypeID");
			String isbn = rs.getString("Isbn");
			String title = rs.getString("title");
			String language = rs.getString("Language");
			int numOfPages = rs.getInt("NumOfPages");
			String summary = rs.getString("Summary");
			int publishYear = rs.getInt("PublishYear");
			float cost = rs.getFloat("cost");
			String barCode = rs.getString("BarCode");
			String status = rs.getString("status");
			
			
			
			book.setBookID(bookID);
			book.setTypeID(typeID);
			book.setBarcode(barCode);
			book.setCost(cost);
			book.setLanguage(language);
			book.setIsbn(isbn);
			book.setNumOfPages(numOfPages);
			book.setTitle(title);
			book.setPublishYear(publishYear);
			book.setSummary(summary);
			book.setStatus(status);
			
			book.setAuthor(author);
			
		}
		return book;
	}

	public ArrayList<BookItem> getCartItem(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM storebook.bookitem WHERE cartcartID = ? ;";
		
		ArrayList<BookItem> listItem = new ArrayList<>();
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			int bid= rs.getInt("id");
			int bookID = rs.getInt("bookbookid");
			Book book = getBook(bookID);
			
			float price = rs.getFloat("price");
			String image = rs.getString("image");
			
			
			BookItem bookItem = new BookItem();
			bookItem.setId(bid);
			bookItem.setBook(book);
			bookItem.setPrice(price);
			bookItem.setImage(image);
			
			listItem.add(bookItem);
		}
		return listItem;
	}
	
	public boolean checkSoldOut(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM storebook.book WHERE bookID = ? AND status = 'pushed'; ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		//Neu tim thay == chua bi mua
		if(rs.next()) return false;
			
		return true;
	}

	@Override
	public boolean updateItem(BookItem bookItem) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE storebook.bookitem SET "
				+ "price=?, image=?"
				+ "WHERE id = ?";
		

		PreparedStatement ps = con.prepareStatement(sql);

        ps.setFloat(1, bookItem.getPrice());
        ps.setString(2, bookItem.getImage());
        
        ps.setInt(3, bookItem.getId());
         
        boolean result = ps.executeUpdate() > 0;
        
        return result;
	}
}
