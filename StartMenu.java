package clickergame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class StartMenu extends JPanel implements ActionListener {
	private Container cpane;
	private JButton startButton;

	public StartMenu(Container cpane) {

		this.cpane = cpane;
		this.setLayout(null);
		this.setSize(575, 575);
		this.setBackground(Color.black);

		startButton = new JButton("Start");
		startButton.setLocation(100, 100);
		startButton.setSize(100, 50);
		startButton.addActionListener(this);
		this.add(startButton);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startButton) {
			this.setVisible(false);
			cpane.add(new ModeSelect(cpane));
			cpane.remove(this);
		}
	}
}
