package virtualcasino;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*****************************************
 * Roulette Table for Virtual Casino.
 * @author Brendan Caywood
 * @version 2/23/18
 ****************************************/
public class RouWheel {
	/**collection of lists used to represent the roulette table*/ 
	/**Black numbers on a roulette table.*/
	private List<Integer> blackNums = new ArrayList<Integer>();
	/**Red numbers on the roulette table.*/
	private List<Integer> redNums = new ArrayList<Integer>();
	/**Odd numbers on the roulette table.*/
	private List<Integer> odds = new ArrayList<Integer>();
	/**Even Numbers on the roulette table.*/
	private List<Integer> evens = new ArrayList<Integer>();
	/**The first(left) column on the roulette table.*/
	private List<Integer> column1 = new ArrayList<Integer>();
	/**The second(middle) column on the roulette table.*/
	private List<Integer> column2 = new ArrayList<Integer>();
	/**The Third (right) column on the roulette table.*/
	private List<Integer> column3 = new ArrayList<Integer>();
	/** first dozen numbers(1-12).*/
	private List<Integer> dozen1 = new ArrayList<Integer>();
	/** Second dozen numbers(13-24).*/
	private List<Integer> dozen2 = new ArrayList<Integer>();
	/** Third Dozen Numbers (25-36).*/
	private List<Integer> dozen3 = new ArrayList<Integer>();
	/** First half of the numbers (1-18).*/
	private List<Integer> half1 = new ArrayList<Integer>();
	/** Second half of the numbers (2-36).*/
	private List<Integer> half2 = new ArrayList<Integer>();
	/**All numbers on the roulette table.*/
	private List<Integer> allNums = new ArrayList<Integer>();
	/**Current value of the roulette table.*/
	private int value;
	/**used to make a random number.*/
	private Random rand = new Random();
	/*****************************************
	 * constructor for roulette wheel.
	 ****************************************/
	public RouWheel() {
		//sets up odds/evens
		for(int y = 1; y <= 36; y++) {
			if(y % 2 != 0) {
				odds.add(y);
			}else {
				evens.add(y);
			}
		}
		//sets up red/black numbers
		int partitions = 1;
		for(int x = 1; x <=36; x++) {
			if(partitions % 2 == 0) {
				if(x % 2 != 0) {
					blackNums.add(x);
				}else {
					redNums.add(x);
				}
			}else {
				if(x % 2 != 0) {
					redNums.add(x);
				}else {
					blackNums.add(x);
				}
			}
			if(x == 10 || x == 18 || x == 28) {
				partitions++;
			}
		}
		//sets up columns 
		int count = 0;
		for(int z = 1; z<=36; z++) {
			if(count == 2) {
				column3.add(z);
			}else if(count == 1) {
				column2.add(z);
			}else {
				column1.add(z);
			}
			count++;
			if(count == 3) {
				count = 0;
			}
		}
		//sets up dozens
		for(int dozen = 1; dozen <= 36; dozen++) {
			if(dozen <= 12) {
				dozen1.add(dozen);
			}else if(dozen <= 24) {
				dozen2.add(dozen);
			}else {
				dozen3.add(dozen);
			}
		}
		//sets up halves 
		for(int halves = 1; halves <= 36; halves++) {
			if(halves <= 18) {
				half1.add(halves);
			}else {
				half2.add(halves);
			}
		}
		//sets up all numbers
		for(int num = 0; num <= 36; num++) {
			allNums.add(num);
		}
		//37 is placeholder for 00
		allNums.add(37);
	}
	/********************************
	 * "spins the roulette board".
	 * Generates a random int between
	 * 0-37 (37 being 00).
	 *******************************/
	public void spin() {
		value = rand.nextInt(38);
	}
	/*******************************
	 * gets the value of board.
	 * @return value of board
	 *****************************/
	public int getValue() {
		return value;
	}
	/*******************************
	 * sets the value of board.
	 * @param newVal desired value for value
	 *****************************/
	public void setValue(final int newVal) {
		value = newVal;
	}
	/**************************************************
	 * checks the given bet type and returns multiplier.
	 * @param type the type of bet (outlined in gui)
	 * @param num the number desired in a single number bet
	 * @return returns multiplier to multiply the bet by
	 *************************************************/
	public int checkBet(final int type, final int num) {
		if(type == 1) {
			if(value == num) {
				return 35;
			}
			return 0;
		}else if(type == 2) {
			if(column1.contains(value)) {
				return 2;
			}
			return 0;
		}else if(type == 3) {
			if(column2.contains(value)) {
				return 2;
			}
			return 0;
		}else if(type == 4) {
			if(column3.contains(value)) {
				return 2;
			}
			return 0;
		}else if(type == 5) {
			if(dozen1.contains(value)) {
				return 2;
			}
			return 0;
		}else if(type == 6) {
			if(dozen2.contains(value)) {
				return 2;
			}
			return 0;
		}else if(type == 7) {
			if(dozen3.contains(value)) {
				return 2;
			}
			return 0;
		}else if(type == 8) {
			if(blackNums.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 9) {
			if(redNums.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 10) {
			if(odds.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 11) {
			if(evens.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 12) {
			if(half1.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 13) {
			if(half2.contains(value)) {
				return 1;
			}
			return 0;
		}else {
			System.out.println("Invalid bet type");
			return 0;
		}
	}

	/***************************************************
	 * checks color of number.
	 * @return the color (0 = red, 1 = black, 2=green)
	 **************************************************/
	public int getColor() {
		if(redNums.contains(value)) {
			return 0;
		}else if(blackNums.contains(value)) {
			return 1; 
		}else {
			return 2;
		}
	}
}
	


