package task11shuffleDeck;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] suits = {"DIAMOND", "CLUB", "HEART", "SPADE"};
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<String> deck = new ArrayList<>();
        
        //Adding cards to deck
        for (int i = 0; i <suits.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                String card = rank[j] + " of " + suits[i];
                deck.add(card);
            }
        }
        
        //Printing out each card
        for (String card: deck) {
            System.out.println(card);
        }
    }
}
