import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

/****************************************************************
 * Description: used to manage screens for the GUI.
 * @author Marc Chesebro
 *
 * @version 2/19/18
 ****************************************************************/
public class ScreenController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(final Scene main) {
        this.main = main;
    }

    protected void addScreen(final String name, final Pane pane){
        screenMap.put(name, pane);
    }

    public Pane getScreen(final String name){
        return screenMap.get(name);
    }

    protected void removeScreen(final String name){
        screenMap.remove(name);
    }

    protected void activate(final String name){
        main.setRoot( screenMap.get(name) );
    }
}
