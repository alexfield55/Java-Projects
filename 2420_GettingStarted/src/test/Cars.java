package test;

import java.util.Comparator;

public class Cars implements Comparable<Cars>
{
    private int year;
    private String make;
    private String model;
    private String color;
    public static final Comparator<Cars> BY_MAKE = new sortByMake();
    
    public Cars(int year, String make, String model, String color)
    {
	this.year = year;
	this.make = make;
	this.model = model;
	this.color = color;
    }
    
    

    public int getYear()
    {
        return year;
    }



    public void setYear(int year)
    {
        this.year = year;
    }



    public String getMake()
    {
        return make;
    }



    public void setMake(String make)
    {
        this.make = make;
    }



    public String getModel()
    {
        return model;
    }



    public void setModel(String model)
    {
        this.model = model;
    }



    public String getColor()
    {
        return color;
    }



    public void setColor(String color)
    {
        this.color = color;
    }



    @Override
    public int compareTo(Cars that)
    {
	if (this.year < that.year) return -1;
	if (this.year > that.year) return +1;
	return 0;
    }
    
    @Override
    public String toString()
    {
	return this.year + ", " + this.make + ", " + this.model + ", " + this.color;
	
    }
    
    private static class sortByMake implements Comparator<Cars>
    {

	@Override
	public int compare(Cars c1, Cars c2)
	{
	   return c1.getMake().compareTo(c2.getMake());
	}
	
    }
    
    

}
