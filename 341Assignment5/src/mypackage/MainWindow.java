package mypackage;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class MainWindow {
	JButton btnNewButton;

	private JFrame frame;
	private JTextArea textArea;
	private JFileChooser chooser;
	private File selectedFile;
	private Scanner in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean contains = false;
				
				Component parent = null;
				int returnVal = chooser.showOpenDialog(parent);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	selectedFile = chooser.getSelectedFile();
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			    }
			    try {
					in = new Scanner(selectedFile);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			    LinkedList linky = new LinkedList();
			    while(in.hasNext()) {
			    	contains = true;
			    	try
			    	{
			    	  double val = Double.parseDouble(in.next());
			    	  linky.addNode(val);
			    	}
			    	catch(NumberFormatException e2)
			    	{
			    	  System.out.println(e2);
			    	}
			    }
			    if(contains) {
			    	textArea.setText(linky.getList()+"\n"+linky.getMean()+"\n"+linky.getStdv()+"\n");			    	
			    }else {
			    	textArea.setText("File is empty");			    				    	
			    }
			}
				
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(165, 26, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(46, 147, 312, 103);
		frame.getContentPane().add(textArea);
		  chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif","txt");
		    chooser.setFileFilter(filter);
		    
		 
	}
}
