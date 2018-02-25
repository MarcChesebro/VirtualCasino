import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for playing blackjack.
 *
 * @author Marc Chesebro
 * @version 2/23/2018
 */
public class Blackjack {


    /**
     * Function for playing blackjack.
     *
     * @param player  that is playing the game.
     */
    public static void play(final Player player){

        //scanner for reading input
        Scanner scanner = new Scanner(System.in);
        //create the Deck
        Deck deck = new Deck();
        //create the player and dealers hand
        ArrayList<Card> dealerHand = new ArrayList<Card>();
        ArrayList<Card> playerHand = new ArrayList<Card>();


        //main game loop
        do{
            //ask for the players bet
            System.out.println("Player Money: $" + player.getMoney());
            System.out.println("Amount to bet(-1 to quit): ");
            int bet = scanner.nextInt();


            //if the bet is less than 0 the player wants to quit break out
            if(bet < 0){
                break;
            }

            // draw initial hands
            playerHand.add(deck.drawCard());
            playerHand.add(deck.drawCard());

            dealerHand.add(deck.drawCard());
            dealerHand.add(deck.drawCard());

            int input;

            // Player loop
            do {
                //ask the player if they want another card
                System.out.println("cards: ");
                Deck.printHand(playerHand);
                System.out.println("player Total: " 
                + Deck.totalValue(playerHand));
                System.out.println("1 to hit anything else to hold");
                input = scanner.nextInt();

                //if the player wanted to draw a card add it to their hand
                if(input == 1){
                    playerHand.add(deck.drawCard());
                }
            }while(input == 1 && Deck.totalValue(playerHand) < 22);


            //Dealer loop
            //dealer hits until 17 or above
            while(Deck.totalValue(dealerHand) < 17){
                dealerHand.add(deck.drawCard());
            }

            //print out hands
            System.out.println("dealerHand: " + Deck.totalValue(dealerHand));
            Deck.printHand(dealerHand);
            System.out.println("playerHand: " + Deck.totalValue(playerHand));
            Deck.printHand(playerHand);


            //check who won and give or take money from player
            if(Deck.totalValue(playerHand) > Deck.totalValue(dealerHand)
            		&& Deck.totalValue(playerHand) < 22){
                System.out.println("player win");
                player.changeMoney(bet);
            }else if(Deck.totalValue(dealerHand) 
            		> 21 && Deck.totalValue(playerHand) < 22) {
                System.out.println("dealer bust");
                player.changeMoney(bet);
            }else {
                System.out.println("player lose");
                player.changeMoney(bet * -1);
            }

            //clear hands
            playerHand.clear();
            dealerHand.clear();

            //shuffle the deck
            deck.shuffle();

        }while(player.getMoney() > 0);
        scanner.close();
    }
}
