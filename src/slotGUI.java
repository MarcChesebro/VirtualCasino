import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class slotGUI{

	public JFrame frame;

	private Slots current_turn;

	private final String[] CARDSTRING = {"Ten","Jack","Queen","King","Ace"};
	private final String[] CARDIMAGES = {"10_of_spades.png","jack_of_spades.png","queen_of_spades.png","king_of_spades.png","ace_of_spades.png"};

	public slotGUI(Slots g_current_turn){
		current_turn = g_current_turn;
	}

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
		int mywallet = current_turn.get_wallet();
		final JLabel Wallet = new JLabel("Wallet:   "+mywallet, JLabel.CENTER);
                final JLabel betInput = new JLabel("Current Bet:   ", JLabel.CENTER);
		JButton roll = new JButton("Roll");
		JButton change_bet = new JButton("Set Bet  ");
		JButton exit = new JButton("Exit");

		//Creates the panels for roll and other data
		JPanel roll_panel = new JPanel();
		roll_panel.setBackground(bgc);
                roll_panel.setLayout(new GridLayout(1,1));
		JPanel data_panel = new JPanel();
		data_panel.setBackground(bgc);
		data_panel.setLayout(new GridLayout(1,3));

		//Creates the panel where the slots will reside
		int number_of_slots = this.current_turn.get_num_slots();
		JPanel slots_panel = new JPanel();
		slots_panel.setBackground(bgc);
		slots_panel.setBorder(BorderFactory.createLineBorder(bgc));
		slots_panel.setLayout(new GridLayout(1,number_of_slots));

		//The slot lables will be stored in this array
		JLabel slot_Arr[] = new JLabel[number_of_slots];

		//gets the filepath needed to use the card images
		String file_name = "back.png";
		String working_directory = System.getProperty("user.dir") + "/images";
		String file_path = working_directory + System.getProperty("file.separator") + file_name;

		boolean images_exsist = false;

		//createing the slot array with an image
		for(int i = 0; i<number_of_slots;i++){

			//Check the filepath to verify location. If images are dead/gone
			//Use plane text instead
			try {
				images_exsist = true;
				BufferedImage img = ImageIO.read(new File(file_path));
				ImageIcon back_icon = new ImageIcon(img);
				slot_Arr[i] = new JLabel(back_icon,JLabel.CENTER );
				slot_Arr[i].setBorder(BorderFactory.createLineBorder(bgc,5));
				slots_panel.add(slot_Arr[i]);
                                slot_Arr[i].setBackground(cardColor);
                                slots_panel.setBackground(cardColor);
			} catch (IOException e) {
				images_exsist = false;
				slot_Arr[i] = new JLabel("Slot #" + i + " ");
				slots_panel.add(slot_Arr[i]);
			}
		}

		//If the images dont exist throw this pop up message
		if (images_exsist == false){
			JLabel label = new JLabel("Images were moved or deleted.");
			JOptionPane.showMessageDialog(null, label);
		}

		//Add all of the components to the panels
		data_panel.add(Wallet);
                data_panel.add(change_bet);
                data_panel.add(betInput);
                roll.setBorder(BorderFactory.createLineBorder(bgc,10));
                Font font = new Font("Arial", Font.PLAIN, 40);
                roll.setFont(font);
                roll.setBackground(rc);
                roll_panel.add(roll);


		//What to do when the roll button is pressed
		roll.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e){

				//Lets check the bet to make sure it is valid
				int currBet = current_turn.get_bet(); 
				if(currBet <= 0){
					JOptionPane.showMessageDialog(frame,"No bet selected!");
					return;
				}else if(!current_turn.check_bet(currBet)) {
					JOptionPane.showMessageDialog(frame,"Bet Invalid");
					return;
				}
				//Roll the slots
				current_turn.randomize_slots();

				//update the player wallet and return the value
				int moneyWon = current_turn.update_wallet();

				Wallet.setText("Wallet:  " + current_turn.get_wallet());

				//set the text the user will see
				String wl = current_turn.win_lose(moneyWon);
				moneyWon = Math.abs(moneyWon);
				outcome.setText(wl + moneyWon);

				//update the card images
				int cards[] = current_turn.get_slots();
				for(int i = 0; i<number_of_slots;i++){
					String file_name = CARDIMAGES[cards[i]] ;
					String working_directory = System.getProperty("user.dir") + "/images";
					String file_path = working_directory + System.getProperty("file.separator") + file_name;
					
					//Check if the images exsist
					try{
						BufferedImage img = ImageIO.read(new File(file_path));
						ImageIcon front_icon = new ImageIcon(img);
						slot_Arr[i].setIcon(front_icon);
					}catch(IOException exception){
						slot_Arr[i].setText(CARDSTRING[cards[i]]);
					}
				}
			}
		});

		//What to do when the change bet button is pressed.
		change_bet.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e){
				String new_bet = JOptionPane.showInputDialog(frame,"Enter new bet.");
				try{
					int tryBet = Integer.parseInt(new_bet);
					if(current_turn.check_bet(tryBet)){
                                                change_bet.setText("Change Bet");
						current_turn.set_bet(tryBet);
						betInput.setText("Current Bet:  " + tryBet);						
					}else{
						JOptionPane.showMessageDialog(frame,"Invalid Bet!!");
					}
				}catch(NumberFormatException exc){

				}
			}
		});

		//What to do when the change bet button is pressed.
		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e){
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

                //This is the layout for the whole frame
                layout.setHorizontalGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(outcome)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(slots_panel)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(data_panel)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(roll_panel)
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(exit)
                );
                layout.setVerticalGroup(
                        layout.createSequentialGroup()
                            .addComponent(outcome)
                            .addComponent(slots_panel)
                            .addComponent(roll_panel)
                            .addComponent(data_panel)
                            .addComponent(exit)
                );
                
                //add the panel to the frame.
                panel.setBackground(bgc);
                frame.add(panel);
		this.frame.setVisible(true);
		
	}
}