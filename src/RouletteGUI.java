import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

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
	
	private RouWheel rou = new RouWheel();
	private int bet = 0;
	
	
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
	}
	
	@FXML 
	public void betButton() {
	}
	
	@FXML 
	public void exitButton() {
		MenuGUI.screenController.activate("main");
	}
	

}
