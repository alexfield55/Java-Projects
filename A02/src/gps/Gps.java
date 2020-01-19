package gps;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class to store an arrayList of the object GpsPosition
 * so that it can be used to create a list of points and do
 * calculations on those points. Also provides methods for editing
 * updating the arrayList
 * 
 * 
 * @author alexf
 *
 */
public class Gps
{
    /**
     * ArrayList to store objects of class GpsPosition
     */
    private ArrayList<GpsPosition> route = new ArrayList();

    /**
     * Constructor for class that takes a GpsPosition as parameters
     * and add it to the ArrayList
     * @param position
     */
    public Gps(GpsPosition position)
    {
	route.add(position);
    }

    /**
     * Getter to reveal elements in the ArrayList
     * @return ArrayList<GpsPosition>
     */
    public ArrayList<GpsPosition> getRoute()
    {
	return route;
    }

    /**
     * Adds a Gps position to the ArrayList
     * @param position
     */
    public void update(GpsPosition position)
    {
	route.add(position);
    }

    /**
     * Calls the Math class random method to generate a number between -0.5 and 0.5 and
     * adds it to the latitude of the current position, calls the random method and adds
     * that number to the longitude.
     */
    public void randomUpdate()
    {
	double r1 = Math.random()-.5;
	double r2 = Math.random()-.5;
	GpsPosition updated = new GpsPosition(position().getLatitude()+r1, position().getLongitude()+r2, position().getElevation());
	route.add(updated);
    }

    /**
     * Reveals the last item in the ArrayList as the current position
     * @return GpsPosition object
     */
    public GpsPosition position()
    {
	return route.get(route.size()-1);
    }

    /**
     * A method that loops through the elements in the array and does calculations
     * to find the distance between them.
     * @return double
     */
    public double distanceTraveled()
    {
	double distanceTraveled = 0;

	for (int i = 0; i < route.size() - 1; i++)
	{
	    distanceTraveled += distance(route.get(i), route.get(i + 1));
	}

	return distanceTraveled;

    }

    private double distance(GpsPosition t, GpsPosition f)
    {
	double theta = t.getLongitude() - f.getLongitude();
	double dist = Math.sin(deg2rad(t.getLatitude())) * Math.sin(deg2rad(f.getLatitude()))
		+ Math.cos(deg2rad(t.getLatitude())) * Math.cos(deg2rad(f.getLatitude())) * Math.cos(deg2rad(theta));
	dist = Math.acos(dist);
	dist = rad2deg(dist);
	dist = dist * 60 * 1.1515;
	dist = dist * 1.609344;
	
	return (dist);
    }


    //This function converts decimal degrees to radians
    private double deg2rad(double deg)
    {
	return (deg * Math.PI / 180.0);
    }

    //This function converts radians to decimal degrees : 
    private double rad2deg(double rad)
    {
	return (rad * 180.0 / Math.PI);
    }

    /**
     * function to remove all items in ArrayList except the last one
     */
    public void reset()
    {
	for (int i = 0; i < route.size()-1; i++)
	{
	    route.remove(i);
	}
    }
}
