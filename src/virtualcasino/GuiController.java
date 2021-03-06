package virtualcasino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/****************************************************************
* Description: The Controller for the main gui screen.
* @author Marc Chesebro
*         Brendan Caywood
*         Patrick McMahon
* @version 4/19/18
****************************************************************/
public class GuiController implements Initializable {
	
	/**The label for the current user.*/
	@FXML
	private Label currentUser;

	/*******************************************************
	 * Runs at runtime of the GUI.
	 * 
	 ******************************************************/
	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
		currentUser.setText(MenuGUI.getCasino().getPlayer().getName());
	}

	/*******************************************************
	 * The actions of the blackjack button for the main GUI.
	 * 
	 ******************************************************/
	@FXML 
	private void blackjackButton() {
		MenuGUI.getCasino().blackjack();
		currentUser.setText(MenuGUI.getCasino().getPlayer().getName());
	}
	/********************************************************
	 * The actions of the slot button for the main GUI.
	 *******************************************************/
	@FXML 
	private void slotButton() {
		MenuGUI.getCasino().slots();
	}
	
	/********************************************************
	 * The actions of the refresh button for the main GUI.
	 *******************************************************/
	@FXML
	private void refreshButton() {
		//start();
	}
	
	/*******************************************************
	 * The actions of the roulette button for the main GUI.
	 ******************************************************/
	@FXML 
	private void rouButton() {
		MenuGUI.getCasino().roulette();
	}

	/**
	 * Action for the change user action.
	 **/
	@FXML
	private void changeUserAction(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.setInitialDirectory(new File("./users"));
		fileChooser.getExtensionFilters()
		.add(new FileChooser.ExtensionFilter("User Saves", "*.vcsf"));
		File userFile = fileChooser.showOpenDialog(new Stage());
		try (BufferedReader br = new 
				BufferedReader(new FileReader(userFile))) {
			String name = br.readLine();
			String moneyString = br.readLine();
			int money = Integer.parseInt(moneyString);

			MenuGUI.getCasino().setPlayer(new Player(money, name));

			currentUser.setText(name);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Action for the new user button.
	 **/
	@FXML
	private void newUserAction(){
		TextInputDialog dialog = new TextInputDialog("Name");
		dialog.setTitle("Create New User");
		dialog.setHeaderText("Create a New User");
		dialog.setContentText("Please enter your name:");

		Optional<String> result = dialog.showAndWait();

		String name = "Guest";

		if (result.isPresent()){
			name = result.get();
			MenuGUI.getCasino().setPlayer(new Player(100, name));

			currentUser.setText(name);
		}

		File newUser = new File("./users/" + name + ".vcsf");
		try {
			newUser.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter br = new 
				BufferedWriter(new FileWriter(newUser))) {
			br.write(name + "\n");
			br.write("100");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * saves the users data.
	 **/
	@FXML
	private void saveUser(){

		String name = MenuGUI.getCasino().getPlayer().getName();
		int money = MenuGUI.getCasino().getPlayer().getMoney();

		File userFile = new File("./users/" + name + ".vcsf");

		try (BufferedWriter br = new 
				BufferedWriter(new FileWriter(userFile))) {
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
