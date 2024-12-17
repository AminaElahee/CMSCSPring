import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {
	
	Customer a1,a2;
	
	@BeforeEach
	public void setUp() throws Exception {
		 a1 = new Customer("n", 22);
		 a2 = new Customer(a1);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		a1 =a2 = null;
		
	}

	
	
	@Test
	void testCustomerStringInt()
	{
		assertEquals("n", a1.getName());
		assertEquals(22, a1.getAge());
	}

	@Test
	void testCustomerCustomer() {
		 assertEquals("n", a2.getName());
		 assertEquals(22, a2.getAge());
	}

	@Test
	void testGetAge() {
		assertEquals(22, a1.getAge());
	}

	@Test
	void testSetAge() {
		a1.setAge(30);
		assertEquals(30, a1.getAge());
	}

	@Test
	void testGetName() {
		assertEquals("n", a1.getName());
	}

	@Test
	void testSetName() {
		  a1.setName("B");
		  assertEquals("B", a1.getName());
	}

	

}
