package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TimeSelectPanel extends JPanel implements ActionListener {
	
	int time;
	String[] times = {"10", "60", "Unlimited"};
	JButton[] timeBtns = new JButton[3];
	
	public TimeSelectPanel() {
		this.setLayout(new BorderLayout()); 
	    JLabel title = new JLabel("Time:", SwingConstants.CENTER);
	    this.add(title, BorderLayout.NORTH);
	    
	    JPanel buttonPanel = new JPanel(new GridLayout(1, 3)); 
		for (int i = 0; i < 3; i++) {
			timeBtns[i] = new JButton(times[i]);
			timeBtns[i].setFocusPainted(false);
			timeBtns[i].setOpaque(true);
			timeBtns[i].setVisible(true);
			timeBtns[i].addActionListener(this);
			buttonPanel.add(timeBtns[i]);
		}
		this.add(buttonPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public int getTime() {
		return time;
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0;i < timeBtns.length; i++) {
			timeBtns[i].setEnabled(true);
		}
		if(e.getSource() == timeBtns[0]) {
			time = 10;
			timeBtns[0].setEnabled(false);
		}
		else if(e.getSource() == timeBtns[1]) {
			time = 60;
			timeBtns[1].setEnabled(false);
		}
		else if(e.getSource() == timeBtns[2]) {
			time = 0;
			timeBtns[2].setEnabled(false);
		}
	}

}
