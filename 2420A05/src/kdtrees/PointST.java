package kdtrees;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;

public class PointST<Value>
{
    RedBlackBST<Point2D, Value> redblack;

    // construct an empty symbol table of points
    public PointST()
    {
	redblack = new RedBlackBST<Point2D, Value>();
    }

    // is the symbol table empty?
    public boolean isEmpty()
    {
	return redblack.isEmpty();
    }

    // number of points
    public int size()
    {
	return redblack.size();
    }

    // associate the value val with point p
    public void put(Point2D p, Value val)
    {
	if (p == null || val == null)
	{
	    throw new NullPointerException();
	}
	redblack.put(p, val);
    }

    // value associated with point p
    public Value get(Point2D p)
    {
	if (p == null)
	{
	    throw new NullPointerException();
	}
	return redblack.get(p);
    }

    // does the symbol table contain point p?
    public boolean contains(Point2D p)
    {
	if (p == null)
	{
	    throw new NullPointerException();
	}
	return redblack.contains(p);
    }

    // all points in the symbol table
    public Iterable<Point2D> points()
    {
	return redblack.keys();
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect)
    {
	if (rect == null)
	{
	    throw new NullPointerException();
	}
	Queue<Point2D> pointQ = new Queue<Point2D>();

	for (Point2D p : points())
	{
	    if (rect.contains(p))
	    {
		pointQ.enqueue(p);
	    }
	}
	return pointQ;
    }

    // a nearest neighbor to point p; null if the symbol table is empty
    public Point2D nearest(Point2D p)
    {
	if (p == null)
	{
	    throw new NullPointerException();
	}
	if (redblack.isEmpty())
	    return null;

	Point2D nearest = null;
	double distance;
	double neighbor = Double.MAX_VALUE;

	for (Point2D point : points())
	{
	    distance = point.distanceSquaredTo(p);
	    if (distance < neighbor)
	    {
		neighbor = distance;
		nearest = point;
	    }
	}
	return nearest;
    }

    public static void main(String[] args)
    {

    }

}
