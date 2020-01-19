
package blackjack;

import java.util.ArrayList;

public class Player
{
    private final String name;
    ArrayList<Hand> hands = new ArrayList();
    private int wallet;
    private int bet;
    
    public Player(String n, int w) {
        name = n;
        wallet = w;
    }
    
    public void setHands(Hand h)
    {
        hands.add(h);
    }
    
    public void addToWallet(int v)
    {
        wallet+=v;
    }
    
    
    public void placeBet(int b) {
        bet = b;
    }
    
    public int getBet() {
        return bet;
    }
    
    public int getWallet() {
        return wallet;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Hand> getHands() {
        return hands;
    }
    
    public String printHands() {
        int counter = 1;
        String s = "";
        for(Hand h : hands) {
           s = s + "Hand " + counter + ": " +  h.toString() + "   ";
           counter++;
        }
        return s;
    }
    
//    public ArrayList<Card> getHand() {
//        return hand;
//    }
//    
//    public void addToHand(Card c) {
//        hand.add(c);
//    }
//    
//    public String handToString() {
//        String s = "";
//        for (Card c : hand) {
//            s = s + c.toString();
//        }
//        return s;
//    }
//    
//    private int[] calculateScore() {
//        int[] score = {0, 0};
//        boolean hasAce = false;
//        for (Card c : hand) {
//            if (c.rank == Rank.ACE) {
//                hasAce = true;
//                score[0] += 1;
//            } else {
//                score[0] += c.rank.value();
//            }
//        }
//        if (score[0] <= 11 && hasAce == true) {
//            score[1] = score[0] + 10;
//        }
//        return score;
//    }
//    
//    public int getScore() {
//        int[] s = calculateScore();
//        if (s[1] > 0) {
//            return s[1];
//        } else {
//            return s[0];
//        }
//    }
//    
//    public String scoreToString() {
//        int[] s = calculateScore();
//        if (s[1] > 0) {
//            return s[0] + " or " + s[1];
//        } else {
//            return "" + s[0];
//        }
//    }
//    
//    public static void main(String[] args) {
//        Deck d = new Deck();
//        Player p = new Player("Lonnie");
//        
//        p.addToHand(new Card(Suit.CLUBS, Rank.ACE));
//        p.addToHand(d.draw());
//        p.addToHand(d.draw());
//        
//        System.out.println(p.handToString());
//        
//        System.out.println(p.scoreToString());
//        System.out.println(p.getScore());
//    }

}
