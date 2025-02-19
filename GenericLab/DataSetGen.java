
public class DataSetGen<T extends Measurable> {
	
	private double total;
	
	private int count;
	private T max;
	  
	public DataSetGen()
	{
		total = 0;
		count = 0;
		max= null;
	}
	
	public T getMaximum()
	{
		return max;
	}

	public void add(T a)
	{
		total += a.getMeasure();
		
		if (count == 0 || max.getMeasure() < a.getMeasure())
		{
			max = a;
		}
	        
		count++;
	}

	   
	public double getAverage()
	{
		if (count == 0)
		{
			return 0;
		}
	        
		return total / count;
	}

	   
	
	

}
