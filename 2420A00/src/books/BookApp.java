package books;

import java.util.ArrayList;
import java.util.Collections;

public class BookApp
{

    public static void main(String[] args)
    {

	String file = "books.csv";
	
	ArrayList<Book> arr = (ArrayList<Book>) Book.getList(file);
	
	System.out.println();
	
	Collections.sort(arr);
	
	System.out.println("Sorted Book List:");
	for (Book el: arr)
	{
	   System.out.println(el);
	}
	System.out.println();
	
	Collections.sort(arr, Book.REVERSE);
	
	System.out.println("Reverse Sorted Book List:");
	for (Book el: arr)
	{
	   System.out.println(el);
	}
	

    }
}
