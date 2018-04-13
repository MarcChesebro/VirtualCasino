import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
public class GuiController extends VirtualCasino implements Initializable {
	@FXML Button refreshButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//casino.start();
	}
	@FXML 
	private void blackjackButton() {
		blackjack();
	}
	@FXML 
	private void slotButton() {
		slots();
	}
	@FXML
	private void refreshButton() {
		//start();
	}
	@FXML 
	private void rouButton() {
		roulette();
	}
	@FXML 
	private void quitMItem() {
		Platform.exit();
	}
}
