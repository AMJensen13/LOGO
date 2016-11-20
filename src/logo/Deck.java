/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.util.*;

/**
 *
 * @author AMJensen13
 */
public class Deck {
    ArrayList<Card> cards;
    
    public Deck(ArrayList<Card> cards)
    {
        this.cards = cards;
        shuffleDeck();
    }
    
    private void shuffleDeck()
    {
        Collections.shuffle(cards, new Random(System.currentTimeMillis()));
    }
    
    public Card drawCard()
    {
        Card retCard = cards.get(0);
        
        cards.remove(0);
        cards.add(retCard);
        
        return retCard;
    }
}
