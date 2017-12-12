import java.util.GregorianCalendar;

class DailyWeatherReport implements IDailyReport {

	private GregorianCalendar date;
	private int highTemp;
	private int lowTemp;
	
	DailyWeatherReport(GregorianCalendar date, int highTemp, int lowTemp) {
		this.date = date;
		this.highTemp = highTemp;
		this.lowTemp = lowTemp;
	}

	GregorianCalendar getDate() {
		return date;
	}

	public int getHigh() {
		return highTemp;
	}

	public int getLow() {
		return lowTemp;
	}
	
}
