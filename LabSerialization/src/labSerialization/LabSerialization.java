package labSerialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabSerialization
{
    public static void main(String[] args)
    {
	ListVsSetDemo demo = new ListVsSetDemo(new ColoredSquare(4, Color.RED), new ColoredSquare(6, Color.BLUE),
		new ColoredSquare(4, Color.RED), new ColoredSquare(8, Color.YELLOW));

	//testDemo(demo);
	serialize(demo, "Demo.ser");
	ListVsSetDemo newDemo = deserialize("Demo.ser");
	testDemo(newDemo);

    };

    private static void testDemo(ListVsSetDemo demo)
    {
	System.out.println("List:");
	System.out.println(demo.getListElements());
	System.out.println("Set:");
	System.out.println(demo.getSetElements());
    }

    private static void serialize(ListVsSetDemo demo, String filename)
    {
	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));)
	{
	    oos.writeObject(demo);
	    System.out.println("Object was Serialized");

	} 
	catch (IOException e)
	{

	    e.printStackTrace();

	}

    }

    private static ListVsSetDemo deserialize(String filename)
    {
	ListVsSetDemo l = null;
	
	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));)
	{
	    	l = (ListVsSetDemo) ois.readObject();   	
	} 
	catch (IOException | ClassNotFoundException e)
	{
	    e.printStackTrace();
	}
	return l;
    }
}
