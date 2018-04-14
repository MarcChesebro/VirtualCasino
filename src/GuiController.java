import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
public class GuiController extends MenuGUI implements Initializable {
	@FXML Button refreshButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	@FXML 
	private void blackjackButton() {
		casino.blackjack();
		//TODO: the whole gui
	}
	@FXML 
	private void slotButton() {
		casino.slots();
		//TODO: Lets user go below 0, needs a "return" that comes back to the main menu
	}
	@FXML
	private void refreshButton() {
		//start();
	}
	@FXML 
	private void rouButton() {
		casino.roulette();
		//TODO: the whole gui
	}
	@FXML 
	private void quitMItem() {
		Platform.exit();
	}
}
