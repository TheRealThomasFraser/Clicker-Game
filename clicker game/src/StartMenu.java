import javax.swing.*;

public class StartMenu {
	
	JPanel startGUI;

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
		return startGUI;
	}
	}




