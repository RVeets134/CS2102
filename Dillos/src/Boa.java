
class Boa extends AbsAnimal{
	
	String name;
	String eats;
	
	Boa(String name,int length,String eats){
		
		super(length);
		this.name = name;
		this.eats = eats;
		
	}
	
	//returns true if both boas like the same food
	boolean likesSameFood(Boa otherBoa) {
		return eats.equals(otherBoa.eats);
	}
	
	// is this Boa a normal size?
	public boolean isNormalSize() {
		return isLengthWithin(5,10);
	}
	
}
