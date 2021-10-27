package rowe;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btn;
	private JLabel label1;
	private JLabel label3;
	private JLabel label2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private SalesSlip slip;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(solve(textField.getText(),textField_1.getText(),textField_2.getText()));
				textArea_1.setText(findTotal(textField_1.getText()));
			}
				
		});
	}
	
	public String solve(String str1, String str2, String str3) {
		
		slip.addItem(str1, Double.parseDouble(str2), Integer.parseInt(str3));
		return slip.toString();
	}
	public String findTotal(String str) {
		return slip.total();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		slip = new SalesSlip();
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(141, 43, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 74, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 105, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btn = new JButton("Add Item");
		btn.setBounds(138, 136, 89, 23);
		frame.getContentPane().add(btn);
		
		label1 = new JLabel("Item Name");
		label1.setBounds(39, 46, 76, 14);
		frame.getContentPane().add(label1);
		
		label2 = new JLabel("Cost $");
		label2.setBounds(39, 77, 76, 14);
		frame.getContentPane().add(label2);
		
		label3 = new JLabel("Quantity");
		label3.setBounds(39, 108, 76, 14);
		frame.getContentPane().add(label3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 170, 339, 87);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(145, 275, 82, 30);
		frame.getContentPane().add(textArea_1);
	}
}
