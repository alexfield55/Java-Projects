package test;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFS
{
    private boolean[] marked; // marked[v] = true if v is reachable
			      // from source (or sources)
    private int count; // number of vertices reachable from s

    /**
     * Computes the vertices in digraph {@code G} that are reachable from the source
     * vertex {@code s}.
     * 
     * @param G the digraph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DirectedDFS(Digraph G, int s)
    {
	marked = new boolean[G.V()];
	validateVertex(s);
	dfs(G, s);
    }

    /**
     * Computes the vertices in digraph {@code G} that are connected to any of the
     * source vertices {@code sources}.
     * 
     * @param G       the graph
     * @param sources the source vertices
     * @throws IllegalArgumentException unless {@code 0 <= s < V} for each vertex
     *                                  {@code s} in {@code sources}
     */
    public DirectedDFS(Digraph G, Iterable<Integer> sources)
    {
	marked = new boolean[G.V()];
	validateVertices(sources);
	for (int v : sources)
	{
	    if (!marked[v])
		dfs(G, v);
	}
    }

    private void dfs(Digraph G, int v)
    {
	count++;
	marked[v] = true;
	for (int w : G.adj(v))
	{
	    if (!marked[w])
		dfs(G, w);
	}
    }

    /**
     * Is there a directed path from the source vertex (or any of the source
     * vertices) and vertex {@code v}?
     * 
     * @param v the vertex
     * @return {@code true} if there is a directed path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean marked(int v)
    {
	validateVertex(v);
	return marked[v];
    }

    /**
     * Returns the number of vertices reachable from the source vertex (or source
     * vertices).
     * 
     * @return the number of vertices reachable from the source vertex (or source
     *         vertices)
     */
    public int count()
    {
	return count;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {
	int V = marked.length;
	if (v < 0 || v >= V)
	    throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertices(Iterable<Integer> vertices)
    {
	if (vertices == null)
	{
	    throw new IllegalArgumentException("argument is null");
	}
	int V = marked.length;
	for (int v : vertices)
	{
	    if (v < 0 || v >= V)
	    {
		throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	    }
	}
    }

    /**
     * Unit tests the {@code DirectedDFS} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)
    {

	String filename = "C:\\Users\\alexf\\eclipse-workspace\\2420_GettingStarted\\src\\test\\tinyDG.txt";
	int[] sourceArray =
	{ 2 };

	In in = new In(filename);
	Digraph G = new Digraph(in);

	Bag<Integer> sources = new Bag<Integer>();
	for (int i = 1; i < args.length; i++)
	{
	    int s = sourceArray[0];
	    sources.add(s);
	}

	int s = sourceArray[0];

	// multiple-source reachability
	DirectedDFS dfs = new DirectedDFS(G, 2);
	/*
	 * System.out.println("Paths DFS:"); for (int v = 0; v < G.V(); v++) { if
	 * (dfs.marked(v)) { StdOut.printf("%d to %d:  ", s, v); for (int x : sources) {
	 * if (x == s) StdOut.print(x); else StdOut.print("->" + x); } StdOut.println();
	 * }
	 * 
	 * else { StdOut.printf("%d to %d:  not connected\n", s, v); } }
	 */

	StringBuilder sb = new StringBuilder();
	System.out.println("Adjacency List:");
	sb.append(G.V() + " vertices, " + G.E() + " edges \n");
	for (int v = 0; v < G.V(); v++)
	{
	    sb.append(String.format("%d: ", v));
	    for (int w : G.adj(v))
	    {
		sb.append(String.format("%d ", w));
	    }
	    sb.append("\n");
	}
	System.out.println(sb);
	
	System.out.println("DirectedDFS using Diraph and tinyDG.txt. Sources: 2");
	// print out vertices reachable from sources
	for (int v = 0; v < G.V(); v++)
	{
	    if (dfs.marked(v))
		StdOut.print(v + " ");

	}
	StdOut.println();
    }

}