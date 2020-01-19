package a05;

/**
 * Subclass of Rectangle
 * Designed to created a square object
 * @author alexf
 *
 */
public class Square extends Rectangle
{
    /**
     * Constructor taking in one side parameter, and then 
     * calling superclass constructor and using the parameter twice for both 
     * length and width as called for in superclass constructor
     * @param s
     */
    Square(int s)
    {
	super(s,s);
    }
    
    /**
     * Getter to reveal length of side by accessing super class method for
     * getting a side
     * @return
     */
    public int getSide()
    {
	return super.getLength();
    }
    
    /**
     * Overridden toString method with formatted contents of class
     */
    @Override
    public String toString()
    {
	return getClass().getSimpleName() + " (" + super.getLength() + ")";
    }
    
}
