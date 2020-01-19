package poker;

/**
 * class to construct a player object that can hold hand and the information for the strength of the hand
 * @author alexf
 *
 */
public class Player
{
    private String name;
    private Hand hand;
    private int handStrength;

    //generic getters and setters
    public int getHandStrength()
    {
	return handStrength;
    }

    public void setHandStrength(int handStrength)
    {
	this.handStrength = handStrength;
    }

    public Player(String n)
    {
	this.name = n;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public Hand getHand()
    {
	return hand;
    }

    public void setHand(Hand hand)
    {
	this.hand = hand;
    }

}
