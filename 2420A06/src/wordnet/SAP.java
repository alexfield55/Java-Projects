package wordnet;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

public class SAP
{
    private Digraph g;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G)
    {
	this.g = G;
    }

    // is the digraph a directed acyclic graph?
    public boolean isDAG()
    {	
	Topological test = new Topological(g); //put graph into topographical class
	return test.hasOrder(); //method that returns whether a digraph cylces
    }

    // is the digraph a rooted DAG?
    public boolean isRootedDAG()
    {

	for (int i = 0; i < g.V(); i++) // loop each vertex of digraph
	{
	    if(g.indegree(i)==0)
	    {
		return true;
	    }
	}
	
	return false;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w)
    {
	int path = -1; // set as -1 just in case there is no path
	int minlength = 1000; // set as high number to keep checking against to find lower number

	BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(g, v); // create bfs of digraph with v
	BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(g, w); // create bfs of disgraph with w

	for (int i = 0; i < g.V(); i++) // loop each vertex of digraph
	{
	    if (vPath.hasPathTo(i) && wPath.hasPathTo(i)) // check if each vertex of digraph has a path to either v or w
	    {
		int length = vPath.distTo(i) + wPath.distTo(i); // if true take the distance from v to vertex(i) and w
								// to vertex(i) and add them together to get length
								// between them

		if (length < minlength) // if it finds a smaller length, update minlength
		{
		    minlength = length;
		}

		path = minlength;

	    }
	}

	return path;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path;
    // -1 if no such path
    public int ancestor(int v, int w)
    {
	int ancestor = -1;
	int minlength = Integer.MAX_VALUE;

	BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(g, v); // create bfs of digraph with v
	BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(g, w); // create bfs of disgraph with w

	for (int i = 0; i < g.V(); i++) // loop each vertex of digraph
	{
	    if (vPath.hasPathTo(i) && wPath.hasPathTo(i)) // check if each vertex of digraph has a path to either v or w
	    {
		int length = vPath.distTo(i) + wPath.distTo(i); // if true take the distance from v to vertex(i) and w
								// to vertex(i) and add them together to get length
								// between them

		if (length < minlength) // if it finds a smaller length, update minlength
		{
		    minlength = length;
		    ancestor = i; // updates ancestor at position where minlength was found
		}

	    }
	}

	return ancestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in
    // w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w)
    {
	int path = -1; // set as -1 just in case there is no path
	int minlength = 1000; // set as high number to keep checking against to find lower number

	BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(g, v); // create bfs of digraph with v
	BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(g, w); // create bfs of disgraph with w

	for (int i = 0; i < g.V(); i++) // loop each vertex of digraph
	{
	    if (vPath.hasPathTo(i) && wPath.hasPathTo(i)) // check if each vertex of digraph has a path to either v or w
	    {
		int length = vPath.distTo(i) + wPath.distTo(i); // if true take the distance from v to vertex(i) and w
								// to vertex(i) and add them together to get length
								// between them

		if (length < minlength) // if it finds a smaller length, update minlength
		{
		    minlength = length;
		}

		path = minlength;

	    }
	}

	return path;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such
    // path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w)
    {
	int ancestor = -1;
	int minlength = 1000;

	BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(g, v); // create bfs of digraph with v
	BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(g, w); // create bfs of disgraph with w

	for (int i = 0; i < g.V(); i++) // loop each vertex of digraph
	{
	    if (vPath.hasPathTo(i) && wPath.hasPathTo(i)) // check if each vertex of digraph has a path to either v or w
	    {
		int length = vPath.distTo(i) + wPath.distTo(i); // if true take the distance from v to vertex(i) and w
								// to vertex(i) and add them together to get length
								// between them

		if (length < minlength) // if it finds a smaller length, update minlength
		{
		    minlength = length;
		    ancestor = i; // updates ancestor at position where minlength was found
		}

	    }
	}

	return ancestor;
    }

    // do unit testing of this class
    public static void main(String[] args)
    {
	In in = new In("C:\\Users\\alexf\\eclipse-workspace\\2420A06\\src\\wordnet\\digraph1.txt");
	Digraph G = new Digraph(in);
	SAP sap = new SAP(G);

	int v = 3;
	int w = 11;
	int length = sap.length(v, w);
	int ancestor = sap.ancestor(v, w);
	StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);

	v = 9;
	w = 12;
	length = sap.length(v, w);
	ancestor = sap.ancestor(v, w);
	StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);

	v = 7;
	w = 2;
	length = sap.length(v, w);
	ancestor = sap.ancestor(v, w);
	StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);

	v = 1;
	w = 6;
	length = sap.length(v, w);
	ancestor = sap.ancestor(v, w);
	StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
    }
}
