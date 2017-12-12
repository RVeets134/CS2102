import java.lang.Math;
import java.util.LinkedList;

interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();
 // returns if the binary tree is a heap
 boolean isAHeap();
 // returns the root of the tree
 int getRoot();
 // returns true if the root is less than the given element
 boolean isLesser(int e);
 // returns a linkedlist of all the elements of tree
 LinkedList<Integer> makeList(LinkedList<Integer> l);
 // returns true if is empty
 boolean checkEmpty();
}

