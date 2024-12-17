
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class OrderTestStudent {
	Order a1, a2, a3, a4;

	@Before
	public void setUp() throws Exception {
		a1 = new Order(7, Day.MONDAY, new Customer("Mary", 22));
		a2 = new Order(12, Day.SATURDAY, new Customer("John", 45));
		a3 = new Order(10, Day.SUNDAY, new Customer("Kate", 21));
	}

	@After
	public void tearDown() throws Exception {
		a1 = a2 = a3 = null;
	}

	

	@Test
	public void testAddNewBeverage() throws NullPointerException {

		assertTrue(a1.getTotalItems() == 0);
		
		a1.addNewBeverage(" Coffee", Size.MEDIUM, true, false);
		assertTrue(a1.getBeverage(0).getType().equals(Type.COFFEE));
		
		a1.addNewBeverage("a", Size.MEDIUM);
		assertTrue(a1.getBeverage(1).getType().equals(Type.ALCOHOL));
		
		a1.addNewBeverage("s", Size.SMALL, 2, true);
		assertTrue(a1.getBeverage(2).getType().equals(Type.SMOOTHIE));
		
		assertTrue(a1.getTotalItems() == 3);

		a2.addNewBeverage("s", Size.LARGE, 0, false);
		assertTrue(a2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		
		a2.addNewBeverage("a", Size.SMALL);
		assertTrue(a2.getBeverage(1).getType().equals(Type.ALCOHOL));
		
		a2.addNewBeverage("c Coffee", Size.MEDIUM, false, false);
		assertTrue(a2.getBeverage(2).getType().equals(Type.COFFEE));
		
		assertTrue(a2.getTotalItems() == 3);

	}

	@Test
	public void testCalcOrderTotal() {
		a1.addNewBeverage(" Coffee", Size.MEDIUM, false, false);
		a1.addNewBeverage("A", Size.SMALL);
		a1.addNewBeverage("B", Size.MEDIUM, 2, true);

		assertEquals(9.5, a1.calcOrderTotal(), .01);

		a2.addNewBeverage("A Coffee", Size.SMALL, true, false);
		a2.addNewBeverage("V", Size.SMALL);
		a2.addNewBeverage("x", Size.LARGE, 2, false);

		assertEquals(9.1, a2.calcOrderTotal(), .01);

	}

}
