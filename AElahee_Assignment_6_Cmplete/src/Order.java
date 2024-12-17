import java.util.ArrayList;
import java.util.Random;
/* Class: CMSC203 CRN 21525
Program: Assignment 6
Instructor: Khandan Vahabzadeh Monshi
Summary of Description: holds all the order
Due Date: 12/16/2024 
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Student Name: Amina Elahee
*/
public class Order implements OrderInterface, Comparable<Order>{
	
	
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	
	
	
	public Order(int orderTime,Day orderDay,Customer cust)
	{
		
		this.orderTime=orderTime;
		this.orderDay=orderDay;
		this.customer=new Customer(cust);
		this.orderNum= generateOrder();
		this.beverages = new ArrayList<>();
	}
	
	public int generateOrder()
	{
		Random r=new Random();
		
		int randNum=  10000 + r.nextInt(90001);
		
		return randNum;
	}
	
	
	public int getOrderNo()
	{
		return orderNum;
	}
	
	public int getOrderTime()
	{
		return orderTime;
	}
	
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	public Customer getCustomer()
	{
		return new Customer(customer);
	}
	
	public boolean isWeekend()
	{

		return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
	}
	
	public Beverage getBeverage(int itemNo)
	{
		if (itemNo >= 0 && itemNo < beverages.size())
		{
			return beverages.get(itemNo);
        }
		
		return null;
		

    }
	
	
	public int getTotalItems()
	{
		return beverages.size();
	}
	
	
	public void addNewBeverage(String bevName,Size size,boolean extraShot,boolean extraSyrup)
	{
		
		 Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		 beverages.add(c);
	}
	
	

	public void addNewBeverage(String bevName,Size size)
	{
		boolean isWeekend = orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
		Alcohol a = new Alcohol(bevName, size, isWeekend());
		beverages.add(a);
		
	}
	
	
	
	public void addNewBeverage(String bevName,Size size,int numOfFruits,boolean addProtein)
	{
		 Smoothie s = new Smoothie(bevName, size, numOfFruits, addProtein);
		 beverages.add(s);;
	}
	
	@Override
	public double calcOrderTotal()
	{
		double total=0.0 ;
	    for (int i = 0; i < beverages.size(); i++) {
	        total += beverages.get(i).calcPrice();
	    }
	    return total;
	}
	
	
	@Override
	public int findNumOfBeveType(Type type)
	{
		int n = 0;
	    for (int i = 0; i < beverages.size(); i++) {
	        if (beverages.get(i).getType().equals(type)) {
	            n++;
	        }
	    }
	    return n;
	}
	
	@Override
	public String toString()
	{
		
		String result = "Order Number: " + orderNum + "\nOrder Time: " + orderTime + "\nOrder Day: " + orderDay
				+ "\nCustomer Name: " + customer.getName() + "\nCustomer Age: " + customer.getAge() + "\nBeverages: \n";

		for (Beverage bev : beverages) {
			result += bev.toString() + "\n";
		}

		return result;
	}
	
	@Override
	public int compareTo(Order anotherOrder)
	{
	
		if (orderNum == anotherOrder.getOrderNo()) 
		{
			return 0;
		}
		else if (orderNum > anotherOrder.getOrderNo())
		{
		
			return 1;
		}
		else 
		{
			return -1;
		}
	}
}
