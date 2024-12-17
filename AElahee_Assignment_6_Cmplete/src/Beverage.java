/* Class: CMSC203 CRN 21525
 Program: Assignment 6
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:This class gets Beverage name size and type
 Due Date: 12/16/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */

public abstract class Beverage {
	
	public static final double BASE_PRICE=2.0;
	public static final double SIZE_PRICE=0.5;
	
	private String Name;
	private Type Type;
	private Size Size;
	
	
	
	public Beverage(String bevName,Type type, Size size)
	{
		
		Name=bevName;
		Type=type;
		Size=size;
	}

	
	
	public double getBasePrice()
	{
		return BASE_PRICE;
	}
	
	public String getBevName()
	{
		return Name;
	}
	
	public Type getType()
	{
		return Type;
	}
	
	public Size getSize()
	{
		return Size;
	}
	
	
	public double addSizePrice()
	{
		
		double newPrice=BASE_PRICE;
		
	
		 if(Size==Size.MEDIUM)
		{
			newPrice+= SIZE_PRICE;
			
			
		}
		if(Size==Size.LARGE)
		{
			newPrice+=(2*SIZE_PRICE);
		}
		
		return newPrice;
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString()
	{
		return  "Beverage [name=" + Name + ", size=" + Size + "]";
	}
	
	@Override
	public boolean equals(Object anotherBev)
	{
		
		if (this == anotherBev)
			return true;
		if (!(anotherBev instanceof Beverage)) 
			return false;
		Beverage beverage = (Beverage) anotherBev;
		return Name.equals(beverage.Name) && Type == beverage.Type && Size == beverage.Size;
		
	}
}

