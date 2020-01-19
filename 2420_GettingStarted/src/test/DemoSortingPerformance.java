package test;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

public class DemoSortingPerformance
{
    public static void main(String[] args)
    {
	int arraySize = 500;
	
	System.out.println("Items in Array \tSelection Sort Time \tQuick Sort Time");
	
	for (int i = 0; i < 7; i++)
	{

	    Integer[] ra1 = getRandomNumberArray(arraySize, 100);
	    Integer[] ra2 = ra1.clone();

	    long startTime = System.nanoTime();
	    Selection.sort(ra1);
	    long endTime = System.nanoTime();
	    long sduration = (endTime - startTime);

	    startTime = System.nanoTime();
	    Quick.sort(ra2);
	    endTime = System.nanoTime();
	    long qduration = (endTime - startTime);

	    arraySize *= 2;
	    System.out.println(ra1.length + "\t\t" + sduration / 100000 + "\t\t\t" + qduration / 100000);
	}

    }

    private static Integer[] getRandomNumberArray(int arraySize, int numberOfDigits)
    {
	Integer[] RandomNumberArray = new Integer[arraySize];

	for (int i = 0; i < RandomNumberArray.length; i++)
	{
	    RandomNumberArray[i] = StdRandom.uniform(0, numberOfDigits);
	}

	return RandomNumberArray;

    }

}
