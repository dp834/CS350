import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinPackTest {

	@Test
	void constructor() {
		CoinPack cp = new CoinPack();
		assertNotNull(cp);
		assertEquals(0, cp.cents[0]);
		assertEquals(0, cp.cents[1]);
		assertEquals(0, cp.cents[2]);
		assertEquals(0, cp.cents[3]);		
		cp = new CoinPack(1,3,5,100);
		assertNotNull(cp);
		assertEquals(1, cp.cents[0]);
		assertEquals(3, cp.cents[1]);
		assertEquals(5, cp.cents[2]);
		assertEquals(100, cp.cents[3]);		
	}
	
	@Test
	void constructorThrow() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new CoinPack(1,-1,3,4);});
	}
	
	@Test 
	void getters() {
		CoinPack cp = new CoinPack();
		assertEquals(0, cp.pennies());
		assertEquals(0, cp.nickles());
		assertEquals(0, cp.dimes());
		assertEquals(0, cp.quarters());	
	}
	
	@Test

	void setters() {
		CoinPack cp = new CoinPack();
		assertTrue(cp.pennies(0));
		assertTrue(cp.nickles(1));
		assertTrue(cp.dimes(2));
		assertTrue(cp.quarters(3));			
		assertFalse(cp.pennies(-1));
		assertFalse(cp.nickles(-2));
		assertFalse(cp.dimes(-2));
		assertFalse(cp.quarters(-3));			
	}
}