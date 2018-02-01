import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> draw;
    private ArrayList<Card> discard;

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

    public Deck(ArrayList<Card> draw, ArrayList<Card> discard) {
        this.draw = draw;
        this.discard = discard;
    }

    public void shuffle(){
        this.draw.addAll(this.discard);
        this.discard.clear();

        Collections.shuffle(this.draw, new Random());
    }
}