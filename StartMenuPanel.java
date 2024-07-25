package clickergame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class StartMenuPanel extends JPanel implements ActionListener {
    private Container cpane;
    private JButton startButton;

    public StartMenuPanel(Container cpane) {
        this.cpane = cpane;
        initializePanel();
        initializeComponents();
    }

    private void initializePanel() {
        this.setLayout(new BorderLayout());
    }

    private void initializeComponents() {
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 50));
        startButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(startButton, new GridBagConstraints());

        this.add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            cpane.remove(this);
            cpane.add(new SettingsPanel(cpane));
            cpane.revalidate();
            cpane.repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clicker Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Container cpane = frame.getContentPane();
        cpane.setLayout(new CardLayout());
        cpane.add(new StartMenuPanel(cpane), "StartMenu");

        frame.setVisible(true);
    }
}