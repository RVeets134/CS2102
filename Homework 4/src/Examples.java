import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

class Examples {

	HeapTester tester = new HeapTester();
	
	// Empty heap
	IHeap heap0 = new MtHeap();
	
	// Heaps with only roots
	IHeap heap1 = new DataHeap(1,heap0,heap0);
	IHeap heap2 = new DataHeap(2,heap0,heap0);
	IHeap heap3 = new DataHeap(3,heap0,heap0);
	IHeap heap4 = new DataHeap(4,heap0,heap0);
	IHeap heap5 = new DataHeap(5,heap0,heap0);
	IHeap heap6 = new DataHeap(6,heap0,heap0);
	IHeap heap7 = new DataHeap(7,heap0,heap0);
	IHeap heap8 = new DataHeap(8,heap0,heap0);
	IHeap heap9 = new DataHeap(9,heap0,heap0);
	
	IHeap heap10 = new DataHeap(7,heap9,heap8);
	IHeap heap11 = new DataHeap(6,heap7,heap10);
	IHeap heap11Diff = new DataHeap(6,heap10,heap7);
	IHeap heap12 = new DataHeap(5,heap10,heap11);
	
	IHeap heap13 = new DataHeap(4,heap10,heap8);
	
	//Test addElt:
	
	//Cases:
	//Add to end of heap
	//Add to end of heap with same elements, but different layout
	//Add an element already in the heap
	//Add to empty heap
	//Add element that doesn't go to bottom of heap
	//Add element, but resulting heap is not what the tester is looking for
	
	//Tests when element is added to end of heap
	@Test
	public void addTest1() {
		assertTrue(tester.addEltTester(heap11, 25, heap11.addElt(25)));
	}
	
	//Tests when element is added to end of heap when it has different layout but same elements
	@Test
	public void addTest2() {
		assertTrue(tester.addEltTester(heap11Diff, 25, heap11Diff.addElt(25)));
	}
	
	//Tests when element is added when a duplicate of it is already in the heap
	@Test
	public void addTest3() {
		assertTrue(tester.addEltTester(heap9, 9, heap9.addElt(9)));
	}

	//Tests when element is added an empty heap
	@Test
	public void addTest4() {
		assertTrue(tester.addEltTester(heap0, 4, heap0.addElt(4)));
	}
	
	//Tests when element is added to middle of a heap
	@Test
	public void addTest5() {
		assertTrue(tester.addEltTester(heap12, 7, heap12.addElt(7)));
	}

	//Tests resultant heap is not correct
	@Test
	public void addTest6() {
		assertFalse(tester.addEltTester(heap6, 7, heap5.addElt(7)));
	}
	
	//Test removElt:
	
	//Cases:
	//Remove smallest element in a heap
	//Remove smallest element from heap with same elements, but different layout
	//Remove one element from a heap with duplicates of that element
	//Remove from an empty heap
	//Remove last element in a heap
	//Remove element, resulting heap not what tester is looking for
	
	//Test when smallest element is removed from the heap
	@Test
	public void removeTest1() {
		assertTrue(tester.remMinEltTester(heap11, heap11.remMinElt()));
	}
	
	//Test different layout for the heap than the last test, but same elements
	@Test
	public void removeTest2() {
		assertTrue(tester.remMinEltTester(heap11, heap11Diff.remMinElt()));		
	}

	//Test removing element from heap with duplicates
	@Test
	public void removeTest3() {
		assertTrue(tester.remMinEltTester(heap13, heap13.remMinElt()));	
	}
	
	//Test removing element from an empty heap
	@Test
	public void removeTest4() {
		assertTrue(tester.remMinEltTester(heap0, heap0.remMinElt()));	
	}
	
	//Test removing last element in a heap
	@Test
	public void removeTest5() {
		assertTrue(tester.remMinEltTester(heap8, heap8.remMinElt()));	
	}
	
	//Test resultant heap not correct
	@Test
	public void removeTest6() {
		assertFalse(tester.remMinEltTester(heap4, heap10.remMinElt()));	
	}		
}
