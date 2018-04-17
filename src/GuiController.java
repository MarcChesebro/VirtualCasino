import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
/**************************************************************** 
* Description: The Controller for the main gui screen.
* @author Marc Chesebro
*         Brendan Caywood
*         Patrick McMahon
* @version 4/14/18
****************************************************************/
public class GuiController implements Initializable {
	
	/*******************************************************
	 * Runs at runtime of the GUI.
	 * 
	 ******************************************************/
	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
	}
	/*******************************************************
	 * The actions of the blackjack button for the main GUI.
	 * 
	 ******************************************************/
	@FXML 
	private void blackjackButton() {
		MenuGUI.casino.blackjack();
		//TODO: the whole gui
	}
	/********************************************************
	 * The actions of the slot button for the main GUI.
	 *******************************************************/
	@FXML 
	private void slotButton() {
		MenuGUI.casino.slots();
		//TODO: Lets user go below 0, needs a "return" that comes back to the main menu
	}
	
	/********************************************************
	 * The actions of the refresh button for the main GUI.
	 *******************************************************/
	@FXML
	private void refreshButton() {
		//start();
	}
	
	/*******************************************************
	 * The actions of the refresh button for the main GUI.
	 ******************************************************/
	@FXML 
	private void rouButton() {
		MenuGUI.casino.roulette();
		//TODO: the whole gui
	}
	
	/*******************************************************
	 * The actions of the quit menu item for the main GUI.
	 ******************************************************/
	@FXML 
	private void quitMItem() {
		Platform.exit();
	}
}
