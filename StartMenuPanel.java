package clickergame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class StartMenuPanel extends JPanel implements ActionListener {
	private Container cpane;
	private JButton startButton;

	public StartMenuPanel(Container cpane) {

		this.cpane = cpane;
		this.setLayout(null);
		this.setSize(575, 575);

		startButton = new JButton("Start");
		startButton.setSize(100, 50);
		startButton.addActionListener(this);
		this.add(startButton);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startButton) {
			cpane.remove(this);
			cpane.add(new SettingsPanel(cpane));
			cpane.revalidate();
			cpane.repaint();
			
		}
	}
}
