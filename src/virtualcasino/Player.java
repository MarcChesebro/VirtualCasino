package virtualcasino;

/**
 * Description: Represents the player of the game.
 *
 * @author Marc Chesebro
 * @version 2/23/2018
 */
public class Player {

    /** current amount of money the player has. */
    private int money;

    /** current name of the player. */
    private String name;

    /**
     * Constructor that take the amount of money the player starts with.
     * @param money amount of money the player starts with.
     * @param name name of the player
     */
    public Player(final int money, final String name) {
        this.money = money;
        this.name = name;
    }

    /**
     * get the name of the player.
     * @return name of the player.
     */
    public String getName() {
        return name;
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
     * @param money the amount of money to set the player to.
     */
    public void setMoney(final int money) {
        this.money = money;
    }

    /**
     * Function for changing the amount of money a player has.
     * can accept negative numbers to remove Money
     * @param change amount to change.
     */
    public void changeMoney(final int change){
        this.money += change;
    }
}
