/*
 * Alex Field
 * 1410
 * Assignment A04
 * 
 */

package a04;

import java.util.ArrayList;

public class InheritanceApp
{

    public static void main(String[] args)
    {
	Rectangle myRectangle = new Rectangle(5, 4);
	Square mySquare = new Square(4);
	IsocelesRightTriangle myIsocelesRightTriangle = new IsocelesRightTriangle(5);
	Circle myCircle = new Circle(4);

	System.out.println(myRectangle.toString());
	System.out.println("Length: " + myRectangle.getLength());
	System.out.println("Width: " + myRectangle.getWidth());
	System.out.println();

	System.out.println(mySquare.toString());
	System.out.println("Side: " + myRectangle.getLength());
	System.out.println();

	System.out.println(myIsocelesRightTriangle.toString());
	System.out.println("Leg: " + myIsocelesRightTriangle.getLeg());
	System.out.printf("Hypo: %.1f%n", myIsocelesRightTriangle.hypotenuse());
	System.out.println();

	System.out.println(myCircle.toString());
	System.out.println("Diameter: " + myCircle.diameter());
	System.out.printf("Circumference: %.1f%n", myCircle.circumference());
	System.out.println("Radius: " + myCircle.getRadius());
	System.out.println();

	Rectangle rectangle2 = mySquare;

	System.out.println("rectangle2");
	System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
	System.out.println();
	

	System.out.println(rectangle2.toString());
	System.out.println("Length: " + rectangle2.getLength());
	System.out.println("Width: " + rectangle2.getWidth());
	System.out.println();

	
	
	System.out.println("Rectangle Array");
	System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
	System.out.println();
	
	
	ArrayList<Rectangle> rectangles = new ArrayList<>();

	rectangles.add(mySquare);
	rectangles.add(rectangle2);
	rectangles.add(myRectangle);
	
	for (Rectangle el : rectangles)
	{
	    System.out.println(el.toString());
	    System.out.println("Length: " + el.getLength());
	    System.out.println("Width: " + el.getWidth());
	    System.out.println();
	}
    }

}
