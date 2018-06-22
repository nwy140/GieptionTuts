public class Book extends Stationery{
	private String bookName;
	
	public Book() {
		super();
		System.out.println("New Book");
	}
	
	public Book(String bookName) {
		super();
		this.bookName = bookName;
		System.out.println("New Book with Name");
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
	
	public void showPriceAndLocation(double price, String location) {
		System.out.println("This book cost RM" + price + "and it is located at "+location);
	}
}
