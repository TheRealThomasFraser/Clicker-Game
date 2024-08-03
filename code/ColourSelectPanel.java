package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColourSelectPanel extends JPanel implements ActionListener {
	
	Color[] warmColours = {Color.orange, Color.pink, Color.red, Color.yellow};
	Color[] coldColours = {Color.blue, Color.cyan, Color.green, Color.magenta};
	Color[] randomColours = {Color.orange, Color.pink, Color.red, Color.yellow, Color.blue, Color.cyan, Color.green, Color.magenta};
	Color[] colours;
	String[] colourOptns = {"Warm", "Cold", "Random"};
	JButton[] colourBtns = new JButton[3];
	
	public ColourSelectPanel() {
		this.setLayout(new BorderLayout()); 
	    JLabel title = new JLabel("Colours:", SwingConstants.CENTER);
	    this.add(title, BorderLayout.NORTH);
	    
	    JPanel buttonPanel = new JPanel(new GridLayout(1, 3)); 
		for (int i = 0; i < 3; i++) {
			colourBtns[i] = new JButton(colourOptns[i]);
			colourBtns[i].setFocusPainted(false);
			colourBtns[i].setOpaque(true);
			colourBtns[i].setVisible(true);
			colourBtns[i].addActionListener(this);
			buttonPanel.add(colourBtns[i]);
		}
		this.add(buttonPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void setColours(Color[] selectedColours) {
		colours = new Color[selectedColours.length];
		for(int i=0; i < selectedColours.length; i++) {
			colours[i] = selectedColours[i];
		}
	}
	
	public Color[] getColours() {
		return colours;
	}

	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i < colourBtns.length; i++) {
			colourBtns[i].setEnabled(true);
		}
		
		if(e.getSource() == colourBtns[0]) {
			setColours(warmColours);
			colourBtns[0].setEnabled(false);
		}
		else if(e.getSource() == colourBtns[1]) {
			setColours(coldColours);
			colourBtns[1].setEnabled(false);
		}
		else if(e.getSource() == colourBtns[2]) {
			setColours(randomColours);
			colourBtns[2].setEnabled(false);
		}
		
	}

}
