package test;

public class NameHash
{

    public Integer hash(String str)
    {
	int val = 0;
	
	for (char c : str.toCharArray())
	{
	    val = val + Integer.valueOf(c);

	}
	
	System.out.print(val + "\n");
	
	return val;
    }

}
