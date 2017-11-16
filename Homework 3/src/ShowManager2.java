import java.util.LinkedList;

class ShowManager2 {

	ShowManager2() {
	}

	public ShowSummary organizeShows(LinkedList<Show> shows) {
		
		LinkedList<Show> daytime = new LinkedList<Show>();
		LinkedList<Show> primetime = new LinkedList<Show>();
		
		for(Show show: shows) {
			if(show.broadcastTime >= 600 && show.broadcastTime < 1700) {
				daytime.add(show);
			} else if(show.broadcastTime >= 1700 && show.broadcastTime < 2300) {
				primetime.add(show);
			}
		}
		
		return new ShowSummary(daytime,primetime);
		
	}

}
