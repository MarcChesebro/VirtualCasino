import java.util.ArrayList;
import java.util.List;

public class RouWheel{
	private int bet;
	private List<Integer> blackNums = new ArrayList<Integer>();
	private List<Integer> redNums = new ArrayList<Integer>();
	private List<Integer> odds = new ArrayList<Integer>();
	private List<Integer> evens = new ArrayList<Integer>();
	
	
	for(int y = 1; y <= 36; y++) {
		if(y % 2 != 0) {
			odds.add(y);
		}else {
			evens.add(y);
		}
	}

	for(int x = 1; x <=36; x++) {
		int partitions = 1;
		if(partitions % 2 == 0) {
			if(x % 2 != 0) {
				redNums.add(x);
			}else {
				blackNums.add(x);
			}
		}
		if(x % 10 == 0) {
			partitions++;
		}
	}	
}


