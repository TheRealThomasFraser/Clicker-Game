import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu implements ActionListener{
	
	JPanel startGUI;
	JButton startButton;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true); // Makes frame appear the same across different OS
		JFrame frame = new JFrame("Clicker Game");
		StartMenu demo = new StartMenu();
		frame.setContentPane(demo.createContentPane()); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Customising Frame:
		frame.setSize(500, 530);
		frame.setVisible(true);
		}
	
	public JPanel createContentPane() {
		startGUI = new JPanel();
		startGUI.setLayout(null);


 		startButton = new JButton("Start");
        startButton.setLocation(130, 120);
        startButton.setSize(80, 30);
        startButton.addActionListener(this);
        startGUI.add(startButton);

		return startGUI;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			ModeSelect.main(null);
		}
	}
	}




