
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;


public class MenuGUI extends Application {
	 public static VirtualCasino casino = new VirtualCasino();
	 public static ScreenController screenController;
	 public static BlackJackGUI blackjackController;
	 
     @Override
     public void start(final Stage primaryStage) throws Exception {
         try {
             Parent root = FXMLLoader.load(getClass()
            		 .getResource("/gui_css.fxml"));
             Scene scene = new Scene(root);
             screenController = new ScreenController(scene);
             FXMLLoader mainLoader = 
            		 new FXMLLoader(getClass()
            				 .getResource("/gui_css.fxml"));
             FXMLLoader blackjackLoader = 
            		 new FXMLLoader(getClass()
            				 .getResource("/blackjack.fxml"));

             screenController.addScreen("main", mainLoader.load());
             screenController.addScreen("blackjack", blackjackLoader.load());
             screenController
             .addScreen("roulette", FXMLLoader
            		 .load(getClass().getResource("/roulette.fxml")));

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

     public static void main(final String[] args) {
         launch(args);
     }

}
