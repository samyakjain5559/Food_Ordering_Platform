import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.DefaultListModel;

import org.junit.Test;

public class manager_addnew_menuitem_test {
	
    private static Hashtable<Integer, ArrayList<String>> burritodata = new Hashtable<Integer, ArrayList<String>>();
    private static Hashtable<Integer, ArrayList<String>> wrapdata = new Hashtable<Integer, ArrayList<String>>();
    private static Hashtable<Integer, ArrayList<String>> saladdata = new Hashtable<Integer, ArrayList<String>>();
    private static Hashtable<Integer, ArrayList<String>> drinksdata = new Hashtable<Integer, ArrayList<String>>();
    
    private static int item_inc_burrito = 22; // after fixed menu burrito item menu
    private static int item_inc_wrap = 4;
    private static int item_inc_salad = 34;
    private static int item_inc_drinks = 44;
    
    private static boolean b = true;
    private static boolean b2 = true;
    private static boolean b3 = true; // salad
    private static boolean b4 = true; // drinks
    
    public static Hashtable<Integer, ArrayList<String>> burritoitems(String name, String price, String inc, String type){
		 // need to make public to add item
		if(b == true) {
		    burritodata.put(20, new ArrayList<String>(){
	        {
	                add("[Name:smokehouse]");  // item name
	                add("[Price:$18]");       // price
	                add("[Includes: wheat,bread,rice,corn]");
	                add("[Type:burrito]");
	        }
	        });
			burritodata.put(21, new ArrayList<String>(){
	            {
	                add("[Name:tex mex]");  // item name
	                add("[Price:$17]");       // price
	                add("[Includes: avacado,bread,olives,corn]");
	                add("[Type:burrito]");
	            }
	        });
			b = false;
		}
		
		if(!name.equals("")) {
		    burritodata.put(item_inc_burrito, new ArrayList<String>(){
	            {
	                add("[Name:"+name+"]");  // item name
	                add("[Price:$"+price+"]");       // price
	                add("[Includes: "+inc+"]");
	                add("[Type:"+type+"]");
	            }
	        });
			System.out.println("Burrito list after adding"+burritodata.size());
			item_inc_burrito++;
		}
		return burritodata;
	}
	
   public Hashtable<Integer, ArrayList<String>> wrapmenuitems(String name, String price, String inc, String type) { // here item start from 0
		if(b2 == true) {
			wrapdata.put(0, new ArrayList<String>(){
	            {
	                add("[Name:fiesta]");  // item name
	                add("[Price:$18]");       // price
	                add("[Includes: wheat,flour,cucumber]");
	                add("[Type:wrap]");
	            }
	        });
			wrapdata.put(1, new ArrayList<String>(){
	            {
	                add("[Name:cobb]");  // item name
	                add("[Price:$17]");       // price
	                add("[Includes: onions,gram,olives]");
	                add("[Type:wrap]");
	            }
	        });
			wrapdata.put(2, new ArrayList<String>(){
	            {
	                add("[Name:market]");  // item name
	                add("[Price:$11]");       // price
	                add("[Includes: parsley,wheat,spinach]");
	                add("[Type:wrap]");
	            }
	        });
			wrapdata.put(3, new ArrayList<String>(){
	            {
	                add("[Name:kale caesar]");  // item name
	                add("[Price:$19]");       // price
	                add("[Includes: wheat,olives,spinach]");
	                add("[Type:wrap]");
	            }
	        });
			b2 = false;
		}
		if(!name.equals("")) {
			wrapdata.put(item_inc_wrap, new ArrayList<String>(){
	            {
	                add("[Name:"+name+"]");  // item name
	                add("[Price:$"+price+"]");       // price
	                add("[Includes: "+inc+"]");
	                add("[Type:"+type+"]");
	            }
	        });
			System.out.println("wrap list after adding"+wrapdata.size());
			item_inc_wrap++;
		}
		return wrapdata;
	}
   
   public Hashtable<Integer, ArrayList<String>> saladmenuitems(String name, String price, String inc, String type) { // here item start from 0
		if(b3 == true) {
			saladdata.put(30, new ArrayList<String>(){
	            {
	                add("[Name:mediterranean]");  // item name
	                add("[Price:$13]");       // price
	                add("[Includes: wheat,flour,cucumber,green]");
	                add("[Type:salad]");
	            }
	        });
			saladdata.put(31, new ArrayList<String>(){
	            {
	                add("[Name:pangoa]");  // item name
	                add("[Price:$15]");       // price
	                add("[Includes: onions,gram,sauce,corn]");
	                add("[Type:salad]");
	            }
	        });
			saladdata.put(32, new ArrayList<String>(){
	            {
	                add("[Name:bamboo]");  // item name
	                add("[Price:$10]");       // price
	                add("[Includes: cabbage,wheat,carrot]");
	                add("[Type:salad]");
	            }
	        });
			saladdata.put(33, new ArrayList<String>(){
	            {
	                add("[Name:texmex]");  // item name
	                add("[Price:$17]");       // price
	                add("[Includes: wheat,ranch,yogurt]");
	                add("[Type:salad]");
	            }
	        });
			b3 = false;
		}
		if(!name.equals("")) {
			saladdata.put(item_inc_salad, new ArrayList<String>(){
	            {
	                add("[Name:"+name+"]");  // item name
	                add("[Price:$"+price+"]");       // price
	                add("[Includes: "+inc+"]");
	                add("[Type:"+type+"]");
	            }
	        });
			System.out.println("salad list after adding"+saladdata.size());
			item_inc_salad++;
		}
		return saladdata;
	}
   
   public Hashtable<Integer, ArrayList<String>> drinksmenuitems(String name, String price, String inc, String type) { // here item start from 0
		if(b4 == true) {
			drinksdata.put(40, new ArrayList<String>(){
	            {
	                add("[Name:chocolate]");  // item name
	                add("[Price:$7]");       // price
	                add("[Includes: milk,coco,sugar]");
	                add("[Type:drinks]");
	            }
	        });
			drinksdata.put(41, new ArrayList<String>(){
	            {
	                add("[Name:green]");  // item name
	                add("[Price:$8]");       // price
	                add("[Includes: kale,almond,milk,banana]");
	                add("[Type:drinks]");
	            }
	        });
			drinksdata.put(42, new ArrayList<String>(){
	            {
	                add("[Name:mango]");  // item name
	                add("[Price:$10]");       // price
	                add("[Includes: mango,milk,sugar]");
	                add("[Type:drinks]");
	            }
	        });
			drinksdata.put(43, new ArrayList<String>(){
	            {
	                add("[Name:strawberry]");  // item name
	                add("[Price:$7]");       // price
	                add("[Includes: strawberry,banana,yogurt,milk]");
	                add("[Type:drinks]");
	            }
	        });
			b4 = false;
		}
		if(!name.equals("")) {
			drinksdata.put(item_inc_drinks, new ArrayList<String>(){
	            {
	                add("[Name:"+name+"]");  // item name
	                add("[Price:$"+price+"]");       // price
	                add("[Includes: "+inc+"]");
	                add("[Type:"+type+"]");
	            }
	        });
			System.out.println("drinks list after adding"+drinksdata.size());
			item_inc_drinks++;
		}
		return drinksdata;
	}
   
	// This test tests if a item is added to food menu after manager added it 
	@Test
	public void test() {
		wrapmenuitems("testitem", "12", "test includes", "wrap");
		assertEquals("[[Name:testitem], [Price:$12], [Includes: test includes], [Type:wrap]]",wrapdata.get(4).toString());	
	}
}
