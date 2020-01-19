package labKeyValue;

import java.util.ArrayList;
import java.util.List;

public class PairApp
{
    public static void main(String[] args)
    {
	KeyValuePair p1 = new KeyValuePair("SLC", 189899);
	KeyValuePair p2 = new KeyValuePair("NY", 8244910);
	KeyValuePair p3 = new KeyValuePair("LA", 3819702);
	KeyValuePair p4 = new KeyValuePair("NY", 812826);
	
	List<KeyValuePair> cities = new ArrayList<>();
	cities.add(p1);
	cities.add(p2);
	cities.add(p3);
	cities.add(p4);
	
	System.out.println("Original List");
	for(KeyValuePair el: cities)
	{
	    System.out.println(el.toString());
	}
	
	System.out.println();
	
	
    }
    
}
