import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;

import org.junit.Test;

public class food_order_test {
	
	DefaultListModel<String> final_item_list = new DefaultListModel<String>();
	int totalprice = 0;
	String Location = "";
	String phonenumber = "";
	String pay_status = "";
	String delivery_status = "";
	
	public int createorder(String locationin, String numberin, String pay, String deliver) {
		String adder = "";
		Object[] items = (Object[]) final_item_list.toArray();
		for(int i = 0; i < items.length; i++) {
            // 1 identifier for whole order
			String item = (String) items[i];
            String sub_string = item.substring(item.indexOf('$'), item.length() - 1);
			String price = sub_string.substring(sub_string.indexOf('$') + 1, sub_string.indexOf(']'));
			totalprice = totalprice + Integer.parseInt(price);
		}
		System.out.println(totalprice);
		Location = Location + locationin;
		phonenumber = phonenumber + numberin; 
		pay_status = pay_status + pay;
		delivery_status = delivery_status + deliver;
		return totalprice;
	}
	
	// here we are testing the order function and output here is total bill of the order
	@Test
	public void test() {
		final_item_list.addElement("[Name:kale caesar] [Price:$19] [Includes: wheat,olives,spinach] [Type:wrap]  [Size Selected:Large] "+" [Size Selected:"+"medium"+"]");
	    final_item_list.addElement("[Name:smokehouse] [Price:$18] [Includes: wheat,bread,rice,corn] [Type:burrito]  [Size Selected:Medium] "+" [Size Selected:"+"medium"+"]");
				
		assertEquals(37,createorder("canada","123456","paid","delivered"));	
	}
}
