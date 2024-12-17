import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	BevShop a1;

    @BeforeEach
    public void setUp() {
        a1 = new BevShop();
    }

    @Test
    void testIsValidTime() {
        assertTrue(a1.isValidTime(8));
        assertFalse(a1.isValidTime(24));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(BevShopInterface.MAX_FRUIT, a1.getMaxNumOfFruits());
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(BevShopInterface.MIN_AGE_FOR_ALCOHOL, a1.getMinAgeForAlcohol());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(a1.isMaxFruit(6));
        assertFalse(a1.isMaxFruit(3));
    }

    @Test
    void testIsEligibleForMore() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.processAlcoholOrder("Beer", Size.SMALL);
        a1.processAlcoholOrder("Wine", Size.MEDIUM);
        a1.processAlcoholOrder("Whiskey", Size.LARGE);
        assertFalse(a1.isEligibleForMore());
    }

    @Test
    void testGetNumOfAlcoholDrink() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.processAlcoholOrder("Beer", Size.SMALL);
        a1.processAlcoholOrder("Wine", Size.MEDIUM);
        a1.processAlcoholOrder("Whiskey", Size.LARGE);
        assertEquals(3, a1.getNumOfAlcoholDrink());
    }

    @Test
    void testIsValidAge() {
        assertTrue(a1.isValidAge(21));
        assertFalse(a1.isValidAge(18));
    }

    @Test
    void testStartNewOrder() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        assertEquals("X", a1.getCurrentOrder().getCustomer().getName());
        assertEquals(10, a1.getCurrentOrder().getOrderTime());
    }

    @Test
    void testProcessCoffeeOrder() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.processCoffeeOrder("Latte", Size.SMALL, true, false);
        assertEquals(1, a1.getCurrentOrder().getTotalItems());
    }

    @Test
    void testProcessAlcoholOrder() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, a1.getCurrentOrder().getTotalItems());
    }

    @Test
    void testProcessSmoothieOrder() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.processSmoothieOrder("Strawberry", Size.MEDIUM, 2, true);
        assertEquals(1, a1.getCurrentOrder().getTotalItems());
    }

    @Test
    void testFindOrder() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        int orderNo = a1.getCurrentOrder().getOrderNo();
        assertEquals(0, a1.findOrder(orderNo));
    }

    @Test
    void testTotalOrderPrice() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.processCoffeeOrder("Latte", Size.SMALL, true, false);
        assertEquals(2.5, a1.totalOrderPrice(a1.getCurrentOrder().getOrderNo()), 0.01);
    }



    @Test
    void testTotalNumOfMonthlyOrders() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.startNewOrder(12, Day.TUESDAY, "Y", 30);
        assertEquals(2, a1.totalNumOfMonthlyOrders());
    }

    @Test
    void testGetCurrentOrder() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        assertNotNull(a1.getCurrentOrder());
    }

    @Test
    void testGetOrderAtIndex() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        assertNotNull(a1.getOrderAtIndex(0));
        assertNull(a1.getOrderAtIndex(1));
    }

    @Test
    void testSortOrders() {
        a1.startNewOrder(10, Day.MONDAY, "X", 25);
        a1.startNewOrder(12, Day.TUESDAY, "Y", 30);
        a1.sortOrders();
        assertTrue(a1.getOrderAtIndex(0).getOrderNo() < a1.getOrderAtIndex(1).getOrderNo());
    }

}
