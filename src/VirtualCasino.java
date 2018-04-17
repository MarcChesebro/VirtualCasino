import java.awt.*;
import java.util.Scanner;

/**************************************************************** 
* Description: The main class in the Virtual Casino program.
* @author Marc Chesebro
*         Brendan Caywood
*         Patrick McMahon
* @version 2/23/18
****************************************************************/
public class VirtualCasino {

	/**instance variable for player.*/
	private Player player;

	/**instance variable for blackjack.*/
	private Blackjack blackjack;


	/*********************************
	 * constructor for virtual casino.
	 ********************************/
	public VirtualCasino() {
		//initialize player with $100.
		player = new Player(100);
	}

	public Blackjack getBlackjack() {
		return blackjack;
	}

	public Player getPlayer() {
		return player;
	}

	/*********************************
	 * calls blackjack's play method.
	 ********************************/
	public void blackjack() {
		this.blackjack = new Blackjack();
		MenuGUI.screenController.activate("blackjack");
	}
	
	/***********************************
	 * calls roulette's play method.
	 **********************************/
	public void roulette() {
		Roulette.play(player);
	}
	
	/**********************************
	 * calls slots' play method.
	 *********************************/
	public void slots() {
		Slots.play(player);
	}
    /**************************************************************** 
    * Description: The function that runs the entire virtual casino 
    *              program.
    * @param args The input that the program is ran with.
    **************************************************************** */
    public static void main(final String[] args) {
    	
        //Initialize player with $100.
    	Player player = new Player(100);
    	//scanner to ask what game.
    	Scanner scanner = new Scanner(System.in, "utf-8");

        //Varable used to check loop.
        int x;

        //Runs the menu until the player decides to exit.
        do{
        	//Menu to display for the user.
        	System.out.println("Please choose a game:");
        	System.out.println("'1' for roulette");
        	System.out.println("'2' for blackjack");
            System.out.println("'3' for slots");
            System.out.println("'4' for player options");
            System.out.println("'0' to exit");
            System.out.print("Input: ");

            //Make sure the input is a number
            while (!scanner.hasNextInt()) {
                System.out.println("Try again");
                System.out.print("Input: ");
                scanner.next();
            }
            
            x = scanner.nextInt();
            //Loop to parse user input.
        	if(x == 1) {
        		Roulette.play(player);
        	}else if (x == 2){
        		//Blackjack.play(player);
        	}else if(x == 3){
        		Slots.play(player);
        	}else if(x == 4){
                //This will be a function in a later release.
                //Add more money for the player.
        		System.out.println("enter '1' to add money"
        				+ ", '0' to exit");
        		System.out.print("Input: ");
        		int playerOptionsInput = scanner.nextInt();
        		if(playerOptionsInput == 1){
        			System.out.print("how much?: ");
        			int moreMoneyMoreProblems = scanner.nextInt();
        			player.changeMoney(moreMoneyMoreProblems);
        			System.out.println("New balance: "
        			+player.getMoney());
        		}
        	}
        }while(x != 0);
    }
}

