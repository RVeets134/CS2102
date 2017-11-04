
abstract class AbsAnimal implements IAnimal{
	
	int length;
	
	AbsAnimal(int length){
		
		this.length = length;
		
	}
	
	// return true if this animal's length is between low and high
	boolean isLengthWithin(int low,int high) {
		return this.length >= low && this.length >= high;
	}
	
	// is this animal's length less than the given length?
	public boolean lengthBelow(int someLength) {
		return length < someLength;
	}
	
}
