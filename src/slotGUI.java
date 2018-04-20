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


public class slotGUI{

	public JFrame frame;


	private final String[] CARDSTRING = {"Ten","Jack","Queen","King","Ace"};
	private final String[] CARDIMAGES = {"10_of_spades.png","jack_of_spades.png","queen_of_spades.png","king_of_spades.png","ace_of_spades.png"};

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
		final JLabel Wallet = new JLabel("Wallet:   "+mywallet, JLabel.CENTER);
                final JLabel betInput = new JLabel("Current Bet:   ", JLabel.CENTER);
		JButton roll = new JButton("Roll");
		JButton exit = new JButton("Exit");

		//Creates the panels for roll and other data

		//Creates the panel where the slots will reside

		//The slot lables will be stored in this array

		//gets the filepath needed to use the card images


		//createing the slot array with an image

			//Check the filepath to verify location. If images are dead/gone
			//Use plane text instead
			try {
			} catch (IOException e) {
			}
		}

		//If the images dont exist throw this pop up message
			JLabel label = new JLabel("Images were moved or deleted.");
			JOptionPane.showMessageDialog(null, label);
		}

		//Add all of the components to the panels
                data_panel.add(betInput);
                roll.setBorder(BorderFactory.createLineBorder(bgc,10));
                Font font = new Font("Arial", Font.PLAIN, 40);
                roll.setFont(font);
                roll.setBackground(rc);


		//What to do when the roll button is pressed
		roll.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e){

				//Lets check the bet to make sure it is valid
				if(currBet <= 0){
					JOptionPane.showMessageDialog(frame,"No bet selected!");
					return;
					JOptionPane.showMessageDialog(frame,"Bet Invalid");
					return;
				}
				//Roll the slots

				//update the player wallet and return the value


				//set the text the user will see
				moneyWon = Math.abs(moneyWon);
				outcome.setText(wl + moneyWon);

				//update the card images
					
					//Check if the images exsist
					try{
					}catch(IOException exception){
					}
				}
			}
		});

		//What to do when the change bet button is pressed.
		{
			@Override
			public void actionPerformed(ActionEvent e){
				try{
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
                            .addGroup(layout.createSequentialGroup())
                            .addGroup(layout.createSequentialGroup())
                            .addGroup(layout.createSequentialGroup())
                                .addComponent(exit)
                );
                layout.setVerticalGroup(
                        layout.createSequentialGroup()
                            .addComponent(outcome)
                            .addComponent(exit)
                );
                
                //add the panel to the frame.
                panel.setBackground(bgc);
                frame.add(panel);
		this.frame.setVisible(true);
		
	}
}