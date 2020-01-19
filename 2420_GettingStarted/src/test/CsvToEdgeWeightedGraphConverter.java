package test;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class CsvToEdgeWeightedGraphConverter
{
    public ST<String, Integer> generateEdgeWeightedGraph(String csv, String output)
    {
	ST<String, Integer> csvST = new ST<String, Integer>();

	In csvIn = new In(csv);
	Out out = new Out(output);

	int i = 0;

	StringBuilder sb = new StringBuilder();

	while (csvIn.hasNextLine())
	{
	    String strLine = csvIn.readLine();

	    String[] items = strLine.split(",");

	    if (sb.indexOf(items[0]) == -1)
	    {
		csvST.put(items[0], i);
		i++;
	    }

	    if (sb.indexOf(items[1]) == -1)
	    {
		csvST.put(items[1], i);
		i++;
	    }

	    sb.append(items[0]);
	    sb.append(items[1]);

	}

	EdgeWeightedGraph G = new EdgeWeightedGraph(csvST.size());

	csvIn = new In(csv);
	while (csvIn.hasNextLine())
	{
	    String strLine = csvIn.readLine();

	    String[] items = strLine.split(",");

	    Edge e = new Edge(csvST.get(items[0]), csvST.get(items[1]), Double.parseDouble(items[2]));

	    G.addEdge(e);

	}

	out.println(G.V());
	out.println(G.E());

	for (Edge e : G.edges())
	{
	    int v = e.either();
	    out.printf("%d %d %.0f\n", e.either(), e.other(v), e.weight());
	}

	return csvST;
    }

    public static void main(String[] args)
    {
	CsvToEdgeWeightedGraphConverter test = new CsvToEdgeWeightedGraphConverter();
	ST<String, Integer> csvST = new ST<String, Integer>();
	csvST = test.generateEdgeWeightedGraph("C:\\Users\\alexf\\eclipse-workspace\\2420_GettingStarted\\src\\test\\CityConnections.csv",
		"C:\\Users\\alexf\\eclipse-workspace\\2420_GettingStarted\\src\\test\\citiesEWG.txt");
		
	for (String s : csvST.keys())
	    StdOut.println(s + " " + csvST.get(s));
    }

}
