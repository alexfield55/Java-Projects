package labItinerary;

import java.util.ArrayList;
import java.util.Scanner;

public class LabItinerary
{

    public static void main(String[] args)
    {
	ArrayList<String> itinerary = new ArrayList();
	Scanner input = new Scanner(System.in);
	String travelRoute = "";
	StringBuilder sb = new StringBuilder();

	// continues the loop until user enters done of any case
	while (travelRoute.compareToIgnoreCase("done") != 0)
	{
	    System.out.print("Destination: ");
	    travelRoute = input.nextLine();
	    
	    //again checking if user enters "done", if not, appends entry to the end of travel route
	    if (travelRoute.compareToIgnoreCase("done") != 0)
	    {
		itinerary.add(travelRoute);
	    }
	    System.out.println();
	}
	
	
	boolean first = true;
	//loop to attach the formatting of " to " in front every element except the first element
	for (String el : itinerary)
	{

	    if (first)
		first = false;
	    else
	    {
		sb.append(" to ");
	    }
	    sb.append(el.toUpperCase());
	}

	System.out.println("travel route: ");
	System.out.println(sb.toString());

    }

}
