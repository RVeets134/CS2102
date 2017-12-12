import java.util.LinkedList;

class Examples {

	LinkedList<String> guestList = new LinkedList<String>();
	
	IBST emptyBST = new EmptyBST();
	IBST jakeBST = new DataBST("Jake",emptyBST,emptyBST);
	IBST davidBST = new DataBST("David",emptyBST,emptyBST);
	IBST guestAVL = new DataBST("Tim",jakeBST,davidBST);
	
	IBST david2BST = new DataBST("David",jakeBST,emptyBST);
	IBST guestBST = new DataBST("Tim",david2BST,emptyBST);
	
	Examples(){
		guestList.add("Jake");
		guestList.add("David");
		guestList.add("Tim");
	}
	
	// an EventGuests that uses LinkedLists under the hood
	EventGuests guestLists = new EventGuests(new List(guestList));
	
	// an EventGuests that uses BSTs under the hood
	EventGuests guestBSTs = new EventGuests(guestBST);
	
	// an EventGuests that uses AVL trees under the hood
	EventGuests guestAVLs = new EventGuests(guestAVL);
	
	
	
}
