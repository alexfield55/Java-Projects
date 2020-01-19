package rectangleSort;

import java.util.Comparator;

public class Rectangle implements Comparable<Rectangle>
{
    private int length;
    private int width;
    public static final Comparator<Rectangle> BY_AREA = new CompareByArea();

    public Rectangle(int leng, int widt)
    {
	this.length = leng;
	this.width = widt;
    }

    public int getLength()
    {
	return length;
    }

    public int getWidth()
    {
	return width;
    }

    public int perimeter()
    {
	return (width * 2) + (length*2);
    }

    public double diagonal()
    {
	return (Math.pow(width, 2) + Math.pow(length, 2));
    }

    public int area()
    {
	return length * width;
    }

    @Override
    public String toString()
    {
	return "[" + this.getLength()+ "X" + this.getWidth()+"] diagonal: " + (int)this.diagonal() + ", area : " + this.area();
    }

    public int compare(Rectangle a, Rectangle b)
    {
	return (int) (a.diagonal() - b.diagonal()) * -1;
    }

    @Override
    public int compareTo(Rectangle b)
    {
	return (int) (this.diagonal() - b.diagonal()) * -1;
    }
    
    private static class CompareByArea implements Comparator<Rectangle>
    {
	@Override
	public int compare(Rectangle a, Rectangle b)
	{
	    return a.area()-b.area();
	}
    }

}
