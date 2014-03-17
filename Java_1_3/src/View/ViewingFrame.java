package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.CollectionClasses;

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
		
		frame = new JFrame("Book Collection");
		frame.setSize(size);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TODO: Initialize the rest of the frame (JPanels ect)
		/** Panels for the GUI **/
		JPanel statusPanel = new JPanel(new FlowLayout());
		JPanel contentPanel = new JPanel(new BorderLayout());
		
		/** Add everything to the panels and frame**/
		statusPanel.add(statusLabel);
		contentPanel.add(getCenterPanel(), BorderLayout.CENTER);
		contentPanel.add(statusPanel, BorderLayout.SOUTH);
		contentPanel.add(getButtonPanel(),BorderLayout.WEST);
		
		frame.setJMenuBar(getCostumMenuBar());
		frame.add(contentPanel);
		
		/** finish the initialize **/
		contentPanel.setPreferredSize(getMaximumSize());
		frame.setVisible(true);
	}
	
	private JPanel getButtonPanel(){
		JPanel buttonListPanel = new JPanel(new GridLayout(4,0));
		buttonListPanel.add(new JButton("Sort on name"));
		buttonListPanel.add(new JButton("Sort on price"));
		buttonListPanel.add(new JButton("Sort on year"));
		buttonListPanel.add(new JButton("Sort on id"));
		
		return buttonListPanel;
	}
	
	private JPanel getCenterPanel(){
		JPanel centerPanel = new JPanel();
		centerPanel.add(new JLabel(""));
		centerPanel.setBackground(Color.WHITE);
		return centerPanel;
	}
	
	private JMenuBar getCostumMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		
		JMenuItem menuItemSaveObject = new JMenuItem("Save File Object");
		menuItemSaveObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Need to save as object file
				
			}
		});
		JMenuItem menuItemLoadObject = new JMenuItem("Save File Object");
		menuItemSaveObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Need to load as object file
				
			}
		});
		JMenuItem menuItemSaveText = new JMenuItem("Save File Object");
		menuItemSaveObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Need to save as text file
				
			}
		});
		JMenuItem menuItemLoadText = new JMenuItem("Save File Object");
		menuItemSaveObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Need to load as text file
				
			}
		});
		JMenuItem menuItemAbout = new JMenuItem("About");
		menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, 
						"This program was build by\n" +
						"Vincent Stout en Jelle Braat\n" +
						"in the year 2014.",
						"About",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		
		
		menuFile.add(menuItemSaveObject);
		menuFile.add(menuItemLoadObject);
		menuFile.add(menuItemSaveText);
		menuFile.add(menuItemLoadText);
		menuFile.addSeparator();
		menuFile.add(menuItemAbout);
		
		menuBar.add(menuFile);
		return menuBar;
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
