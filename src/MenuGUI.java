
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;


public class MenuGUI extends Application {
	 public static VirtualCasino casino = new VirtualCasino();
	 public static ScreenController screenController;
	 
     @Override
     public void start(Stage primaryStage) throws Exception {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui_css.fxml"));
             Scene scene = new Scene(root);
             screenController = new ScreenController(scene);

             screenController.addScreen("main", FXMLLoader.load(getClass().getResource("/gui_css.fxml")));
             screenController.addScreen("blackjack", FXMLLoader.load(getClass().getResource("/blackjack.fxml")));

             primaryStage.setScene(scene);
             primaryStage.setTitle("Virtual Casino");
             primaryStage.setResizable(false);
             primaryStage.show();
         }
         catch (IOException e) {
             e.printStackTrace();
         }
     }

     public static void main(String[] args) {
         launch(args);
     }

}
