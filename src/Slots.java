import java.util.Scanner;
import java.util.Random;


/* *************************************************************** /
/ Description: The class that contains all of the information on how to
			   play the game of slots.
/ @author Patrick McMahon
/ @Version 2/23/18
/ *************************************************************** */
public class Slots{

	//The number of slots being used in the game
	public static final int NUMSLOTS=3;

	/* *************************************************************** /
	/ Description: Will accept user input and run the game of slots
				   accordingly
	/ @param player: The user that is playing the game of slots 
	/ *************************************************************** */
	public static void play(Player player){

		//Scanenr object used to read in user input
		Scanner scanner = new Scanner(System.in);

		//used to keep track of the users desired move.
		int options=1;

		//This will run the game of slots until the user enters 0.
		while(options != 0){

			System.out.println("=======================");
			System.out.println("Enter '1' to place bet.");
			System.out.println("Enter '2' to view credit");
			System.out.println("Enter '0' to quit.");
			System.out.print("Input: ");
			options=scanner.nextInt();

			//If the user wants to place a bet
			if(options == 1)  {

				System.out.print("Place bet: ");

				//The users desired bet
				int bet = scanner.nextInt();

				//Check to make sure bet is valid
				if(bet>player.getMoney() || bet<0){
					System.out.println("Bet invalid.");
					System.out.println("Current balance: "+
						player.getMoney());
					continue;
				}

				System.out.println("=======================");
				
				//pull the lever and return the total gains
				int gains = pullLever(bet);
				gains = gains - bet;

				//send changeMoney the total net gains
				player.changeMoney(gains);


			//If the user wants to see their balance
			}else if(options == 2){
				System.out.println("Money: "+player.getMoney());
			}
			else
				return;
		}
		return;
	}


	/* *************************************************************** /
	/ Description: Just creates a random number, useful for 
	/				future features
	/ @return random integer between 1 and 100
	/ *************************************************************** */
	public static int oneSlot(){
		Random rand = new Random();
		return (rand.nextInt(100)+1);
	}

	/* *************************************************************** /
	/ Description: Will run the slots and controls the output. 
	/ @param bet: The original bet
	/ @return retVal: The amount of money won
	/ *************************************************************** */
	public static int pullLever(int bet){

		int indivSlots[] = new int[NUMSLOTS]; 
		
		//Used ace through ten, because they are easily recognizable.
		int ace=0;
		int king=0;
		int queen=0;
		int jack=0;
		int ten = 0;

		//The multiplyer based on winning a round.
		double winner=0.0;

		//makes the slots array
		//prints the output
		//counts the number of each option
		for(int i = 0; i<NUMSLOTS; i++) {
			
			int temp = oneSlot();
			if(temp<40) {
				System.out.print(" Ace ");
				indivSlots[i] = 1;
				ace++;
			}else if(temp < 65 && temp >= 40) {
				System.out.print(" King ");
				indivSlots[i] = 2;
				king++;
			}else if(temp < 85 && temp >= 65) {
				System.out.print(" Queen ");
				indivSlots[i] = 3;
				queen++;
			}else if(temp < 95 && temp >= 85) {
				System.out.print(" Jack ");
				indivSlots[i] = 4;
				jack++;
			}else if(temp <= 100 && temp >= 95) {
				System.out.print(" Ten ");
				indivSlots[i] = 5;
				ten++;
			}
		}

		System.out.println("\n");

		//determins the multiplyer for the return value
		if(ace == NUMSLOTS)
			winner = 5.0;
		else if(king == NUMSLOTS)
			winner = 1.5;	
		else if(queen == NUMSLOTS)
			winner = 1.2;	
		else if(jack == NUMSLOTS)
			winner = 1.1;	
		else if(ten == NUMSLOTS)
			winner = 1;	
		else
			winner = 0;

		int retVal = bet * (int)winner;

		//Output to let the user know the outcome
		if(winner>0)
			System.out.println(" You Won $"+retVal);
		else
			System.out.println(" You Lose.");

		return retVal;
	}
}