package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TimeSelectPanel extends JPanel implements ActionListener {
	
	String[] times = {"1", "2", "3"};
	JButton[] timeBtns = new JButton[3];
	
	public TimeSelectPanel() {
		this.setLayout(new GridLayout(1,3));
		for (int i = 0; i < 3; i++) {
			timeBtns[i] = new JButton(times[i]);
			timeBtns[i].setOpaque(true);
			timeBtns[i].setVisible(true);
			timeBtns[i].addActionListener(this);
			add(timeBtns[i]);
		}

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
