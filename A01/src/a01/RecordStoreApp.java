package a01;

import java.util.Scanner;

/**
 * Below is the app that runs the main method. 
 * In it is a switch case to navigate the menu.
 * At the bottom is a private method for the menu.
 * @author alexf
 *
 */
public class RecordStoreApp
{

    @SuppressWarnings("resource")
    public static void main(String[] args)
    {

	int choice = 0;

	Scanner input = new Scanner(System.in);
	Records list = new Records(); // creating an instance of Records
	
	while (choice != 6) // loop to keep menu going
	{
	    System.out.println("\n");
	    printMenu();
	    choice = input.nextInt();
	    input.nextLine();
	    
	    while (choice<1 || choice>6) // error checking menu choice
	    {
		System.out.println("Please enter a valid number 1-6");
		printMenu();
		choice = input.nextInt();
	    }
		

	    switch (choice)
	    {
	    case 1:
		list.printList();
		break;
	    case 2:
		list.addAlbum();
		break;
	    case 3:
		list.findItem();
		break;
	    case 4:
		list.deleteItem();
		break;
	    case 5:
		list.counter();
		break;
	    case 6:
		System.out.println("Good Bye!");
		break;

	    }

	}

    }

    /**
     * A private static method to contain the sout for printing the menu
     */
    private static void printMenu()
    {
	System.out.println("1. Display all Records");
	System.out.println("2. Add a Record");
	System.out.println("3. Find an Record");
	System.out.println("4. Delete an Record");
	System.out.println("5. Number of Records");
	System.out.println("6. Exit");
    }

}
