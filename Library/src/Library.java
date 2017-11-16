import java.util.LinkedList;

class Library {

	LinkedList<Book> holdings = new LinkedList<Book>();
	
	Library(){}
	
	// add the given book to this library's holdings
	Library addBook(Book b) {
		this.holdings.add(b);
		return this;
	}
	
	//find a book by its title
	//assumes the title is in the library
	Book findByTitle(String atitle) {
		for(Book item:holdings) {
			if(item.title.equals(atitle)){
				return item;
			}
		}
		
		//returns null if book isn't found because compiler needs to return something
		return null;
		
	}
	
	// produce a list of all books that are currently checked out
	LinkedList<Book> checkedOut(){
		
		LinkedList<Book> checkedOut = new LinkedList<Book>();
		
		for(Book b: holdings) {
			if(!b.isAvailable) {
				checkedOut.add(b);
			}
		}
		
		return checkedOut;
		
	}
	
}
