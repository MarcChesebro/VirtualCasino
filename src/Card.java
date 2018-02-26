/**
 * Card class to represent a standard poker cards.
 *
 * @author Marc Chesebro
 * @version 2/23/2018
 */
public class Card {

    /** suit of the card. */
    private Suit suit;

    /** number of the card. */
    private int number;

    /**
     * Constructor that takes the suit and the number of the cards.
     *
     * @param suit   the suit of the card.
     * @param number the number of the card.
     */
    public Card(final Suit suit, final int number) {
        this.suit = suit;
        this.number = number;
    }

    /**
     * returns an integer array of all the possible values of the cards.
     * @return int array with all possible values of the card.
     */
    public int[] getValues() {

        // Cards 2 through 10 have the same value as there number
        if(this.number > 1 && this.number < 11) {
            return new int[]{this.number};

        // Face cards(over 10) have a value of 10
        }else if(this.number > 10) {
            return new int[]{10};

        // Aces have the value of wither 1 or 11
        }else {

            return new int[]{1, 11};
        }
    }

    /**
     * returns the suit of the cards.
     * @return the suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * set the suit of the cards.
     * @param suit suit to be set.
     */
    public void setSuit(final Suit suit) {
        this.suit = suit;
    }

    /**
     * get the number of the cards.
     * @return the number of the cards.
     */
    public int getNumber() {
        return number;
    }

    /**
     * set the number of the cards.
     * @param number the number of the card.
     */
    public void setNumber(final int number) {
        this.number = number;
    }

    /**
     * returns a string representing the cards.
     * @return string representation of the card.
     */
    public String toString() {
        String str = "";
        switch (this.number) {
            case 1:
                str = "Ace";
                break;
            case 11:
                str = "Jack";
                break;
            case 12:
                str = "Queen";
                break;
            case 13:
                str = "King";
                break;
            default:
                str = "" + this.getNumber();
        }
        str = str + " of " + this.suit.toString();
        return str;
     }

    /**
     * enum that represents the suit of the card.
     */
    public enum Suit {
        /**
         * heart suit.
         */
        heart,
        /**
         * diamond suit.
         */
        diamond,
        /**
         * spade suit.
         */
        spade,
        /**
         * club suit.
         */
        club
    }
}
