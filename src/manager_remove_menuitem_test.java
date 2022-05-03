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

public class manager_remove_menuitem_test {
	
    private Hashtable<Integer, ArrayList<String>> burritodata = new Hashtable<Integer, ArrayList<String>>();
    private Hashtable<Integer, ArrayList<String>> wrapdata = new Hashtable<Integer, ArrayList<String>>();
    private Hashtable<Integer, ArrayList<String>> saladdata = new Hashtable<Integer, ArrayList<String>>();
    private Hashtable<Integer, ArrayList<String>> drinksdata = new Hashtable<Integer, ArrayList<String>>();
	
	public void removeitem(String itemtype, String itemname) {
		if(itemtype.equals("burrito")) {
			Set<Integer> setOfKeys = burritodata.keySet();  
			Iterator<Integer> itr = setOfKeys.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				String item = (String) burritodata.get(key).get(0);
				System.out.println(item);
				
				if(item.contains(itemname)) {
					System.out.println("in cond remove name"+item+key);
					burritodata.remove(key);
					break;
				}
			}
		}else if(itemtype.equals("wrap")) {
			Set<Integer> setOfKeys = wrapdata.keySet();  
			Iterator<Integer> itr = setOfKeys.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				String item = (String) wrapdata.get(key).get(0);
				System.out.println(item);
				
				if(item.contains(itemname)) {
					System.out.println("in cond remove name"+item+key);
					wrapdata.remove(key);
					break;
				}
			}
		}else if(itemtype.equals("salad")) {
			Set<Integer> setOfKeys = saladdata.keySet();  
			Iterator<Integer> itr = setOfKeys.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				String item = (String) saladdata.get(key).get(0);
				System.out.println(item);
				
				if(item.contains(itemname)) {
					System.out.println("in cond remove name"+item+key);
					saladdata.remove(key);
					break;
				}
			}
		}else {
			Set<Integer> setOfKeys = drinksdata.keySet();  
			Iterator<Integer> itr = setOfKeys.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				String item = (String) drinksdata.get(key).get(0);
				System.out.println(item);
				
				if(item.contains(itemname)) {
					System.out.println("in cond remove name"+item+key);
					drinksdata.remove(key);
					break;
				}
			}
		}
	}
	
	// This test tests if a item is removed from food menu after manager removes it 
	@Test
	public void test() {
		
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
			
		removeitem("wrap","cobb");
		assertEquals(false,wrapdata.containsValue("cobb"));	
	}
}
