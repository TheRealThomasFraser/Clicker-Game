package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ModeSelect extends JPanel implements ActionListener {

	private JButton mode1Button, mode2Button;
	private Container cpane;

	ModeSelect(Container cpane) {

		this.cpane = cpane;

		this.setLayout(null);
		this.setSize(575, 575);
		this.setBackground(Color.black);

		mode1Button = new JButton("Click");
		mode1Button.setLocation(100, 100);
		mode1Button.setSize(100, 50);
		mode1Button.addActionListener(this);
		add(mode1Button);

		mode2Button = new JButton("Hover");
		mode2Button.setLocation(200, 100);
		mode2Button.setSize(100, 50);
		mode2Button.addActionListener(this);
		add(mode2Button);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mode1Button) {
			this.setVisible(false);
			cpane.add(new Mode1(cpane));
			cpane.remove(this);
		} else if (e.getSource() == mode2Button) {
			this.setVisible(false);
			cpane.add(new Mode2(cpane));
			cpane.remove(this);
		}

	}

}