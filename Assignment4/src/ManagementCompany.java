/* Class: CMSC203 CRN 21525
 Program: Assignment 4
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description: Management company class manages up to five properties within a plot, calculating total rent and fees.
 Due Date: 11/12/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amine Elahee
 */
public class ManagementCompany {

	
	public static final int MAX_PROPERTY=5;	
	public static final int MGMT_WIDTH=10;
	public static final int MGMT_DEPTH=10;
	
	
	private String ManagementCompanyName;
	private String TaxId;
	private double ManagementFeePercentage;
	private Property[] properties;
	private int numberOfProperties;
	private Plot plot;
	
	
	public ManagementCompany()
	{
		ManagementCompanyName = "No ManagementCompanyName";
        TaxId = "NO tax id";
        ManagementFeePercentage = 0;
       
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		ManagementCompanyName = name;
        TaxId = taxID;
        ManagementFeePercentage = mgmFee;
       
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		ManagementCompanyName = name;
        TaxId = taxID;
        ManagementFeePercentage = mgmFee;
       
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = 0;
        plot = new Plot(x, y, width, depth);
	}
	
	
	
	public ManagementCompany(ManagementCompany otherCompany)
	{
		ManagementCompanyName = otherCompany.ManagementCompanyName;
        TaxId = otherCompany.TaxId;
        ManagementFeePercentage = otherCompany.ManagementFeePercentage;
       
        properties = new Property[MAX_PROPERTY];
        numberOfProperties = otherCompany.numberOfProperties;
        plot = new Plot(otherCompany.plot);

        for (int i = 0; i < numberOfProperties; i++)
        		{
            this.properties[i] = new Property(otherCompany.properties[i]); 
        }
	}
	
	
	
	
	public String getManagementCompanyName()
	{
		return ManagementCompanyName;
	}
	
	public String getTaxID()
	{
		return TaxId;
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	public double getManagementFeePercentage()
	{
		return ManagementFeePercentage;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public int getnumOfProperties()
	{
		return numberOfProperties;
	}
	
	//------------
	

	public int addProperty(String name, String city, double rent, String owner)
	{
		if (numberOfProperties >= MAX_PROPERTY)
		{
			return -1;
		}
		
		Property newProperty = new Property(name, city, rent, owner);
		
		if (!plot.encompasses(newProperty.getPlot()))
		{
			return -2;
		}
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i].getPlot().overlaps(newProperty.getPlot())) {
				return -3;
			}
		}
		properties[numberOfProperties++] = newProperty;
		return numberOfProperties - 1;
		
	}
	

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		if (numberOfProperties >= MAX_PROPERTY) 
		{
			return -1;
		}
		
		Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
		
		if (!plot.encompasses(newProperty.getPlot())) {
			return -2;
		}
		
		for (int i = 0; i < numberOfProperties; i++) 
		{
			if (properties[i].getPlot().overlaps(newProperty.getPlot()))
			{
				return -3;
			}
		}
		
		properties[numberOfProperties++] = newProperty;
		
		return numberOfProperties - 1;
		
	}
	

	public int addProperty(Property property)
	{
		if (numberOfProperties >= MAX_PROPERTY)
		{
			return -1;
		}
		if (!plot.encompasses(property.getPlot())) {
			return -2;
		}
		
		for (int i = 0; i < numberOfProperties; i++) 
		{
			if (properties[i].getPlot().overlaps(property.getPlot())) 
			{
				return -3;
			}
		}
		
		properties[numberOfProperties++] = property;
		
		return numberOfProperties - 1;
		
	}
	
	
	
	public void removeLastProperty()
	{
		if (numberOfProperties > 0)
		{
			properties[--numberOfProperties] = null;
		}
	}
	
	public boolean isPropertiesFull()
	{
		 return numberOfProperties >= MAX_PROPERTY;
	}
	
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	
	public double getTotalRent()
	{
		double totalRent = 0;
		
		for (int i = 0; i < numberOfProperties; i++)
		{
			totalRent += properties[i].getRentAmount();
		}
		return totalRent;
	}
	
	public Property getHighestRentPropperty()
	{
		if (numberOfProperties == 0) 
			return null;
		
        Property highestRentProperty = properties[0];
        
        for (int i = 1; i < numberOfProperties; i++) 
        {
        	if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
	}

	public boolean isMangementFeeValid()
	{
		return ManagementFeePercentage >= 0 && ManagementFeePercentage <= 100;
	}
	
	public String toString()
	{
		String result = "List of the properties for " + ManagementCompanyName + ", taxID: " + TaxId + "\n"+ "______________________________________________________\n";


		for (int i = 0; i < numberOfProperties; i++) 
		{
			result += properties[i].toString() + "\n";
		}


		double totalManagementFee = getTotalRent() * ManagementFeePercentage / 100;
		result += "______________________________________________________\n\n"+ " total management Fee: " + totalManagementFee;

		return result;

	}

}
