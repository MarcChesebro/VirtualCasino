import javax.swing.*;
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

	public slotGUI(Slots g_current_turn){
		current_turn = g_current_turn;
	}

	public void showWindow(){

		//the background color of the window
		Color bgc = new Color(255,150,150);

		//Creates the JFrame and sets the details
		frame = new JFrame("Slots");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setLayout(new GridLayout(3,1));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(bgc);

		//Creating lables to change when user does various things
		final JLabel outcome = new JLabel("Win/Lose");
		final JLabel Wallet = new JLabel("Wallet:   ", JLabel.CENTER);
		final JLabel betInput = new JLabel("CurrentBet:   ", JLabel.CENTER);
		JButton roll = new JButton("Roll");
		JButton change_bet = new JButton("  Change Bet  ");

		//Creates the three sections of the window
		JPanel title_panel = new JPanel();
		title_panel.setBackground(bgc);
		JPanel gameplay_panel = new JPanel();
		gameplay_panel.setBackground(bgc);
		JPanel data_panel = new JPanel();
		data_panel.setBackground(bgc);
		data_panel.setLayout(new FlowLayout());

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

		//Add everything to the three sections
		title_panel.add(outcome);
		gameplay_panel.add(slots_panel);
		gameplay_panel.add(roll);
		data_panel.add(change_bet);
		data_panel.add(betInput);
		data_panel.add(Wallet);

		//What to do when the roll button is pressed
		roll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				current_turn.randomize_slots();
				int temp =current_turn.update_wallet();
				String wl = current_turn.win_lose(temp);
				temp = Math.abs(temp);
				outcome.setText(wl + temp);
			}
		});

		//What to do when the change bet button is pressed.
		change_bet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				String new_bet = JOptionPane.showInputDialog(frame,"Enter new bet.");
				try{
					current_turn.set_bet(Integer.parseInt(new_bet));
					//TODO setcards method, and make cards global
				}catch(NumberFormatException exc){

				}
			}
		});

		//Adds the sections of the window to the frame
		frame.add(title_panel);
		frame.add(gameplay_panel);
		frame.add(data_panel);
		this.frame.setVisible(true);
		
	}
}