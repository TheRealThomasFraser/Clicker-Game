package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ClickerGame extends JFrame {
	Container cpane;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClickerGame cg = new ClickerGame();
	}
	public ClickerGame() {
		this.setSize(575, 575);
		this.setTitle("Click King");
		cpane = this.getContentPane();
		cpane.add(new StartMenu(cpane));
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
}
