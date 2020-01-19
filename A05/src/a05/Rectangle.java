package a05;

/**
 * Class to contain a rectangle object.
 * 
 * @author alexf
 *
 */

public class Rectangle implements Shape, Printable
{
    /**
     * length of rectangle sides
     */
    private int length = 0;
    /**
     * width of rectangle sides
     */
    private int width = 0;

    /**
     * Constructor to take in both a length and wides of sides of rectangle
     * 
     * @param l
     * @param w
     */
    Rectangle(int l, int w)
    {
	length = l;
	width = w;
    }

    /**
     * Getter to reveal the field length
     * 
     * @return int
     */
    public int getLength()
    {
	return length;
    }

    /**
     * Getter to reveal the field width
     * 
     * @return
     */
    public int getWidth()
    {
	return width;
    }

    /**
     * Overridden String method to return formated contents of the class
     */
    @Override
    public String toString()
    {
	return getClass().getSimpleName() + " (" + getLength() + "x" + getWidth() + ")";
    }

    /**
     * An overriden interface method providing a loop structure to 
     * print out to console a picture of the perimeter of a shape made of
     * characters.
     */
    @Override
    public void printable()
    {
	for (int i = 0; i < width; i++)
	{
	    for (int k = 0; k < length; k++)
	    {
		if (k == 0 || k == length - 1)
		    System.out.print("O ");
		else if (i == 0 || i == width - 1)
		    System.out.print("O ");
		else
		    System.out.print("  ");
	    }

	    System.out.println();
	}
    }
    
    /**
     * An overidden interface to calculate the perimeter of a shape object
     */
    @Override
    public double perimeter()
    {
	return (double) (2 * length + 2 * width);
    }

    /**
     * an overridden interface to calculate the area of an object
     */
    @Override
    public double area()
    {
	return (double) length * width;
    }
}
