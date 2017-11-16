import java.util.LinkedList;

class Mouse {
	
	String food;
	int foodAmount;
	int treadmill;
	int workLength;
	LinkedList<Double> weight;
	LinkedList<String> date;
	
	Mouse(String food,int foodAmount,int treadmill,int workLength){
		this.food = food;
		this.foodAmount = foodAmount;
		this.treadmill = treadmill;
		this.workLength = workLength;
	}
	
}
