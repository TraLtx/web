package model.book;

public class BookItem {

	private int id;
	private float price;
	private String image;
	private int vote;
	private String feedback;
	
	private Book book;
	
	public BookItem(){
		
	}

	public BookItem(float price, String image, int vote, String feedback) {
		super();
		this.price = price;
		this.image = image;
		this.vote = vote;
		this.feedback = feedback;
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
	
}
