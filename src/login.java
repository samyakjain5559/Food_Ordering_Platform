import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class login implements ActionListener {

	JFrame frame;
	JTextField textField;
	JTextField textField_1;
	JButton btnNewButton, btnNewButton_1;
	Boolean is_manager = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 731, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Freshii");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(270, 61, 247, 44);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(124, 159, 182, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(57, 162, 57, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(376, 165, 85, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(466, 159, 182, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(286, 243, 135, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Dont Have An Account ? ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(246, 322, 349, 44);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBounds(286, 396, 135, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // can put in user authentication
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton) {
			UserAuthentication();
		}else if(e.getSource() == btnNewButton_1) {
			frame.dispose();
			register_account window = new register_account();
			window.frame.setVisible(true);
		}
	}
	
	public void UserAuthentication() {
		String name = "root";
    	String password = "password";
    	try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   	    	ResultSet r = s.executeQuery("SELECT email,type FROM signup");
   	    	while(r.next()) {
			    if(r.getString(1).equals(textField.getText())) {
			    	
			    	if(r.getString(2).equals("manager")) {
			    		System.out.println("yes manager");
			    		is_manager = true;
			    		Main_Dashboard.is_manager_main = true;
			    	}else if(r.getString(2).equals("admin")) {
			    		Main_Dashboard.is_admin_main = true;
			    	}
			    	
			    	frame.dispose();
			    	Main_Dashboard window = new Main_Dashboard();
					window.frame.setVisible(true);
			    }
			}
   	    }catch (SQLException e1) {
   	         e1.printStackTrace();
   	    }
	}
}
