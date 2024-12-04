
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {{10, 20, 30}, {40, 50}, {60, 70, 80, 90}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetRowTotal() {
		assertEquals(300.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2), .001);
	}
}
