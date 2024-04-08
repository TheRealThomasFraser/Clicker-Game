package clickergame;

import javax.swing.*;

@SuppressWarnings("serial")
public class Run extends JFrame {
	

	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
		mw.setSize(1000, 1000);
		mw.setTitle("Click King");
		mw.setVisible(true);

	}
}