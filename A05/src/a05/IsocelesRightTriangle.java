package a05;

/**
 * Class to create an object of an Isoceles Right Triangle
 */
public class IsocelesRightTriangle implements Shape, Printable
{
    /**
     * field to store a leg length
     */
    private int leg = 0;
    
    /**
     * constructor to take in the length of one leg, which is the same 
     * as the other given a right isoceles triangle
     * @param l
     */
    IsocelesRightTriangle(int l)
    {
	leg = l;
    }

    /**
     * Method calling upon the Math class to return
     * hypotenuse of triangle
     * @return double
     */
    public double hypotenuse()
    {
	return Math.hypot(leg, leg);
    }

    /**
     * Getter to reveal value stored in leg field
     * @return int
     */
    public int getLeg()
    {
        return leg;
    }
    
    /**
     * Overridden toString method to output the values of the class formatted.
     */
    @Override
    public String toString()
    {
	return getClass().getSimpleName() + "(" + leg + ")";
    }

    /**
     * An overriden interface method providing a loop structure to 
     * print out to console a picture of the perimeter of a shape made of
     * characters.
     */
    @Override
    public void printable()
    {
	for (int i = 0; i < leg; i++)
	{
	    for (int k = 0; k < i+1; k++)
	    {
		if (k == 0 || k == i)
		    System.out.print("O ");
		else if (i == 0 || i == leg- 1)
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
	
	return leg + leg + Math.hypot(leg, leg);
    }

    /**
     * an overridden interface to calculate the area of an object
     */
    @Override
    public double area()
    {
	
	return (leg*leg)/2.0;
    }
    
    
}
