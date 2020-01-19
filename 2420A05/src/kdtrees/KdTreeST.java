package kdtrees;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTreeST<Value>
{
    private Node root;
    private int size;

    private class Node
    {
	private Point2D p; // the point
	private Value value; // the symbol table maps the point to this value
	private RectHV rect; // the axis-aligned rectangle corresponding to this node
	private Node lb; // the left/bottom subtree
	private Node rt; // the right/top subtree

	public Node(Point2D point, Value val)
	{
	    p = point;
	    value = val;
	}
    }

    // construct an empty symbol table of points
    public KdTreeST()
    {
	root = null; // no real need to initialize this but why not
	size = 0;
    }

    // is the symbol table empty?
    public boolean isEmpty()
    {
	return size() == 0;
    }

    // number of points
    public int size()
    {
	return size;
    }

    // associate the value val with point p
    public void put(Point2D p, Value val)
    {
	if (p == null || val == null)
	    throw new NullPointerException("Point and/or Value cannot be null");
	root = put(root, p, val, true);
    }

    /*
     * Based on algs4's put() methods
     */
    private Node put(Node n, Point2D p, Value v, boolean vh)
    {
	if (n == null)
	{ // if n is null then n is either root or an empty subtree, so it constructs new
	  // node
	    size++;
	    return new Node(p, v);
	}
	if (vh)
	{ // x-compares
	    if (p.x() < n.p.x())
	    { // go to left subtree, recurse
		n.lb = put(n.lb, p, v, false); // x-compares pass a false boolean so that next level of tree will be a
					       // y-compare
	    } else if (p.x() > n.p.x())
	    { // go to right subtree, recurse
		n.rt = put(n.rt, p, v, false);
	    } else if (p.y() != n.p.y())
	    { // xs are equal but ys are not, go right
		n.rt = put(n.rt, p, v, false);
	    } else
		n.value = v; // if x and y are equal, overwrite value
	} else
	{ // y-compares
	    if (p.y() < n.p.y())
	    { // go to left subtree, recurse
		n.lb = put(n.lb, p, v, true); // y-compares pass a true boolean so that next level of tree will be an
					      // x-compare
	    } else if (p.y() > n.p.y())
	    { // go to right subtree, recurse
		n.rt = put(n.rt, p, v, true);
	    } else if (p.x() != n.p.x())
	    { // ys are equal but xs are not, go right
		n.rt = put(n.rt, p, v, true);
	    } else
		n.value = v; // if x and y are equal, go left
	}
	return n;
    }

    // value associated with point p
    public Value get(Point2D p)
    {
	return get(root, p, true);
    }

    /*
     * Reverse engineered put() method, based on algs4 BST.class' get()
     */
    private Value get(Node n, Point2D p, boolean vh)
    {
	if (n == null)
	    return null;
	if (vh)
	{ // x-compares
	    if (p.x() < n.p.x())
		return get(n.lb, p, false);
	    else if (p.x() > n.p.x())
		return get(n.rt, p, false);
	    else if (p.y() != n.p.y())
		return get(n.rt, p, false);
	    else
		return n.value;
	} else
	{ // y-compares
	    if (p.y() < n.p.y())
		return get(n.lb, p, true);
	    else if (p.y() > n.p.y())
		return get(n.rt, p, true);
	    else if (p.x() != n.p.x())
		return get(n.rt, p, true);
	    else
		return n.value;
	}
    }

    // does the symbol table contain point p?
    public boolean contains(Point2D p)
    {
	if (p == null)
	    throw new NullPointerException();
	return false;
    }

    // all points in the symbol table
    public Iterable<Point2D> points()
    {
	return null;
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect)
    {
	if (rect == null)
	    throw new NullPointerException();
	return null;
    }

    // a nearest neighbor to point p; null if the symbol table is empty
    public Point2D nearest(Point2D p)
    {
	if (p == null)
	    throw new NullPointerException();
	return null;
    }

    public static void main(String[] args)
    {
	KdTreeST<String> testkd = new KdTreeST<String>();
	System.out.println("Constructing empty tree...");

	Point2D testpoint = new Point2D(0.1, 0.1);
	Point2D testpoint2 = new Point2D(0.2, 0.2);

	System.out.println("is Empty?: " + testkd.isEmpty());

	testkd.put(testpoint, "Apple");
	testkd.put(testpoint2, "Harold");

	System.out.println(testkd.get(testpoint));
	System.out.println(testkd.get(testpoint2));
	System.out.println("is Empty? (should be false): " + testkd.isEmpty());
	System.out.println("Size:" + testkd.size());
    }

}
