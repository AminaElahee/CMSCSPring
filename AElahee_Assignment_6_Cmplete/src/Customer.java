/* Class: CMSC203 CRN 21525
 Program: Assignment 6
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:T this class gets the Customer details
 Due Date: 12/16/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */
public class Customer {

	
	
	private String customerName;
	private int customerAge;
	
	
	
	
	public Customer(String name,int age)
	{
		customerName=name;
		customerAge=age;
	}
	
	public Customer(Customer c)
	{
		customerName=c.customerName;
		customerAge=c.customerAge;

	}
	
	public int getAge()
	{
		return customerAge;
	}
	
	
	public void setAge(int age)
	{
		customerAge=age;
	}
	
	public String getName()
	{
		return customerName;
	}

	
	public void setName(String name)
	{
		customerName=name;
	}
	
	@Override
	public String toString()
	{
		return ("Would you please enter your name "+getName()+
        "\nWould you please enter your age "+getAge());
		
		
	}
}
