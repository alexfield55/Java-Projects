package labTimesTable;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LabTimesTable
{

    public static void main(String[] args)
    {

	String fileName = "src/labTimesTable/TimesTable.txt";

	try (PrintWriter writer = new PrintWriter(fileName))
	{
	    for (int i = 1; i <= 10; i += 2)
	    {
		for (int j = 1; j <= 10; j++)
		{
		    writer.format("%2d * %d = %d\t\t%2d * %d = %d\n", j, i, i * j, j, i + 1, (i + 1) * j);
		}
		writer.format("\n");
	    }
	} 
	catch (FileNotFoundException e)
	{

	    e.printStackTrace();
	}

    }

}
