
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
    	if(x == 1) {

    		Roulette.play(player);
    	}else if (x == 2){
    		Blackjack.play(player);
    	}else if(x == 3){
    		Slots.play(player);
    	}else if(x == 4){
    		System.out.println("enter '1' to add money, '0' to exit");
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
}

