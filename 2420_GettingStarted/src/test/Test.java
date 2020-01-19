package test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class Test
{

    public static void main(String[] args)
    {
	System.out.println("Hello World");
	
	ArrayList<String> animals = new ArrayList<>();
	
	animals.add("bat");
	animals.add("cat");
	animals.add("ant");
	animals.add("dog");
	animals.add("eel");
	
	System.out.println(animals);
	
	Collections.sort(animals);
	
	System.out.println(animals);
	
	Collections.sort(animals, Collections.reverseOrder());
	
	System.out.println(animals);
	
	

    }

}
