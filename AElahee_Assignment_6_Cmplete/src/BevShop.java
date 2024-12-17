/* Class: CMSC203 CRN 21525
 Program: Assignment 6
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:This class gets calculates the total
 Due Date: 12/16/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */

import java.util.ArrayList;

public class BevShop implements BevShopInterface
{
	
	 private int numOfAlcoholCurrent;
	 private ArrayList<Order> orders;
	 private Order currentOrder;

	public BevShop()
	{
		numOfAlcoholCurrent=0;
		orders = new ArrayList<>();
		
	}
	
	public boolean isValidTime(int time)
	{
		 if(time >=MIN_TIME && time <= MAX_TIME)
			 return true;
		 
		 return false;
	}
	
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol()
	{
		 return MIN_AGE_FOR_ALCOHOL;
	}
	
	public boolean isMaxFruit(int numOfFruits)
	{
		
		return numOfFruits > MAX_FRUIT;
		
	}
	
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL ;
	}
	
	public boolean isEligibleForMore()
	{
		if(numOfAlcoholCurrent < MAX_ORDER_FOR_ALCOHOL)
		 return true;
		
		return false;
	}
	
	
	public int getNumOfAlcoholDrink()
	{
		int count = 0;
		for (Order order : orders) 
		{
			count += order.findNumOfBeveType(Type.ALCOHOL);
		}
	        
		 return count;
	}
	
	public boolean isValidAge(int age)
	{
		return age >= MIN_AGE_FOR_ALCOHOL;
	}
	
	public void startNewOrder(int time,Day day,String customerName,int customerAge)
	{
		
	
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		numOfAlcoholCurrent = 0;
		orders.add(currentOrder);

        
	}
	
	public void processCoffeeOrder(String bevName,Size size,boolean extraShot,boolean extraSyrup)
	{
		
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}
	
	
	public void processAlcoholOrder(String bevName,Size size)
	{
		if (isEligibleForMore()) 
		{
			currentOrder.addNewBeverage(bevName, size);
			
            numOfAlcoholCurrent++;
        }
	}
	
	public void processSmoothieOrder(String bevName,Size size,int numOfFruits,boolean addProtein)
	{
		if (!isMaxFruit(numOfFruits)) 
		{
			currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
		}
	}
	
	public int findOrder(int orderNo)
	{
		for (int i = 0; i < orders.size(); i++) 
		{
			if (orders.get(i).getOrderNo() == orderNo)
			{
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public double totalOrderPrice(int orderNo)
	{
		 double total = 0; 
		 
		    for (Order order : orders) {
		        total += order.calcOrderTotal(); 
		    }
		    return total;
	}
	
	@Override
	public double totalMonthlySale()
	{
		double total = 0;
        for (Order order : orders) 
        {
            total += order.calcOrderTotal();
        }
        return total;
	}
	
	public int totalNumOfMonthlyOrders()
	{
		return orders.size();
	}
	
	public Order getCurrentOrder()
	{
		return currentOrder;
	}
	
	public Order getOrderAtIndex(int index)
	{
		if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
	}

	
	public void sortOrders()
	{
		for (int i = 0; i < orders.size() - 1; i++) 
		
		{
            int minIndex = i;
            
            for (int j = i + 1; j < orders.size(); j++) 
            {
            	if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
            		minIndex = j;
                }
            }
            
            Order temp = orders.get(i);
            orders.set(i, orders.get(minIndex));
            orders.set(minIndex, temp);
        }
	}
	
	public String toString()
	{
		  StringBuilder result = new StringBuilder();
	        result.append("BevShop Orders:\n");
	        for (Order order : orders) {
	            result.append(order.toString()).append("\n");
	        }
	        result.append("Total Monthly Sale: ").append(totalMonthlySale());
	        return result.toString();
	}
}
