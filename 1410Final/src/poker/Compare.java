package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * class to return results of a hand of poker
 * @author alexf
 *
 */
public class Compare
{
    /**
     * goes through checking for differnt hand results
     * @param p
     * @param t
     * @return
     */
    public int comparison(Hand p, Hand t)
    {
	List<Card> cards = new ArrayList<>();
	for (Card el : p.hand)
	{
	    cards.add(el);
	}
	for (Card el : t.hand)
	{
	    cards.add(el);
	}

	int[] ranks = new int[7];
	for (int i = 0; i < 7; i++)
	{
	    ranks[i] = cards.get(i).getRank().value();
	}

	Arrays.sort(ranks);

	//System.out.println(cards);

	int[] vals = new int[15];

	for (int el : ranks)
	{
	    switch (el)
	    {
	    case 2:
		vals[2]++;
		break;
	    case 3:
		vals[3]++;
		break;
	    case 4:
		vals[4]++;
		break;
	    case 5:
		vals[5]++;
		break;
	    case 6:
		vals[6]++;
		break;
	    case 7:
		vals[7]++;
		break;
	    case 8:
		vals[8]++;
		break;
	    case 9:
		vals[9]++;
		break;
	    case 10:
		vals[10]++;
		break;
	    case 11:
		vals[11]++;
		break;
	    case 12:
		vals[12]++;
		break;
	    case 13:
		vals[13]++;
		break;
	    case 14:
		vals[14]++;
		break;
	    }

	}

//	for (int el : vals)
//	{
//	    System.out.print(el + " ");
//	}
//	System.out.println();

	// matched cards test
	int pairs = 0;
	int trips = 0;
	int quads = 0;

	for (int el : vals)
	{
	    switch (el)
	    {
	    case 2:
		pairs++;
		break;
	    case 3:
		trips++;
		break;
	    case 4:
		quads++;
		break;
	    }
	}

	boolean hasOnePair = false;
	if (pairs == 1)
	{
	    hasOnePair = true;
	}

	boolean hasTwoPair = false;
	if (pairs >= 2)
	{
	    hasTwoPair = true;
	}

	boolean hasTrips = false;
	if (trips >= 1)
	{
	    hasTrips = true;
	}

	boolean hasQuads = false;
	if (quads >= 1)
	{
	    hasQuads = true;
	}

	// straight
	boolean hasStraight = false;
	for (int i = 0; i < vals.length - 4; i++)
	{
	    if (vals[i] >= 1 && vals[i + 1] >= 1 && vals[i + 2] >= 1 && vals[i + 3] >= 1 && vals[i + 4] >= 1)
	    {
		hasStraight = true;
	    }
	}

	// flush
	int h = 0;
	int c = 0;
	int s = 0;
	int d = 0;
	for (Card el : cards)
	{
	    if (el.getSuit() == Suit.D)
		d++;
	    if (el.getSuit() == Suit.H)
		h++;
	    if (el.getSuit() == Suit.C)
		c++;
	    if (el.getSuit() == Suit.S)
		s++;
	}

	boolean hasFlush = false;
	if (d >= 5 || s >= 5 || c >= 5 || h >= 5)
	{
	    hasFlush = true;
	}

	// full house
	boolean hasFullhouse = false;
	if (trips >= 1 && pairs >= 1)
	{
	    hasFullhouse = true;
	}

	boolean hasStraightFlush = false;
	if (hasStraight && hasFlush)
	{
	    hasStraightFlush = true;
	}

//	System.out.println("Straight Flush: " + hasStraightFlush);
//	System.out.println("quads: " + hasQuads);
//	System.out.println("fullhouse: " + hasFullhouse);
//	System.out.println("flush: " + hasFlush);
//	System.out.println("straight " + hasStraight);
//	System.out.println("trips: " + hasTrips);
//	System.out.println("two pair: " + hasTwoPair);
//	System.out.println("one pair: " + hasOnePair);

	if (hasStraightFlush)
	    return 9;
	if (hasQuads)
	    return 8;
	if (hasFullhouse)
	    return 7;
	if (hasFlush)
	    return 6;
	if (hasStraight)
	    return 5;
	if (hasTrips)
	    return 4;
	if (hasTwoPair)
	    return 3;
	if (hasOnePair)
	    return 2;
	return 1;

    }
    
    /**
     * used to return String name of hand
     * @param x
     * @return
     */
    public String nameOfHand(int x)
    {
	if(x==9)
	    return "Straight Flush";
	if(x==8)
	    return "Four of a Kind";
	if(x==7)
	    return "Full House";
	if(x==6)
	    return "Flush";
	if(x==5)
	    return "Straight";
	if(x==4)
	    return "Three of a Kind";
	if(x==3)
	    return "Two Pair";
	if(x==2)
	    return "One Pair";
	return "High Card";
	    
    }

}
