import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;
import java.lang.Thread;

/**************************************************
 * Description: The Controller for the roulette gui screen.
 * @author Brendan Caywood
 * @version 4/17/18
 *************************************************/
public class RouletteGUI implements Initializable{
	@FXML
	private TextField bettxt;
	
	final ToggleGroup g1 = new ToggleGroup();
	
	@FXML
	private TextField singlenumtxt;
	
	@FXML
	private RadioButton half1rb;
	
	@FXML
	private RadioButton half2rb;
	
	@FXML
	private RadioButton redrb;

	@FXML
	private RadioButton dozen1rb;

	@FXML
	private RadioButton blackrb;

	@FXML
	private RadioButton column3rb;

	@FXML
	private RadioButton column2rb;

	@FXML
	private RadioButton evenrb;

	@FXML
	private RadioButton dozen3rb;

	@FXML
	private RadioButton column1rb;

	@FXML
	private RadioButton dozen2rb;

	@FXML
	private RadioButton oddrb;

	@FXML
	private RadioButton singlenumrb;
	
	@FXML
	private Label spunNumber;
	
	@FXML
	private Label playermonlbl;
	
	private RouWheel rou = new RouWheel();
	private int bet = 0;
	private Random random = new Random();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		half1rb.setToggleGroup(g1);	
		half2rb.setToggleGroup(g1);
		blackrb.setToggleGroup(g1);
		redrb.setToggleGroup(g1);
		oddrb.setToggleGroup(g1);
		evenrb.setToggleGroup(g1);
		column1rb.setToggleGroup(g1);
		column2rb.setToggleGroup(g1);
		column3rb.setToggleGroup(g1);
		dozen1rb.setToggleGroup(g1);
		dozen2rb.setToggleGroup(g1);
		dozen3rb.setToggleGroup(g1);
		singlenumrb.setToggleGroup(g1);
		spunNumber.setText("spin!");
		g1.selectToggle(column1rb);
		playermonlbl.setText(
				String.valueOf(MenuGUI.casino
						.getPlayer().getMoney()));
	}
	
	@FXML 
	public void betButton() {
		int singlenum;
		try {	
			bet = Integer.parseInt(bettxt.getText());
		}catch (NumberFormatException e) {
			spunNumber.setText("Bet is not a number");
			return;
		}
		try {
			if(singlenumrb.isPressed()) {
				singlenum = Integer.parseInt(singlenumtxt.getText());
			}
		}catch (NumberFormatException e) {
			spunNumber.setText("desired number is not a number");
			return;
		}
		rou.spin();
		spunNumber.setText(String.valueOf(rou.getValue()));
		if(bet > 0 && MenuGUI.casino.getPlayer().getMoney() >= bet) {
			int multiplier;
			if(half1rb.isPressed()) {
				multiplier = rou.checkBet(12, 0);
			}else if(half2rb.isPressed()) {
				multiplier = rou.checkBet(13, 0);
			}else if(blackrb.isPressed()) {
				multiplier = rou.checkBet(8, 0);
			}else if(redrb.isPressed()) {
				multiplier = rou.checkBet(9, 0);
			}else if(oddrb.isPressed()) {
				multiplier = rou.checkBet(10, 0);
			}else if(evenrb.isPressed()) {
				multiplier = rou.checkBet(11, 0);
			}else if(column1rb.isPressed()) {
				multiplier = rou.checkBet(2, 0);
			}else if(column2rb.isPressed()) {
				multiplier = rou.checkBet(3, 0);
			}else if(column3rb.isPressed()) {
				multiplier = rou.checkBet(4, 0);
			}else if(dozen1rb.isPressed()) {
				multiplier = rou.checkBet(5, 0);
			}else if(dozen2rb.isPressed()) {
				multiplier = rou.checkBet(6, 0);
			}else if(dozen3rb.isPressed()) {
				multiplier = rou.checkBet(7, 0);
			}else {
				multiplier = rou.checkBet(1, singlenum);
			}
		}
		playermonlbl.setText(String.valueOf(MenuGUI.casino
						.getPlayer().getMoney()));
	}
	
	@FXML 
	public void exitButton() {
		MenuGUI.screenController.activate("main");
	}
	

}
