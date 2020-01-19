package a04;

/**
 * Class to create an object of an Isoceles Right Triangle
 */
public class IsocelesRightTriangle
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
    
    
}
