
class Book {

	String title;
	String callNum;
	int timesOut;
	boolean isAvailable;
	
	Book(String title,String callNum,int timesOut,boolean isAvailable){
		this.title = title;
		this.timesOut = timesOut;
		this.callNum = callNum;
		this.isAvailable = isAvailable;
	}
	
	Book(String title,String callNum){
		this.title = title;
		this.callNum = callNum;
		this.timesOut = 0;
		this.isAvailable = true;
	}
	
	// create a request for this book by the patron with the given
	// library card number
	Request makeRequest(int byCardNum) {
		return new Request(this,byCardNum);
	}
	
	// check out this book
	Book checkOut() {
		this.timesOut = this.timesOut + 1;
		this.isAvailable = false;
		return this;
	}
	
	//mark a book as checked in at the library
	public Book checkIn() {
		this.isAvailable = true;
		return this;
	}
	
}
