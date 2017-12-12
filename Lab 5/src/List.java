import java.util.LinkedList;

class List implements ISet{
	
	LinkedList<String> list;
	
	List(LinkedList<String> list){
		this.list = list;
	}

	@Override
	public ISet addElt(String elt) {
		list.add(elt);
		return (ISet)list;
	}

	@Override
	public boolean hasElt(String elt) {
		return list.contains(elt);
	}

	@Override
	public int size() {
		return list.size();
	}
	
	
	
}
