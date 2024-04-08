package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColourSelectPanel extends JPanel implements ActionListener {
	
	String[] colours = {"1", "2", "3"};
	JButton[] colourBtns = new JButton[3];
	
	public ColourSelectPanel() {
		this.setLayout(new GridLayout(1,3));
		for (int i = 0; i < 3; i++) {
			colourBtns[i] = new JButton(colours[i]);
			colourBtns[i].setOpaque(true);
			colourBtns[i].setVisible(true);
			colourBtns[i].addActionListener(this);
			add(colourBtns[i]);
		}

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
