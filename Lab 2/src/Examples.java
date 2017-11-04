import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples(){}
    
    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */
    
    Shark shark = new Shark(16,0);
    Boa Bo = new Boa("Bo",13,"people");
    
    // tests whether the isNormalSize method is used for a Fish or Shark
    @Test
    public void testSharkSize() {
    	assertTrue(shark.isNormalSize());
    }
    
    // tests whether a boa that eats people is dangerous
    @Test
    public void testBoaDanger() {
    	assertTrue(Bo.isDangerToPeople());
    }
    
    // tests whether a shark that hasn't attacked is dangerous to people
    @Test
    public void testSharkAttack() {
    	assertTrue(shark.isDangerToPeople());
    }
  
}
