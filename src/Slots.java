import java.util.Random;

/**
 * This is the game of slots, it allows you to create a slot game,
 * bet money and win/lose money.
 * @author Patrick McMahon
 * @date 4/18/2018
 */
public class Slots{

	private int numSlots;
	private int bet;
	private int[] slotsArray;
	private Player player;

        /**
         * This is the constructor for the Slots game play
         * creates the slots and bet values
         * @param givenPlayer a player object
         */
	public Slots(final Player givenPlayer){
		player = givenPlayer;
		numSlots = 3;
		bet = 0;
		int temp[] = new int[numSlots];
		for(int i = 0; i < numSlots; i++){
			temp[i] = 0;
		}
		slotsArray = temp;
	}
        
	/**
	* play will launch the slots GUI
	* @param player The user that is playing the game of slots.
	*/
	public static void play(final Player player){

		Slots curTurn = new Slots(player);
		slotGUI sgu = new slotGUI(curTurn);
		sgu.showWindow();
	}

        /**
         * getNumSlots returns the number of slots in the current game.
         * @return the number of slots in the game
         */
	public int getNumSlots(){
		return this.numSlots;
	}

        /**
         * getSlots returns an array containing the slots value
         * @return an array containing the slots
         */
	public int[] getSlots(){
		return this.slotsArray;
	}

        /**
         * getBet returns the players current bet amount.
         * @return bet - the players current bet amount
         */
	public int getBet(){
		return this.bet;
	}

        /**
         * getWallet returns the players wallet amount
         * @return the players wallet amount
         */
	public int getWallet(){
		return this.player.getMoney();
	}

        /**
         * setSlots will set the slots for the game play
         * @param givenSlots 
         */
	public void setSlots(int[] givenSlots){
		this.slotsArray = givenSlots;
	}

        /**
         * Sets the bet 
         * @param givenbet - the value to set bet to 
         */
	public void setBet(int givenBet){
		this.bet = givenBet;
	}

        /**
         * Randomizes the slots based on certain odds.
         * Tens - 20%
         * Jacks - 30%
         * Queens - 25%
         * Kings - 15%
         * Aces - 10% 
         */
	public void randomizeSlots(){

		for(int i = 0; i<this.numSlots; i++) {
			Random rand = new Random();
			int temp = rand.nextInt(100)+1;
			if(temp<20) {
				this.slotsArray[i] = 0;
			}else if(temp < 50 && temp >= 20) {
				this.slotsArray[i] = 1;
			}else if(temp < 75 && temp >= 50) {
				this.slotsArray[i] = 2;
			}else if(temp < 90 && temp >= 75) {
				this.slotsArray[i] = 3;
			}else if(temp <= 100 && temp >= 90) {
				this.slotsArray[i] = 4;
			}
		}
	}

	/**
	* Based on the current array of slots this will return the players winnings
	* and this will update the player wallet.
	* @return retVal - the amount of money that the player won/lost
	*/
	public int updateWallet(){
	
		//Used ace through ten, because they are easily recognizable.
		int ace=0;
		int king=0;
		int queen=0;
		int jack=0;
		int ten = 0;

		//The multiplyer based on winning a round.
		int multiplyer=0;

		for(int i = 0; i<this.numSlots; i++) {

			if(this.slotsArray[i] == 1) {
				ten++;
			}else if(this.slotsArray[i] == 2) {
				jack++;
			}else if(this.slotsArray[i] == 3) {
				queen++;
			}else if(this.slotsArray[i] == 4) {
				king++;
			}else if(this.slotsArray[i] == 5) {
				ace++;
			}
		}

		//determins the multiplyer for the return value.
		if(ace == this.numSlots){
			multiplyer = 5;
		} else if(king == this.numSlots){
			multiplyer = 4;	
		} else if(queen == this.numSlots){
			multiplyer = 3;	
		} else if(jack == this.numSlots){
			multiplyer = 2;	
		} else if(ten == this.numSlots){
			multiplyer = 1;	
		} else{
			multiplyer = 0;
		}

		int retVal = this.bet * multiplyer;
		retVal = retVal - this.bet;
		this.player.changeMoney(retVal);
		return retVal;

	}

	/** 
	* based on the amount of money the player won/lost
	* this method will return a string to output to the player
	*  @param playerMoney - the players winings/losings
	*  @return retVal - a string that will be outputted to the player
	*/
	public String winLose(int playerMoney){
		
            String retVal = "";
            if(playerMoney < this.bet){
                    retVal = "You Lost $"; 
            }else if (playerMoney == this.bet){
                    retVal = "You kept your $";
            }else if (playerMoney > this.bet){
                    retVal = "You won $";
            }

            return retVal;
	}

	/**
	* method to make sure the given bet is valid.
	* @param testBet - the bet to check for validity
	* @return boolean value based on if the bet is valid of not
	*/
	public Boolean checkBet(int testBet){

            if(testBet >= 1 && testBet <= player.getMoney()){
                    return true;
            }
            return false;
	}
}