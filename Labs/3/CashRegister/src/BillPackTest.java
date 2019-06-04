import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BillPackTest {

	@Test
	void constructor() {
		BillPack bp = new BillPack();
		assertNotNull(bp);
		assertEquals(0, bp.bills[0]);
		assertEquals(0, bp.bills[1]);
		assertEquals(0, bp.bills[2]);
		assertEquals(0, bp.bills[3]);
		assertEquals(0, bp.bills[4]);
		assertEquals(0, bp.bills[5]);		
		bp = new BillPack(1,3,5,100,0,10);
		assertNotNull(bp);
		assertEquals(1, bp.bills[0]);
		assertEquals(3, bp.bills[1]);
		assertEquals(5, bp.bills[2]);
		assertEquals(100, bp.bills[3]);
		assertEquals(0, bp.bills[4]);
		assertEquals(10, bp.bills[5]);		
	}
	
	@Test
	void constructorThrow() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new BillPack(1,-1,3,4,5,6);});
	}
	
	@Test 
	void getters() {
		BillPack bp = new BillPack();
		assertEquals(0, bp.ones());
		assertEquals(0, bp.fives());
		assertEquals(0, bp.tens());
		assertEquals(0, bp.twenties());
		assertEquals(0, bp.fifties());
		assertEquals(0, bp.hundreds());		
	}
	
	@Test

	void setters() {
		BillPack bp = new BillPack();
		assertTrue(bp.ones(0));
		assertTrue(bp.fives(1));
		assertTrue(bp.tens(2));
		assertTrue(bp.twenties(3));
		assertTrue(bp.fifties(5));
		assertTrue(bp.hundreds(10));			
		assertFalse(bp.ones(-1));
		assertFalse(bp.fives(-2));
		assertFalse(bp.tens(-2));
		assertFalse(bp.twenties(-3));
		assertFalse(bp.fifties(-5));
		assertFalse(bp.hundreds(-10));			
		
	}

}
