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
            return new int[]{this.number};

        // Face cards(over 10) have a value of 10
        }else if(this.number > 10){
            return new int[]{10};

        // Aces have the value of wither 1 or 11
        }else{

            return new int[]{1, 11};
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
