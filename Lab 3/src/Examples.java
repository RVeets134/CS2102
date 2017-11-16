import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {

	Planning p = new Planning();
	LinkedList<Double> list1 = new LinkedList<Double>();	
	LinkedList<Double> list2 = new LinkedList<Double>();	
	LinkedList<Double> list3 = new LinkedList<Double>();
	
	public Examples(){
		
	//List of all doubles
	list1.add(3.0);
	list1.add(4.0);
	list1.add(5.0);
		
	//List of all negative numbers
	list2.add(-3.0);
	list2.add(-4.0);
	list2.add(-5.0);
	
	//List with -999 at the beginning
	list3.add(-999.0);
	list3.add(2.0);
	list3.add(3.0);
	
	}
	
	// Test how rainFall handles a list of all doubles
	@Test
	public void testAllDoubles() {
		assertEquals(p.rainFall(list1),4.0,0.0001);
	}
	
	// Test how rainFall handles a list of all negative numbers
	@Test
	public void testAllNegative() {
		assertEquals(p.rainFall(list2),-1,0.0001);
	}
	
	// Test how rainFall handles a list of doubles starting with -999.0
	@Test 
	public void testStart999() {
		assertEquals(p.rainFall(list3),-1,0.0001);
	}
	
}
