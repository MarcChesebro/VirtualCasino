public class Card {

    private Suit suit;
    private int number;

    public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public int[] getValues() {

        // Cards 2 through 10 have the same value as there number
        if(this.number > 1 && this.number < 11){
            int[] values = {this.number};
            return values;

            // Face cards(over 10) have a value of 10
        }else if(this.number > 10){
            int[] values = {10};
            return values;

            // Aces have the value of wither 1 or 11
        }else{
            int[] values = {1, 11};
            return values;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public enum Suit {
        heart,
        diamond,
        spade,
        club
    }
}
