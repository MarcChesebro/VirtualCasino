import java.util.Scanner;
// import java.util.ArrayList;
import java.util.Random;

public class Slots{

	public static final int NUMSLOTS=3;

	public static void play(Player player){

		Scanner scanner = new Scanner(System.in);

		int options=1;

		while(options != 0){

			System.out.println("=======================");
			System.out.println("Enter '1' to place bet.\nEnter '2' to view credit");
			System.out.println("Enter '0' to quit.");
			System.out.print("Input: ");
			options=scanner.nextInt();

			//If the user wants to place a bet
			if(options == 1){

				System.out.print("Place bet: ");
				int bet = scanner.nextInt();

				if(bet>player.getMoney()){
					System.out.println("Insuficient funds. Bet invalid.\nCurrent balance: "+player.getMoney());
					continue;
				}
				System.out.println("=======================");
				int gains = pullLever(bet);
				gains = gains - bet;
				player.changeMoney(gains);
			}else if(options == 2){
				System.out.println("Money: "+player.getMoney());
			}
			else
				return;
		}
		return;
	}

	public static int oneSlot(){
		Random rand = new Random();
		return (rand.nextInt(100)+1);
	}

	public static int pullLever(int bet){

		int indivSlots[] = new int[NUMSLOTS]; 
		
		int ace=0, king=0, queen=0, jack=0, ten = 0;
		double winner=0.0;

		for(int i = 0; i<NUMSLOTS; i++){
			
			int temp = oneSlot();
			if(temp<40){
				System.out.print(" Ace ");
				indivSlots[i] = 1;
				ace++;
			}else if(temp < 65 && temp >= 40){
				System.out.print(" King ");
				indivSlots[i] = 2;
				king++;
			}else if(temp < 85 && temp >= 65){
				System.out.print(" Queen ");
				indivSlots[i] = 3;
				queen++;
			}else if(temp < 95 && temp >= 85){
				System.out.print(" Jack ");
				indivSlots[i] = 4;
				jack++;
			}else if(temp <= 100 && temp >= 95){
				System.out.print(" Ten ");
				indivSlots[i] = 5;
				ten++;
			}
		}

		System.out.println("");

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

		return bet * (int)winner;
	}
}