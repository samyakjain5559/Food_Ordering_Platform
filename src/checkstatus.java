import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class checkstatus implements ActionListener {

	JFrame frame;
	JTextField ordno_txt;
	JTextField phnno_txt;
	JButton status_btn,btnNewButton;
	JTextArea output;
	private JScrollPane scrollPane;
	
	/**
	 * Create the application.
	 */
	public checkstatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 695, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Your Order Number:");
		lblNewLabel.setBounds(26, 36, 197, 13);
		frame.getContentPane().add(lblNewLabel);
		
		ordno_txt = new JTextField();
		ordno_txt.setBounds(127, 75, 208, 34);
		frame.getContentPane().add(ordno_txt);
		ordno_txt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Please Enter Your Phone Number:");
		lblNewLabel_1.setBounds(26, 151, 197, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		phnno_txt = new JTextField();
		phnno_txt.setBounds(127, 193, 208, 34);
		frame.getContentPane().add(phnno_txt);
		phnno_txt.setColumns(10);
		
		status_btn = new JButton("Check Status");
		status_btn.setBounds(450, 128, 170, 36);
		frame.getContentPane().add(status_btn);
		
		btnNewButton = new JButton("Back To Main Screen");
		btnNewButton.setBounds(26, 358, 160, 34);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 265, 480, 75);
		frame.getContentPane().add(scrollPane);
		
		output = new JTextArea();
		scrollPane.setViewportView(output);
		
		status_btn.addActionListener(this);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == status_btn) {
			String exceptionAsString = "";
			String name = "root";
	   	    String password = "password";
	   	    String str_out = "";
	   	    boolean signof = false;
	    	try {
	    		
	    		Statement s2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
	    		ResultSet r2 = s2.executeQuery("SELECT hour,minutes,month,day,orderid,itemlist,totalprice,pay_status,delivery_status FROM deliverytime_tbl,orders_tbl WHERE (orderno = "+ordno_txt.getText()+" and orderid = "+ordno_txt.getText()+");");
	    		while(r2.next()) {
	    			LocalDateTime dt1 = LocalDateTime.now();
		   	    	Duration duration = Duration.between(LocalDateTime.of(2022,r2.getInt(3),r2.getInt(4),r2.getInt(1),r2.getInt(2)), dt1 );
		   	    	if(duration.getSeconds() > 1800) {
	    				str_out = "Order Number: "+r2.getString(5)+"\n"+"Items Ordered: "+r2.getString(6)+"\n"+"Order Total: $"+r2.getString(7)+"\n"+"Pay Status: "+r2.getString(8)+"\n"+"Delivery Status: Signed for";
					    signof = true;
	    				//int r = s2.executeUpdate("UPDATE orders_tbl SET delivery_status = 'Signed for' WHERE (orderid = '"+ordno_txt.getText()+"');");
	    			}else {
		    			str_out = "Order Number: "+r2.getString(5)+"\n"+"Items Ordered: "+r2.getString(6)+"\n"+"Order Total: $"+r2.getString(7)+"\n"+"Pay Status: "+r2.getString(8)+"\n"+"Delivery Status: Delivering";
	    			    signof = false;
	    			}
	    		}
	    		if(signof) {
	    			Statement s1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
	    		    int r = s2.executeUpdate("UPDATE orders_tbl SET delivery_status = 'Signed for' WHERE (orderid = '"+ordno_txt.getText()+"');");
	    		}
	    		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				StringWriter sw = new StringWriter();
		   	    e1.printStackTrace(new PrintWriter(sw));
		   	    exceptionAsString = sw.toString();
			}
	    	
	    	if(!exceptionAsString.equals("")) {
	    		output.setText(exceptionAsString);
	   	    	System.out.println(exceptionAsString);
	    	}else {
	    		output.setText(str_out);
	    	}
		}else if(e.getSource() == btnNewButton) {
			frame.dispose();
			Main_Dashboard window = new Main_Dashboard();
			window.frame.setVisible(true);
		}
	}

}
