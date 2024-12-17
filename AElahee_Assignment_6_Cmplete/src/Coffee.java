/* Class: CMSC203 CRN 21525
 Program: Assignment 6
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:This class gets coffee bev name and extra syrap and shots
 Due Date: 12/16/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */

public class Coffee extends Beverage{

	
	 public static final double EXTRA_SHOT_PRICE = 0.50;
	 public static final double EXTRA_SYRUP_PRICE = 0.50;
	 
	 
	private boolean extraShot;
	private boolean extraSyrup;
	
	
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, Type.COFFEE, size);
		
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
		
	}
	
	
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	
	@Override
	public String toString() //nned to fix this
	{
		return  "Extra Shot: " + extraShot + "\nExtra Syrup: " + extraSyrup + "\nPrice: $" + calcPrice();
	}

	@Override
	public double calcPrice() 
	{
		double price = addSizePrice(); 
	     
		if (extraShot) 
		{
			price += EXTRA_SHOT_PRICE;
		}
		if (extraSyrup) 
		{
			price += EXTRA_SYRUP_PRICE;
		}

		return price;
		
	}
	
	@Override
	public boolean equals(Object anotherBev)
	{
		
		
		
		if(anotherBev instanceof Coffee)
		{
			Coffee temp=(Coffee)anotherBev;
			
			if (this == anotherBev)
				return true;
			if (!(anotherBev instanceof Coffee))
				return false;
			if (!super.equals(anotherBev))
				return false;
		
			return extraShot == temp.extraShot && extraSyrup == temp.extraSyrup;
			
		}
		
		return false;
	}

	
	
	
}
