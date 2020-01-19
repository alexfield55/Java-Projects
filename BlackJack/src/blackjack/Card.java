
package blackjack;

public class Card
{
   
    Suit suit;
    Rank rank;
    
    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }
    
    public Rank getRank() {return rank;}
    public Suit getSuit() {return suit;}
    
    @Override
    public String toString() 
    {
        
            return rank.abb() + suit.symbol();
        
    }
    
    public static void main(String[] args) 
    {
        Card c = new Card(Suit.CLUBS, Rank.ACE);
        System.out.println(c.getRank().value());
        System.out.println(c.getRank().order());
        System.out.println(c.toString());
    }
}

