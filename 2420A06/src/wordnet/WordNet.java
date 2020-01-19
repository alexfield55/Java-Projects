package wordnet;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class WordNet
{
    /**
     * synsetInt is a symbol table storing String keys and Bag<Integer> values.
     * Because words can be associated with different values, we use a Bag structure
     * to hold any integers associated with each String.
     */
    private final ST<String, Bag<Integer>> synsetInt; // ST with String key and Integer value
    Bag<Integer> bag = new Bag<Integer>();
    /**
     * synsetWord is a symbol table storing Integer keys and String values. get
     * method takes an Integer and returns a String.
     */
    private final ST<Integer, String> synsetWord; // ST with Integer key and String value
    private final Digraph hypernymsDG; // digraph of hypernyms
    private final SAP sap; // SAP object initialized with Digraph of hypernyms in constructor

    /**
     * 
     * @param synsets
     * @param hypernyms
     */
    public WordNet(String synsets, String hypernyms)
    { // constructor takes the name of the two input files
	if (synsets == null || hypernyms == null)
	    throw new NullPointerException("Filenames cannot be null");
	synsetInt = new ST<String, Bag<Integer>>();
	synsetWord = new ST<Integer, String>();

	In synsetsIn = new In(synsets); // read in synset file
	while (synsetsIn.hasNextLine())
	{
	    String strLine = synsetsIn.readLine();

	    String[] items = strLine.split(","); // comma separated values

	    // synsetInt.put(items[1],Integer.parseInt(items[0])); // store word as key and
	    // int as value
	    synsetWord.put(Integer.parseInt(items[0]), items[1]); // store int as key and word as value

	    // foreach takes each word and either initializes a bag or adds corresponding
	    // int to bag
	    for (String word : items[1].split(" "))
	    {
		bag = synsetInt.get(word);

		if (bag == null)
		{
		    bag = new Bag<Integer>();
		    bag.add(Integer.parseInt(items[0]));
		    synsetInt.put(word, bag);
		} else
		{
		    bag.add(Integer.parseInt(items[0]));
		}
	    }

	}

	hypernymsDG = new Digraph(synsetWord.size()); // construct digraph using number of items in synset as size

	In hypernymsIn = new In(hypernyms); // read in hypernyms file

	while (hypernymsIn.hasNextLine())
	{
	    String strLine = hypernymsIn.readLine();

	    String[] items = strLine.split(","); // hypernyms file split by spaces

	    if (items.length > 1)
	    {
		for (int i = 1; i < items.length; i++)
		{
		    hypernymsDG.addEdge(Integer.parseInt(items[0]), Integer.parseInt(items[i]));
		}
	    }
	    // else hypernymsDG.addEdge(Integer.parseInt(items[0]), 0);
	}

	sap = new SAP(hypernymsDG);

	if (!sap.isRootedDAG())
	    throw new IllegalArgumentException("Hypernyms file must be rooted DAG");
    }

    // returns all WordNet nouns
    public Iterable<String> nouns()
    {
	return synsetInt.keys();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word)
    {
	if (word == null)
	    throw new NullPointerException();
	return synsetInt.contains(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB)
    {
	if (nounA == null || nounB == null)
	    throw new NullPointerException("Null argument");
	if (!isNoun(nounA) || !isNoun(nounB))
	    throw new IllegalArgumentException("Not a WordNet noun");

	// take the Strings in, put them in ST, return ints, put those ints in new SAP,
	// call SAP.distance, return that value
	int distance = -1;
	if (isNoun(nounA) && isNoun(nounB))
	    distance = sap.length(synsetInt.get(nounA), synsetInt.get(nounB));
	return distance;
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA
    // and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB)
    {
	if (nounA == null || nounB == null)
	    throw new NullPointerException("Null argument");
	if (!isNoun(nounA) || !isNoun(nounB))
	    throw new IllegalArgumentException("Not a WordNet noun");

	int ancestor = -1;

	if (isNoun(nounA) && isNoun(nounB))
	{
	    ancestor = sap.ancestor(synsetInt.get(nounA), synsetInt.get(nounB));
	    return synsetWord.get(ancestor);
	} else
	    return "One or both words is not in WordNet";
    }

    // do unit testing of this class
    public static void main(String[] args)
    {
	WordNet wordnet = new WordNet("C:\\Users\\ariel\\eclipse-workspace\\WordNet\\src\\wordnet\\synsets.txt",
		"C:\\Users\\ariel\\eclipse-workspace\\WordNet\\src\\wordnet\\hypernyms.txt");

	System.out.println(wordnet.hypernymsDG.V());
	System.out.println(wordnet.hypernymsDG.E());

	System.out.println(wordnet.sap("soda", "water"));

    }
}
