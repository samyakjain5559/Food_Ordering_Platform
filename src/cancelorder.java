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

public class cancelorder implements ActionListener {

	JFrame frame;
	JTextField orderno_txt;
	JTextField phoneno_txt;
	JLabel lblNewLabel,lblNewLabel_1;
	
	JButton cancel_btn,btnNewButton;
	JTextArea textArea;
	private JScrollPane scrollPane;
	/**
	 * Create the application.
	 */
	public cancelorder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 723, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    lblNewLabel = new JLabel("Enter Order Number:");
		lblNewLabel.setBounds(27, 34, 132, 13);
		frame.getContentPane().add(lblNewLabel);
		
		orderno_txt = new JTextField();
		orderno_txt.setBounds(124, 71, 187, 34);
		frame.getContentPane().add(orderno_txt);
		orderno_txt.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Enter Your Phone Number:");
		lblNewLabel_1.setBounds(27, 157, 187, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		phoneno_txt = new JTextField();
		phoneno_txt.setBounds(124, 206, 187, 34);
		frame.getContentPane().add(phoneno_txt);
		phoneno_txt.setColumns(10);
		
		cancel_btn = new JButton("Cancel This Order");
		cancel_btn.setBounds(465, 136, 169, 34);
		frame.getContentPane().add(cancel_btn);
		
		btnNewButton = new JButton("Back To Main Screen");
		btnNewButton.setBounds(27, 279, 169, 34);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(465, 265, 169, 48);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnNewButton.addActionListener(this);
		cancel_btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton) {
			frame.dispose();
			Main_Dashboard window = new Main_Dashboard();
			window.frame.setVisible(true);
		}else if(e.getSource() == cancel_btn) {
			//DB storage of orders
			removeorder();
		}
	}
	
	public void removeorder() {
		String exceptionAsString = "";
		String name = "root";
   	    String password = "password";
   	    boolean cancancel = false;
   	    // Can clear corresponding order from delivery tbl as well
   	    try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   	    	ResultSet r1 = s.executeQuery("SELECT hour,minutes,month,day FROM deliverytime_tbl WHERE (orderno = "+orderno_txt.getText()+");");
   	    	while(r1.next()){
   	    	  System.out.println("Cancel ordr db value--"+r1.getInt(1));
   	    	  LocalDateTime dt1 = LocalDateTime.now();
   	    	  //Duration duration = Duration.between(dt1,LocalDateTime.of(2022,1,15,20,50) );
   	    	  Duration duration = Duration.between(LocalDateTime.of(2022,r1.getInt(3),r1.getInt(4),r1.getInt(1),r1.getInt(2)), dt1 );
   	    	  System.out.println("Cancel ordr--"+duration.getSeconds()+" __"+dt1);
   	    	  if(duration.getSeconds() < 1200) { // Can cancel in 20 minutes
   	    		try{
   		   	    	Statement s2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   				    int r = s2.executeUpdate("DELETE FROM orders_tbl WHERE (orderid = "+orderno_txt.getText()+");");
   				    cancancel = true;
   				    System.out.println("we are here"+orderno_txt.getText());
   		   	    }catch (SQLException e1) {
   		   	    	StringWriter sw = new StringWriter();
   		   	    	e1.printStackTrace(new PrintWriter(sw));
   		   	    	exceptionAsString = sw.toString();
   		   	    }
			  }
   	    	}
   	    }catch (SQLException e1) {
   	    	StringWriter sw = new StringWriter();
   	    	e1.printStackTrace(new PrintWriter(sw));
   	    	exceptionAsString = sw.toString();
   	    }
   	    /*try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
		    int r = s.executeUpdate("DELETE FROM orders_tbl WHERE (orderid = "+orderno_txt.getText()+");");
		    System.out.println(orderno_txt.getText());
   	    }catch (SQLException e1) {
   	    	StringWriter sw = new StringWriter();
   	    	e1.printStackTrace(new PrintWriter(sw));
   	    	exceptionAsString = sw.toString();
   	    }*/
   	    if(!exceptionAsString.equals("")) {
   	    	textArea.setText(exceptionAsString);
   	    	System.out.println(exceptionAsString);
   	    }else if(cancancel == false) {
   	    	textArea.setText("Can not cancel the order as it has passed cancellation period of 20 Minutes");
   	    }else if(exceptionAsString.equals("") && cancancel == true) {
   	    	textArea.setText("Order Cancelled Successfully");
   	    }
	}
}
