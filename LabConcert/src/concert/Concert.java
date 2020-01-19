package concert;

/**
 * Class designed for constructing an object called concert with 
 * the details of the band name, and the start and end times of the concert
 * @author alexf
 *
 */
public class Concert
{
    private String name;
    private Time startTime = new Time();
    private Time endTime = new Time();

    /**
     * Constructor to take in parameters of band name, start time, and end time of
     * a given concert
     * 
     * @param n
     * @param start
     * @param end
     */
    public Concert(String n, Time start, Time end)
    {
	name = n;
	startTime = start;
	endTime = end;

    }

    /**
     * gets band name
     * @return String
     */
    public String getName()
    {
	return name;
    }

    /**
     * sets band name
     * @param name
     */
    public void setName(String name)
    {
	this.name = name;
    }

    /**
     * gets the concert start time
     * @return Time
     */
    public Time getStartTime()
    {
	return startTime;
    }

    /**
     *sets the concert start time
     * @param startTime
     */
    public void setStartTime(Time startTime)
    {
	this.startTime = startTime;
    }

    /**
     * gets the concert end time
     * @return Time
     */
    public Time getEndTime()
    {
	return endTime;
    }

    /**
     * sets the concert end time
     * @param endTime
     */
    public void setEndTime(Time endTime)
    {
	this.endTime = endTime;
    }

    @Override
    /**
     * overriden toString method to return a useable and formatted String
     * of the contents of the object Concert.
     */
    public String toString()
    {
	return "The " + getName() + " starts at " + getStartTime().toString() + " and ends at "
		+ getEndTime().toString();
    }
}
