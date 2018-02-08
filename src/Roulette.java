import java.util.ArrayList;

import java.util.Scanner;
public class Roulette {
	RouWheel wheel = new RouWheel();
	private static Scanner scanner;
	
		// have buttons call this with the player
		public static void play(Player player){
			scanner = new Scanner(System.in);
			do{
				System.out.println("Please select what type of bet to make: ");
				System.out.println("(Ex: 1:Single number, 2:column1, 3:column2, 4:column3");
				System.out.println(" 5:dozen1, 6:dozen2, 7:dozen3, 8:black, 9:red, 10:odd, 11:even, 12:half1, 13:half2");
				int betType = scanner.nextInt();
				
				
			}while(true);
		}
	}