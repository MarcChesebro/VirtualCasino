import java.util.Random;

public class Slots{

	private int num_slots;
	private int bet;
	private int[] slots_arr;
	private Player player;

	public Slots(Player g_player){
		player = g_player;
		num_slots = 3;
		bet = 0;
		int temp[] = new int[num_slots];
		for(int i = 0; i < num_slots; i++){
			temp[i] = 0;
		}

		slots_arr = temp;

	}
	/****************************************************************
	* Description: stuff
	* @param player The user that is playing the game of slots.
	*****************************************************************/
	public static void play(final Player player){

		Slots curTurn = new Slots(player);
		slotGUI sgu = new slotGUI(curTurn);
		sgu.showWindow();
	}

	public int get_num_slots(){
		return this.num_slots;
	}

	public int[] get_slots(){
		return this.slots_arr;
	}

	public int get_bet(){
		return this.bet;
	}

	public int get_wallet(){
		return this.player.getMoney();
	}

	public void set_num_slots(int g_num_slots){
		this.num_slots = g_num_slots;
	}

	public void set_slots(int[] g_slots){
		this.slots_arr = g_slots;
	}

	public void set_slots(){
		for(int i = 0; i < this.num_slots; i++){
			this.slots_arr[i] = 0;
		}
	}

	public void set_bet(int g_bet){
		this.bet = g_bet;
	}

	public void randomize_slots(){

		for(int i = 0; i<this.num_slots; i++) {
			Random rand = new Random();
			int temp = rand.nextInt(100)+1;
			if(temp<30) {
				this.slots_arr[i] = 0;
			}else if(temp < 55 && temp >= 30) {
				this.slots_arr[i] = 1;
			}else if(temp < 75 && temp >= 55) {
				this.slots_arr[i] = 2;
			}else if(temp < 90 && temp >= 75) {
				this.slots_arr[i] = 3;
			}else if(temp <= 100 && temp >= 90) {
				this.slots_arr[i] = 4;
			}
		}
	}

	public int update_wallet(){
	
		//Used ace through ten, because they are easily recognizable.
		int ace=0;
		int king=0;
		int queen=0;
		int jack=0;
		int ten = 0;

		//The multiplyer based on winning a round.
		int multiplyer=0;

		for(int i = 0; i<this.num_slots; i++) {

			if(this.slots_arr[i] == 1) {
				ten++;
			}else if(this.slots_arr[i] == 2) {
				jack++;
			}else if(this.slots_arr[i] == 3) {
				queen++;
			}else if(this.slots_arr[i] == 4) {
				king++;
			}else if(this.slots_arr[i] == 5) {
				ace++;
			}
		}

		//determins the multiplyer for the return value.
		if(ace == this.num_slots){
			multiplyer = 5;
		} else if(king == this.num_slots){
			multiplyer = 4;	
		} else if(queen == this.num_slots){
			multiplyer = 3;	
		} else if(jack == this.num_slots){
			multiplyer = 2;	
		} else if(ten == this.num_slots){
			multiplyer = 1;	
		} else{
			multiplyer = 0;
		}

		int retVal = this.bet * multiplyer;
		retVal = retVal - this.bet;
		this.player.changeMoney(retVal);
		return retVal;

	}

	//Output to let the user know the outcome.
	public String win_lose(int x){
		String retVal = "";

		if(x < this.bet){
			retVal = "You Lost $"; 
		}else if (x == this.bet){
			retVal = "You kept your $";
		}else if (x > this.bet){
			retVal = "You won $";
		}

		return retVal;
	}

	//method to make sure the given bet is valid.
	public Boolean check_bet(int testBet){

		if(testBet >= 1 && testBet <= player.getMoney()){
			return true;
		}

		return false;
	}
}