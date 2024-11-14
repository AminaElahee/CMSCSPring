/* Class: CMSC203 CRN 21525
 Program: Assignment 4
 Instructor: Khandan Vahabzadeh Monshi
 Summary of Description: Plot class defines a rectangular area with methods to set dimensions, check overlaps and verify containment.
 Due Date: 11/12/2024 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Amine Elahee
 */
public class Plot {

	private int X;
	private int Y;
	private int Depth;
	private int Width;
	
	//Constructors
	public Plot()
	{
		X=0;
		Y=0;
		Depth=1;// 1 because depth or width can't be 0
		Width=1;
		
		
	}
	
	public Plot(int x,int y, int width, int depth)
	{
		
		X = x;
        Y = y;
        Width = width;
        Depth = depth;
	}
	
	public Plot(Plot otherPlot)
	{
		X = otherPlot.X;
        Y = otherPlot.Y;
        Width = otherPlot.Width;
        Depth = otherPlot.Depth;
		
		
	}
	
	
	//get methods
	public int getX()
	{
		return X;
		 
	}
	
	public int getY()
	{
		return Y;
		 
	}
	
	public int getDepth()
	{
		return Depth;
		 
	}
	
	public int getWidth()
	{
		return Width;
		 
	}
	
	//set methods
	public void setX(int x1)
	{		
		X=x1;
	}
	
	public void setY(int y1)
	{		
		Y=y1;
	}
	public void setDepth(int d)
	{		
		Depth=d;
	}
	 
	public void setWidth(int w)
	{		
		Width=w;
	}
	
	
	
	public boolean overlaps(Plot plot)
	{
	        
		if (X + Width <= plot.X || plot.X + plot.Width <= X || Y + Depth <= plot.Y || plot.Y + plot.Depth <= Y)
		{ 
			return false;
		}
	     
		return true;
	}
	
	
	public boolean encompasses (Plot plot)
	{
		if (X <= plot.X && Y <= plot.Y && X + Width >= plot.X + plot.Width && Y + Depth >= plot.Y + plot.Depth)
		{ 
			return true;
		}
	     
		return false;
		
		
	}
	
	@Override
	public String toString() 
	{
		return X + "," + Y + "," + Width + "," + Depth;
    }
	
}
