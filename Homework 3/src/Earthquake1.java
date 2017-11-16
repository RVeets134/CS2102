import java.util.LinkedList;

class Earthquake1 {
	Earthquake1() {
	}

	// checks whether a datum is a date
	boolean isDate(double anum) {
		return (int) anum > 10000000;
	}

	// extracts the month from an 8-digit date
	int extractMonth(double dateNum) {
		return ((int) dateNum % 10000) / 100;
	}

	public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

		LinkedList<MaxHzReport> monthReport = new LinkedList<>();
		double currentDate = 0.0;
		double currentMax = 0.0;
		boolean firstRun = true;
		boolean correctMonth = false;

		for (double d : data) {
			if (isDate(d)) {
				if (!firstRun)
				if (correctMonth) { // if last month was valid
					monthReport.add(new MaxHzReport(currentDate, currentMax));
					currentMax = 0.0;
				}
				if (extractMonth(d) == month) {
					currentDate = d;
					correctMonth = true;
				} else correctMonth = false;
				firstRun = false;
			} else {
				if (correctMonth)
					if (currentMax < d)
						currentMax = d;
			}
		}
		if (correctMonth)
			monthReport.add(new MaxHzReport(currentDate, currentMax));

		return monthReport;

	}

}
