import org.junit.Test;
import static org.junit.Assert.*;

class Examples {
	
	Dillo babyDillo = new Dillo(8,false);
	Dillo adultDillo = new Dillo(24,false);
	Dillo hugeDeadDillo = new Dillo(65,true);
	
	Boa billy = new Boa("Billy",12,"toads");
	Boa trixie = new Boa("Trixie",18,"ferns");
	
	// test the length of a boa
	@Test
	public void testBoaLength() {
		assertTrue(billy.lengthBelow(15));
	}
	
	// test the length of a dillo
	@Test
	public void testDilloLength() {
		assertFalse(babyDillo.lengthBelow(3));
	}
	
	@Test
	public void testSmallDillo() {
		assertFalse(babyDillo.canShelter());
	}
	
	// test a large, dead dillo
	@Test
	public void testLargeDead() {
		assertTrue(hugeDeadDillo.canShelter());
	}
	
	// test where they have different favorite foods
	@Test
	public void testDifferent() {
		assertFalse(billy.likesSameFood(trixie));
	}
	
	// test where they like the same food
	@Test
	public void testSame() {
		assertTrue(billy.likesSameFood(new Boa("Jennifer",13,"toads")));
	}
	
}
