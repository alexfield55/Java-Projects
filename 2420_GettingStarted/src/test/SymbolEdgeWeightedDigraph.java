package test;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class SymbolEdgeWeightedDigraph
{
    private EdgeWeightedDigraph G;
    ST<Integer, String> csvSTNames = new ST<Integer, String>();
    ST<String, Integer> csvST = new ST<String, Integer>();

    public void generateSymbolEdgeWeightedDigraph(String csv)
    {
	ST<String, Integer> csvST = new ST<String, Integer>();
	ST<Integer, String> csvSTNames = new ST<Integer, String>();

	In csvIn = new In(csv);

	int i = 0;

	StringBuilder sb = new StringBuilder();

	while (csvIn.hasNextLine())
	{

	    String strLine = csvIn.readLine();

	    String[] items = strLine.split(" ");

	    if (sb.indexOf(items[0]) == -1)
	    {
		csvST.put(items[0], i);
		csvSTNames.put(i, items[0]);
		i++;
	    }

	    if (sb.indexOf(items[1]) == -1)
	    {
		csvST.put(items[1], i);
		csvSTNames.put(i, items[1]);
		i++;
	    }

	    sb.append(items[0]);
	    sb.append(items[1]);

	}

	EdgeWeightedDigraph G = new EdgeWeightedDigraph(csvST.size());

	csvIn = new In(csv);

	while (csvIn.hasNextLine())
	{
	    String strLine = csvIn.readLine();

	    String[] items = strLine.split(" ");

	    DirectedEdge e = new DirectedEdge(csvST.get(items[0]), csvST.get(items[1]), Double.parseDouble(items[2]));

	    G.addEdge(e);

	}

	this.G = G;
	this.csvSTNames = csvSTNames;
	this.csvST=csvST;
    }

    public EdgeWeightedDigraph getEWD()
    {
	return this.G;
    }

    public ST<Integer, String> getCSVNAMES()
    {
	return this.csvSTNames;
    }

    public ST<String, Integer> getCSVST()
    {
	return this.csvST;
    }

    public static void main(String[] args)
    {
	SymbolEdgeWeightedDigraph test = new SymbolEdgeWeightedDigraph();
	test.generateSymbolEdgeWeightedDigraph(
		"C:\\Users\\alexf\\eclipse-workspace\\2420_GettingStarted\\src\\test\\airportsEWD.txt");

	System.out.println(test.getEWD().V());
	System.out.println(test.getEWD().E());

	for (DirectedEdge e : test.getEWD().edges())
	{
	    System.out.printf("%d %d %.0f\n", e.from(), e.to(), e.weight());
	}
	for (String s : test.getCSVST().keys())
	    StdOut.println(s + " " + test.getCSVST().get(s));
    }

}
