package clickergame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class Mode1Panel extends JPanel implements ActionListener, MouseListener {
	private JPanel statPanel;
	private JPanel[] clickPanels;
	private JLabel score, time;
	private Color colours[];
	private int scoreVal, timeVal, randomX, randomY, squares;
	private Timer timer, timeUpdate;
	private Container cpane;
	static Random random = new Random();

	Mode1Panel(Container cpane, int squares, Color[] colours, int timeVal) {
		this.colours = colours;
		this.cpane = cpane;
		this.squares = squares;
		this.timeVal = timeVal;
		clickPanels = new JPanel[squares];
		this.setLayout(null);
		this.setSize(575, 575);
		this.setBackground(Color.black);
		randomX = random.nextInt(501);
		randomY = random.nextInt(501);
		scoreVal = 0;

		statPanel = new JPanel();
		statPanel.setLayout(null);
		statPanel.setSize(200, 100);
		statPanel.setBackground(Color.black);
		add(statPanel);

		score = new JLabel();
		score.setForeground(Color.white);
		score.setLocation(0, 0);
		score.setSize(100, 50);
		score.setFont(new Font("Serif", Font.PLAIN, 20));
		score.setText("Score: " + scoreVal);
		statPanel.add(score);

		time = new JLabel();
		time.setForeground(Color.white);
		time.setLocation(0, 50);
		time.setSize(200, 50);
		time.setFont(new Font("Serif", Font.PLAIN, 20));
		if (timeVal == 0) {
			time.setText("Time: Unlimited");
		}
		else {
		time.setText("Time: " + timeVal);
		timer = new Timer((timeVal * 1000), this);
		timer.start();
		timeUpdate = new Timer(1000, this);
		timeUpdate.start();
		}
		statPanel.add(time);

		for (int i=0; i < squares; i++) {
		clickPanels[i] = new JPanel();
		clickPanels[i].setBackground(Color.yellow);
		clickPanels[i].setLocation(randomX, randomY);
		clickPanels[i].setSize(50, 50);
		clickPanels[i].addMouseListener(this);
		add(clickPanels[i]);
		}

	}

	public void mousePressed(MouseEvent e) {

		randomX = random.nextInt(501);
		randomY = random.nextInt(501);
		int randomCol = random.nextInt(colours.length);
		for (int i=0; i < squares; i++) {
		if (e.getSource() == clickPanels[i]) {
			scoreVal += 1;
			score.setText("Score: " + scoreVal);
			clickPanels[i].setLocation(randomX, randomY);
			clickPanels[i].setBackground(colours[randomCol]);
		}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timeUpdate) {
			timeVal -= 1;
			time.setText("Time: " + timeVal);
			timeUpdate.start();
		} else if (e.getSource() == timer) {
			timer.stop();
			cpane.add(new SettingsPanel(cpane));
			cpane.remove(this);
			cpane.revalidate();
			cpane.repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
