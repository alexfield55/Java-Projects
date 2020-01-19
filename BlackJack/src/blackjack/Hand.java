    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

public class Hand
{        
    ArrayList<Card> hand = new ArrayList();

       public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void addToHand(Card c) {
        hand.add(c);
    }
    
    public String handToString() {
        String s = "";
        for (Card c : hand) {
            s = s + c.toString();
        }
        return s;
    }
    
    private int[] calculateScore() {
        int[] score = {0, 0};
        boolean hasAce = false;
        for (Card c : hand) {
            if (c.rank == Rank.ACE) {
                hasAce = true;
                score[0] += 1;
            } else {
                score[0] += c.rank.value();
            }
        }
        if (score[0] <= 11 && hasAce == true) {
            score[1] = score[0] + 10;
        }
        return score;
    }
    
    public int getScore() {
        int[] s = calculateScore();
        if (s[1] > 0) {
            return s[1];
        } else {
            return s[0];
        }
    }
    
    public String scoreToString() {
        int[] s = calculateScore();
        if (s[1] > 0) {
            return s[0] + " or " + s[1];
        } else {
            return "" + s[0];
        }
    } 
}
