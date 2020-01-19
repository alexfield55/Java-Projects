package gps;

/**
 * Class for a GPS position with relevant constructors and getters
 * @author alexf
 *
 */
public class GpsPosition
{

    private double latitude;
    private double longitude;
    private double elevation;

    /**
     * Constructor to take in a latitude, longitude, and elevation to 
     * create and object with GPS location parameters
     * 
     * @param latitude
     * @param longitude
     * @param elevation
     */
    public GpsPosition(double latitude, double longitude, double elevation)
    {
	if ((latitude < -90 || latitude > 90) || (longitude < -180 || longitude > 180))
	{
	    throw new IllegalArgumentException("Invalid latitude and/or longitude");
	} else
	{
	    this.latitude = latitude;
	    this.longitude = longitude;
	    this.elevation = elevation;
	}
    }

    /**
     * function to reveal latitude
     * @return double
     */
    public double getLatitude()
    {
	return latitude;
    }

    /**
     * function to reveal longitude
     * @return double
     */
    public double getLongitude()
    {
	return longitude;
    }

    /**
     * function to reveal elevation
     * @return double
     */
    public double getElevation()
    {
	return elevation;
    }

    /**
     * Overridden toString method with formatting to reveal on up to six decimal 
     * places of the lat and long, as well as one of elevation
     */
    @Override
    public String toString()
    {
	return String.format("%.6f, %.6f (%.1f)", getLatitude(), getLongitude(), getElevation());

    }

}
