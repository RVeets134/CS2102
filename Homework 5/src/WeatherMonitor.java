import java.util.GregorianCalendar;
import java.util.LinkedList;

class WeatherMonitor {

	LinkedList<IDailyReport> reports = new LinkedList<>();
	
	WeatherMonitor(LinkedList<IDailyReport> reports){
		this.reports = reports;
	}
	
	double averageHighForMonth(int month, int year) {
		if (reports.size() == 0) return 0.0;
		int sum = 0;
		for (IDailyReport report : reports)
			sum += report.getHigh();
		return (double) sum / reports.size();
	}
	
	double averageLowForMonth(int month, int year) {
		if (reports.size() == 0) return 0.0;
		int sum = 0;
		for (IDailyReport report : reports)
			sum += report.getLow();
		return (double) sum / reports.size();
	}
	
	void addDailyReport(GregorianCalendar date,LinkedList<Integer> readings) {
		int high = 0;
		int low = 0;
		for(Integer r : readings) {
			if(r > high) {
				high = r;
			}
			if(r < low) {
				low = r;
			}
		}
		reports.add(new DailyWeatherReport(date,high,low));
	}
	
}
