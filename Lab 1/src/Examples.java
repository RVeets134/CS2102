
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
    
    Album album = new Album("Rob","Rock");
    Song song1 = new Song("Song 1",14,album);
    Song song2 = new Song("Song 2",6,album);
    
    @Test
    public void checkSong1Len() {
    	assertEquals(14,song1.lenInSeconds);
    }
    
    @Test
    public void checkSong2Len() {
    	assertEquals(14,song2.lenInSeconds);
    }
    
    @Test
    public void checkGenreSong1() {
    	assertEquals("Rock",song1.album.genre);
    }
  
}