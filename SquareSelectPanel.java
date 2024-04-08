package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SquareSelectPanel extends JPanel implements ActionListener {
	
	String[] squares = {"1", "2", "3"};
	JButton[] squareBtns = new JButton[3];
	
	public SquareSelectPanel() {
		this.setLayout(new GridLayout(1,3));
		for (int i = 0; i < 3; i++) {
			squareBtns[i] = new JButton(squares[i]);
			squareBtns[i].setOpaque(true);
			squareBtns[i].setVisible(true);
			squareBtns[i].addActionListener(this);
			add(squareBtns[i]);
		}

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
