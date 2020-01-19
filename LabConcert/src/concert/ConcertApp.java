package concert;

/**
 * class with main used to construct objects of Time and 
 * use those objects plus a String to construct object of Concert
 * as well as printing out object Concert.
 * @author alexf
 *
 */
public class ConcertApp

{
    public static void main(String[] args)
    {
	Time startTime = new Time(17,30,0);
	Time endTime = new Time(22,45,0);

	Concert ozzy = new Concert("Black Sabbath", startTime, endTime);
		
	System.out.println(ozzy.toString());
	
    }

}
