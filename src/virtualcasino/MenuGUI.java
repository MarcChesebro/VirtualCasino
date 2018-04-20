package virtualcasino;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;
/*******************************************
 * Instantiates all of the gui screens and screen controller.
 * @author Brendan Caywood
 * @author Marc Chesebro
 * @version 4/20/18
 *****************************************/

public class MenuGUI extends Application {
	 /** The virtual casino object.*/
	 private static VirtualCasino casino = new VirtualCasino();
	 
	 /**The screen controller.*/
	 private static ScreenController screenController;

    /**The blackjack gui.*/
    private static BlackJackGUI blackjackController;

    /**
     * returns virtual casino instance
     * @return virtual casino instance
     */
    public static VirtualCasino getCasino() {
        return casino;
    }

    /**
     * returns virtual casino instance
     * @return virtual casino instance
     */
    public static void setCasino(VirtualCasino casino) {
        MenuGUI.casino = casino;
    }

    public static ScreenController getScreenController() {
        return screenController;
    }

    public static void setScreenController(ScreenController screenController) {
        MenuGUI.screenController = screenController;
    }

    public static BlackJackGUI getBlackjackController() {
        return blackjackController;
    }

    public static void setBlackjackController(BlackJackGUI blackjackController) {
        MenuGUI.blackjackController = blackjackController;
    }

     @Override
     public void start(final Stage primaryStage) throws Exception {
         try {
             Parent root = FXMLLoader.load(getClass().getResource("gui_css.fxml"));
             Scene scene = new Scene(root);
             screenController = new ScreenController(scene);
             FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("gui_css.fxml"));
             FXMLLoader blackjackLoader = new FXMLLoader(getClass().getResource("blackjack.fxml"));

             screenController.addScreen("main", mainLoader.load());
             screenController.addScreen("blackjack", blackjackLoader.load());
             screenController
             .addScreen("roulette", FXMLLoader
            		 .load(getClass().getResource("roulette.fxml")));

             blackjackController = blackjackLoader
            		 .<BlackJackGUI>getController();

             primaryStage.setScene(scene);
             primaryStage.setTitle("Virtual Casino");

             primaryStage.setResizable(true);
             primaryStage.show();
             }catch (IOException e) {
             e.printStackTrace();
         }
     }

     /**********************************
      * the main method for menu Gui.
      * @param args the arguments
      **********************************/
     public static void main(final String[] args) {
         launch(args);
     }

}
