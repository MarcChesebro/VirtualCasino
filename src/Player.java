/**
 * Represents the player of the game.
 *
 * @author Marc Chesebro
 * @version 2/23/2018
 */
public class Player {

    /** current amount of money the player has. */
    private int money;

    /**
     * Constructor that take the amount of money the player starts with.
     * @param int money amount of money the player starts with.
     */
    public Player(int money) {
        this.money = money;
    }

    /**
     * get the amount of money the player currently has.
     * @return the amount of money the player has as an int.
     */
    public int getMoney() {
        return money;
    }

    /**
     * set the amount of money the player currently has.
     * @param int money the amount of money to set the player to.
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Function for changing the amount of money a player has.
     * can accept negative numbers to remove Money
     * @param int change amount to change.
     */
    public void changeMoney(int change){
        this.money += change;
    }
}
