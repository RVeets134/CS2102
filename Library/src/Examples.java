import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

class Examples {
	
	public Examples(){}
	
	Book deal = new Book("Art of the Deal","QA 234",0,true);
	Book alice = new Book("Alice in Wonderland","pq234",0,true);
	Book hamlet = new Book("Hamlet","QA 123");
	Request reqHamlet = hamlet.makeRequest(1234);
	
	Library gordonLib = new Library();
	
	@Before
	public void setUp() {
		gordonLib.addBook(deal).addBook(alice).addBook(hamlet);
	}
	
	@Test
	public void testCheckedOut() {
		LinkedList<Book> result = new LinkedList<Book>();
		deal.isAvailable = false;
		hamlet.isAvailable = false;
		result.add(deal);
		result.add(hamlet);
		assertEquals(result,gordonLib.checkedOut());
	}
	
}
