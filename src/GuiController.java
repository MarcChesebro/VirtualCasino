                      import java.io.*;
					  import java.net.URL;
					  import java.util.Optional;
					  import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
					  import javafx.scene.control.*;
					  import javafx.stage.FileChooser;
					  import javafx.stage.Stage;

					  import javax.swing.filechooser.FileNameExtensionFilter;

					  /****************************************************************
* Description: The Controller for the main gui screen.
* @author Marc Chesebro
*         Brendan Caywood
*         Patrick McMahon
* @version 4/14/18
****************************************************************/
public class GuiController implements Initializable {

	@FXML
	private Label currentUser;

	/*******************************************************
	 * Runs at runtime of the GUI.
	 * 
	 ******************************************************/
	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
		currentUser.setText(MenuGUI.casino.getPlayer().getName());
	}

	/*******************************************************
	 * The actions of the blackjack button for the main GUI.
	 * 
	 ******************************************************/
	@FXML 
	private void blackjackButton() {
		MenuGUI.casino.blackjack();
		currentUser.setText(MenuGUI.casino.getPlayer().getName());
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
	}

	@FXML
	private void changeUserAction(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.setInitialDirectory(new File("./users"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("User Saves", "*.vcsf"));
		File userFile = fileChooser.showOpenDialog(new Stage());
		try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
			String name = br.readLine();
			String moneyString = br.readLine();
			int money = Integer.parseInt(moneyString);

			MenuGUI.casino.setPlayer(new Player(money, name));

			currentUser.setText(name);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void newUserAction(){
		TextInputDialog dialog = new TextInputDialog("Name");
		dialog.setTitle("Create New User");
		dialog.setHeaderText("Create s New User");
		dialog.setContentText("Please enter your name:");

		Optional<String> result = dialog.showAndWait();

		String name = "Guest";

		if (result.isPresent()){
			name = result.get();
			MenuGUI.casino.setPlayer(new Player(100, name));

			currentUser.setText(name);
		}

		File newUser = new File("./users/" + name + ".vcsf");
		try {
			newUser.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter br = new BufferedWriter(new FileWriter(newUser))) {
			br.write(name + "\n");
			br.write("100");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void saveUser(){

		String name = MenuGUI.casino.getPlayer().getName();
		int money = MenuGUI.casino.getPlayer().getMoney();

		File userFile = new File("./users/" + name + ".vcsf");

		try (BufferedWriter br = new BufferedWriter(new FileWriter(userFile))) {
			br.write(name + "\n");
			br.write(String.valueOf(money));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*******************************************************
	 * The actions of the quit menu item for the main GUI.
	 ******************************************************/
	@FXML 
	private void quitMItem() {
		Platform.exit();
	}
}
