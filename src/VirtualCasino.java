
import java.util.ArrayList;

import java.util.Scanner;

public class VirtualCasino {

    public static void main(String[] args) {
    	// create player with $100
    	Player player = new Player(100);
    	//scanner to ask what game
    	Scanner scanner = new Scanner(System.in);


    	//Have buttons call
    	System.out.println("Please choose a game:");
    	System.out.println("'1' for roulette, '2' for blackjack, '3' for slots, '4' for player options, '0' to exit.");
    	System.out.print("Input: ");
    	int x = scanner.nextInt();
		//Blackjack.play(player);
    	if(x == 1) {
    		Roulette.play(player);
    	}else if (x == 2){
    		Blackjack.play(player);
    	}else if(x == 3){
    		Slots.play(player);
    	}else if(x == 4){
    		System.out.println("enter '1' to add money, '0' to exit")
    		System.out.print("Input: ");
    		int playerOptionsInput = scanner.nextInt();
    		if(playerOptionsInput == 1){
    			System.out.print("how much?: ");
    			int moreMoneyMoreProblems = scanner.nextInt();
    			player.changeMoney(moreMoneyMoreProblems);
    			System.out.println("New balance: "+player.getMoney());
    		}

    	}
    }

    public static class Blackjack {

		// have buttons call this with the player
		public static void play(Player player){

			Scanner scanner = new Scanner(System.in);
			Deck deck = new Deck();
			ArrayList<Card> dealerHand = new ArrayList<Card>();
			ArrayList<Card> playerHand = new ArrayList<Card>();
			do{

				//ask for the players bet
				System.out.println("Player Money: $" + player.getMoney());
				System.out.println("Amount to bet(-1 to quit): ");
				int bet = scanner.nextInt();

				if(bet < 0){
					break;
				}

				// draw initial hands
				playerHand.add(deck.drawCard());
				playerHand.add(deck.drawCard());

				dealerHand.add(deck.drawCard());
				dealerHand.add(deck.drawCard());

				int input;

				do {
					System.out.println("cards: ");
					Deck.printHand(playerHand);
					System.out.println("player Total: " + Deck.totalValue(playerHand));
					System.out.println("1 to hit anything else to hold");
					input = scanner.nextInt();
					if(input == 1){
						playerHand.add(deck.drawCard());
					}
				}while(input == 1 && Deck.totalValue(playerHand) < 22);

				while(Deck.totalValue(dealerHand) < 17){
					dealerHand.add(deck.drawCard());
				}

				System.out.println("dealerHand: " + Deck.totalValue(dealerHand));
				Deck.printHand(dealerHand);
				System.out.println("playerHand: " + Deck.totalValue(playerHand));
				Deck.printHand(playerHand);

				if(Deck.totalValue(playerHand) > Deck.totalValue(dealerHand) && Deck.totalValue(playerHand) < 22){
					System.out.println("player win");
					player.changeMoney(bet);
				}else if(Deck.totalValue(dealerHand) > 21 && Deck.totalValue(playerHand) < 22){
					System.out.println("dealer bust");
					player.changeMoney(bet);
				}else{
					System.out.println("player lose");
					player.changeMoney(bet * -1);
				}

				playerHand.clear();
				dealerHand.clear();

				deck.shuffle();

			}while(player.getMoney() > 0);

		}
	}
}

