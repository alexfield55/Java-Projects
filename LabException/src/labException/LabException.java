package labException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LabException
{

    public static void main(String[] args)
    {
	try
	{
	    int digit = numberFromUser();
	    int result = sevenModulus(digit);
	    System.out.printf("7 %% %d = %d", digit, result);
	} catch (Exception e)
	{
	    System.out.println("A Problem Occured: " + e.getMessage());
	}

    }

    private static int numberFromUser()
    {
	Scanner input = new Scanner(System.in);
	int userInt = 0;
	boolean done = false;
	do
	{
	    try
	    {
		System.out.print("\nnumber: ");
		userInt = input.nextInt();
		done = true;

	    } catch (InputMismatchException e)
	    {
		System.out.println("Enter a WHOLE number!");
		input.nextLine();
	    }
	} while (!done);

	return userInt;
    }

    private static int sevenModulus(int number)
    {
	if (number == 0)
	{
	    IllegalArgumentException err = new IllegalArgumentException("Cannot Modulus by Zero!");
	    throw err;
	}
	return 7 % number;
    }

}
