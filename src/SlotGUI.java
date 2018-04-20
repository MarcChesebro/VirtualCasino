import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * This is the GUI for a game of slots. allowing player functionality
 * for betting money and wining/losing money.
 * @author Patrick McMahon
 * @version 4/10/2018
 */
public class SlotGUI{

	/**The jframe.*/
	public JFrame frame;

	/** The current turn.*/
	private Slots currentTurn;

	/** The array of cards.*/
	private final String[] cardString = {"Ten","Jack",
			"Queen","King","Ace"};
	
	/** The array of card file names.*/
	private final String[] cardImages = 
		{"10_of_spades.png","jack_of_spades.png",
				"queen_of_spades.png","king_of_spades.png",
				"ace_of_spades.png"};

	/**
	* Initializes the slots game play.
	* @param givenCurrTurn a slots game
	*/
	public SlotGUI(final Slots givenCurrTurn){
		currentTurn = givenCurrTurn;
	}

	/**
	* This is the GUI for the whole slots game. 
	* creates the window, adds the slots and 
	* additional buttons, and shows player money.
	*/
	public void showWindow(){

		//the background color of the window
		Color bgc = new Color(255,150,150);

                //the color of the roll button
      		Color rc = new Color(150,150,255);
                
                //color of the back of cards
                Color cardColor = new Color(255,255,255);

		//Creates the JFrame and sets the details
		frame = new JFrame("Slots");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(bgc);

                //The panel that we will add to the frame
                JPanel panel = new JPanel();
                GroupLayout layout = new GroupLayout(panel);
                panel.setLayout(layout);
                
		//Creating lables to change when user does various things
		final JLabel outcome = new JLabel("Welcome to Slots!");
		int mywallet = currentTurn.getWallet();
		final JLabel wallet = new JLabel("Wallet:   "
		+mywallet, JLabel.CENTER);
        final JLabel betInput = new JLabel("Current Bet:   ", JLabel.CENTER);
		JButton roll = new JButton("Roll");
		JButton changeBet = new JButton("Set Bet  ");
		JButton exit = new JButton("Exit");

		//Creates the panels for roll and other data
		JPanel rollPanel = new JPanel();
		rollPanel.setBackground(bgc);
                rollPanel.setLayout(new GridLayout(1,1));
		JPanel dataPanel = new JPanel();
		dataPanel.setBackground(bgc);
		dataPanel.setLayout(new GridLayout(1,3));

		//Creates the panel where the slots will reside
		int numberOfSlots = this.currentTurn.getNumSlots();
		JPanel slotsPanel = new JPanel();
		slotsPanel.setBackground(bgc);
		slotsPanel.setBorder(BorderFactory.createLineBorder(bgc));
		slotsPanel.setLayout(new GridLayout(1,numberOfSlots));

		//The slot lables will be stored in this array
		JLabel[] slotArr = new JLabel[numberOfSlots];

		//gets the filepath needed to use the card images
		String fileName = "back.png";
		String workingDirectory = System.getProperty("user.dir") 
				+ "/images";
		String filePath = workingDirectory 
				+ System.getProperty("file.separator") 
				+ fileName;

		boolean imagesExsist = false;

		//createing the slot array with an image
		for(int i = 0; i<numberOfSlots;i++){

			//Check the filepath to verify location. 
			//If images are dead/gone
			//Use plane text instead
			try {
				imagesExsist = true;
				BufferedImage img = ImageIO
						.read(new File(filePath));
				ImageIcon backIcon = new ImageIcon(img);
				slotArr[i] = new JLabel(backIcon,JLabel.CENTER);
				slotArr[i].setBorder(BorderFactory
						.createLineBorder(bgc,5));
				slotsPanel.add(slotArr[i]);
                                slotArr[i].setBackground(cardColor);
                                slotsPanel.setBackground(cardColor);
			} catch (IOException e) {
				imagesExsist = false;
				slotArr[i] = new JLabel("Slot #" + i + " ");
				slotsPanel.add(slotArr[i]);
			}
		}

		//If the images dont exist throw this pop up message
		if (!imagesExsist){
			JLabel label = 
					new 
					JLabel("Images were moved or deleted.");
			JOptionPane.showMessageDialog(null, label);
		}

		//Add all of the components to the panels
		dataPanel.add(wallet);
                dataPanel.add(changeBet);
                dataPanel.add(betInput);
                roll.setBorder(BorderFactory.createLineBorder(bgc,10));
                Font font = new Font("Arial", Font.PLAIN, 40);
                roll.setFont(font);
                roll.setBackground(rc);
                rollPanel.add(roll);


		//What to do when the roll button is pressed
		roll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(final ActionEvent e){

				//Lets check the bet to make sure it is valid
				int currBet = currentTurn.getBet(); 
				if(currBet <= 0){
					JOptionPane.showMessageDialog(frame,
							"No bet selected!");
					return;
				}else if(!currentTurn.checkBet(currBet)) {
					JOptionPane.showMessageDialog(frame,
							"Bet Invalid");
					return;
				}
				//Roll the slots
				currentTurn.randomizeSlots();

				//update the player wallet and return the value
				int moneyWon = currentTurn.updateWallet();

				wallet.setText("Wallet:  " 
				+ currentTurn.getWallet());

				//set the text the user will see
				String wl = currentTurn.winLose(moneyWon);
				moneyWon = Math.abs(moneyWon);
				outcome.setText(wl + moneyWon);

				//update the card images
				int[] cards = currentTurn.getSlots();
				for(int i = 0; i<numberOfSlots;i++){
					String fileName = cardImages[cards[i]] ;
					String workingDirectory = 
						System.getProperty("user.dir") 
						+ "/images";
					String filePath = workingDirectory 
						+ System
						.getProperty("file.separator") 
						+ fileName;
					
					//Check if the images exsist
					try{
						BufferedImage img = ImageIO
					    .read(new File(filePath));
						ImageIcon frontIcon = 
						new ImageIcon(img);
						slotArr[i].setIcon(frontIcon);
					}catch(IOException exception){
						slotArr[i]
						.setText(cardString[cards[i]]);
					}
				}
			}
		});

		//What to do when the change bet button is pressed.
		changeBet.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(final ActionEvent e){
				String newBet 
				= JOptionPane
				.showInputDialog(frame,"Enter new bet.");
				try{
					int tryBet = Integer.parseInt(newBet);
					if(currentTurn.checkBet(tryBet)){
                                                changeBet.setText("Change Bet");
						currentTurn.setBet(tryBet);
						betInput
						.setText("Current Bet:  " 
						+ tryBet);	
					}else{
						JOptionPane
						.showMessageDialog(frame,
						"Invalid Bet!!");
					}
				}catch(NumberFormatException exc){

				}
			}
		});

		//What to do when the change bet button is pressed.
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(final ActionEvent e){
				frame.dispatchEvent(
						new WindowEvent(frame, 
						WindowEvent.WINDOW_CLOSING));
			}
		});

                //This is the layout for the whole frame
                layout.setHorizontalGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(outcome)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(slotsPanel)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(dataPanel)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(rollPanel)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(exit)
                );
                layout.setVerticalGroup(
                        layout.createSequentialGroup()
                            .addComponent(outcome)
                            .addComponent(slotsPanel)
                            .addComponent(rollPanel)
                            .addComponent(dataPanel)
                            .addComponent(exit)
                );
                
                //add the panel to the frame.
                panel.setBackground(bgc);
                frame.add(panel);
		this.frame.setVisible(true);
		
	}
}
