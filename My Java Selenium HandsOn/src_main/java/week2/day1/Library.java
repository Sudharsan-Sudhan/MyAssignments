package week2.day1;

public class Library {

	public String addBook (String bookTitle) {
		System.out.println("Book added successfully : " + bookTitle);
		return bookTitle;
	}
	
	public void issueBook() {
		System.out.println("Book issued successfully");
	}
	
	public static void main(String[] args) {
		Library lib = new Library();
		lib.addBook("English");
		lib.issueBook();
	}

}
