/* Class: CMSC203 CRN 21525
 Program: Assignment 5
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description:The assignment calculates holiday bonuses for retail stores based on sales,
 Due Date: 12/3/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amina Elahee
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility extends Object {

	
	
	public TwoDimRaggedArrayUtility()
	{
		
		
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		 int MAX_ROWS = 10;
		 int MAX_COLUMNS = 10;
         int row = 0;
         
         String[][] array = new String[MAX_ROWS][MAX_COLUMNS];
         Scanner scan = new Scanner(file);

       
        
         while (scan.hasNextLine() && row < MAX_ROWS) 
         {
        	 String line = scan.nextLine();
        	 
   
             Scanner l = new Scanner(line); 

             int col = 0;
             while (l.hasNext() && col < MAX_COLUMNS) {
                 array[row][col] = l.next(); 
                 col++;
             }
             row++;
             
             l.close();
         }
         
         
         scan.close();

         if (row == 0) 
         {
        	 return null; 
         }

         double[][] result= new double[row][];
         
         
         for (int i = 0; i < row; i++) 
         {
             
        	 int columns = 0;
             for (int j = 0; j < MAX_COLUMNS; j++) 
             {
                 if (array[i][j] != null) {
                     columns++;
                 }
             }

            
             result[i] = new double[columns];
             
             for (int j = 0; j < columns; j++)
             {
                 result[i][j] = Double.parseDouble(array[i][j]);
             }
         }

         return result;
    
	}
			
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(outputFile);

        for (int i = 0; i < data.length; i++) 
        {
        	for (int j = 0; j < data[i].length; j++) {
        		writer.print(data[i][j]);
        		if (j < data[i].length - 1)
        		{
        			writer.print(" ");
        		}
            }
        	
            writer.println();
        }

        writer.close();
    }
	
		
	
	
	public static double getTotal(double[][] data)//3
	{
		double total = 0;
		
		for (int i = 0; i < data.length; i++) 
		{
			for (int j = 0; j < data[i].length; j++) 
			{
				total += data[i][j];
			}
		}
        return total;
		
	}
	
	public static double getAverage(double[][] data)//4
	{
		double total = getTotal(data);
		
	    int e = 0;
	    
	    for (int i = 0; i < data.length; i++)
	    {
	    	e += data[i].length;
	    }
	    
	    double avg=total / e;
	    
	    return avg;
		
	}
	
	
	public static double getRowTotal(double[][] data, int row)//5
	{
		double total = 0;
		
		for (int i = 0; i < data[row].length; i++) 
		{
			total += data[row][i];
	    }
		
	    return total;
		
	}
	
	public static double getColumnTotal(double[][] data, int col)//6
	{
		
		double total = 0;
		
		for (int i = 0; i < data.length; i++) 
		{
			if (col < data[i].length) 
			{
				total += data[i][col];
			}
		}
		
		return total;
		
	}
	
	
	public static double getHighestInRow(double[][] data, int row)//7
	{
		
		double highest = data[row][0];
		
		
		for (int i = 0; i < data[row].length; i++) 
		{
			if (data[row][i] > highest)
			{
				highest = data[row][i];
			}
		}
		
		return highest;
	}
		
	public static int getHighestInRowIndex(double[][] data, int row)//8
	{
		int i = 0;
		
		for (int j = 1; j < data[row].length; j++) 
		{
			if (data[row][j] > data[row][i]) 
			{
				i = j;
			}
		}
		
		return i;
	}
	
	
	public static double getLowestInRow(double[][] data, int row)//9
	{
		double lowest = data[row][0];
		for (int i = 1; i < data[row].length; i++) 
		{
			if (data[row][i] < lowest) 
			{
				lowest = data[row][i];
			}
		}
		
		return lowest;
		
	}
	
	public static int getLowestInRowIndex(double[][] data, int row)//10
	{
		int index = 0;
		
		for (int i = 1; i < data[row].length; i++) 
		{
			if (data[row][i] < data[row][index])
			{
				index = i;
			}
		}
		return index;
		
	}
	
	public static double getHighestInColumn(double[][] data, int col)//11
	{
		double highest = data[0][col];
		
		for (int i = 1; i < data.length; i++) 
		{
			if (col < data[i].length && data[i][col] > highest)
			{
				highest = data[i][col];
			}
		}
		
		
	    return highest;
		
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		int i = 0;
		double highest = data[0][col];
	    
		for (int x = 1; x < data.length; x++) 
		{
			if (col < data[x].length && data[x][col] > highest) 
			{
				highest = data[x][col];
				i = x;
			}
		}
		
	    return i;
		
	}
	
	
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest = data[0][col];
		
		for (int i = 1; i < data.length; i++) 
		{
			if (col < data[i].length && data[i][col] < lowest) 
			{
				lowest = data[i][col];
			}
		}
		
		return lowest;
		
	}
	
	
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		int i = 0;
		double lowest = data[0][col];
		    
		for (int x = 1; x < data.length; x++) 
		{
			if (col < data[x].length && data[x][col] < lowest) 
			{
				lowest = data[x][col];
				i = x;
			}
		}
		return i;
		
	}
//--------------------------NEED TO FIX------------//
	public static double getHighestInArray(double[][] data)
	{
		double highest = data[0][0];
		for (int i = 0; i < data.length; i++) 
		{
			for (int j = 0; j < data[i].length; j++) 
			{
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		
		return highest;
		
	}
	
	
	
	public static double getLowestInArray(double[][] data)
	{
		 double lowest = data[0][0];
		    for (int i = 0; i < data.length; i++) {
		        for (int j = 0; j < data[i].length; j++) {
		            if (data[i][j] < lowest) {
		                lowest = data[i][j];
		            }
		        }
		    }
		    return lowest;
		
	}
	
	
	
	
	

	
	
	
}
