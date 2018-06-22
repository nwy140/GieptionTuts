public class Book {
	private String bookName;
	
	public Book(String bookName) {
		super();
		this.bookName = bookName;
		System.out.println("New Book");
	}

	private void setBook(String bookName) {
		this.bookName = bookName; // this access .h's defined variables
	}


	public String getBook() {
		return bookName;
	}
	
	public void tellStory(){
		System.out.println("My Favourite book is " + getBook());
	}
}
