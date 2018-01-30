import javax.swing.*;

public class MenuGUI extends JFrame {

    public MenuGUI(String title){
        setTitle(title);
        setSize(500, 500);

        // Create JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create Jlabels
        JLabel header = new JLabel("Virtual Casino");

        // Create Jbuttons
        JButton slotButton = new JButton("Slots");
        JButton jackButton = new JButton("Black Jack");
        JButton roulButton = new JButton("Roulette");

        // Add buttons and labels to the panel
        panel.add(header);
        panel.add(slotButton);
        panel.add(jackButton);
        panel.add(roulButton);

        // Add panel to frame
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
