package poker;

/**
 * class to create a card, used by deck class
 * @author alexf
 *
 */
public class Card
{
    private Suit suit;
    private Rank rank;

    public Card(Suit s, Rank r)
    {
	suit = s;
	rank = r;
    }

    public Rank getRank()
    {
	return rank;
    }

    public Suit getSuit()
    {
	return suit;
    }
    
    @Override
    public String toString()
    {
	return rank.abb() + " " + suit;
    }

}
