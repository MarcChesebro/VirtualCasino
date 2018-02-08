/*****************************************
 * Roulette Table for Virtual Casino
 * @author Brendan Caywood
 ****************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouWheel{
	/**collection of lists used to represent the roulette table*/ 
	//handles the black and red colored spots
	private List<Integer> blackNums = new ArrayList<Integer>();
	private List<Integer> redNums = new ArrayList<Integer>();
	//handles odd numbers and even numbers
	private List<Integer> odds = new ArrayList<Integer>();
	private List<Integer> evens = new ArrayList<Integer>();
	//handles the columns
	private List<Integer> column1 = new ArrayList<Integer>();
	private List<Integer> column2 = new ArrayList<Integer>();
	private List<Integer> column3 = new ArrayList<Integer>();
	//handles each dozen of numbers
	private List<Integer> dozen1 = new ArrayList<Integer>();
	private List<Integer> dozen2 = new ArrayList<Integer>();
	private List<Integer> dozen3 = new ArrayList<Integer>();
	//handles each half of numbers
	private List<Integer> half1 = new ArrayList<Integer>();
	private List<Integer> half2 = new ArrayList<Integer>();
	//holds all the roulette numbers
	private List<Integer> allNums = new ArrayList<Integer>();
	//hold current value of wheel
	private int value;
	//random number helper
	private Random rand;
	/*****************************************
	 * constructor for roulette wheel
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
			}else{
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
	 * "spins the roulette board"
	 * Generates a random int between
	 * 0-37 (37 being 00)
	 *******************************/
	public void spin() {
		value = rand.nextInt(38);
	}
	public int checkBet(int type, int bet) {
		if(type == 1) {
			if(value == bet) {
				return 1;
			}
			return 0;
		}else if(type == 2) {
			if(column1.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 3) {
			if(column2.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 4) {
			if(column3.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 5) {
			if(dozen1.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 6) {
			if(dozen2.contains(value)) {
				return 1;
			}
			return 0;
		}else if(type == 7) {
			if(dozen3.contains(value)) {
				return 1;
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
		}
		return 0;
	}
}
	


