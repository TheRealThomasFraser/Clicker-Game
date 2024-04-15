package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SquareSelectPanel extends JPanel implements ActionListener {
	
	String[] squareAmnts = {"1", "3", "5"};
	JButton[] squareBtns = new JButton[3];
	int squares;
	
	public SquareSelectPanel() {
	    this.setLayout(new BorderLayout()); 
	    JLabel title = new JLabel("Squares:", SwingConstants.CENTER);
	    this.add(title, BorderLayout.NORTH);
	    
	    JPanel buttonPanel = new JPanel(new GridLayout(1, 3)); 
	    for (int i = 0; i < 3; i++) {
	        squareBtns[i] = new JButton(squareAmnts[i]);
	        squareBtns[i].setFocusPainted(false);
	        squareBtns[i].setOpaque(true);
	        squareBtns[i].setVisible(true);
	        squareBtns[i].addActionListener(this);
	        buttonPanel.add(squareBtns[i]);
	    }

	    this.add(buttonPanel, BorderLayout.CENTER); 

	    this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i < squareBtns.length; i++) {
			squareBtns[i].setEnabled(true);
		}
		for (int i=0; i < 3; i++) {
		if (e.getSource() == squareBtns[i]) {
			squares = Integer.parseInt(squareAmnts[i]);
			squareBtns[i].setEnabled(false);
		}
		}
	}
	
	public int getSquares() {
		return squares;
	}

}
