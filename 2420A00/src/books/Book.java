package books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book>
{
    private String title;
    private String author;
    private int year;
    public static final Comparator<Book> REVERSE = new ReverseByTitle(); //Comapator to Reverse sort

    /**
     * Constructor
     * @param title
     * @param author
     * @param year
     */
    public Book(String title, String author, int year)
    {
	this.title = title;
	this.author = author;
	this.year = year;
    }

    public String getTitle()
    {
	return title;
    }

    public String getAuthor()
    {
	return author;
    }

    public int getYear()
    {
	return year;
    }

    @Override
    public String toString()
    {
	return getTitle() + " by " + getAuthor() + " (" + getYear() + ")"; // todo
    }

    /**
     * Takes in a String filename, gets uses it from the Book.class.getResourceAsStream
     * 
     * @param file
     * @return List<Book>
     */
    public static List<Book> getList(String file)
    {
	List<Book> Books = new ArrayList<>();

	String line = "";

	int count = 0;

	try (Scanner reader = new Scanner(Book.class.getResourceAsStream(file)))
	{
	    while (reader.hasNextLine())

	    {

		line = reader.nextLine();

		try
		{
		    String[] items = line.split(",");
		    Book b = new Book(items[0], items[1], Integer.parseInt(items[2]));
		    Books.add(b);
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

	System.out.println("Number of Books read in: " + count);
	return Books;
    }

    /**
     * overridden natural sort to just sort by title in order
     */
    @Override
    public int compareTo(Book b)
    {
	return (this.getTitle().compareTo(b.getTitle()));
    }

    /**
     * static class to implement another Comparator to sort by reserved title order
     * @author alexf
     *
     */
    private static class ReverseByTitle implements Comparator<Book>
    {

	/**
	 * compares by title and then reverses the natural alphabetical order
	 */
	@Override
	public int compare(Book b1, Book b2)
	{
	    return (b1.getTitle().compareTo(b2.getTitle())) * -1;
	}

    }

}
