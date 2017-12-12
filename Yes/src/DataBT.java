import java.util.LinkedList;

class DataBT implements IBinTree {
	int data;
	IBinTree left;
	IBinTree right;

	DataBT(int data, IBinTree left, IBinTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// an alternate constructor for when both subtrees are empty
	DataBT(int data) {
		this.data = data;
		this.left = new MtBT();
		this.right = new MtBT();
	}

	// determines whether this node or node in subtree has given element
	public boolean hasElt(int e) {
		return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
	}

	// adds 1 to the number of nodes in the left and right subtrees
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	// adds 1 to the height of the taller subtree
	public int height() {
		return 1 + Math.max(this.left.height(), this.right.height());
	}

	public boolean isBigger(int e) {
		return (this.data >= e);
	}

	public boolean isLesser(int e) {
		return (this.data < e);
	}

	// returns true if the binary tree is a heap
	public boolean isAHeap() {
		return isLesser(this.right.getRoot()) && isLesser(this.left.getRoot()) && this.right.isAHeap()
				&& this.left.isAHeap();
	}

	// returns the root of the tree
	public int getRoot() {
		return this.data;
	}

	// returns a list of all elements of a tree
	@Override
	public LinkedList<Integer> makeList(LinkedList<Integer> l) {
		l.add(this.data);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		if (!left.checkEmpty()) {
			l.addAll(left.makeList(l2));
		}
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		if (!right.checkEmpty()) {
			l.addAll(right.makeList(l3));
		}
		return l;
	}

	// returns false because is not empty
	@Override
	public boolean checkEmpty() {
		return false;
	}

}