import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.DefaultListModel;

import org.junit.Test;

public class manager_updateorder_test {
	
	public int update_test(String selectedin, String ordernoin) {
		String exceptionAsString_m = "";
		int r = 0;
		if(selectedin.equals("Paid")) { // perform update in order table and add new thing in order array list about delivering
			//DB storage of orders
			String name = "root";
	   	    String password = "password";
	   	    try{
	   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
			    r = s.executeUpdate("UPDATE orders_tbl SET pay_status = '"+selectedin+"' WHERE (orderid = '"+ordernoin+"');");
	   	    }catch (SQLException e1) {
	   	    	StringWriter sw = new StringWriter();
	   	    	e1.printStackTrace(new PrintWriter(sw));
	   	    	exceptionAsString_m = sw.toString();
	   	    }
			System.out.println("sle paid");  // need to update 0 row of array list
		}else if(selectedin.equals("Unpaid")) {
			String name = "root";
	   	    String password = "password";
	   	    try{
	   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
			    r = s.executeUpdate("UPDATE orders_tbl SET pay_status = '"+selectedin+"' WHERE (orderid = '"+ordernoin+"');");
	   	    }catch (SQLException e1) {
	   	    	StringWriter sw = new StringWriter();
	   	    	e1.printStackTrace(new PrintWriter(sw));
	   	    	exceptionAsString_m = sw.toString();
	   	    }
			System.out.println("sle unpaid");
		}else if(selectedin.equals("Delivering")) {
			String name = "root";
	   	    String password = "password";
	   	    try{
	   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
			    r = s.executeUpdate("UPDATE orders_tbl SET delivery_status = '"+selectedin+"' WHERE (orderid = '"+ordernoin+"');");
	   	    }catch (SQLException e1) {
	   	    	StringWriter sw = new StringWriter();
	   	    	e1.printStackTrace(new PrintWriter(sw));
	   	    	exceptionAsString_m = sw.toString();
	   	    }
			System.out.println("del");
		}else if(selectedin.equals("Signed for")) {
			String name = "root";
	   	    String password = "password";
	   	    try{
	   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
			    r = s.executeUpdate("UPDATE orders_tbl SET delivery_status = '"+selectedin+"' WHERE (orderid = '"+ordernoin+"');");
	   	    }catch (SQLException e1) {
	   	    	StringWriter sw = new StringWriter();
	   	    	e1.printStackTrace(new PrintWriter(sw));
	   	    	exceptionAsString_m = sw.toString();
	   	    }
			System.out.println("signed for");
		}
		return r;
	}
	
	// This test tests if a item is updated from food menu after manager updates it 
	@Test
	public void test() {
		
		//function call
		String orderno = "599";
		update_test("Unpaid",orderno);
		
		// test if pay_status updated in database
		String name = "root";
   	    String password = "password";
   	    try{
	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
	    	ResultSet r1 = s.executeQuery("SELECT pay_status FROM orders_tbl WHERE (orderid = "+orderno+");");
	    	while(r1.next()){
	    		assertEquals("Unpaid", r1.getString(1));	
	    	}
	    }catch (SQLException e1) {
	    	// TODO Auto-generated catch block
		    e1.printStackTrace();
	    }
		
	}
}
