import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for playing blackjack.
 *
 * @author Marc Chesebro
 * @version 2/23/2018
 */
public class Blackjack {

    //create the Deck
    private Deck deck;
    //create the player and dealers hand
    private ArrayList<Card> dealerHand;
    private ArrayList<Card> playerHand;

    public Deck getDeck() {
        return deck;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public Blackjack() {
        dealerHand = new ArrayList<Card>();
        playerHand = new ArrayList<Card>();
        deck = new Deck();
    }

    public void reset(){
        dealerHand.clear();
        playerHand.clear();
        deck.shuffle();
    }

    public Card dealerDraw(){
        Card drawn = deck.drawCard();
        dealerHand.add(drawn);
        return drawn;
    }

    public Card playerDraw(){
        Card drawn = deck.drawCard();
        playerHand.add(drawn);
        return drawn;
    }

    public int dealerScore(){
        return Deck.totalValue(dealerHand);
    }

    public int playerScore(){
        return Deck.totalValue(playerHand);
    }
}
