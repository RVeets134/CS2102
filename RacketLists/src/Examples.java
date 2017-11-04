
class Examples {

	Examples(){}
	
	EmptyList empty = new EmptyList();
	NonEmptyList pears = new NonEmptyList("pears",empty);
	NonEmptyList applesPears = new NonEmptyList("apples",pears);
	
}
