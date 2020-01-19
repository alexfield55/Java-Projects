package test;

import java.util.Collections;

import edu.princeton.cs.algs4.Insertion;

public class CarsApp
{

    public static void main(String[] args)
    {
	Cars[] carArr = {new Cars(1997, "Oldsmobile", "Cutlass", "Gold"), new Cars(2003, "Ford", "F150", "Gold"), 
		new Cars(2018, "Subaru", "Crosstrek", "Maroon"), new Cars(1969, "Chevrolet", "Camaro", "Red")};
		
	
	System.out.println("Original List");
	for(Cars el: carArr)
	{
	    System.out.println(el);
	}
	
	Insertion.sort(carArr);
	
	System.out.println();
	
	System.out.println("Sort by year, natural sort");
	for(Cars el: carArr)
	{
	    System.out.println(el);
	}
	
	Insertion.sort(carArr, Cars.BY_MAKE);
	
	System.out.println();
	
	System.out.println("Sort by make");
	for (Cars el: carArr)
	{
	    System.out.println(el);
	}
	
    }

}
