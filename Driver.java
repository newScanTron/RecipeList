import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Driver {
	
	protected static Component newPanel;
    protected static JFrame displayFrame;
    
	public static void main(String[] args) throws IOException {
		createGUI();
	}
	
	static void createGUI() throws IOException {

		// Creates the JFrame, sets what happens when we close it, and makes it a fixed size (dependent on JPanel sizes)
		displayFrame = new JFrame("Recipe Program!");
		
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.setResizable(false);
		displayFrame.setLayout(new BorderLayout());
		
		newPanel = new RecipeGUI();
		
		displayFrame.getContentPane().add(newPanel);

		// Packs the Frame up for delivery to the console
		displayFrame.pack();
		
		// Opens the JFrame in the center of the monitor
		displayFrame.setLocationRelativeTo(null);
		
		displayFrame.setVisible(true); // Allows us to see the Frame
	}
}
