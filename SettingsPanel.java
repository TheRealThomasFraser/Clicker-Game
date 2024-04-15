package clickergame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SettingsPanel extends JPanel implements ActionListener{
	
	JLabel title;
	JPanel settingsContainer;
	JButton playBtn;
	Container cpane;
	ColourSelectPanel csp;
	TimeSelectPanel tsp;
	SquareSelectPanel ssp;
	ModeSelectPanel msp;
	
	public SettingsPanel(Container cpane) {
		
		this.cpane = cpane;
		this.setLayout(new GridLayout(3,1));
		title = new JLabel("Settings", SwingConstants.CENTER);
		title.setVisible(true);
		this.add(title);
		settingsContainer = new JPanel();
		settingsContainer.setLayout(new GridLayout(2,2));
		csp = new ColourSelectPanel();
		settingsContainer.add(csp);
		tsp = new TimeSelectPanel();
		settingsContainer.add(tsp);
		ssp = new SquareSelectPanel();
		settingsContainer.add(ssp);
		msp = new ModeSelectPanel();
		settingsContainer.add(msp);
		settingsContainer.setVisible(true);
		this.add(settingsContainer);
		playBtn = new JButton("Play");
		playBtn.setFocusPainted(false);
		playBtn.setOpaque(true);
		playBtn.addActionListener(this);
		playBtn.setVisible(true);
		
		this.add(playBtn);
		
		this.setVisible(true);
		
	}
	
	public void startgame(int mode) {
		cpane.removeAll();
		int squares = ssp.getSquares();
		Color[] colours = csp.getColours();
		int timeVal = tsp.getTime();
		if (mode == 1) {
			Mode1Panel m1p = new Mode1Panel(cpane, squares, colours, timeVal);
			cpane.add(m1p);
		}
		else if (mode == 2) {
			Mode2Panel m2p = new Mode2Panel(cpane);
			cpane.add(m2p);
	}
		cpane.revalidate();
		cpane.repaint();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playBtn) {
			startgame(msp.getMode());
		}
		
	}

}
