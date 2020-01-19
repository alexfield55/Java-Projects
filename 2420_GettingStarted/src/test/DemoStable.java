package test;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Selection;

public class DemoStable
{

    public static void main(String[] args)
    {
	Rectangle[] rectangles = new Rectangle[]
	{ new Rectangle(4, 2), new Rectangle(3, 5), new Rectangle(4, 3), new Rectangle(6, 2), new Rectangle(3, 4),
		new Rectangle(4, 4), new Rectangle(6, 4), new Rectangle(12, 2), new Rectangle(2, 4),
		new Rectangle(4, 6), new Rectangle(2, 12) };
	
	print(rectangles, "rectangles");
	
	Selection.sort(rectangles, Rectangle.BY_AREA);
	
	print(rectangles, "sorted area");
	
	Merge.sort(rectangles);
	
	print(rectangles, "sorted length");
	
	

    }

    public static void print(Rectangle[] rectangles, String s)
    {

	for (int i = 0; i < rectangles.length; i++)
	{
	    if (i == 0)
	    {
		System.out.print(s+"\t: [" + rectangles[0]);
	    } else if (i > 0 && i < rectangles.length - 1)
	    {
		System.out.print(", " + rectangles[i]);
	    } else if (i < rectangles.length)
		System.out.print(", " + rectangles[i] + "]\n");
	}
    }

}
