import javax.swing.*; 

import java.awt.*; 

import java.awt.event.*; 

public class VirtualCasino extends JFrame {
		VirtualCasino(String title) { 
        this.setSize(500,500); 
        setTitle(title); 
    }

    public static void main(String[] args) {
    	VirtualCasino window = new VirtualCasino("Hello World");
    	window.setVisible(true);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}

