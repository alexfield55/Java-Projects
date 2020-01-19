package module1Test;

import java.util.ArrayList;

/**
 * A class to test both String and StringBuilder functionality
 * when taking in elements of an ArrayList
 * @author alexf
 *
 */
public class Module1Test
{

    public static void main(String[] args)
    {
	/**
	 * An ArrayList of Strings called rodents
	 * to contain different rodent names
	 */
	ArrayList<String> rodents = new ArrayList();

	rodents.add("bunny");
	rodents.add("hamster");
	rodents.add("gerbil");
	rodents.add("rat");
	rodents.add("mouse");
	rodents.add("beaver");
	rodents.add("porcupine");
	rodents.add("muskrat");
	rodents.add("squirrel");

	System.out.println("Here is the rodentString output");
	System.out.println(rodentString(rodents));
	System.out.println();
	System.out.println("Here is the rodentSB output");
	System.out.println(rodentSB(rodents));

    }
    
    /**
     * A method that takes in a given ArrayList of and
     * concatinates all elements of the ArrayList into one long 
     * String value which formatted with commas and spacing and
     * then returned
     * 
     * @param r
     * @return String
     */
    public static String rodentString(ArrayList<String> r)
    {
	/**
	 * new String value to store concatinated Strings from ArrayList
	 */
	String retValue = "";
	
	/**
	 * boolean variable to setup where the commas and formatting goes
	 */
	boolean first = true;

	for (String el : r) //looping elements of ArrayList
	{
	    if (first) //determining formatting for commas and spaces
		first = false;
	    else
	    {
		retValue = retValue.concat(", ");
	    }
	    retValue = retValue.concat(el);
	}

	return retValue;

    }
    
    
    /**
     * A method that creates a new StringBuilder,
     * appends all elements of given ArrayList of Strings
     * and then returns the StringBuilder value, formatted with
     * commas and spacing
     * 
     * @param r
     * @return StringBuilder
     */
    public static StringBuilder rodentSB(ArrayList<String> r)
    {
	/**
	 * boolean variable to setup where the commas and formatting goes
	 */
	boolean first = true;
	
	/**
	 * creating new instance of StringBuilder
	 */
	StringBuilder sb = new StringBuilder();

	for (String el : r) //looping elements in ArrayList
	{
	    if (first) //determining formatting for commas and spaces
		first = false;
	    else
	    {
		sb.append(", ");
	    }
	    sb.append(el);
	}
	return sb;
    }

}
