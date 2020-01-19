package test;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstPathModified
{

    private boolean[] marked; // marked[v] = is there an s-v path?
    private int[] edgeTo; // edgeTo[v] = last edge on s-v path
    private final int s; // source vertex

    /**
     * Computes a path between {@code s} and every other vertex in graph {@code G}.
     * 
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DepthFirstPathModified(Graph G, int s)
    {
	this.s = s;
	edgeTo = new int[G.V()];
	marked = new boolean[G.V()];
	validateVertex(s);
	dfs(G, s);
    }

    // depth first search from v
    private void dfs(Graph G, int v)
    {
	marked[v] = true;
	for (int w : G.adj(v))
	{
	    if (!marked[w])
	    {
		edgeTo[w] = v;
		dfs(G, w);
	    }
	}
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * 
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v)
    {
	validateVertex(v);
	return marked[v];
    }

    /**
     * Returns a path between the source vertex {@code s} and vertex {@code v}, or
     * {@code null} if no such path.
     * 
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         {@code s} and vertex {@code v}, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> pathTo(int v)
    {
	validateVertex(v);
	if (!hasPathTo(v))
	    return null;
	Stack<Integer> path = new Stack<Integer>();
	for (int x = v; x != s; x = edgeTo[x])
	    path.push(x);
	path.push(s);
	return path;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {
	int V = marked.length;
	if (v < 0 || v >= V)
	    throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    /**
     * Unit tests the {@code DepthFirstPaths} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)
    {
	In in = new In("C:\\Users\\alexf\\eclipse-workspace\\2420_GettingStarted\\src\\test\\GraphExercise06.txt");
	Graph G = new Graph(in);
	int s = 1;
	DepthFirstPathModified dfs = new DepthFirstPathModified(G, s);
	BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

	System.out.println("Adjacency List");

	StringBuilder sb = new StringBuilder();

	for (int v = 0; v < G.V(); v++)
	{
	    sb.append(v + ": ");

	    for (int w : G.adj(v))
	    {
		sb.append(w + " ");
	    }

	    sb.append("\n");

	}
	System.out.println(sb);

//	System.out.println("Marked \t EdgeTo");
//
//	for (int v = 0; v < G.V(); v++)
//	{
//	    if (dfs.hasPathTo(v))
//	    {
//		StdOut.printf("%b \t %d", dfs.hasPathTo(v), dfs.edgeTo[v]);
//		StdOut.println();
//	    }
//	}

	System.out.println();

	System.out.println("Paths DFS:");
	for (int v = 0; v < G.V(); v++)
	{
	    if (dfs.hasPathTo(v))
	    {
		StdOut.printf("%d to %d:  ", s, v);
		for (int x : dfs.pathTo(v))
		{
		    if (x == s)
			StdOut.print(x);
		    else
			StdOut.print("-" + x);
		}
		StdOut.println();
	    }

	    else
	    {
		StdOut.printf("%d to %d:  not connected\n", s, v);
	    }

	}
	
	System.out.println();

	System.out.println("Paths BFS");

	for (int v = 0; v < G.V(); v++)
	{
	    if (bfs.hasPathTo(v))
	    {
		StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
		for (int x : bfs.pathTo(v))
		{
		    if (x == s)
			StdOut.print(x);
		    else
			StdOut.print("-" + x);
		}
		StdOut.println();
	    }

	    else
	    {
		StdOut.printf("%d to %d (-):  not connected\n", s, v);
	    }
	}
    }

}
