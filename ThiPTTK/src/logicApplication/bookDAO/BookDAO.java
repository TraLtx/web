package logicApplication.bookDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.book.Author;
import model.book.Book;
import model.book.BookItem;

public interface BookDAO {

	public void BookDAO();
	
	public BookItem getBookItem(int id) throws SQLException;
	public ArrayList<Book> getAllBook() throws SQLException;
	public ArrayList<BookItem> getAllBookItem() throws SQLException;
	public ArrayList<BookItem> search(String key) throws SQLException;
	
	public boolean addBook(Book book) throws SQLException;
	public boolean upToStore(BookItem bookItem) throws SQLException;
	public boolean update(Book book) throws SQLException;
	public boolean updateItem(BookItem bookItem) throws SQLException;
	public void store(int id);
	
	public Author getAuthor(int id) throws SQLException;
}
