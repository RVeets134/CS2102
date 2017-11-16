import java.util.LinkedList;

class ShowManager1 {

	ShowManager1() {
	}

	public ShowSummary organizeShows(LinkedList<Show> shows) {
		ShowSummary summary = new ShowSummary();
		for (Show show : shows) {
			if (show.broadcastTime >= 600 && show.broadcastTime < 1700) summary.daytime.add(show);
			else if (show.broadcastTime >= 1700 && show.broadcastTime < 2300) summary.primetime.add(show);
		}
		return summary;
	}

}
