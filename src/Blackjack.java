import java.util.ArrayList;

/**
 * Description: Class for playing blackjack.
 *
 * @author Marc Chesebro
 * @version 4/19/2018
 */
public class Blackjack {

    /** deck instance of the game. */
    private Deck deck;

    /** List of cards that represents the dealers hand. */
    private ArrayList<Card> dealerHand;

    /** List of cards that represents the players hand. */
    private ArrayList<Card> playerHand;

    /**
     * Ruturns the current deck object.
     * @return the current deck instance.
     */
    public Deck getDeck() {
        return deck;
    }

    /** constructor that creates the hands and deck. */
    public Blackjack() {
        dealerHand = new ArrayList<Card>();
        playerHand = new ArrayList<Card>();
        deck = new Deck();
    }

    /**
     * clear both hands and shuffle the deck.
     */
    public void reset(){
        dealerHand.clear();
        playerHand.clear();
        deck.shuffle();
    }

    /**
     * Draws a card from the deck and puts it in the dealers hand.
     * @return The card drawn.
     */
    public Card dealerDraw(){
        Card drawn = deck.drawCard();
        dealerHand.add(drawn);
        return drawn;
    }

    /**
     * Draws a card from the deck and puts it in the players hand.
     * @return The card drawn.
     */
    public Card playerDraw(){
        Card drawn = deck.drawCard();
        playerHand.add(drawn);
        return drawn;
    }

    /**
     * Returns the total value of the dealers hand.
     * @return The total value of the dealers hand.
     */
    public int dealerScore(){
        return Deck.totalValue(dealerHand);
    }

    /**
     * Returns the total value of the players hand.
     * @return The total value of the players hand.
     */
    public int playerScore(){
        return Deck.totalValue(playerHand);
    }
}
