import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	Coffee a1 , a2 ,a3,a4;
	 
	@Before
	public void setUp() throws Exception {
		a1 = new Coffee( "C1",Size.SMALL, false,false);
		
		a2 = new Coffee("C2",Size.MEDIUM, true,true);
		a3 = new Coffee("C3",Size.LARGE, true,false);
		
	}

	@After
	public void tearDown() throws Exception {
		a1=a2=a3=a4=null;
	}
	
	@Test
	void testCalcPrice() {

		a1 = new Coffee( "C1",Size.SMALL, false,false);
		a2 = new Coffee("C2",Size.MEDIUM, true,true);
		a3 = new Coffee("C3",Size.LARGE, true,false);
		
		assertEquals(2,a1.calcPrice(), .01 );
		assertEquals(3.5,a2.calcPrice(), .01 );
		assertEquals(3.5,a3.calcPrice(), .01 );


	}

	
	
	

}
