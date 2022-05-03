import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class manage_accounts implements ActionListener {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	JButton btnNewButton,btnNewButton_1 ;
	
	/**
	 * Create the application.
	 */
	public manage_accounts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add/Remove Client/Manager Account:");
		lblNewLabel.setBounds(35, 39, 231, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Email:");
		lblNewLabel_1.setBounds(64, 101, 101, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(200, 93, 244, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password:");
		lblNewLabel_2.setBounds(64, 187, 101, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 179, 244, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(234, 250, 128, 30);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back To Main Menu");
		btnNewButton_1.setBounds(23, 288, 167, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton_1) {
			frame.dispose();
			Main_Dashboard window = new Main_Dashboard();
			window.frame.setVisible(true);
		}
	}
}
