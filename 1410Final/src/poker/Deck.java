package poker;

import java.util.Arrays;
import java.util.Collections;

/**
 * class that creates an array of cards by creating 52 objects of Card and looping through its constants
 * @author alexf
 *
 */
public class Deck
{
    private Card[] deck = new Card[52];
    private int deckPos = 0;

    /**
     * creates array
     */
    public Deck()
    {
	for (Suit s: Suit.values())
	{
	    for (Rank r : Rank.values())
	    {
		deck[deckPos] = new Card(s, r);
		deckPos++;
	    }
	}
	shuffle();
	deckPos = 0;

    }

    /**
     * draws a card from the deck and advances the current deck positoin
     * @return
     */
    public Card draw()
    {
	return deck[deckPos++];
    }

    @Override
    public String toString()
    {

	return deck.toString();
    }

    public void shuffle()
    {
	Collections.shuffle(Arrays.asList(deck));
    }

//    public static void main(String[] args)
//    {
//	Deck d = new Deck();
//	for (int i = 0; i < 52; i++)
//	{
//	    System.out.println(d.draw().toString());
//	    // System.out.println(d.deckPos);
//	}
//    }
}
