package test;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.StdOut;

public class KruskalsDorm
{
    public static void main(String[] args)
    {

	In in = new In("C:\\Users\\alexf\\eclipse-workspace\\2420_GettingStarted\\src\\test\\GraphDorm.txt");
	EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	KruskalMST mst = new KruskalMST(G);

	StdOut.print("Doorms that need to be connected: ");
	for (Edge e : mst.edges())
	{
	    int v = e.either();
	    if (!(v == 2 || e.other(v) == 2))
		StdOut.print(v + "-" + e.other(v) + " ");

	}

	System.out.println();

	StdOut.print("Doorms that need router: ");
	for (Edge e : mst.edges())
	{
	    int v = e.either();
	    if ((v == 2 || e.other(v) == 2))
		if (v == 2)
		    StdOut.print(e.other(v) + " ");
		else
		    StdOut.print(e.either() + " ");
	}

	System.out.println();

	StdOut.printf("Total cost: $%.2f\n", mst.weight());

    }
}
