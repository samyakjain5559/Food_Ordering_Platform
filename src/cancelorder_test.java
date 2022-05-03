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

public class cancelorder_test {
	
	public int removeorder(String ordernoin) {
		String exceptionAsString = "";
		String name = "root";
   	    String password = "password";
   	    boolean cancancel = false;
   	    int r = 0;
   	    // Can clear corresponding order from delivery tbl as well
   	    try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   	    	ResultSet r1 = s.executeQuery("SELECT hour,minutes,month,day FROM deliverytime_tbl WHERE (orderno = "+ordernoin+");");
   	    	while(r1.next()){
   	    	  System.out.println("Cancel ordr db value--"+r1.getInt(1));
   	    	  LocalDateTime dt1 = LocalDateTime.now();
   	    	  //Duration duration = Duration.between(dt1,LocalDateTime.of(2022,1,15,20,50) );
   	    	  Duration duration = Duration.between(LocalDateTime.of(2022,r1.getInt(3),r1.getInt(4),r1.getInt(1),r1.getInt(2)), dt1 );
   	    	  System.out.println("Cancel ordr--"+duration.getSeconds()+" __"+dt1);
   	    	  if(duration.getSeconds() < 1200) { // Can cancel in 20 minutes
   	    		try{
   		   	    	Statement s2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   				    r = s2.executeUpdate("DELETE FROM orders_tbl WHERE (orderid = "+ordernoin+");");
   				    cancancel = true;
   				    System.out.println("we are here"+ordernoin);
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
   	    return r;
	}
	
	// here we test cancel order and function should not allow the user to cancel the order after 20 minutes
	// expected output here is 0 because after 20 minutes the function will not cancel the order. So no row is returned by the database
	@Test
	public void test() {
		assertEquals(0,removeorder("599"));	
	}
}
