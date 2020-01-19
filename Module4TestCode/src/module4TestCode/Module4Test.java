package module4TestCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Module Test 4
 * A program to swap duck names around
 * @author alexf
 *
 */
public class Module4Test
{

    public static void main(String[] args)
    {
	ArrayList<String> famousDucks = new ArrayList<>();

	Collections.addAll(famousDucks, "Donald", "Daffy", "Huey", "Dewey", "Louie", "Daisy", "Darkwing", "The Mighty",
		"Dodgers", "Dastardly");

	System.out.println("Original List");
	System.out.println(printDucks(famousDucks));
	System.out.println();

	duckSort(famousDucks);
	System.out.println();

	System.out.println("Sorted List");
	System.out.println(printDucks(famousDucks));
	System.out.println();

	String[] duckArray = fillDuckArray(famousDucks);

	System.out.println("Ducks Swapped");
	duckSwap(duckArray, 0, 1);

    }

    /**
     * A method taking in a List of Strings and sorting them using the Collections method sort function
     * @param ducks
     */
    public static void duckSort(List<String> ducks)
    {
	Collections.sort(ducks);

	int i = 1;

	for (String el : ducks)
	{
	    System.out.printf("Duck #%d: %s%n", i, el.toString());
	    i++;
	}
    }

    /**
     * A method that takes in a List of Strings and stores them into an Array of String values and returns that Array
     * @param ducks
     * @return String[]
     */
    public static String[] fillDuckArray(List<String> ducks)
    {
	String[] ret = new String[ducks.size()];

	for (int i = 0; i < ret.length; i++)
	{
	    ret[i] = ducks.get(i);
	}

	return ret;
    }
    
    /**
     * A method that takes in a List of Strings and concatenates them together into one string with each value separated by a "-'
     * @param ducksToPrint
     * @return String
     */
    public static String printDucks(List<String> ducksToPrint)
    {
	String ret = "";

	boolean first = true;
	for (String el : ducksToPrint)
	{
	    if (first)
	    {
		ret = el;
		first = false;
	    } else
		ret += "-" + el;
	}
	return ret;
    }

    /**
     * A method taking an array of a Generic Type and swapping two positions in it, based on the parameters x and y
     * @param arr
     * @param x
     * @param y
     */
    public static <T> void duckSwap(T[] arr, int x, int y)
    {
	T temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;

	String ducks = "";

	boolean first = true;
	for (T el : arr)
	{
	    if (first)
	    {
		first = false;
		ducks = "" + el;
	    } else
		ducks += ", " + el;
	}

	System.out.println(ducks);
    }

}
