import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class register_account_test {
	
	public int register_account(Boolean user,String email, String passwordin) {
		//DB storage of orders
		String name = "root";
   	    String password = "password";
   	    int r = 0;
   	    try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
   	    	if(user) {
   	    		r = s.executeUpdate("INSERT INTO signup values ('"+email+"','"+passwordin+"','"+"manager"+"');");
   	    	}else {
   	    		r = s.executeUpdate("INSERT INTO signup values ('"+email+"','"+passwordin+"','"+"client"+"');");
   	    	}
   	    }catch (SQLException e1) {
   	         e1.printStackTrace();
   	    }
   	    return r;
	}
	
	// here we test that user information is properly stored in database and we will verify this by using "exist" clause of MYSQL query.
	// Here 1 means the that user with give email exists.
	@Test
	public void test() {
		
		register_account(true,"junitemail4@gmail.com","anypass");
		
		// Using exists clause to see if user exists after calling the register_account method
				String name = "root";
		   	    String password = "password";
		   	    try{
			    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
			    	ResultSet r1 = s.executeQuery("SELECT EXISTS(SELECT * from signup WHERE email = 'junitemail4@gmail.com');");
			    	while(r1.next()){
			    		assertEquals(1, r1.getInt(1));	
			    	}
			    }catch (SQLException e1) {
			    	// TODO Auto-generated catch block
				    e1.printStackTrace();
			    }
	}
}
