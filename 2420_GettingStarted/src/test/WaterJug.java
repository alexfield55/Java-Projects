package test;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/*
 * Alex Field 
 * Final Code
 * CS2420
 * Write a program to solve the following problem: You have two jugs, 
 * a 4-gallon and a 3-gallon. Neither of the jugs has markings on them. 
 * There is a pump that can be used to fill the jugs with water. 
 * How can you get exactly two gallons of water in the 4 gallon jug?
 * 
 * Using an A* algorithm like the 8puzzle project, I created an Iterable
 * that takes the current state of the two jugs (x,y) and computes all their
 * next possible moves. My solver than puts these moves on a new queue, while
 * looping the jugs on that queue, I run my iterator on them, disregarding previous
 * states with a very simple previous type of node. So far it does not take the
 * best path the answer, but it does get there relatively simply. If you started with
 * different states, (4,0) instead of (0,3) it would get there one step faster, 
 * but my code currently doesn't adjust for fastest paths.
 * 
 * 
 */
public class WaterJug
{
    private int x = 4; // hard coded 4 gallon jug
    private int y = 3; // hard coded 3 gallon jug
    private int xFill; // amount in 4 gallon jug
    private int yFill; // amount in 3 gallon jug
    private int goal = 2; // used to find goal amount
    private WaterJug previous = null; // used so that the algorithm doesn't consider previous states

    /**
     * constructs water jug with two jug fill values
     * 
     * @param x
     * @param y
     */
    public WaterJug(int x, int y)
    {
	this.xFill = x;
	this.yFill = y;
    }

    /**
     * sets previous board node for comparisons
     * 
     * @param that
     */
    public void setPrevious(WaterJug that)
    {
	this.previous = that;
    }

    /**
     * returns previous board
     * 
     * @return
     */
    public WaterJug getPrevious()
    {
	return previous;
    }

    @Override
    public String toString()
    {
	return xFill + "," + yFill;
    }

    /**
     * iterates possible outcomes of moves from jug states and returns them as a
     * stack
     * 
     * @return
     */
    public Iterable<WaterJug> moves()
    {
	Stack<WaterJug> jugs = new Stack<>();
	int xtemp = this.xFill;
	int ytemp = this.yFill;

	if (yFill == 0 && xFill == 0)
	{
	    jugs.push(new WaterJug(x, 0));
	    jugs.push(new WaterJug(0, y));
	}

	if (ytemp > 0 && xtemp != x)
	    jugs.push(new WaterJug(x, ytemp)); // fill 4g jug leave 3g jug as is

	if (xtemp > 0 && ytemp != y)
	    jugs.push(new WaterJug(xtemp, y)); // fill 3g jug, leave 4g jug as is

	if ((ytemp - (x - xtemp)) > 0)
	    jugs.push(new WaterJug(x, (ytemp - (x - xtemp)))); // 3g jug fills 4g jug

	if ((xtemp - (y - ytemp)) > 0)
	    jugs.push(new WaterJug(xtemp - (y - ytemp), y)); // 4g jug fills 3g jug

	if (ytemp == y && ytemp != 0)
	    jugs.push(new WaterJug(xtemp, 0)); // leaves 4 gal, emptys 3

	if (xtemp == x && xtemp != 0)
	    jugs.push(new WaterJug(0, ytemp)); // leave 3 gal emptys 4

	if ((ytemp + xtemp) <= x && ytemp > 0)
	    jugs.push(new WaterJug(ytemp + xtemp, 0)); // all of 3g jug to 4g jug

	if ((ytemp + xtemp) <= y && xtemp > 0)
	    jugs.push(new WaterJug(0, xtemp + ytemp)); // all of 4g jug in 3g jug

	return jugs;
    }

    public static void main(String[] args)
    {
	WaterJug jug = new WaterJug(0, 0); // creates empty jugs

	Queue<WaterJug> jugs = new Queue<>(); // creates queue of jugs

	jugs.enqueue(jug); // puts jug on queue

	WaterJug tempjug = jug; // stores temp as first jug state

	do
	{
	    if (tempjug.getPrevious() != jugs.peek()) // checks to make sure the previous jug is not the same as the one
						      // that will come off next
	    {
		tempjug = jugs.dequeue();

		for (WaterJug el : tempjug.moves())
		{
		    if (el.getPrevious() != el)
		    {
			el.previous = tempjug;
			jugs.enqueue(el);

		    }
		}
	    }

	} while (tempjug.xFill != tempjug.goal && !jugs.isEmpty());

	System.out.println("Left number is 4 gallon jug state, \n"
		+ "right number is 3 gallon jug state");
	System.out.println("Goal state is 2 gallons in 4 gallon jug");
	System.out.println("Goal reached: ");
	System.out.println(tempjug);

	WaterJug temp = tempjug.getPrevious();

	System.out.println("Moves from goal to start:");
	while (temp.getPrevious() != null)
	{
	    System.out.println(temp);
	    temp = temp.getPrevious();
	}

	System.out.println("Starting condition");
	System.out.println(jug);

    }
}
