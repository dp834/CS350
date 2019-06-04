import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DrawerTest {

	@Test
	void test() {
		Drawer d = new Drawer(1,1,1,1,1,1,1,1,1,1);
		assertThrows(IllegalArgumentException.class, ()->{d.depositChange(-1, -1, -1, -1);});
		assertThrows(IllegalArgumentException.class, ()->{d.depositBills(-1, -1, -1, -1, -1, -1);});
		assertFalse(d.removeChange(100, 100, 100, 100));
		assertFalse(d.removeBills(100, 100, 100, 100, 100, 100));
	}

}
