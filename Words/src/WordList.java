import java.util.LinkedList;

class WordList {
	
	LinkedList<String> words;
	
	// initialize the list to empty in the constructor
	WordList(){
		this.words = new LinkedList<String>();
	}
	
	// add the given word to this list
	void addWord(String word) {
		this.words.addFirst(word);
	}
	
	int numUses(String str) {
		int uses = 0;
		
		//For-each loop format
		//for(type var:specific list){
		//	  statement(s);
		//}
		
		for(String w:this.words) {
			if(w.equals(str)) {
				uses = uses + 1;
			}
		}
		return uses;
	}
	
	//return a list of the words longer than the given length
	LinkedList<String> wordsLongerThan(int low){
		
		LinkedList<String> result = new LinkedList<String>();
		
		for(String word:this.words) {
			if(word.length() > low) {
				result.add(word);
			}
		}
		
		return result;
		
	}

}
