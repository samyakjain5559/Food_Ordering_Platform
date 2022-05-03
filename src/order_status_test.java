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

public class order_status_test {
	
	public String check_status(String orderno_in) {
		String exceptionAsString = "";
		String name = "root";
   	    String password = "password";
   	    String str_out = "";
   	    boolean signof = false;
    	try {
    		
    		Statement s2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
    		ResultSet r2 = s2.executeQuery("SELECT hour,minutes,month,day,orderid,itemlist,totalprice,pay_status,delivery_status FROM deliverytime_tbl,orders_tbl WHERE (orderno = "+orderno_in+" and orderid = "+orderno_in+");");
    		
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
    		    int r = s2.executeUpdate("UPDATE orders_tbl SET delivery_status = 'Signed for' WHERE (orderid = '"+orderno_in+"');");
    		}
    		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
	   	    e1.printStackTrace(new PrintWriter(sw));
	   	    exceptionAsString = sw.toString();
		}
    	return str_out;
	}
	
	// this test check if for a order number whats the status of the order. It provides information like items, total cost , if item is delivered or not.
	@Test
	public void test() {
		assertEquals("Order Number: "+"921"+"\n"+"Items Ordered: "+"[Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Large] [Name:tex mex] [Price:$17] [Includes: avacado,bread,olives,corn] [Type:burrito]  [Size Selected:Small] "+"\n"+"Order Total: $"+"35"+"\n"+"Pay Status: "+"Unpaid"+"\n"+"Delivery Status: Signed for",check_status("921"));	
	}
}
