/* Class: CMSC203 CRN 21525
 Program: Assignment 5
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:This class counts the bonuses
 Due Date: 12/3/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */
public class HolidayBonus {

	public static final double HIGHEST_SALES = 5000.0;
    public static final double LOWEST_SALES = 1000.0;
    public static final double OTHER_STORES = 2000.0;
	
    public HolidayBonus()
    {
    	
    }

	
    public static double[] calculateHolidayBonus(double[][] data)
    {
    	double[] bonus = new double[data.length];

    	for (int row = 0; row < data.length; row++) 
    	{
    		double b = 0;

    		for (int col = 0; col < data[row].length; col++) 
    		{
    			double hSales = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
    			double lSales = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

    			if (data[row][col] > 0) 
    			{
                      
    				if (data[row][col] == hSales) 
    				{
    					b += HIGHEST_SALES;
    				}
    				else if (data[row][col] == lSales) 
    				{
    					b += LOWEST_SALES;
    				} 
    				else 
    				{
    					b += OTHER_STORES;
    				}
    			}
    		}

    		bonus[row] = b;
    	}

    	return bonus;
    }

   
    public static double calculateTotalHolidayBonus(double[][] data) 
    {
    	double[] bonus = calculateHolidayBonus(data);
    	double totalBonus = 0;

    	for (int i = 0; i < bonus.length; i++) 
    	{
    		totalBonus += bonus[i];
    	}

    	return totalBonus;
      }
  }