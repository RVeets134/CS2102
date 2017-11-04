import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Rakesh Veetekat
 * @author Lucas Varella
 */
public class Examples {
	
	// Initialize some ShootingRounds
	ShootingRound score0 = new ShootingRound(0);
	ShootingRound score1 = new ShootingRound(1);
	ShootingRound score2 = new ShootingRound(2);
	ShootingRound score3 = new ShootingRound(3);
	ShootingRound score4 = new ShootingRound(4);
	ShootingRound score5 = new ShootingRound(5);

	// Initialize ShootingResults
	ShootingResult shooting1 = new ShootingResult(score1, score2, score3, score4);
	ShootingResult shooting2 = new ShootingResult(score0, score4, score5, score3);

	// Initialize SkiingResults
	SkiingResult skiing1 = new SkiingResult(100, 1, shooting1);
	SkiingResult skiing2 = new SkiingResult(130, 2, shooting2);
	SkiingResult skiing3 = new SkiingResult(230, 3, shooting1);
	SkiingResult skiing4 = new SkiingResult(440, 7, shooting2);

	// Initialize Athletes
	Athlete athlete1 = new Athlete(shooting1, skiing1);
	Athlete athlete2 = new Athlete(shooting2, skiing2);
	Athlete athlete3 = new Athlete(shooting2, skiing3);
    
	public Examples() {}
	
	// Test getting total points earned by a collection of shooting rounds
	@Test
	public void testPointsEarnedShooting() {
		assertEquals(shooting1.pointsEarned(), 10, 0.0001);
	}
    
	// Test getting total points earned by a collection of shooting rounds (fail)
	@Test
	public void testFailPointsEarnedShooting() {
		assertTrue(shooting1.pointsEarned() < 0);
	}
	
	// Test adding shooting penalties to a shooting result
	@Test
	public void testAddShootingPenalties() {
		assertEquals(skiing1.addShootingPenalties(shooting1), 300, 0.0001);
	}
	
	// Test adding shooting penalties to a shooting result (fail)
	@Test
	public void testFailAddShootingPenalties() {
		assertTrue(skiing1.addShootingPenalties(shooting1) < 0 ||
				skiing1.addShootingPenalties(shooting1) > 400);
	}
	
	// Test getting total points earned by a skiing result
	@Test
	public void testPointsEarnedSkiing() {
		assertEquals(skiing1.pointsEarned(), 290, 0.0001);
		assertEquals(skiing2.pointsEarned(), 283, 0.0001);
		assertEquals(skiing3.pointsEarned(), 427, 0.0001);
		assertEquals(skiing4.pointsEarned(), 600, 0.0001);
	}
    
	// Test getting total points earned by a skiing result (fail)
	@Test
	public void testFailPointsEarnedSkiing() {
		assertTrue(skiing1.pointsEarned() < 0);
	}
	
	// Test determining which skiier has the lower score of two skiiers
	@Test
	public void testBetterSkiier() {
		assertTrue(athlete2.betterSkiier(athlete1).equals(athlete2));
	}
	
	// Test determining which skiier has the lower score of two skiiers (fail)
	@Test
	public void testFailBetterSkiier() {
		assertTrue(athlete1.betterSkiier(athlete2).equals(athlete1));
	}
	
	// Test determining whether an athlete has beaten another
	@Test
	public void testHasBeaten() {
		assertTrue(athlete2.hasBeaten(athlete1));
		assertTrue(athlete1.hasBeaten(athlete3));
		assertFalse(athlete3.hasBeaten(athlete2));
	}
	
	// Test determining whether an athlete has beaten another (fail)
	@Test
	public void testFailHasBeaten() {
		assertFalse(athlete2.hasBeaten(athlete1));
		assertFalse(athlete1.hasBeaten(athlete3));
		assertTrue(athlete3.hasBeaten(athlete2));
	}
    
}