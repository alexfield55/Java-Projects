package a05;

/**
 * Class to created an object of a Circle
 * 
 * @author alexf
 *
 */
public class Circle implements Shape
{
    /**
     * field to store the circles radius
     */
    private int radius = 0;

    /**
     * constructor that takes in radius of circle as parameter
     * 
     * @param r
     */
    Circle(int r)
    {
	radius = r;
    }

    /**
     * Method designed to calculated the diameter of the Circle
     * 
     * @return int
     */
    public int diameter()
    {
	return 2 * radius;
    }

    /**
     * Method designed to return the cicumference of the Circle
     * 
     * @return double
     */
    public double circumference()
    {
	return 2 * Math.PI * radius;
    }

    /**
     * Getter designed to reveal the value stored in radius
     * 
     * @return
     */
    public int getRadius()
    {
	return radius;
    }

    /**
     * Overridden toString method to output the values of the class formatted.
     */
    @Override
    public String toString()
    {
	return getClass().getSimpleName() + " (" + getRadius() + ")";
    }

    @Override
    public double perimeter()
    {
	return circumference();
    }

    @Override
    public double area()
    {
	return Math.PI * Math.pow(radius, 2);
    }
}
