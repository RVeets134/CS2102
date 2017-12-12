
//Andrew Bonaventura (abonaventura) and Nathan Walzer (nwalzer)
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {

	public Examples() {
	}

	IHeap myHeap = new DataHeap(3, 
			new DataHeap(10, 
					new MtHeap(), 
					new MtHeap()), 
			new MtHeap());
	IHeap singleNode = new DataHeap(3, 
			new MtHeap(), 
			new MtHeap());
	IHeap emptyHeap = new MtHeap();
	IHeap duplicateHeap = new DataHeap(3, 
								new DataHeap(5, 
										new MtHeap(), 
										new MtHeap()), 
								new DataHeap(5, 
										new MtHeap(), 
										new MtHeap()));
	IHeap degenerateHeap = new DataHeap(2, 
			new MtHeap(), 
			new DataHeap(3, 
					new MtHeap(), 
					new DataHeap(4, 
							new MtHeap(),
							new DataHeap(5, 
									new MtHeap(), 
									new MtHeap()))));
	IHeap minDupHeap = new DataHeap(3, 
			new DataHeap(3, 
					new MtHeap(), 
					new MtHeap()), 
			new DataHeap(10, 
					new MtHeap(),
					new MtHeap()));
	
	
	HeapTester HT = new HeapTester();

	
	
	@Test
	public void addTest1() {
		assertTrue(HT.addEltTester(myHeap, 5, myHeap.addElt(5)));
	}
	
	@Test
	public void addTest2() {
		assertTrue(HT.addEltTester(singleNode, 2, singleNode.addElt(2)));
	}
	
	@Test
	public void addTest3() {
		assertTrue(HT.addEltTester(emptyHeap, 10, emptyHeap.addElt(10)));
	}
	
	@Test
	public void addTest4() {
		assertTrue(HT.addEltTester(duplicateHeap, 4, duplicateHeap.addElt(4)));
	}
	
	@Test
	public void addTest5() {
		assertTrue(HT.addEltTester(degenerateHeap, 1, degenerateHeap.addElt(1)));
	}
	
	@Test
	public void addTest6() {
		assertTrue(HT.addEltTester(myHeap,  3, myHeap.addElt(3)));
	}
	
	
	
	
	@Test
	public void remTest1() {
		assertTrue(HT.remMinEltTester(myHeap, myHeap.remMinElt()));
	}
	
	@Test
	public void remTest2() {
		assertTrue(HT.remMinEltTester(singleNode, singleNode.remMinElt()));
	}
	
	@Test
	public void remTest3() {
		assertFalse(HT.remMinEltTester(emptyHeap, new MtHeap()));
	}
	
	@Test
	public void remTest4() {
		assertTrue(HT.remMinEltTester(duplicateHeap, duplicateHeap.remMinElt()));
	}
	
	@Test
	public void remTest5() {
		assertTrue(HT.remMinEltTester(degenerateHeap, degenerateHeap.remMinElt()));
	}
	
	@Test
	public void remTest6() {
		assertTrue(HT.remMinEltTester(minDupHeap, minDupHeap.remMinElt()));
	}
	
	
	
	
}
