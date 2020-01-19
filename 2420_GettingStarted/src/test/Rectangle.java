package test;

import java.util.Comparator;

public class Rectangle implements Comparable<Rectangle>
{

    private int length;
    private int width;
    public static final Comparator<Rectangle> BY_AREA = new CompareByArea();

    public Rectangle(int l, int w)
    {
	this.length = l;
	this.width = w;
    }

    public int getLength()
    {
	return this.length;
    }

    public int getWidth()
    {
	return this.width;
    }

    public int perimeter()
    {
	return (getLength() * 2) + (getWidth() * 2);
    }

    public int area()
    {
	return getLength() * getWidth();
    }

    @Override
    public String toString()
    {
	return "[" + getLength() + "x" + getWidth() + "]";
    }

    @Override
    public int compareTo(Rectangle that)
    {
	return this.length-that.length;
    }
    
    public static class CompareByArea implements Comparator<Rectangle>
    {

	@Override
	public int compare(Rectangle r1, Rectangle r2)
	{
	    return r1.area()-r2.area();
	}
	
    }

}
