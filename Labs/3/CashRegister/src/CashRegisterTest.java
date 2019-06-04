import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CashRegisterTest {

	@Test
	void constructor() {
		BillPack bp = new BillPack();
		CoinPack cp = new CoinPack();
		assertNotNull(new CashRegister());
		assertNotNull(new CashRegister(new Drawer()));
		assertNotNull(new CashRegister(0,0,0,0,0,0,0,0,0,0));
		assertNotNull(new CashRegister(0,0,0,0,0,0,0,0,0,0, new PennsylvaniaTax()));
		assertNotNull(new CashRegister(bp, cp));
		assertNotNull(new CashRegister(bp, cp, new PennsylvaniaTax()));
	}
	
	@Test
	void getters() {
		BillPack bp = new BillPack();
		CoinPack cp = new CoinPack();
		CashRegister cr = new CashRegister(bp,cp);
		assertEquals(cr.drawerValue(), 0);
		assertEquals(cr.coinsInDrawer().pennies(), cp.pennies());
		assertEquals(cr.billsInDrawer().ones(), bp.ones());
	}

	@Test
	void purchase() {
		BillPack bp = new BillPack();
		CoinPack cp = new CoinPack();
		CashRegister cr = new CashRegister(bp,cp);
		assertThrows(IllegalStateException.class, ()->{new CashRegister(new BillPack(), new CoinPack()).purchaseItem(1,0,0,0,0,0,0,0,0,0,0);});
		assertThrows(IllegalStateException.class, ()->{new CashRegister(new BillPack(), new CoinPack()).purchaseItem(1,2,0,0,0,0,0,0,0,0,0);});
		bp = new BillPack(1,2,1,1,1,1);
		cp = new CoinPack(1,1,1,1);
		cr = new CashRegister(bp,cp);
		assertEquals(cr.purchaseItem(3, bp, cp), 188.23);
		cr = new CashRegister(bp,cp);
		assertEquals(cr.purchaseItem(1, 1, 0, 0, 0, 0, 0, 6, 0, 0, 0), 0);
	}	
	
	@Test
	void scanItem() {
		BillPack bp = new BillPack(1,1,1,1,1,1);
		CoinPack cp = new CoinPack(1,1,1,1);
		CashRegister cr = new CashRegister(bp,cp);
		assertEquals(cr.scanItem(1, "Hello"), 1);
		assertEquals(cr.finalizePurchase(new BillPack(1,0,0,0,0,0), new CoinPack(6,0,0,0)), 0);
		assertEquals(cr.scanItem(1, "Hello"), 1);
		assertThrows(IllegalStateException.class, ()->{cr.finalizePurchase(new BillPack(), new CoinPack());});
	}
}
