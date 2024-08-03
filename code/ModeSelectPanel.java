package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ModeSelectPanel extends JPanel implements ActionListener {
	
	int mode;
	String[] modes = {"Click", "Hover"};
	JButton[] modeBtns = new JButton[2];
	
	public ModeSelectPanel() {
		this.setLayout(new BorderLayout()); 
	    JLabel title = new JLabel("Modes:", SwingConstants.CENTER);
	    this.add(title, BorderLayout.NORTH);
	    JPanel buttonPanel = new JPanel(new GridLayout(1, 3)); 
		for (int i = 0; i < 2; i++) {
			modeBtns[i] = new JButton(modes[i]);
			modeBtns[i].setFocusPainted(false);
			modeBtns[i].setOpaque(true);
			modeBtns[i].setVisible(true);
			modeBtns[i].addActionListener(this);
			buttonPanel.add(modeBtns[i]);
		}
		this.add(buttonPanel, BorderLayout.CENTER); 
		this.setVisible(true);
	}
	
	public int getMode() {
		return mode;
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0;i < modeBtns.length; i++) {
			modeBtns[i].setEnabled(true);
		}
		if (e.getSource() == modeBtns[0]) {
			mode = 1;
			modeBtns[0].setEnabled(false);
		}
		else if (e.getSource() == modeBtns[1]) {
			mode = 2;
			modeBtns[1].setEnabled(false);
		}
	}

}
