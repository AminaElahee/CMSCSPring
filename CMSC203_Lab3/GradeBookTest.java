import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook g1,g2,g3;

	@BeforeEach
	void setUp() throws Exception 
	{
		//Task3
		g1=new GradeBook(5);
	    g2= new GradeBook(5);
	    
	    g1.addScore(20);
	    g1.addScore(40);

	    g2.addScore(30);
	    g2.addScore(60);
	   
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		g1 = null;
		g2 = null;
	}
	//task3 ends

	//Task 4
	@Test
	void testAddScore() 
	{
		
		assertTrue(g1.toString().equals("20.0 40.0 ")); //comparing the strings
		assertEquals(2, g1.getScoreSize());  //comparing the score size which is 2

		assertTrue(g2.toString().equals("30.0 60.0 ")); //comparing the strings
		assertEquals(2, g2.getScoreSize()); //comparing the score size which is 2
	
	}

	@Test
	void testSum() 
	{
		assertEquals(60, g1.sum(), .001); //comparing the sum of the two value of the object g1
		assertEquals(90, g2.sum(), .001);//comparing the sum of the two value of the object g2
		
		
	}

	@Test
	void testMinimum() 
	{
		assertEquals(20, g1.minimum(), .001); //comparing the minimum value  of the two value of the object g1
		assertEquals(30, g2.minimum(), .001); //comparing the minimum value  of the two value of the object g2
		
	}

	@Test
	void testFinalScore() {
		assertEquals(40, g1.finalScore(), .001);  //Sum-lowest score(60-20=40)
		assertEquals(60, g2.finalScore(), .001);  //Sum-lowest score(90-30=60)
	}
	//task 4 ends



}
