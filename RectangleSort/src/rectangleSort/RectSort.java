package rectangleSort;

import edu.princeton.cs.algs4.Selection;

public class RectSort
{

    public static void main(String[] args)
    {
	Rectangle[] Rectangles = makeRecs();
	
	PrintRectArr(Rectangles, "Original");
	
	Selection.sort(Rectangles);
	
	System.out.println();
	
	PrintRectArr(Rectangles, "Selection Length");
	
	Rectangles = makeRecs();
	
	System.out.println();
	
	Selection.sort(Rectangles, Rectangle.BY_AREA);
	
	PrintRectArr(Rectangles, "Selection Area");
	
    }

    public static Rectangle[] makeRecs()
    {
	Rectangle[] Rectangles = new Rectangle[11];
	Rectangles[0] = new Rectangle(4, 2);
	Rectangles[1] = new Rectangle(3, 5);
	Rectangles[2] = new Rectangle(4, 3);
	Rectangles[3] = new Rectangle(6, 2);
	Rectangles[4] = new Rectangle(3, 4);
	Rectangles[5] = new Rectangle(4, 4);
	Rectangles[6] = new Rectangle(6, 2);
	Rectangles[7] = new Rectangle(12, 2);
	Rectangles[8] = new Rectangle(2, 4);
	Rectangles[9] = new Rectangle(4, 6);
	Rectangles[10] = new Rectangle(2, 12);
	return Rectangles;
    }
    
    public static void PrintRectArr(Rectangle[] rects, String type)
    {
	System.out.println("rectangles (" + type + ") : [");
	for(int i = 0; i<rects.length; i++)
	{
	    if(i != rects.length-1)
	    {
		System.out.println(rects[i].toString()+ ", ");
	    }
	    else
	    {
		System.out.print(rects[i].toString());
	    }
	}
	
	System.out.print("]\n");
    }
}
