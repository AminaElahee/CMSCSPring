import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
	Alcohol a1 , a2 ,a3,a4;

	@Before
	public void setUp() throws Exception {
		a1 = new Alcohol( "A1",Size.SMALL, false);
		
		a2 = new Alcohol("A2",Size.MEDIUM, true);
		a3 = new Alcohol("A3",Size.LARGE, true);
		
	}

	@After
	public void tearDown() throws Exception {
		a1=a2=a3=a4=null;
	}
	
	
 
	@Test
	public void testCalPrice() {
		
		a1 = new Alcohol( "A1",Size.SMALL, false);
		a2 = new Alcohol("A2",Size.MEDIUM, true);
		a3 = new Alcohol("A3",Size.LARGE, true);
		
		assertEquals(2,a1.calcPrice(), .01 );
		assertEquals(3.1,a2.calcPrice(), .01 );
		assertEquals(3.6,a3.calcPrice(), .01 );

	}
	
	
	

}


