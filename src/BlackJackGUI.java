import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BlackJackGUI implements Initializable {

    /** Label for the dealers card 1. */
    @FXML
    private Label dealerLabel1;

    /** Label for the dealers card 2. */
    @FXML
    private Label dealerLabel2;

    /** Label for the dealers card 3. */
    @FXML
    private Label dealerLabel3;

    /** Label for the dealers card 4. */
    @FXML
    private Label dealerLabel4;

    /** Label for the dealers card 5. */
    @FXML
    private Label dealerLabel5;

    /** Label for the dealers card 6. */
    @FXML
    private Label dealerLabel6;

    /** Label for the dealers card 7. */
    @FXML
    private Label dealerLabel7;

    /** Label for the dealers card 8. */
    @FXML
    private Label dealerLabel8;

    /** Label for the players card 1. */
    @FXML
    private Label playerLabel1;

    /** Label for the players card 2. */
    @FXML
    private Label playerLabel2;

    /** Label for the players card 3. */
    @FXML
    private Label playerLabel3;

    /** Label for the players card 4. */
    @FXML
    private Label playerLabel4;

    /** Label for the players card 5. */
    @FXML
    private Label playerLabel5;

    /** Label for the players card 6. */
    @FXML
    private Label playerLabel6;

    /** Label for the players card 7. */
    @FXML
    private Label playerLabel7;

    /** Label for the players card 8. */
    @FXML
    private Label playerLabel8;

    /** Label array to hold all the labels for dealer. */
    private Label[] dealerHandLabels = new Label[8];

    /** Label array to hold all the labels for player. */
    private Label[] playerHandLabels = new Label[8];

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
        dealerHandLabels[0] = dealerLabel1;
        dealerHandLabels[1] = dealerLabel2;
        dealerHandLabels[2] = dealerLabel3;
        dealerHandLabels[3] = dealerLabel4;
        dealerHandLabels[4] = dealerLabel5;
        dealerHandLabels[5] = dealerLabel6;
        dealerHandLabels[6] = dealerLabel7;
        dealerHandLabels[7] = dealerLabel8;

        playerHandLabels[0] = playerLabel1;
        playerHandLabels[1] = playerLabel2;
        playerHandLabels[2] = playerLabel3;
        playerHandLabels[3] = playerLabel4;
        playerHandLabels[4] = playerLabel5;
        playerHandLabels[5] = playerLabel6;
        playerHandLabels[6] = playerLabel7;
        playerHandLabels[7] = playerLabel8;

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

        for(int i = 0; i < dealerHandLabels.length; i++){
            if(dealerHandLabels[i].getText().equals("")){
                dealerHandLabels[i].setText(card.toString());
                break;
            }
        }
    }

    /************************************************************************
     * Draws a card and add it to the players hand.
     ************************************************************************/
    private void addToPlayerHand(){

        Card card = game.playerDraw();

        for(int i = 0; i < playerHandLabels.length; i++){
            if(playerHandLabels[i].getText().equals("")){
                playerHandLabels[i].setText(card.toString());
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
        game.getDealerHand().clear();
        game.getPlayerHand().clear();
        clearHands();

        hitButton.setDisable(true);
        holdButton.setDisable(true);
        startButton.setDisable(false);
    }

    /************************************************************************
     * Clears both hand label arrays and sets the score labels to 0.
     ************************************************************************/
    private void clearHands(){
        for(int i = 0; i < dealerHandLabels.length; i++){
            dealerHandLabels[i].setText("");
            playerHandLabels[i].setText("");
        }
        dealerScore.setText("0");
        playerScore.setText("0");
    }
}
