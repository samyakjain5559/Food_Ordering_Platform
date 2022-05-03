import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class Main_Dashboard extends JFrame implements ActionListener{

    JFrame frame;
	JButton btnNewButton,btnNewButton_1,btnNewButton_2;
	JButton btnNewButton_3;
    static Boolean is_manager_main = false;
    static Boolean is_admin_main = false;
    private JButton btnNewButton_4;

	/**
	 * Create the application.
	 */
	public Main_Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 860, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Freshii");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(321, 78, 197, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("What Would You Like To Do Today?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(255, 146, 389, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton("Order Food");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(126, 267, 219, 41);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Access Managers View");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(483, 267, 219, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		// disable manager 
		if(is_manager_main == false && is_admin_main == false) {
			btnNewButton_1.setEnabled(false);
		}
		
		btnNewButton_2 = new JButton("Cancel Order");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(126, 374, 216, 41);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Check Order Status");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(483, 374, 219, 41);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Manage Accounts");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(321, 473, 197, 41);
		frame.getContentPane().add(btnNewButton_4);
		
		// disable manager 
		if(is_admin_main == false) {
			btnNewButton_4.setEnabled(false);
		}
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);
		btnNewButton_3.addActionListener(this);
		btnNewButton_4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton) {
			accessFoodDashboard();
		}else if(e.getSource() == btnNewButton_1) {
			accessmanagerDashboard();
		}else if(e.getSource() == btnNewButton_2) {
			accesscancelorderDashboard();
		}else if(e.getSource() == btnNewButton_3) {
			accesscheckstatusDashboard();
		}else if(e.getSource() == btnNewButton_4) {
			frame.dispose();
			manage_accounts window = new manage_accounts();
			window.frame.setVisible(true);
		}
	}
	
	public void accessFoodDashboard() {
		frame.dispose();
		food_menu window = new food_menu();
		window.frame.setVisible(true);
	}
	
	public void accessmanagerDashboard() {
		frame.dispose();
		manager_view window = new manager_view();
		window.frame.setVisible(true);
	}
	
	public void accesscheckstatusDashboard() {
		frame.dispose();
		checkstatus window = new checkstatus();
		window.frame.setVisible(true);
	}

	public void accesscancelorderDashboard() {
		frame.dispose();
		cancelorder window = new cancelorder();
		window.frame.setVisible(true);
	}


}
