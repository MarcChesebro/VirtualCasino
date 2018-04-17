import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BlackJackGUI implements Initializable {

    @FXML
    private Label dealerLabel1;
    @FXML
    private Label dealerLabel2;
    @FXML
    private Label dealerLabel3;
    @FXML
    private Label dealerLabel4;
    @FXML
    private Label dealerLabel5;
    @FXML
    private Label dealerLabel6;
    @FXML
    private Label dealerLabel7;
    @FXML
    private Label dealerLabel8;

    @FXML
    private Label playerLabel1;
    @FXML
    private Label playerLabel2;
    @FXML
    private Label playerLabel3;
    @FXML
    private Label playerLabel4;
    @FXML
    private Label playerLabel5;
    @FXML
    private Label playerLabel6;
    @FXML
    private Label playerLabel7;
    @FXML
    private Label playerLabel8;

    private Label[] dealerHandLabels = new Label[8];
    private Label[] playerHandLabels = new Label[8];

    @FXML
    private Label dealerScore;
    @FXML
    private Label playerScore;

    @FXML
    private Label playerMoney;

    @FXML
    private ComboBox betPick;

    @FXML
    private Button startButton;
    @FXML
    private Button hitButton;
    @FXML
    private Button holdButton;

    @FXML
    private TextField betAmountText;
    @FXML
    private Label errorLabel;

    private Blackjack game;
    private int bet = -1;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //game = MenuGUI.casino.getBlackjack();
        initializeHandLabels();
        clearHands();

        holdButton.setDisable(true);
        hitButton.setDisable(true);
    }

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

    @FXML
    public void holdAction(){
        resolveHands();

        hitButton.setDisable(true);
        holdButton.setDisable(true);
        startButton.setDisable(false);
    }

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

    public void exit(){
        MenuGUI.screenController.activate("main");
    }

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
    private void updatePlayerMoneyLabel(){
        playerMoney.setText(String.valueOf(MenuGUI.casino.getPlayer().getMoney()));
    }

    public void addToDealerHand(){

        Card card = game.dealerDraw();

        for(int i = 0; i < dealerHandLabels.length; i++){
            if(dealerHandLabels[i].getText().equals("")){
                dealerHandLabels[i].setText(card.toString());
                break;
            }
        }
    }

    public void addToPlayerHand(){

        Card card = game.playerDraw();

        for(int i = 0; i < playerHandLabels.length; i++){
            if(playerHandLabels[i].getText().equals("")){
                playerHandLabels[i].setText(card.toString());
                break;
            }
        }
    }

    private void updatePlayerScore(int Score){
        playerScore.setText(String.valueOf(Score));
    }

    private void updateDealerScore(int Score){
        dealerScore.setText(String.valueOf(Score));
    }

    private void updateErrorlabel(String str){
        errorLabel.setText(str);
    }

    private void reset(){
        game.getDealerHand().clear();
        game.getPlayerHand().clear();
        clearHands();

        hitButton.setDisable(true);
        holdButton.setDisable(true);
        startButton.setDisable(false);
    }

    private void clearHands(){
        for(int i = 0; i < dealerHandLabels.length; i++){
            dealerHandLabels[i].setText("");
            playerHandLabels[i].setText("");
        }
        dealerScore.setText("0");
        playerScore.setText("0");
    }
}
