package labQuadRotors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrotorApp
{

    public static void main(String[] args)
    {
	List<Quadrotor> rotors = Arrays.asList(new Quadrotor(2, 4, 2), new Quadrotor(3, 4, 4), new Quadrotor(4, 4, 6),
		new Quadrotor(5, 4, 2), new Quadrotor(6, 4, 4), new Quadrotor(7, 4, 6));

	Quadrotor searchItem = new Quadrotor(4, 6, 9);

	System.out.println(rotors);
	System.out.println();

	changeOrientation(rotors);

	System.out.println("Orientation change:");
	System.out.println(rotors);
	System.out.println();

	boolean search = true;

	for (Quadrotor el : rotors)
	{
	    if (el.equals(searchItem))
		search = true;
	    else
		search = false;
	}

	if (search)
	    System.out.println("rotors does contain: " + searchItem.toString());
	else
	    System.out.println("rotors does not contain: " + searchItem.toString());

	System.out.println();

	System.out.println("Number of rotors: " + rotors.size());

	System.out.println();

	rotors = new ArrayList(rotors);

	rotors.remove(searchItem);

	System.out.println(rotors);

	System.out.println();

	rotors = new ArrayList(Arrays.asList(new Quadrotor(2, 4, 2), new Quadrotor(3, 4, 4), new Quadrotor(4, 4, 6),
		new Quadrotor(5, 4, 2), new Quadrotor(6, 4, 4), new Quadrotor(7, 4, 6)));

	changeOrientation(rotors);

	rotors.remove(searchItem);
	rotors.remove(0);

	System.out.println(rotors);

    }

    private static void changeOrientation(List<Quadrotor> q)
    {
	for (Quadrotor el : q)
	{
	    int temp = el.getX();
	    el.setX(el.getY());
	    el.setY(temp);
	}
    }

}
