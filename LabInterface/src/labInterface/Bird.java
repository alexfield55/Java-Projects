package labInterface;

public class Bird implements Flyable
{
	private final String type;

	public Bird(String t)
	{
		type = t;
	}

	@Override
	public String toString()
	{
		return type;
	}

	@Override
	public void launch()
	{
	    System.out.println("Flapping the wings to take off");
	    
	}

	@Override
	public void land()
	{
	    System.out.println("Flapping the wings until landing");
	    
	}
}
