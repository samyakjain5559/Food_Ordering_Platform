import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class register_account implements ActionListener {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JButton btnNewButton, btnNewButton_1;
	JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2;
	ButtonGroup group;
	int user = 0;
	
	/**
	 * Create the application.
	 */
	public register_account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 872, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Provide Following Information to Signup");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(220, 64, 479, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(434, 145, 276, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Please Provide Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(149, 149, 170, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please Provide Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(149, 229, 170, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(434, 231, 276, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Client");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(361, 311, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Manager");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(498, 311, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Admin");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setBounds(646, 311, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		group=new ButtonGroup();  
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Account Type:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(149, 309, 170, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton = new JButton("SignUp");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(351, 398, 170, 36);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back To Login");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(24, 444, 144, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_2.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton) {
			register_account();
		}else if(e.getSource() == rdbtnNewRadioButton) {
			user = 1; // false is client
		}else if(e.getSource() == rdbtnNewRadioButton_1) {
			user = 2; // true is manager
		}else if(e.getSource() == rdbtnNewRadioButton_2) {
			user = 3;
		}else if(e.getSource() == btnNewButton_1) {
			frame.dispose();
			login window = new login();
			window.frame.setVisible(true);
		}
	}
	
	public void register_account() {
		//DB storage of orders
		String name = "root";
   	    String password = "password";
   	    try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   	    	if(user == 2) {
   	    		int r = s.executeUpdate("INSERT INTO signup values ('"+textField.getText()+"','"+textField_1.getText()+"','"+"manager"+"');");
   	    	}else if(user == 1) {
   	    		int r = s.executeUpdate("INSERT INTO signup values ('"+textField.getText()+"','"+textField_1.getText()+"','"+"client"+"');");
   	    	}else if(user == 3) {
   	    		int r = s.executeUpdate("INSERT INTO signup values ('"+textField.getText()+"','"+textField_1.getText()+"','"+"admin"+"');");
   	    	}
   	    }catch (SQLException e1) {
   	         e1.printStackTrace();
   	    }
	}
}
