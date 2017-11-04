
class NonEmptyList implements IList{

	String first;
	IList rest;
	
	NonEmptyList(String first,IList rest){
		this.first = first;
		this.rest = rest;
	}

	public int countUses(String str) {
		
		if(this.first.equals(str)) {
			return 1 + rest.countUses(str);
		} else {
			return rest.countUses(str);
		}
	}
	
}
