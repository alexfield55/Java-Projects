package wordnet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast
{
    WordNet wordnet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet)
    {
	this.wordnet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns)
    {
	int currdist = -1;
	int maxdist = -1;
	String outcast = "";
	for (String s : nouns)
	{
	    for (int i = 0; i < nouns.length - 1; i++)
	    {
		currdist = wordnet.distance(s, nouns[i]);
		if (currdist > maxdist)
		{
		    maxdist = currdist;
		    outcast = nouns[i];
		}
	    }
	}
	return outcast;
    }

    // see test client below
    public static void main(String[] args)
    {
	WordNet wordnet = new WordNet("C:\\Users\\ariel\\eclipse-workspace\\WordNet\\src\\wordnet\\synsets.txt",
		"C:\\Users\\ariel\\eclipse-workspace\\WordNet\\src\\wordnet\\hypernyms.txt");
	Outcast outcast = new Outcast(wordnet);

	In in = new In("C:\\Users\\ariel\\eclipse-workspace\\WordNet\\src\\wordnet\\outcast8.txt");
	String[] nouns = in.readAllStrings();

	StdOut.println("Output 8: " + outcast.outcast(nouns));

    }
}