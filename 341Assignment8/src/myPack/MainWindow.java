package myPack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame frame;
	private JTextField textSku;
	private JTextField textTitle;
	private JTextField textPrice;
	private JTextField textQuant;
	private JButton btnAdd;
	private JButton btnRem;
	private JButton btnDisp;
	private JButton btnDispAll;
	private JTextArea results;
	private Library lib;
	private JButton btnExit;
	

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
		lib = new Library("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lib = new Library(textFile.getText());
				lib.addBook(Integer.parseInt(textSku.getText()), textTitle.getText(), Integer.parseInt(textPrice.getText()), Integer.parseInt(textQuant.getText()));
				results.setText("Book added");
			}
		});
		btnRem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lib = new Library(textFile.getText());
				lib.remBook(Integer.parseInt(textSku.getText()));
				results.setText("Book removed");
			}
		});
		btnDisp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lib = new Library(textFile.getText());
				results.setText(lib.dispBook(Integer.parseInt(textSku.getText())));		
			}
		});
		btnDispAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lib = new Library(textFile.getText());
				results.setText(lib.dispAll());
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lib = new Library(textFile.getText());
				lib.exit();
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
		
		 btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		 btnRem = new JButton("Remove");
		btnRem.setBounds(103, 11, 89, 23);
		frame.getContentPane().add(btnRem);
		
		 btnDisp = new JButton("Display");
		btnDisp.setBounds(196, 11, 89, 23);
		frame.getContentPane().add(btnDisp);
		
		btnDispAll = new JButton("Display All");
		btnDispAll.setBounds(302, 11, 107, 23);
		frame.getContentPane().add(btnDispAll);
		
		textSku = new JTextField();
		textSku.setBounds(90, 45, 319, 20);
		frame.getContentPane().add(textSku);
		textSku.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setColumns(10);
		textTitle.setBounds(90, 67, 319, 20);
		frame.getContentPane().add(textTitle);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(90, 90, 319, 20);
		frame.getContentPane().add(textPrice);
		
		textQuant = new JTextField();
		textQuant.setColumns(10);
		textQuant.setBounds(90, 112, 319, 20);
		frame.getContentPane().add(textQuant);
		
		JLabel lblNewLabel = new JLabel("SKU");
		lblNewLabel.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(10, 93, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(10, 118, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		 results = new JTextArea();
		results.setBounds(10, 141, 414, 81);
		frame.getContentPane().add(results);
		
		btnExit = new JButton("Save");
		btnExit.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
