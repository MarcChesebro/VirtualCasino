package virtualcasino;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;

/**************************************************
 * Description: The Controller for the roulette gui screen.
 * @author Brendan Caywood
 * @version 4/17/18
 *************************************************/
public class RouletteGUI implements Initializable{
	
	/**bet text field.*/
	@FXML
	private TextField bettxt;
	
	/**the toggle group for the radio buttons.*/
	private final ToggleGroup g1 = new ToggleGroup();
	
	/**the text field for the single number.*/
	@FXML
	private TextField singlenumtxt;
	
	/**the radio button for the first half of numbers.*/
	@FXML
	private RadioButton half1rb;
	
	/**the radio button for the second half of numbers.*/
	@FXML
	private RadioButton half2rb;
	
	/**the radio button for the red numbers.*/
	@FXML
	private RadioButton redrb;

	/**the radio button for the first dozen numbers.*/
	@FXML
	private RadioButton dozen1rb;

	/**the radio button for the black numbers.*/
	@FXML
	private RadioButton blackrb;

	/**the radio button for the third column.*/
	@FXML
	private RadioButton column3rb;

	/**the radio button for the second column.*/
	@FXML
	private RadioButton column2rb;

	/**the radio button for the even numbers.*/
	@FXML
	private RadioButton evenrb;

	/**the radio button for the third dozen numbers.*/
	@FXML
	private RadioButton dozen3rb;
	
	/**the radio button for the first column of numbers.*/
	@FXML
	private RadioButton column1rb;

	/**the radio button for the second dozen numbers.*/
	@FXML
	private RadioButton dozen2rb;

	/**the radio button for the odd numbers.*/
	@FXML
	private RadioButton oddrb;

	/**the radio button for the single numbers.*/
	@FXML
	private RadioButton singlenumrb;
	
	/**the label for the spun numbers.*/
	@FXML
	private Label spunNumber;
	
	/**the label for the player money.*/
	@FXML
	private Label playermonlbl;
	
	/**the image view for roulette board.*/
	@FXML
	private ImageView boardimg;
	
	/**The roulette wheel object.*/
	private RouWheel rou = new RouWheel();
	
	/**The int that holds the players bet.*/
	private int bet = 0;
		
	/*******************************************************
	 * Runs at runtime of the GUI.
	 * 
	 ******************************************************/
	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
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
				String.valueOf(MenuGUI.getCasino()
						.getPlayer().getMoney()));
		File image = new File("images/table.jpg");
        String path = image.toURI().toString();
        boardimg.setImage(new Image(path));
	}
	
	/***************************************
	 * runs when the bet button is pressed.
	 **************************************/
	@FXML 
	public void betButton() {
		int singlenum = 0;
		try {	
			bet = Integer.parseInt(bettxt.getText());
		}catch (NumberFormatException e) {
			spunNumber.setText("Bet is not a number");
			spunNumber.setTextFill(Color.web("#FF0000"));
			return;
		}
		try {
			if(g1.getSelectedToggle() == singlenumrb) {
				singlenum = Integer.parseInt(singlenumtxt
						.getText());
			}
		}catch (NumberFormatException e) {
			spunNumber.setText("desired number is not a number");
			spunNumber.setTextFill(Color.web("#FF0000"));
			return;
		}
		rou.spin();
		if(rou.getValue() == 37) {
			spunNumber.setText("00");
		}
		spunNumber.setText(String.valueOf(rou.getValue()));
		if(rou.getColor() == 0) {
			spunNumber.setTextFill(Color.web("#FF0000"));
		}else if(rou.getColor() == 1) {
			spunNumber.setTextFill(Color.web("#000000"));
		}else if(rou.getColor() == 2) {
			spunNumber.setTextFill(Color.web("#00FF00"));
		}
		if(bet > 0 && MenuGUI.getCasino()
				.getPlayer().getMoney() >= bet) {
			int multiplier;
			if(g1.getSelectedToggle() == half1rb) {
				multiplier = rou.checkBet(12, 0);
			}else if(g1.getSelectedToggle() == half2rb) {
				multiplier = rou.checkBet(13, 0);
			}else if(g1.getSelectedToggle() == blackrb) {
				multiplier = rou.checkBet(8, 0);
			}else if(g1.getSelectedToggle() == redrb) {
				multiplier = rou.checkBet(9, 0);
			}else if(g1.getSelectedToggle() == oddrb) {
				multiplier = rou.checkBet(10, 0);
			}else if(g1.getSelectedToggle() == evenrb) {
				multiplier = rou.checkBet(11, 0);
			}else if(g1.getSelectedToggle() == column1rb) {
				multiplier = rou.checkBet(2, 0);
			}else if(g1.getSelectedToggle() == column2rb) {
				multiplier = rou.checkBet(3, 0);
			}else if(g1.getSelectedToggle() == column3rb) {
				multiplier = rou.checkBet(4, 0);
			}else if(g1.getSelectedToggle() == dozen1rb) {
				multiplier = rou.checkBet(5, 0);
			}else if(g1.getSelectedToggle() == dozen2rb) {
				multiplier = rou.checkBet(6, 0);
			}else if(g1.getSelectedToggle() == dozen3rb) {
				multiplier = rou.checkBet(7, 0);
			}else {
				multiplier = rou.checkBet(1, singlenum);
			}
			if(multiplier == 0) {
				MenuGUI.getCasino().getPlayer()
				.changeMoney(bet * -1);
			}else {
				MenuGUI.getCasino().getPlayer()
				.changeMoney(bet * multiplier);
			}
		}
		playermonlbl.setText(String.valueOf(MenuGUI.getCasino()
						.getPlayer().getMoney()));
	}
	
	/*****************************************************
	 * Runs when the exit button is pressed.
	 ****************************************************/
	@FXML 
	public void exitButton() {
		MenuGUI.getScreenController().activate("main");
	}
	
	/***********************************************
	 * returns the togglegroup.
	 * @return the togglegroup
	 **********************************************/
	public ToggleGroup getGroup() {
		return g1;
	}
}
