package test;

import javax.swing.JFrame;

import edu.princeton.cs.algs4.StdDraw;

public class draw
{

    public static void main(String[] args)
    {		
	draw(.5, .5, .5, 7);
    }

    public static void draw(double x, double y, double size, int times)
    {
	if (times>0)
	{
	double x0 = x - size / 2;
	double x1 = x + size / 2;
	double y0 = y - size / 2;
	double y1 = y + size / 2;

	StdDraw.line(x0, y0, x0, y1); // p1 to p2
	StdDraw.line(x1, y0, x1, y1); // p3 to p4
	StdDraw.line(x0, y, x1, y); // p5 to p6
	// StdDraw.line(0.5, 0, 0.5, 1);
	
	draw(x0, y0, size/2, times - 1);
	draw(x0, y1, size/2, times - 1);
	draw(x1, y0, size/2, times - 1);
	draw(x1, y1, size/2, times - 1);
	}
	
    }

}