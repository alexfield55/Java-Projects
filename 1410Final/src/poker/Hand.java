package poker;

import java.util.ArrayList;

/**
 * class that can hold and array of the object cards for players hands and the cards dealt to the table
 * @author alexf
 *
 */
public class Hand
{
    ArrayList<Card> hand = new ArrayList<>();
    Deck deck = new Deck();
    
    /**
     * add two cards to a players hand per the rules of texas holdem poker
     * @param c
     * @param d
     */
    public void addToHand(Card c, Card d)
    {
	hand.add(d);
	hand.add(c);
    }
    
    /**
     * adds 5 cards to the table as per the rules to texas holdem
     * @param c
     * @param d
     * @param e
     * @param f
     * @param g
     */
    public void tableCards(Card c, Card d, Card e, Card f, Card g)
    {
	hand.add(c);
	hand.add(d);
	hand.add(e);
	hand.add(f);
	hand.add(g);
    }

    public ArrayList<Card> getHand()
    {
	return hand;
    }

    @Override
    public String toString()
    {
	String s = "";
	for (Card c : hand)
	{
	    s = s + " " + c.toString();
	}
	return s;
    }
    
//    public static void main(String[] args)
//    {
//	Hand h1 = new Hand();
//	Hand h2 = new Hand();
//	Hand h3 = new Hand();
//	System.out.println(h1);
//	System.out.println(h2);
//	System.out.println(h3);
//    }
}
