package a01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a class created to store an
 * ArrayList of the object Record.
 * This allows me to create methods using the 
 * ArrayList to provide functionality to the user in
 * the menus of the app
 * @author alexf
 *
 */
public class Records
{
    /**
     * Creating ArrayList of object Records
     */
    private ArrayList<Record> Records = new ArrayList<Record>();

    /**
     * Hard coded creating of objects to fill ArrayList
     */
    public Records()
    {
	Records.add(new Record("Megadeth", "Rust in Peace", 1990));
	Records.add(new Record("Pink Floyd", "Meddle", 1971));
	Records.add(new Record("Bob Dylan", "Oh Mercy", 1989));
	Records.add(new Record("Origin", "Entity", 2011));
    }

    /**
     * This allows for a menu choice that gives inputs for the user to
     * add an album to the ArrayList
     */
    public void addAlbum()
    {
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	String bandName;
	String albumName;
	int year;

	System.out.println("What is the bands name?");
	bandName = input.nextLine();
	System.out.println("What is the album name?");
	albumName = input.nextLine();
	System.out.println("What year was it made?");
	year = input.nextInt();
	Records.add(new Record(bandName, albumName, year));
    }

    /**
     * method for printing contents of the ArrayList
     */
    public void printList()
    {
	for (Record r : Records)
	{
	    System.out.println(r.toString());
	}
    }

    /**
     * This method searches the ArrayList by looking at each
     * objects ID field.
     * Also provides error checking of ID numbers.
     */
    public void findItem()
    {
	System.out.println("Please give the item ID number of what you would like to find:");
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	int id = input.nextInt();
	int i = 0;
	for (Record r : Records)
	{
	    if (id == r.getID())
	    {
		System.out.println(r.toString());
		i++;
		break;
	    }
	}
	if (i == 0)
	{
	    System.out.println("ID number cannot be found, please try again!");
	}
    }

    /**
     * This method searches the ArrayList by accessing the objects ID field
     * It provides error checking of IDs
     * If correct ID is found it removes object from ArrayList
     * 
     */
    public void deleteItem()
    {
	System.out.println("Please give the item ID number of what you would like to delete from the catalog:");
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	int id = input.nextInt();
	int i = 0;

	for (Record r : Records)
	{
	    if (id == r.getID())
	    {
		System.out.println(r.toString() + " has been deleted from the catalog");
		Records.remove(r);
		i++;
		break;
	    }
	}

	if (i == 0)
	{
	    System.out.println("ID number cannot be found, please try again!");
	}

    }

    /**
     * This method simply counts the number of objects stored in the ArrayList
     */
    @SuppressWarnings("unused")
    public void counter()
    {
	int i = 0;
	for (Record r : Records)
	{
	    i++;
	}
	System.out.println("Number of items is " + i);
    }

}
