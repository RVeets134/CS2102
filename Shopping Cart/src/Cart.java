import java.util.LinkedList;

class Cart {

	LinkedList<Item> cart;
	double totalShoeCost;
	int numHats;
	double totalCostOrder;
	
	public Cart(LinkedList<Item> cart) {
		this.cart = cart;
		processCart();
	}
	
	public void processCart() {
		
		for(Item i:cart) {
			if(i.name.equals("shoes")) {
				totalShoeCost += i.price;
			}
			else if(i.name.equals("hat")) {
				numHats++;
				totalCostOrder+=i.price;
			}
			else {
				totalCostOrder+=i.price;
			}
		}
		
		if(totalShoeCost>100) {
			totalShoeCost*=0.8;
		}
		if(numHats>2) {
			totalCostOrder-=10;
		}
		
		totalCostOrder+=totalShoeCost;
		
	}
	
}
