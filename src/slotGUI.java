import javax.swing.*;
// import java.awt.event.*;  
import java.awt.GridLayout;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import javax.imageio.ImageIO;

public class slotGUI{

	public JFrame frame;



	public slotGUI(Slots current_turn){

		frame = new JFrame("Slots");

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		frame.setLayout(new GridLayout(3,1));

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Make it go away on close

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel slotPanel = new JPanel();

		
		// JLabel slotOne = new JLabel("slotOne");
		// JLabel slotTwo = new JLabel("slotTwo");
		// JLabel slotThree = new JLabel("slotThree");

		// slotPanel.add(slotOne);
		// slotPanel.add(slotTwo);
		// slotPanel.add(slotThree);


		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);

		int numSlots = current_turn.get_num_slots();

		slotPanel.setLayout(new GridLayout(1,numSlots));

		JLabel slotArr[] = new JLabel[numSlots];

		for(int i = 0; i<numSlots;i++){
			slotArr[i] = new JLabel("Slot #" + i + " ");
			slotPanel.add(slotArr[i]);
		}


		//BufferedImage myPicture = ImageIO.read(new File("/images/AC.jpg"));
		//JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		//frame.add(picLabel);

		JLabel winLose = new JLabel("Win/Lose");
		//JLabel Wallet = new JLabel("wallet");
		JLabel betInput = new JLabel("betInput");

		JButton maxBet = new JButton("maxBet");
		JButton betX = new JButton("Bet x");
		JButton roll = new JButton("roll");

		panel1.add(winLose);
		panel2.add(maxBet);
		panel2.add(betX);
		panel2.add(slotPanel);
		panel2.add(roll);
		panel3.add(betInput);

	}

	public void showWindow(){

		this.frame.setVisible(true);
	}

	public void pullSlots(){ 

	}
}