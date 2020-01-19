/*
 * Alex Field
 * 
 * 1410
 * Assignment A05 Inheritance
 * 
 */

package a05;

import java.util.ArrayList;

public class InheritanceApp
{

    public static void main(String[] args)
    {

	System.out.println("Shape Array: ");
	System.out.println("- - - - - - -");
	System.out.println();

	ArrayList<Shape> shapes = new ArrayList<>();

	shapes.add(new Rectangle(6, 3));
	shapes.add(new Rectangle(5, 4));
	
	shapes.add(new Square(4));
	shapes.add(new Square(3));

	shapes.add(new IsocelesRightTriangle(5));
	shapes.add(new IsocelesRightTriangle(3));
	
	shapes.add(new Circle(7));
	shapes.add(new Circle(2));

	for (Shape el : shapes)
	{
	    System.out.println(el.toString());
	    System.out.printf("%s: %.1f%n", el.getClass().getSimpleName(), el.perimeter()); //formatted output for the perimeter of object
	    System.out.printf("%s: %.1f%n", el.getClass().getSimpleName(), el.area()); //formatted output for the area of object
	    if(el instanceof Rectangle) // using instanceof operation to check for rectangle type, inheriting square type too
		((Rectangle) el).printable(); 
	    if(el instanceof IsocelesRightTriangle) //using instance of to access triangle type
		((IsocelesRightTriangle) el).printable();
	    System.out.println();
	}
	
	

    }

}
