package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ModeSelectPanel extends JPanel implements ActionListener {
	
	String[] modes = {"1", "2"};
	JButton[] modeBtns = new JButton[2];
	
	public ModeSelectPanel() {
		this.setLayout(new GridLayout(1,2));
		for (int i = 0; i < 2; i++) {
			modeBtns[i] = new JButton(modes[i]);
			modeBtns[i].setOpaque(true);
			modeBtns[i].setVisible(true);
			modeBtns[i].addActionListener(this);
			add(modeBtns[i]);
		}

		this.setVisible(true);
	}
	
	public int getMode() {
		return 1;
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
