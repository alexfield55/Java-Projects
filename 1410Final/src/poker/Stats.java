package poker;

import java.io.Serializable;

/**
 * class that is used to track statistics of winning hands
 * 
 * @author alexf
 *
 */
public class Stats implements Serializable
{

    private static final long serialVersionUID = -8191858350200729420L;
    private double gamesPlayed;
    private double straightFlush;
    private double quads;
    private double fullhouse;
    private double flush;
    private double straight;
    private double trips;
    private double twoPair;
    private double onePair;
    private double highCard;

    public void gameCounter()
    {
	gamesPlayed++;
    }

    /**
     * anaylyzing winning hand and increments relevant variable
     * @param x
     */
    public void addWin(int x)
    {

	if (x == 9)
	    this.straightFlush++;
	if (x == 8)
	    this.quads++;
	if (x == 7)
	    this.fullhouse++;
	if (x == 6)
	    this.flush++;
	if (x == 5)
	    this.straight++;
	if (x == 4)
	    this.trips++;
	if (x == 3)
	    this.twoPair++;
	if (x == 2)
	    this.onePair++;
	if(x==1)
	    this.highCard++;
    }

    /**
     * prints statistics class
     * @return
     */
    public String printStats()
    {
	if (gamesPlayed == 0)
	    return "No Games Played";


	return 
		
	"Out of " + gamesPlayed + " these are percentages a hand wins:\n"
	+ "\nStraight flush wins: " + straightFlush / gamesPlayed * 100
	+ "%\nFour of a kind wins: " + quads / gamesPlayed * 100
	+ "%\nFull House wins: " + fullhouse / gamesPlayed * 100 
	+ "%\nFlush wins: " + flush / gamesPlayed * 100
	+ "%\nStraight wins: " + straight / gamesPlayed * 100 
	+ "%\nThree of a kind wins: " + trips / gamesPlayed * 100 
	+ "%\nTwo pair wins: " + twoPair / gamesPlayed * 100 
	+ "%\nOne pair wins: " + onePair / gamesPlayed * 100
	+ "%\nHigh Card wins: " + highCard / gamesPlayed * 100 + "%";

    }

}
