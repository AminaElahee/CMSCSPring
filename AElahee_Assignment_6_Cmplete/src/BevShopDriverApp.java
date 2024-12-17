import java.util.Scanner;

public class BevShopDriverApp {

	public static void main(String[] args) {
		 BevShop bevShop = new BevShop();

	        // Start a new order
	        bevShop.startNewOrder(1,Day.MONDAY,"John", 22);
	        Order order1 = bevShop.getOrderAtIndex(0);

	        // Create a customer
	        Customer c = new Customer("John", 22);

	        // Set customer for the order
	        order1.getCustomer().setName(c.getName());
	        order1.getCustomer().setAge(c.getAge());

	 
	        //Orders
	        System.out.println("The current order in process can have at most 3 alcoholic beverages");
	        	System.out.println("The minimum age to order alcohol drink is 21");
	        	System.out.println("Start please a new order");
	        	System.out.println("Total on the Order: " + order1.calcOrderTotal());
	        	
	        if (bevShop.isValidAge(c.getAge()))
	        {  
	        	
	        	
	        	
	        	System.out.println(c);
	        	System.out.println("Your age is above 20 and you are eligible to order alcohol");
	        	
	        	//int i=0;
	        	//while(i<=bevShop.getMaxOrderForAlcohol())
	        	//{
		        	System.out.println("Would you please add an alcohol drink");
		        	order1.addNewBeverage("Alcohol 1", Size.SMALL);
		        	System.out.println("The current order of drinks is "+ bevShop.getNumOfAlcoholDrink());	
		        	System.out.println("The Total price on the Order is "+order1.calcOrderTotal());
		        	
		        	System.out.println("Would you please add an alcohol drink");
		        	order1.addNewBeverage("Alcohol 2", Size.MEDIUM);
		        	System.out.println("The current order of drinks is "+ bevShop.getNumOfAlcoholDrink());	
		        	System.out.println("The Total price on the Order is "+order1.calcOrderTotal());
		        	
		        	System.out.println("Would you please add an alcohol drink");
		        	order1.addNewBeverage("Alcohol 3", Size.LARGE);
		        	System.out.println("The current order of drinks is "+ bevShop.getNumOfAlcoholDrink());	
		        	System.out.println("The Total price on the Order is "+order1.calcOrderTotal());
		        	System.out.println("You have a maximum alcohol drinks for this order");
		        	
		    
		        	System.out.println("Would you please add a COFFEE to your order: ");
		        	order1.addNewBeverage("Cappuccino", Size.LARGE, true, true);
		        	System.out.println("Total items on your order is "+order1.getTotalItems());
		        	System.out.println("The Total Price on the Order: "+order1.calcOrderTotal());
		        	System.out.println("__________________________________________");
	     	
	        }
	        
	        else {
	        		 	     	    
	     	        System.out.println(c);				
	     	        System.out.println("Total items on your order is "+order1.getTotalItems());
	     	        System.out.println(   "Would you please add a SMOOTHIE to order ");
	     	        
	     	        order1.addNewBeverage ( "S1",Size.SMALL, 1,false);
	     	        
	     	        System.out.println("Total items on your order is "+order1.getTotalItems());
	     	        
	     	        System.out.println(   "Would you please add a SMOOTHIE to order ");
	     	        
	     	        System.out.println(   "Would you please add a COFFEE to order ");
	     	        
	     	        order1.addNewBeverage ( "S1",Size.SMALL, false,false);
	     	        
	     	        System.out.println("Would you please add an alcohol drink");
	     	        if(bevShop.isValidAge(c.getAge()))
	     	        {
	     	        	order1.addNewBeverage("Alcohol 4", Size.SMALL);
	     	        }
	     	        else
	     	        	System.out.println("Your Age is not appropriate for alcohol drink!!");
	     	        
	     	        
	     	        System.out.println("Current  items on your order is "+order1.getTotalItems());
	     	        
	     	       	System.out.println("The Total Price on the Order: "+order1.calcOrderTotal());
	     	        
	     	        System.out.println( "Total price on the second Order: "+order1.calcOrderTotal());
	     	        
	     	        System.out.println( "Total price on the second Order: "+bevShop.totalOrderPrice(order1.getOrderNo()));	
	        		
	        }
	        	

	        System.out.println(  "Would you please start a new order");
	        
	        bevShop.startNewOrder(2,Day.TUESDAY,"Jaycob", 52);
	        Order order2 = bevShop.getOrderAtIndex(0);

	        // Create a customer
	        Customer c2 = new Customer("Jaycob", 52);

	        // Set customer for the order
	        order2.getCustomer().setName(c2.getName());
	        order2.getCustomer().setAge(c2.getAge());
	        
	    
	        System.out.println(c2);				
	        System.out.println("Total items on your order is "+order2.getTotalItems());
	        System.out.println(   "Would you please add a SMOOTHIE to order ");
	        
	        order2.addNewBeverage ( "S1",Size.SMALL, 1,false);
	        
	        System.out.println("Total items on your order is "+order2.getTotalItems());
	        
	        System.out.println(   "Would you please add a SMOOTHIE to order ");
	        
	        System.out.println(   "Would you please add a COFFEE to order ");
	        
	        order2.addNewBeverage ( "S1",Size.SMALL, false,false);
	        
	        System.out.println("Would you please add an alcohol drink");
	        if(bevShop.isValidAge(c2.getAge()))
	        {
	        	order2.addNewBeverage("Alcohol 4", Size.SMALL);
	        }
	        else
	        	System.out.println("Your Age is not appropriate for alcohol drink!!");
	        
	        
	        System.out.println("Current  items on your order is "+order2.getTotalItems());
	        
	       	System.out.println("The Total Price on the Order: "+order2.calcOrderTotal());
	        
	        System.out.println( "Total price on the second Order: "+order2.calcOrderTotal());
	        
	        System.out.println( "Total amount for all Orders:  29.5\n\n"+bevShop.totalOrderPrice(order2.getOrderNo()));
	        
	 

	     	
	     
	     	
	     
	
	    }
}


