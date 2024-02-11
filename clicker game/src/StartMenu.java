package clickergame;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

public class ClickerGame implements ActionListener, MouseListener{
	
	private JPanel startGUI, modeGUI, mode1GUI, clickPanel, scorePanel;
	private JButton startButton, mode1Button;
	private JLabel score, time;
	private Color colorList[] = {Color.cyan, Color.yellow, Color.green, Color.magenta, Color.orange, Color.red};
	int scoreVal, timeVal;
	private Timer mode1Time, timeUpdate;
	static JFrame frame = new JFrame("Clicker Game");
	static ClickerGame demo = new ClickerGame();
	static Random random = new Random();
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(575, 575);
				frame.setVisible(true);
				ShowStartGUI();
			}
		});
	}
	private static void ShowStartGUI() {
		
		frame.setContentPane(demo.createStartGUI()); 
		
		}
	
	private static void ShowModeGUI() {
		
		frame.setContentPane(demo.createModeGUI()); 
		
		}
	
private static void ShowMode1GUI() {
		
		frame.setContentPane(demo.createMode1GUI()); 
		
		}
	
	public JPanel createStartGUI() {
		
		startGUI = new JPanel();
		startGUI.setLayout(null);
		startGUI.setSize(575, 575);
		startGUI.setBackground(Color.black);
		
		
		startButton = new JButton("Start");
        startButton.setLocation(100, 100);
        startButton.setSize(100, 50);
        startButton.addActionListener(this);
        startGUI.add(startButton);

		return startGUI;
	}
	
	public JPanel createModeGUI() {
		modeGUI = new JPanel();
		modeGUI.setLayout(null);
		modeGUI.setSize(575, 575);
		modeGUI.setBackground(Color.black);
		

 		mode1Button = new JButton("Mode 1");
        mode1Button.setLocation(100, 100);
        mode1Button.setSize(100, 50);
        mode1Button.addActionListener(this);
        modeGUI.add(mode1Button);
		return modeGUI;
	}
	
	public JPanel createMode1GUI() {
		mode1GUI = new JPanel();
		mode1GUI.setLayout(null);
		mode1GUI.setSize(575, 575);
		mode1GUI.setBackground(Color.black);
		int randomX = random.nextInt(501);
		int randomY = random.nextInt(501);
		scoreVal = 0;
        timeVal = 60;
		
		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setSize(100, 100);
		scorePanel.setBackground(Color.black);
		mode1GUI.add(scorePanel);
	
		score = new JLabel();
		score.setForeground(Color.white);
        score.setLocation(0, 0);
        score.setSize(100, 50);
        score.setFont(new Font("Serif", Font.PLAIN, 20));
        score.setText("Score: " + scoreVal);
        scorePanel.add(score);
        
        time = new JLabel();
		time.setForeground(Color.white);
        time.setLocation(0, 50);
        time.setSize(100, 50);
        time.setFont(new Font("Serif", Font.PLAIN, 20));
        time.setText("Time: " + timeVal);
        scorePanel.add(time);
		
        clickPanel = new JPanel();
		clickPanel.setBackground(Color.yellow);
        clickPanel.setLocation(randomX, randomY);
        clickPanel.setSize(50, 50);
        clickPanel.addMouseListener(this);
        mode1GUI.add(clickPanel);
        
        mode1Time = new Timer(60000, this );
        mode1Time.start();
        timeUpdate = new Timer(1000, this);
        timeUpdate.start();
        
		return mode1GUI;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == startButton) {
			ShowModeGUI();
		}
		else if(e.getSource() == mode1Button) {
			ShowMode1GUI();
		}
		else if(e.getSource() == timeUpdate) {
			timeVal -= 1;
			time.setText("Time: " + timeVal);
			timeUpdate.start();
		}
		else if(e.getSource() == mode1Time) {
			mode1Time.stop();
			ShowModeGUI();
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		int randomX = random.nextInt(501);
		int randomY = random.nextInt(501);
		int randomCol = random.nextInt(colorList.length);
		if(e.getSource() == clickPanel) {
			scoreVal += 1;
			score.setText("Score: " + scoreVal);
			clickPanel.setLocation(randomX, randomY);
			clickPanel.setBackground(colorList[randomCol]);
		}
		
	}

	public void mouseReleased(MouseEvent e) {

		
	}
	public void mouseEntered(MouseEvent e) {

		
	}
	public void mouseExited(MouseEvent e) {
		
	}
}

