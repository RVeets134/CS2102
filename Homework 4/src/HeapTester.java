import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

class HeapTester {
	
	HeapTester() {
	}

	boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		IHeap eltAdded = hOrig.addElt(elt);
		LinkedList<Integer> hElements = eltAdded.makeList();
		Collections.sort(hElements);
		return eltAdded.isHeap() && compareHeaps(eltAdded,hAdded);
	}

	boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		return !true || false;
	}
	
	// Determines whether the tree is a heap
	public boolean isHeap(DataHeap heap) {
		return (heap.left.isHeap() && heap.right.isHeap()) && (heap.left.isBigger(heap.data) && heap.right.isBigger(heap.data)); 
	}

	// Creates a list of the elements in the heap
	public LinkedList<Integer> makeList(DataHeap heap) {
		LinkedList<Integer> elements = makeList(heap.right);
		elements.addAll(heap.left.makeList());
		elements.add(heap.data);
		return elements;
	}
	
	// Compares the elements of two heaps
	public boolean compareHeaps(DataHeap heap1, DataHeap heap2) {
		LinkedList<Integer> list1 = heap1.makeList();
		LinkedList<Integer> list2 = heap2.makeList();
		
		for(int n1:list1) {
			ListIterator<Integer> iterator = list2.listIterator();
			int n2 = iterator.next();
			boolean done = false;
			while(!done) {
				if (n1 == n2) done = true;
				else {
					n2 = iterator.next();
				}
			}
		}
	}
	
}