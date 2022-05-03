import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class login_tests {
	
	
	public boolean UserAuthentication(String inemail) {
		String name = "root";
    	String password = "password";
    	Boolean is_manager = false;
    	try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   	    	ResultSet r = s.executeQuery("SELECT email,type FROM signup");
   	    	while(r.next()) {
			    if(r.getString(1).equals(inemail)) {
			    	
			    	if(r.getString(2).equals("manager")) {
			    		System.out.println("yes manager");
			    		is_manager = true;
			    		Main_Dashboard.is_manager_main = true;
			    	}
			    }
			}
   	    }catch (SQLException e1) {
   	         e1.printStackTrace();
   	    }
    	return is_manager;
	}

	// Here we authenticate the user and display main page accordingly 
	@Test
	public void test() {
		assertEquals(true,UserAuthentication("samayak@gmail.com"));	
	}

}