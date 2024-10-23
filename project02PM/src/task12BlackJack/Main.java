package task12BlackJack;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> deck = shuffleDeck();

        //Giving cards to everyone
        String playerCard1 = deck.removeFirst();
        String dealerCard1 = deck.removeFirst();
        String playerCard2 = deck.removeFirst();
        String dealerCard2 = deck.removeFirst();

        //Showing player cards
        System.out.println("Your first card is: " + playerCard1);
        System.out.println("Your second card is: " + playerCard2);
        int playerHand = getHand(playerCard1, playerCard2);
        System.out.println("Your hand total is: " + playerHand + "\n");
        int dealerHand = getHand(dealerCard1, dealerCard2);

        //Checking for instant win
        if (blackJack(playerHand) && blackJack(dealerHand)){
            System.out.println("It's a draw!");
        } else if (blackJack(dealerHand)){
            System.out.println("Sorry you lost! The dealer scored a BlackJack!");
        } else if (blackJack(playerHand)){
            System.out.println("Congratulations! You scored a BlackJack!");
        }

        //Player turn
        Console cons = System.console();
        String decision = "";
        int cardCount = 2;
        while (!decision.equalsIgnoreCase("N")){
            decision = cons.readLine("Do you wish to draw another card? Y/N\n");
            if (decision.equalsIgnoreCase("Y")){
                if (cardCount == 7){
                    System.out.println("Maximum number of cards drawn!\n");
                    break;
                } else {
                    String nextCard = deck.removeFirst();
                    playerHand = getHand(Integer.toString(playerHand), nextCard);
                    System.out.println("Your new hand total is: " + playerHand + "\n");
                    cardCount++;
                }
            } else if (decision.equalsIgnoreCase("N")){
                break;
            } else {
                System.out.println("Invalid decision! Please try again!\n");
            }
        }

        //Dealer turn
        while (dealerHand < 18){
            String Nextcard = deck.removeFirst();
            dealerHand = getHand(Integer.toString(dealerHand), Nextcard);
        }

        //Evaluate scores
        evaluteScores(dealerHand, playerHand);
        System.out.println("You scored: " + playerHand);
        System.out.println("The dealer scored: " + dealerHand);
        System.out.println("Game over! Bye bye!");
    }

    public static List<String> shuffleDeck() {
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
        Collections.shuffle(deck);
        
        return deck;
    }

    //returns sum of hand
    public static int getHand(String card1, String card2) {
        int hand = 0;
        String value1String = card1.split(" ")[0].strip();
        String value2String = card2.split(" ")[0].strip();
        int value1 = 0;
        int value2 = 0;

        switch (value1String) {
            case "A":
                break;
            case "J":
            case "Q":
            case "K":
                value1 = 10;
                break;
            default:
                value1 = Integer.parseInt(value1String);
                break;
        }
        switch (value2String) {
            case "A":
                if (value1 == 0 || value1 == 10){
                    value2 = 11;
                } else if (value1 < 10){
                    value2 = 10;
                } else{
                    value2 = 1;
                }
            case "J":
            case "Q":
            case "K":
                value2 = 10;
                break;
            default:
                value2 = Integer.parseInt(value2String);
                break;
        }

        if(value1String.equals("A")){
            if (value2String.equals("A") || value2 < 10){
                value1 = 10;
                
            } else if (value2 == 10){
                value1= 11;
            }else {
                value1 = 1;
            }
        }
        hand += value1;
        hand += value2;
        return hand;
    }

    public static boolean blackJack(int handToCheck) {
        if (handToCheck == 21){
            return true;
        } else return false;
    }
    
    public static void evaluteScores(int dealerHand, int playerHand){
        if (playerHand == 21){
            if (dealerHand < 21 || dealerHand > 21){
                System.out.println("Congratulations! You won!");
            } else if (dealerHand == 21){
                System.out.println("It's a draw!");
            }
        } else if (playerHand > 21){
            if (dealerHand <= 21 ){
                System.out.println("Sorry you lost!");
            } else {
                System.out.println("It's a draw");
            }
        } else if (playerHand < 21){
            if (dealerHand > 21 || dealerHand < playerHand){
                System.out.println("Congratulations! You won!");
            } else if (dealerHand > playerHand){
                System.out.println("Sorry you lost!");
            } else if (dealerHand == playerHand){
                System.out.println("It's a draw");
            }
        }
    }
}
