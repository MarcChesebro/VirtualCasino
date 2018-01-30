import javax.swing.*;

public class MenuGUI extends JFrame {

    public MenuGUI(String title){
        setTitle(title);
        setSize(500, 500);

        // Create JPanel
        JPanel panel = new JPanel();

        // Create Jbuttons
        JButton button = new JButton("Slots");

        // Add button to panel
        panel.add(button);

        // Add panel to frame
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
