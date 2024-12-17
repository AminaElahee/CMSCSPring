/* Class: CMSC203 CRN 21525
 Program: Assignment 6
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:This class gets alcohol bev name size and if it was ordererd in the weekend
 Due Date: 12/16/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */
public class Alcohol extends Beverage {
	
	public static final double EXTRA_WEEKEND_DRINK_PRICE = 0.60;
	
	private boolean weekendCheck;
	
	
	public Alcohol(String bevName,Size size, boolean isWeekend)
	{
		super( bevName,Type.ALCOHOL, size);
		
		this.weekendCheck=isWeekend;
		
	}
	
	@Override
	public double calcPrice()
	{
		double price = addSizePrice();
		
		if (weekendCheck) 
		{
			price += EXTRA_WEEKEND_DRINK_PRICE;
		}
		
	
		
		return price;
	}
	
	@Override
	public String toString()
	{
		
		
		return   "Weekend Offer: " + weekendCheck + "\nPrice: $" + calcPrice();
	}
	
	
	@Override
	public boolean equals(Object anotherBev)
	{
		if (this == anotherBev) 
			return true;
		if (!(anotherBev instanceof Alcohol))
			return false;
		if (!super.equals(anotherBev))
			return false;
		
		Alcohol temp = (Alcohol) anotherBev;
		return weekendCheck == temp.weekendCheck;
	}
	
	
	
	public boolean isWeekend()
	{
		  if( weekendCheck)
			  return true;
		  
		  return false;
	}

}
