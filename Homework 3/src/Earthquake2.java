import java.util.LinkedList;
import java.util.ListIterator;

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
	  
	  LinkedList<MaxHzReport> monthReport = new LinkedList<MaxHzReport>();
	  Double d = 0.0;
	  Double currentDate = 0.0;
	  Double currentMax = 0.0;
	  ListIterator<Double> iterator = data.listIterator();
	  d = iterator.next();
	  
	  while(iterator.hasNext()) {
		  
		  if(isDate(d) && (extractMonth(d) == month)) {
			  
			  currentDate = d;
			  currentMax = 0.0;
			  d = iterator.next();
			  boolean done = false;
			  
			  while(!isDate(d) && !done) {
				  if(currentMax < d) {
					  currentMax = d;
				  }
				  if (iterator.hasNext()) d = iterator.next();
				  else done = true;
			  }
			  
			  monthReport.add(new MaxHzReport(currentDate,currentMax));
			  
		  } else d = iterator.next();
		  
	  }
	  
	  return monthReport;
	  
  }
  
}