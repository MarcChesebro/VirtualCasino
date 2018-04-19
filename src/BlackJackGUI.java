import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class BlackJackGUI implements Initializable {

    @FXML
    private ImageView dealerImage1;
    @FXML
    private ImageView dealerImage2;
    @FXML
    private ImageView dealerImage3;
    @FXML
    private ImageView dealerImage4;
    @FXML
    private ImageView dealerImage5;
    @FXML
    private ImageView dealerImage6;
    @FXML
    private ImageView dealerImage7;
    @FXML
    private ImageView dealerImage8;
    /** Label array to hold all the labels for dealer. */
    private ImageView[] dealerHandImages = new ImageView[8];

    @FXML
    private ImageView playerImage1;
    @FXML
    private ImageView playerImage2;
    @FXML
    private ImageView playerImage3;
    @FXML
    private ImageView playerImage4;
    @FXML
    private ImageView playerImage5;
    @FXML
    private ImageView playerImage6;
    @FXML
    private ImageView playerImage7;
    @FXML
    private ImageView playerImage8;
    /** Label array to hold all the labels for dealer. */
    private ImageView[] playerHandImages = new ImageView[8];


    /** Label for the dealers score. */
    @FXML
    private Label dealerScore;

    /** Label for the players score. */
    @FXML
    private Label playerScore;

    /** Label for the players money. */
    @FXML
    public Label playerMoney;

    /** Button to start a hand. */
    @FXML
    private Button startButton;

    /** Button to receive another card. */
    @FXML
    private Button hitButton;

    /** Button to hold. */
    @FXML
    private Button holdButton;

    /** TextField to get users bet amount. */
    @FXML
    private TextField betAmountText;

    /** label to give invalid input feedback to user. */
    @FXML
    private Label errorLabel;

    /** variable for holding current game. */
    private Blackjack game;

    /** variable for holding current bet. */
    private int bet = -1;

    /*************************************************************************
     * Method for setting up initial values.
     *************************************************************************/
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initializeHandLabels();
        clearHands();

        holdButton.setDisable(true);
        hitButton.setDisable(true);
    }

    /**************************************************************************
     * method for initializing labels and label arrays.
     **************************************************************************/
    private void initializeHandLabels() {

        dealerHandImages[0] = dealerImage1;
        dealerHandImages[1] = dealerImage2;
        dealerHandImages[2] = dealerImage3;
        dealerHandImages[3] = dealerImage4;
        dealerHandImages[4] = dealerImage5;
        dealerHandImages[5] = dealerImage6;
        dealerHandImages[6] = dealerImage7;
        dealerHandImages[7] = dealerImage8;

        playerHandImages[0] = playerImage1;
        playerHandImages[1] = playerImage2;
        playerHandImages[2] = playerImage3;
        playerHandImages[3] = playerImage4;
        playerHandImages[4] = playerImage5;
        playerHandImages[5] = playerImage6;
        playerHandImages[6] = playerImage7;
        playerHandImages[7] = playerImage8;

        dealerScore.setText("0");
        playerScore.setText("0");

        updatePlayerMoneyLabel();
        updateErrorlabel("");
    }

    /********************************************************************
     *  Action when hit button is pressed.
     ************************************************************************/
    @FXML
    public void hitAction(){
        addToPlayerHand();
        updatePlayerScore(game.playerScore());

        if(game.playerScore() > 21){
            resolveHands();

            hitButton.setDisable(true);
            holdButton.setDisable(true);
            startButton.setDisable(false);
        }
    }

    /********************************************************************
     *  Action when hold button is pressed.
     ************************************************************************/
    @FXML
    public void holdAction(){
        resolveHands();

        hitButton.setDisable(true);
        holdButton.setDisable(true);
        startButton.setDisable(false);
    }

    /********************************************************************
     *  Action when start button is pressed.
     ************************************************************************/
    @FXML
    public void startAction(){
        if(game == null){
            game = MenuGUI.casino.getBlackjack();
        }

        reset();

        try {
            bet = Integer.parseInt(betAmountText.getText());
        }catch (NumberFormatException e){
            updateErrorlabel("Not a Number");
            return;
        }

        if(bet < 0){
            updateErrorlabel("Must Give Valid Number");
        }

        if(bet > MenuGUI.casino.getPlayer().getMoney()){
            updateErrorlabel("Not Enough Money");
            return;
        }

        updateErrorlabel("");
        addToDealerHand();

        addToPlayerHand();
        addToPlayerHand();

        updatePlayerScore(game.playerScore());
        updateDealerScore(game.dealerScore());

        hitButton.setDisable(false);
        holdButton.setDisable(false);
        startButton.setDisable(true);
    }

    /************************************************************************
     *  Action when hit button is pressed.
     ************************************************************************/
    public void exit(){
        MenuGUI.screenController.activate("main");
    }

    /**************************************************************************
     * Resolves the current hand state and gives reward or removes bet amount
     **************************************************************************/
    private void resolveHands(){

        while(game.dealerScore() < 17){
            addToDealerHand();
        }

        updateDealerScore(game.dealerScore());

        int dealerScore = game.dealerScore();
        int playerScore = game.playerScore();

        //TODO update winLabel
        if(playerScore > 21){
            MenuGUI.casino.getPlayer().changeMoney(-bet);
        }else if(dealerScore > 21){
            MenuGUI.casino.getPlayer().changeMoney(bet);
        }else if(dealerScore >= playerScore){
            MenuGUI.casino.getPlayer().changeMoney(-bet);
        }else{
            MenuGUI.casino.getPlayer().changeMoney(bet);
        }
        updatePlayerMoneyLabel();
    }

    /************************************************************************
     * Updates the playerMoney Label to the players current amount.
     ************************************************************************/
    private void updatePlayerMoneyLabel(){
        playerMoney.setText(String.valueOf(MenuGUI.casino.getPlayer().getMoney()));
    }

    /************************************************************************
     * Draws a card and add it to the dealers hand.
     ************************************************************************/
    private void addToDealerHand(){

        Card card = game.dealerDraw();

        for(int i = 0; i < dealerHandImages.length; i++){
            if(dealerHandImages[i].getImage() == null){

                File image = new File("images/" + card.toString() + ".png");
                String path = image.toURI().toString();
                dealerHandImages[i].setImage(new Image(path));
                break;
            }
        }
    }

    /************************************************************************
     * Draws a card and add it to the players hand.
     ************************************************************************/
    private void addToPlayerHand(){

        Card card = game.playerDraw();

        for(int i = 0; i < playerHandImages.length; i++){
            if(playerHandImages[i].getImage() == null){

                File image = new File("images/" + card.toString() + ".png");
                String path = image.toURI().toString();
                playerHandImages[i].setImage(new Image(path));
                break;
            }
        }
    }

    /************************************************************************
     * Updates the players score Label.
     * @param Score int to set the label to.
     ************************************************************************/
    private void updatePlayerScore(int Score){
        playerScore.setText(String.valueOf(Score));
    }

    /************************************************************************
     * Updates the dealers score Label.
     * @param Score int to set the label to.
     ************************************************************************/
    private void updateDealerScore(int Score){
        dealerScore.setText(String.valueOf(Score));
    }

    /************************************************************************
     * Updates the error Label.
     * @param str String to set the label to.
     ************************************************************************/
    private void updateErrorlabel(String str){
        errorLabel.setText(str);
    }

    /************************************************************************
     * Resets the hand. clearing both hands and making sure a new bet must be made.
     ************************************************************************/
    private void reset(){
        game.reset();
        clearHands();

        hitButton.setDisable(true);
        holdButton.setDisable(true);
        startButton.setDisable(false);
    }

    /************************************************************************
     * Clears both hand label arrays and sets the score labels to 0.
     ************************************************************************/
    private void clearHands(){
        for(int i = 0; i < dealerHandImages.length; i++){
            dealerHandImages[i].setImage(null);
            playerHandImages[i].setImage(null);
        }
        dealerScore.setText("0");
        playerScore.setText("0");
    }
}
