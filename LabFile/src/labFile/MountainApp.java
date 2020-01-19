package labFile;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MountainApp
{
    public static void main(String[] args)
    {
	List<Mountain> mountainList = new LinkedList<>();

	Mountain m = null;

	String line = "";

	try (Scanner reader = new Scanner(MountainApp.class.getResourceAsStream("Mountains.csv")))
	{
	    while (reader.hasNextLine())
	    {
		line = reader.nextLine();
		m = getMountain(line);
		if (m != null)
		    mountainList.add(m);

	    }
	}

	for (Mountain el : mountainList)
	{
	    System.out.println(el);
	}

    }

    private static Mountain getMountain(String line)
    {
	Mountain mount = null;
	try
	{
	    String[] items = line.split(",");

	    mount = new Mountain(items[0], Integer.parseInt(items[1]), Boolean.parseBoolean(items[2]));
	}

	catch (InputMismatchException | NumberFormatException | IndexOutOfBoundsException e)
	{
	    System.err.println("ERROR: \"" + line + "\" could not be turned into a Mountain.\n");
	   
	}

	return mount;
    }

}
