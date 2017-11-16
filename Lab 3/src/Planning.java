import java.util.LinkedList;

class Planning {
	
	Planning(){}

	public double rainFall(LinkedList<Double> readings) {
		
		double accumulator = 0;
		int counter = 0;
		
		for(Double d:readings) {
			
			counter = counter + 1;
			
			//Take double in sum if greater than 0
			if(d > 0) {
				
				accumulator = accumulator + d;
		
			}
			
			//returns -1 when the sum is still 0 and the current double is -999.0
			if(d == -999.0 && accumulator == 0) 
			{
				return -1;
				
			} else if(d == -999) {
				
				return accumulator/counter;
			
			}
			
		}
		
		if(accumulator == 0) {
			return -1;
		} else {
			return accumulator/counter;
		}
		
	}
	
}
