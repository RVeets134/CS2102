
class Cage {
	
	int size;
	IAnimal resident;
	
	Cage(int size,IAnimal resident){
		this.size = size;
		this.resident = resident;
	}
	
	boolean checkResidentFits() {
		return resident.lengthBelow(size);
	}
	
}
