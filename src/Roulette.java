import java.util.ArrayList;

import java.util.Scanner;
public class Roulette {

	private static Scanner scanner;
	
		// have buttons call this with the player
		public static void play(Player player){
			RouWheel wheel = new RouWheel();
			scanner = new Scanner(System.in);
			do{
				System.out.println("Please select what type of bet to make: ");
				System.out.println("(Ex: 1:Single number, 2:column1, 3:column2, 4:column3");
				System.out.println(" 5:dozen1, 6:dozen2, 7:dozen3, 8:black, 9:red, 10:odd, 11:even, 12:half1, 13:half2");
				int betType = scanner.nextInt();
				System.out.println("please enter bet amount:");
				int betAmount = scanner.nextInt();
				int multiplier = wheel.checkBet(betType);
				if(multiplier == 0) {
					player.changeMoney(betAmount * -1);
				}else {
					betAmount = betAmount*multiplier;
					player.changeMoney(betAmount);
				}
				
			}while(true);
		}
	}