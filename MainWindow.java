package clickergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private Container cpane;

	public MainWindow() {

		cpane = this.getContentPane();
		
		StartMenuPanel sm = new StartMenuPanel(cpane);
		this.add(sm);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}

		});
	}
}
