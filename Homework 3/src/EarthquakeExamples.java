import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<Double> fourDates = new LinkedList<Double>();
  LinkedList<MaxHzReport> JanReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> MarchReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> DecReports = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
	  
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    
    fourDates.add(20150113.0);
    fourDates.add(10.0);
    fourDates.add(5.0);
    fourDates.add(20150313.0);
    fourDates.add(50.0);
    fourDates.add(45.0);
    fourDates.add(20150315.0);
    fourDates.add(5.0);    
    fourDates.add(20150513.0);
    fourDates.add(6.0);   
   
    JanReports.add(new MaxHzReport(20150113.0,10.0));
    MarchReports.add(new MaxHzReport(20150313.0,50.0));
    MarchReports.add(new MaxHzReport(20150315.0,5.0));
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }
  
  //Tests when there are no months in the list that matches the month in question
  @Test
  public void testNoCorrectDates() {
	  assertEquals(DecReports,
			  	E1.dailyMaxForMonth(threeDates, 12));
  }
  
  // Tests when the month that's being tested is the first in the list of dates
  @Test
  public void testFirstDate() {
	  assertEquals(JanReports,
			  	E1.dailyMaxForMonth(fourDates, 1));
  }
  
  // Tests when the month being tested for is in the middle of the list of dates
  @Test
  public void testMiddleDates() {
	  assertEquals(MarchReports,
			  	E1.dailyMaxForMonth(fourDates, 3));
  }
  
}
