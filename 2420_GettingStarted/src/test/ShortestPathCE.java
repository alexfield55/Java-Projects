package test;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.StdOut;

public class ShortestPathCE
{

    public static void main(String[] args)
    {
	String start = "start";
	String end = "end";

	SymbolEdgeWeightedDigraph G = new SymbolEdgeWeightedDigraph();
	G.generateSymbolEdgeWeightedDigraph(
		"C:\\Users\\alexf\\eclipse-workspace\\2420_GettingStarted\\src\\test\\airportsEWD.txt");

	DijkstraSP sp = new DijkstraSP(G.getEWD(), G.getCSVST().get(start));

	System.out.printf("Shortest path %s to %s: %.0f\n\n", start, end, sp.distTo(G.getCSVST().get(end)));

	System.out.printf("Path %s to %s:\n", start, end);
	for (DirectedEdge e : sp.pathTo(G.getCSVST().get(end)))
	{
	    System.out.printf("%s -> %s: %.0f\n", G.getCSVNAMES().get(e.from()), G.getCSVNAMES().get(e.to()), e.weight());
	}

	System.out.println("\nST: ");
	for (String s : G.getCSVST().keys())
	    StdOut.println(s + " " + G.getCSVST().get(s));
    }

}
