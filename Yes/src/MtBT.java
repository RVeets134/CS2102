import java.util.LinkedList;

class MtBT implements IBinTree {
 MtBT(){}

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // returns 0 since enpty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }
 
 //returns true since empty tree is a heap
 public boolean isAHeap() {
	 return true;
 }
 
 //returns true for isAHeap function
 public boolean isLesser(int e) {
	 return true;
 }
// returns an empty root
@Override
public int getRoot() {
	return 0;
}
// returns an empty list
@Override
public LinkedList<Integer> makeList(LinkedList<Integer> l) {
	return l;
}

//returns true because tree is empty
@Override
public boolean checkEmpty() {
	return true;
}


}
