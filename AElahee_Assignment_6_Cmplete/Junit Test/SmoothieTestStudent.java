import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	Smoothie a1 , a2 ,a3,a4;
	 
	@Before
	public void setUp() throws Exception {
		a1 = new Smoothie( "S1",Size.SMALL, 1,false);
		a2 = new Smoothie("S2",Size.MEDIUM, 2,true);
		a3 = new Smoothie("S3",Size.LARGE, 3,false);
		
		
		
	}
	
	
	
	@Test
	void testCalcPrice() {

		a1 = new Smoothie( "S1",Size.SMALL, 1,false);
		a2 = new Smoothie("S2",Size.MEDIUM, 2,true);
		a3 = new Smoothie("S3",Size.LARGE, 3,false);
		a4 = new Smoothie( "S4",Size.SMALL, 0,false);
		
		assertEquals(2.5,a1.calcPrice(), .01 );
		assertEquals(5,a2.calcPrice(), .01 );
		assertEquals(4.5,a3.calcPrice(), .01 );
		assertEquals(2,a4.calcPrice(), .01 );

	}

	

	

}
