import java.util.LinkedList;

public class HeapTester {

	public HeapTester() {
	};

	// returns true if the binary tree is a valid result of adding
	// the given integer to the first Heap
	boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		return isAHeap(hAdded) && containsAll(hOrig, elt, hAdded);
	}

	// returns true if the binary tree is a valid result of removing the top element
	// from the given heap
	boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		if(hOrig.size() != 0) {
			return isAHeap(hRemoved) && containsAll(hOrig, hRemoved);
		} else {
			return false;
		}
	}

	// returns true if the given binary tree is a heap
	boolean isAHeap(IBinTree heap) {
		return heap.isAHeap();
	}

	// returns true if the given binary tree contains all elements in the given heap
	// and the newly added element
	boolean containsAll(IHeap hOrig, int elt, IBinTree hAdded) {
		LinkedList<Integer> orig = new LinkedList<Integer>();
		orig.add(elt);
		LinkedList<Integer> added = new LinkedList<Integer>();
		LinkedList<Integer> orig2 = hOrig.makeList(orig);
		LinkedList<Integer> added2 = hAdded.makeList(added);
		return compareLists(orig2, added2);
	}

	// returns true if the given binary tree contains all elements in the given heap
	// except for the removed element
	boolean containsAll(IHeap hOrig, IBinTree hRemoved) {
		LinkedList<Integer> orig = new LinkedList<Integer>();
		LinkedList<Integer> added = new LinkedList<Integer>();
		LinkedList<Integer> orig2 = hOrig.makeList(orig);
		orig2.remove();
		LinkedList<Integer> added2 = hRemoved.makeList(added);
		return compareLists(orig2, added2);
	}

	// returns true if the given two lists have the same elements and false
	// otherwise
	boolean compareLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		if (l1.size() != l2.size())
			return false;
		for (int i = 0; i < l1.size(); i++) {
			if (l2.contains(l1.get(i))) {
				int k = l2.indexOf(l1.get(i));
				l1.remove(i);
				l2.remove(k);
				i--;
			}
		}
		if (l1.size() > 0 || l2.size() > 0) {
			return false;
		}
		return true;
	}
}
