import java.util.ArrayList;
import java.util.List;

public class RouWheel{
	private int bet;
	private List<Integer> blackNums = new ArrayList<Integer>();
	private List<Integer> redNums = new ArrayList<Integer>();
	private List<Integer> odds = new ArrayList<Integer>();
	private List<Integer> evens = new ArrayList<Integer>();
	private List<Integer> column1 = new ArrayList<Integer>();
	private List<Integer> column2 = new ArrayList<Integer>();
	private List<Integer> column3 = new ArrayList<Integer>();
	private List<Integer> dozen1 = new ArrayList<Integer>();
	private List<Integer> dozen2 = new ArrayList<Integer>();
	private List<Integer> dozen3 = new ArrayList<Integer>();
	private List<Integer> half1 = new ArrayList<Integer>();
	private List<Integer> half2 = new ArrayList<Integer>();
	private List<Integer> allNums = new ArrayList<Integer>();
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
		for(int x = 1; x <=36; x++) {
			int partitions = 1;
			if(partitions % 2 == 0) {
				if(x % 2 != 0) {
					redNums.add(x);
				}else {
					blackNums.add(x);
				}
			}else {
				if(x % 2 != 0) {
					blackNums.add(x);
				}else {
					redNums.add(x);
				}
			}
			if(x % 10 == 0) {
				partitions++;
			}
		}
		//sets up columns 
		for(int z = 1; z<=36; z++) {
			if(z % 3 == 0) {
				column3.add(z);
			}else if(z % 2 == 0) {
				column2.add(z);
			}else {
				column1.add(z);
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
		allNums.add(00);
	}
	public void printLists() {
		System.out.println(allNums);
		
	}
}


