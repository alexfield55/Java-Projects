package a04;

/**
 * Class to contain a rectangle object.
 * @author alexf
 *
 */

public class Rectangle
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
     * @param l
     * @param w
     */
    Rectangle (int l, int w)
    {
	length = l;
	width = w;
    }
    
    /**
     * Getter to reveal the field length
     * @return int
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Getter to reveal the field width
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
}
