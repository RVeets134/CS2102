
class EventGuests {

	ISet guests;
	
	EventGuests(ISet guests){
		this.guests = guests;
	}
	
	void addGuest(String newGuestName) {
		guests.addElt(newGuestName);
	}
	
	boolean isComing(String name) {
		return !guests.hasElt(name);
	}
	
	int numGuests() {
		return guests.size();
	}
	
}
