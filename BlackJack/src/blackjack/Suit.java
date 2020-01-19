
package blackjack;

public enum Suit {
    SPADES ("Black", '\u2660'),
    HEARTS ("Red", '\u2764'),
    CLUBS ("Black", '\u2663'),
    DIAMONDS ("Red", '\u2666');
    
    private final String color;
    private final char symbol;
    
    Suit(String c, char s) {
        color = c;
        symbol = s;
    }
    
    public String color() {return color;}
    public char symbol() {return symbol;}
    
    public static void main(String[] args) {
        for (Suit s: Suit.values()) {
            System.out.printf("%s ", s);
            System.out.printf("%s ", s.color());
            System.out.printf("%c", s.symbol());
            System.out.println();
        }
    }
    
}