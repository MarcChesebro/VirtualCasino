import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deck object that represents a standard 52 card poker Deck.
 *
 * @author Marc Chesebro
 * @version 2/23/2018
 */
public class Deck {

    /** The Decks draw pile. */
    private ArrayList<Card> draw;

    /** The Decks discard pile. */
    private ArrayList<Card> discard;

    /**
     * Default Constructor for Deck object.
     * Creates a standard poker deck.
     */
    public Deck() {
        // Create empty deck
        this.draw = new ArrayList<Card>();

        // Make standard 52 card poker deck
        for(int i = 1; i < 14; i++) {
            this.draw.add(new Card(Card.Suit.heart, i));
        }

        for(int i = 1; i < 14; i++) {
            this.draw.add(new Card(Card.Suit.diamond, i));
        }

        for(int i = 1; i < 14; i++) {
            this.draw.add(new Card(Card.Suit.spade, i));
        }

        for(int i = 1; i < 14; i++) {
            this.draw.add(new Card(Card.Suit.club, i));
        }

        // shuffle the deck
        Collections.shuffle(this.draw);

        // create empty discard pile
        this.discard = new ArrayList<Card>();
    }



    /**
     * Puts the discard pile on the draw pile and then randomizes the deck.
     */
    public void shuffle(){
        this.draw.addAll(this.discard);
        this.discard.clear();

        Collections.shuffle(this.draw, new Random());
    }

    /**
     * Draws a card off the draw pile and puts it on the discard pile.
     * Then returns the card drawn.
     * @return The card drawn.
     */
    public Card drawCard(){
        Card removed = this.draw.remove(0);
        discard.add(removed);
        return removed;
    }

    /**
     * prints the hand to the console.
     * @param hand hand to print.
     */
    public static void printHand(final ArrayList<Card> hand){

        for(int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString());
        }
    }

    /**
     * finds the total value of a hand based off blackjack values.
     * @param  hand hand to evaluate.
     * @return returns the total value as an int.
     */
    public static int totalValue(final ArrayList<Card> hand){
        int val = 0;
        int numAces = 0;

        for(int i = 0; i < hand.size(); i++) {
            val += hand.get(i).getValues()[0];
            if(hand.get(i).getNumber() == 1) {
                numAces++;
            }
        }

        for(int i = 0; i < numAces; i++) {
            if(21 - val >= 10) {
                val += 10;
            }
        }

        return val;
    }
}
