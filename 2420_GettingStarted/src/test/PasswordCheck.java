package test;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.princeton.cs.algs4.ST;

public class PasswordCheck
{

    public static void main(String[] args)
    {
	
	ST<Integer, String> names = new ST<Integer, String>();
	NameHash hashme = new NameHash();
	String file = "passcheck.txt";
	
	names = getList(file);//static method for reading in
	
	
	// this is where you read in the file and create the hash and add it with the
	// string, should be (Name hash, Password)
	

	
	Scanner input = new Scanner(System.in);
	
	System.out.print("Please enter the Username:");
	
	int passLoc = hashme.hash(input.nextLine());

	System.out.print("Please enter the Password:");
	String EntPass = input.nextLine();

	if (EntPass.equals(names.get(passLoc)))
	{
	    System.out.print("Welcome!!!!");
	} else
	{
	    System.out.print("Your password and username do not match!" + names.get(passLoc));
	}
    }
    
    //static method for reading in files and creating a symbols table
    public static ST<Integer, String> getList(String file)
    {
	ST<Integer, String> names = new ST<Integer, String>();
	NameHash hashme = new NameHash();

	String line = "";

	int count = 0;

	try (Scanner reader = new Scanner(PasswordCheck.class.getResourceAsStream(file)))
	{
	    while (reader.hasNextLine())

	    {

		line = reader.nextLine();

		try
		{
		    String[] items = line.split(",");
		    names.put(hashme.hash(items[0]), items[1]);
		    count++;
		
		} catch (InputMismatchException | NumberFormatException | IndexOutOfBoundsException e)
		{
		    System.err.println("Problem reading in \"" + line + "\"");

		}
	    }
	} catch (NullPointerException e)
	{
	    System.err.println("File not found/ Unreadable");
	}

	System.out.println("Number of names hashed in: " + count);
	return names;
    }

}
