
class Dillo extends AbsAnimal{
	
	boolean isDead;
	
	Dillo(int length,boolean isDead){

		super(length);
		this.isDead = isDead;
		
	}
	
	boolean canShelter() {
		return length>60 && isDead;
	}
	
	// is this dillo a normal size?
	public boolean isNormalSize() {
		return isLengthWithin(2,3);
	}
	
}
