package clickergame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class Mode1 extends JPanel implements ActionListener, MouseListener {
	private JPanel clickPanel, statPanel;
	private JLabel score, time;
	private Color colorList[] = { Color.cyan, Color.yellow, Color.green, Color.magenta, Color.orange, Color.red,
			Color.blue, Color.pink };
	private int scoreVal, timeVal, randomX, randomY;
	private Timer timer, timeUpdate;
	private Container cpane;
	static Random random = new Random();

	Mode1(Container cpane) {
		this.cpane = cpane;

		this.setLayout(null);
		this.setSize(575, 575);
		this.setBackground(Color.black);
		randomX = random.nextInt(501);
		randomY = random.nextInt(501);
		scoreVal = 0;
		timeVal = 60;

		statPanel = new JPanel();
		statPanel.setLayout(null);
		statPanel.setSize(100, 100);
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
		time.setSize(100, 50);
		time.setFont(new Font("Serif", Font.PLAIN, 20));
		time.setText("Time: " + timeVal);
		statPanel.add(time);

		timer = new Timer(60000, this);
		timer.start();
		timeUpdate = new Timer(1000, this);
		timeUpdate.start();

		clickPanel = new JPanel();
		clickPanel.setBackground(Color.yellow);
		clickPanel.setLocation(randomX, randomY);
		clickPanel.setSize(50, 50);
		clickPanel.addMouseListener(this);
		add(clickPanel);

	}

	public void mousePressed(MouseEvent e) {

		randomX = random.nextInt(501);
		randomY = random.nextInt(501);
		int randomCol = random.nextInt(colorList.length);
		if (e.getSource() == clickPanel) {
			scoreVal += 1;
			score.setText("Score: " + scoreVal);
			clickPanel.setLocation(randomX, randomY);
			clickPanel.setBackground(colorList[randomCol]);
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
			this.setVisible(false);
			cpane.add(new ModeSelect(cpane));
			cpane.remove(this);
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
