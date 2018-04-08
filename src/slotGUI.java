import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class slotGUI{

	public JFrame frame;

	public slotGUI(Slots current_turn){

		//the background color of the window
		Color bgc = new Color(255,150,150);

		//Creates the JFrame and sets the details
		frame = new JFrame("Slots");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setLayout(new GridLayout(3,1));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(bgc);

		
		//Creates the three sections of the window
		JPanel title_panel = new JPanel();
		title_panel.setBackground(bgc);
		JPanel gameplay_panel = new JPanel();
		gameplay_panel.setBackground(bgc);
		JPanel data_panel = new JPanel();
		data_panel.setBackground(bgc);

		JPanel slots_panel = new JPanel();
		slots_panel.setBackground(bgc);
		slots_panel.setBorder(BorderFactory.createLineBorder(bgc));



		frame.add(title_panel);
		frame.add(gameplay_panel);
		frame.add(data_panel);

		data_panel.setLayout(new GridLayout());

		int number_of_slots = current_turn.get_num_slots();

		slots_panel.setLayout(new GridLayout(1,number_of_slots));

		JLabel slot_Arr[] = new JLabel[number_of_slots];

		String file_name = "back.png";
		String working_directory = System.getProperty("user.dir") + "/images";
		String file_path = working_directory + System.getProperty("file.separator") + file_name;



		for(int i = 0; i<number_of_slots;i++){

			try {
				BufferedImage img = ImageIO.read(new File(file_path));
				ImageIcon back_icon = new ImageIcon(img);
				slot_Arr[i] = new JLabel(back_icon,JLabel.CENTER );
				slot_Arr[i].setBorder(BorderFactory.createLineBorder(bgc,5));
				slots_panel.add(slot_Arr[i]);
			} catch (IOException e) {
				JLabel label = new JLabel("Images were moved or deleted.");
				JOptionPane.showMessageDialog(null, label);
				slot_Arr[i] = new JLabel("Slot #" + i + " ");
				slots_panel.add(slot_Arr[i]);
			}

		}

		JLabel winLose = new JLabel("Win/Lose");
		JLabel Wallet = new JLabel("wallet", JLabel.CENTER);
		JLabel betInput = new JLabel("betInput", JLabel.CENTER);

		JButton roll = new JButton("roll");

		title_panel.add(winLose);
		gameplay_panel.add(slots_panel);
		gameplay_panel.add(roll);
		data_panel.add(betInput);
		data_panel.add(Wallet);
	}

	public void showWindow(){

		this.frame.setVisible(true);
	}

	public void pullSlots(){ 

	}


	// protected ImageIcon createImageIcon(String path) {
	// 	java.net.URL imgURL = getClass().getResource(path);
	// 	if (imgURL != null) {
	// 		return new ImageIcon(imgURL);
	// 	} else {
	// 		System.err.println("Couldn't find file: " + path);
	// 	return null;
	// 	}
	// }
}