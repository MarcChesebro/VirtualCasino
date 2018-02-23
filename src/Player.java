public class Player {

    private int money;

    public Player(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //use this to add or remove money
    public void changeMoney(int change) {
        this.money += change;
    }
}
