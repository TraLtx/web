package model.book;

public class Book {

	private int bookID;
	private String typeID;
	private String isbn;
	private String title;
	private String language;
	private int numOfPages;
	private String summary;
	private int publishYear;
	private float cost;
	private String barcode;
	private String status;
	
	private String author;
	
	public Book(){
		
	}

	public Book(int bookID, String typeID, String isbn, String title, String language, int numOfPages, String summary,
			int publishYear, float cost, String barcode, String author, String status) {
		super();
		this.bookID = bookID;
		this.typeID = typeID;
		this.isbn = isbn;
		this.title = title;
		this.language = language;
		this.numOfPages = numOfPages;
		this.summary = summary;
		this.publishYear = publishYear;
		this.cost = cost;
		this.barcode = barcode;
		this.author = author;
		this.status = status;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
