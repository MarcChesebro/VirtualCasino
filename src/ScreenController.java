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
	/**hashmap that holds the scenes.*/
    private HashMap<String, Pane> screenMap = new HashMap<>();
    /**The main Scene.*/
    private Scene main;

    /***************************
     * constructor for the scene conroller.
     * @param main the desired first scene
     **************************/
    public ScreenController(final Scene main) {
        this.main = main;
    }

    /*************************************
     * Adds a screen to the hash map.
     * @param name the name of the screen
     * @param pane the scene itself
     */
    protected void addScreen(final String name, final Pane pane){
        screenMap.put(name, pane);
    }
    
    /***************************************
     * returns the desired screen.
     * @param name the name of the desired screen
     * @return the desired screen
     */
    public Pane getScreen(final String name){
        return screenMap.get(name);
    }

    /***************************************
     * Removes the designated screen.
     * @param name name of the desired screen
     **************************************/
    protected void removeScreen(final String name){
        screenMap.remove(name);
    }

    /*****************************************
     * activates the desired screen.
     * @param name the name of the desired screen
     */
    protected void activate(final String name){
        main.setRoot(screenMap.get(name));
    }
}
