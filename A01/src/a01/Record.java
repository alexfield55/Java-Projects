package a01;



/**
 * This class is to create the object of Record. below are the relevant methods
 * for constructing the object and accessing data in the fields
 * 
 * @author alexf
 *
 */
public class Record
{
    /**
     * String to hold the name of the band
     */
    private String bandName;

    /**
     * String to hold album name
     */
    private String albumName;

    /**
     * integer for year album was made
     */
    private int year;

    /**
     * ID number for album
     */
    private int ID;

    /**
     * static variable to hold count which is incremented each time the constructor
     * is used
     */
    private static int count = 83018;

    /**
     * Constructor that takes in the band name, album name, and year, then using the
     * static value stored in count assigns an ID and then increments count
     */
    public Record(String bN, String aN, int y)
    {
	this.bandName = bN;
	this.albumName = aN;
	this.year = y;
	this.ID = count;
	count++;
    }

    /**
     * returns the band name
     * 
     * @return String
     */
    public String getBandName()
    {
	return bandName;
    }

    /**
     * Returns the album name
     * 
     * @return String
     */
    public String getAlbumName()
    {
	return albumName;
    }

    /**
     * returns the album year
     * 
     * @return int
     */
    public int getYear()
    {
	return year;
    }

    /**
     * Returns the album ID
     * 
     * @return int
     */
    public int getID()
    {
	return ID;
    }

    
    @Override
    /**
     * Overridden to string method to return a useable String for printing the object
     */
    public String toString()
    {
	return (getBandName() + "'s album " + getAlbumName() + " was released in " + getYear() + " and its ID is "
		+ getID());
    }

}
