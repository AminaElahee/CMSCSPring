/* Class: CMSC203 CRN 21525
 Program: Assignment 6
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:This class gets Beverage Smoothie name and calculates additionnal protiens and fruits
 Due Date: 12/16/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */
public class Smoothie extends Beverage{
	
	


	public static final double EXTRA_PROTIEN_PRICE = 1.50;
	public static final double EXTRA_FRUIT_PRICE = 0.50;
	
	private int numOfFruits;
	private boolean addProtein;

	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		super (bevName,Type.SMOOTHIE,  size);
		
		this.numOfFruits=numOfFruits;
		this.addProtein=addProtein;
		
	}
	
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	
	public boolean getAddProtein()
	{
		return addProtein;
	}
	
	
	@Override
	public String toString()
	{
		String s = getBevName() + ", " + getSize() + " " + numOfFruits + " Fruits";

        if (addProtein) {
            s += " Protein powder";
        }

        s += ", $" + calcPrice();

        return s;
	}
	
	@Override
	public double calcPrice()
	{
		double price = addSizePrice();
		
		
		if (numOfFruits > 0) 
		{
			price += numOfFruits * EXTRA_FRUIT_PRICE;
		}
	        
		if (addProtein) 
		{
			price += EXTRA_PROTIEN_PRICE;
		}
		return price;
	
	}
	
	
	
	@Override
	public boolean equals(Object anotherBev)
	{
		if (this == anotherBev) 
			return true;
        if (!(anotherBev instanceof Smoothie)) 
        	return false;
        if (!super.equals(anotherBev))
        	return false;
        Smoothie temp = (Smoothie) anotherBev;
        
        return numOfFruits == temp.numOfFruits && addProtein == temp.addProtein;
	}
	
	
}
