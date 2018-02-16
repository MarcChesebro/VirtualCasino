import java.util.Scanner;
// import java.util.ArrayList;
import java.util.Random;

public class Slots{

	public static void play(Player play){

		Scanner scanner = new Scanner(System.in);

		do{
			System.out.print("Place bet: ");
			int bet = scanner.nextInt();

			//check bet if bad, exit

			int gains = pullLever(bet);

			player.changeMoney(gains);

		}while(Player.getMoney()>0);
		return;
	}

	public int oneSlot(){
		Random rand = new Random();

		return (rand.nextInt(100)+1);
	}

	public int pullLever(int bet){

		//make array of slots
		//initialize each element
		//check the value
		//if you win multiply the bet by the winnings and send (winnings - bet) back
		//if you lose send the bet back negative


	}
}