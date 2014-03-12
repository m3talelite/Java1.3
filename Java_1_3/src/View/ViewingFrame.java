package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ViewingFrame extends JFrame {

	private JFrame frame;
	private Dimension size;
	private JLabel statusLabel = new JLabel("Status");
	
	public ViewingFrame(){
		//initializes the JFrame
		initJFrame(new Dimension(640, 480));
		
		//Timer for the repaint of the screen updates 4 times a second
		Timer timer = new Timer(1000 / 4, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();
	}
	
	private void initJFrame(Dimension size){
		this.size = size;
		
		//TODO: think of a name to call the frame
		frame = new JFrame();
		frame.setSize(size);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TODO: Initialize the rest of the frame (JPanels ect)
		/** Panels for the GUI **/
		JPanel statusPanel = new JPanel(new FlowLayout());
		JPanel contentPanel = new JPanel(new BorderLayout());
		
		/** Add everything to the panels and frame**/
		statusPanel.add(statusLabel);
		contentPanel.add(statusPanel, BorderLayout.SOUTH);
		
		frame.add(contentPanel);
		
		/** finish the initialize **/
		contentPanel.setPreferredSize(getMaximumSize());
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public JLabel getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(JLabel statusLabel) {
		this.statusLabel = statusLabel;
	}
}
