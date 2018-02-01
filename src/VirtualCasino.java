import javax.swing.*;

import java.awt.*; 

import java.awt.event.*; 

public class VirtualCasino {

    public static void main(String[] args) {
    	// create player with $100
    	Player player = new Player(100);

    	MenuGUI window = new MenuGUI("Virtual Casino");
    	window.setVisible(true);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	//Have buttons call
		//BlackJack.play(player);
    }

    public static class Blackjack {

    	// have buttons call this with the player
    	public static void play(Player player){

    		do{
    			//play the game
			}while(true);

		}
	}
}

