import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rakesh Veetekat
 * @author Lucas Varella
 */
public class Examples {

	public Examples(){}
	
	// Initialize ShootingRounds
	ShootingRound score0 = new ShootingRound(0);
	ShootingRound score1 = new ShootingRound(1);
	ShootingRound score2 = new ShootingRound(2);
	ShootingRound score3 = new ShootingRound(3);
	ShootingRound score4 = new ShootingRound(4);
	ShootingRound score5 = new ShootingRound(5);
	
	// Initialize lists of rounds used for a shooting result
	LinkedList<ShootingRound> rounds1 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> rounds2 = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> rounds3 = new LinkedList<ShootingRound>();

	// Declare ShootingResult
	ShootingResult shooting1;
	ShootingResult shooting2;
	ShootingResult shooting3;

	// Declare SkiingResults
	SkiingResult skiing1;
	SkiingResult skiing2;
	SkiingResult skiing3;

	// Declare Athletes
	Athlete athlete1;
	Athlete athlete2;
	Athlete athlete3;
	Athlete athlete4;
	Athlete athlete5;
	Athlete athlete6;
	
	//Initialize Mass Start event
	MassStartResult massStart = new MassStartResult(100,20);
	
	//Declare Competitions
	Competition competition1;
	Competition competition2;
	Competition competition3;
	Competition competition4;
	Competition competition5;
	Competition competition6;
	Competition competition7;
	
	// Test obtaining points earned through a Mass Start event
	@Test
	public void testMassStartPointsEarned() {
		assertEquals(massStart.pointsEarned(),massStart.time,0.0001);
	}
	
	// Sets up objects needed to test ShootingResult pointsEarned
	@Before
	public void setUp1() {
		 
		rounds1.add(score1);
		rounds1.add(score1);
		rounds1.add(score3);
		rounds1.add(score3);
		rounds1.add(score4);
		rounds1.add(score5);
		
		shooting1 = new ShootingResult(rounds1);	
		
	}
	
	// Test points earned through a list of shooting rounds
	@Test
	public void testShootingResultPointsEarned() {
		assertEquals(shooting1.pointsEarned(),score1.targetsHit+score1.targetsHit+score3.targetsHit+
												score3.targetsHit+score4.targetsHit+score5.targetsHit,0.0001);
	}
	
	// Test whether the best shooting round is returned from a list of shooting rounds
	@Test 
	public void testShootingResultBestRound() {
		assertEquals(shooting1.bestRound(),score5);
	}
	
	// Sets up objects needed to test ShootingDNF
	@Before
	public void setUp2() {
		
		rounds2.add(score1);
		rounds2.add(score3);
		
		rounds3.add(score5);
		rounds3.add(score3);
		rounds3.add(score5);
		rounds3.add(score3);
		
		shooting2 = new ShootingResult(rounds2);
		shooting3 = new ShootingResult(rounds3);
		
		skiing1 = new SkiingResult(200,2,shooting1);
		skiing2 = new SkiingResult(100,1,shooting1);
		skiing3 = new SkiingResult(300,3,shooting1);
		
		athlete1 = new Athlete(shooting1,skiing1,"Jack");
		athlete2 = new Athlete(shooting2,skiing2,"Jay");
		athlete3 = new Athlete(shooting3,skiing3,"Jake");
		
		LinkedList<Athlete> athletes1 = new LinkedList<Athlete>();
		athletes1.add(athlete1);
		athletes1.add(athlete2);
		athletes1.add(athlete3);
		
		competition1 = new Competition(7,athletes1);	// All the athletes did not finish 7 rounds
		competition2 = new Competition(5,athletes1);	// Two athletes did not finish 5 rounds
		competition3 = new Competition(3,athletes1);	// One athlete did not finish 3 rounds
		competition4 = new Competition(1,athletes1);	// Every athlete finished 1 round
		
		//List of athletes names
		LinkedList<String> names1 = new LinkedList<String>();
		names1.add("Jack");
		names1.add("Jay");
		names1.add("Jake");
		LinkedList<String> names2 = new LinkedList<String>();
		names1.add("Jay");
		names1.add("Jake");
		LinkedList<String> names3 = new LinkedList<String>();
		names1.add("Jay");
		
	}
	
	// Test for list of athletes' names who did not finish the shooting event
	@Test
	public void testShootingDNF() {
		
	}
	
	// Test whether the correct skiing score is obtained with an athlete's name in a competition
	@Test 
	public void testSkiiingScoreForAthlete() {
		
	}
	
	// Sets up objects needed to test whether an athlete has gotten better at skiing from one competition to another
	@Before
	public void setUp3() {
		
		athlete4 = new Athlete(shooting1,skiing1,"Jack");	// Same skiing score as before
		athlete5 = new Athlete(shooting1,skiing2,"Jack");	// Better skiing score than before
		athlete6 = new Athlete(shooting1,skiing3,"Jack");	// Worse skiing score than before
		
		LinkedList<Athlete> athletes2 = new LinkedList<Athlete>();
		athletes2.add(athlete2);
		athletes2.add(athlete3);
		athletes2.add(athlete4);
		
		LinkedList<Athlete> athletes3 = new LinkedList<Athlete>();
		athletes3.add(athlete2);
		athletes3.add(athlete3);
		athletes3.add(athlete5);
		
		LinkedList<Athlete> athletes4 = new LinkedList<Athlete>();
		athletes4.add(athlete2);
		athletes4.add(athlete3);
		athletes4.add(athlete6);
		
		competition5 = new Competition(6,athletes2);
		competition6 = new Competition(6,athletes3);
		competition7 = new Competition(6,athletes4);
		
	}
	
	// Test whether an athlete has actually gotten a better skiing score in one competition versus the other
	@Test
	public void testAnySkiingImprovement() {
		
		assertTrue(competition1.anySkiingImprovement(competition5));
		assertTrue(competition1.anySkiingImprovement(competition6));
		assertFalse(competition1.anySkiingImprovement(competition7));
		
	}
	
}
