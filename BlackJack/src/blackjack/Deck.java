/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Arrays;
import java.util.Collections;

public class Deck
{
    private Card[] deck = new Card[52];
    private int deckPos = 0;
    
    public Deck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck[deckPos] = new Card(s, r);
                deckPos++;
            }
        }
        shuffle();
        deckPos = 0;
        
    }
    
    public Card draw() {
        return deck[deckPos++];
    }
    
    public void shuffle() {
        Collections.shuffle(Arrays.asList(deck));
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        for(int i = 0; i<=52; i++)
        {
        System.out.println(d.draw().toString());
        //System.out.println(d.deckPos);
        }
    }
    
}
