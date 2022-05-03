import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class manager_view implements ActionListener {

	JFrame frame;
	JTextField itemname_cng,itemprice_cng,iteminclude_cng,itemtype_cng;
	JButton Additem_btn,removeitem_btn,btnNewButton;
    static int item_inc_burrito = 22; // after fixed menu burrito item menu
    static int item_inc_wrap = 4;
    static int item_inc_salad = 34;
    static int item_inc_drinks = 44;
    private JButton mainscreen_btn;
    
    JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1;
    JComboBox<String> comboBox;
    
    static String[] optionsToChoose = {""};
  
    static boolean b = true;
    static boolean b2 = true;
    static boolean b3 = true; // salad
    static boolean b4 = true; // drinks
    
    static Hashtable<Integer, ArrayList<String>> burritodata = new Hashtable<Integer, ArrayList<String>>();
    static Hashtable<Integer, ArrayList<String>> wrapdata = new Hashtable<Integer, ArrayList<String>>();
    static Hashtable<Integer, ArrayList<String>> saladdata = new Hashtable<Integer, ArrayList<String>>();
    static Hashtable<Integer, ArrayList<String>> drinksdata = new Hashtable<Integer, ArrayList<String>>();
    private JTextField updateordernumber;
    private JTextArea ouput;
	/**
	 * Create the application.
	 */
	public manager_view() {
		// may be I need to set the updated item list here
		burritoitems("","","","");
		wrapmenuitems("","","",""); 
		saladmenuitems("","","","");
		drinksmenuitems("","","","");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1164, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Or Remove Item:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 28, 146, 21);
		frame.getContentPane().add(lblNewLabel);
		
		itemname_cng = new JTextField();
		itemname_cng.setBounds(129, 61, 161, 36);
		frame.getContentPane().add(itemname_cng);
		itemname_cng.setColumns(10);
		
		JLabel label = new JLabel("Item Name:");
		label.setBounds(48, 72, 71, 13);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Item Price:");
		lblNewLabel_1.setBounds(316, 72, 65, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		itemprice_cng = new JTextField();
		itemprice_cng.setBounds(389, 61, 161, 36);
		frame.getContentPane().add(itemprice_cng);
		itemprice_cng.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Includes:");
		lblNewLabel_2.setBounds(577, 72, 65, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		iteminclude_cng = new JTextField();
		iteminclude_cng.setBounds(652, 61, 161, 36);
		frame.getContentPane().add(iteminclude_cng);
		iteminclude_cng.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Type:");
		lblNewLabel_3.setBounds(841, 72, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		itemtype_cng = new JTextField();
		itemtype_cng.setBounds(896, 61, 161, 36);
		frame.getContentPane().add(itemtype_cng);
		itemtype_cng.setColumns(10);
		
		Additem_btn = new JButton("Add This Item");
		Additem_btn.setBounds(303, 149, 161, 36);
		frame.getContentPane().add(Additem_btn);
		
		removeitem_btn = new JButton("Remove This Item");
		removeitem_btn.setBounds(662, 149, 161, 36);
		frame.getContentPane().add(removeitem_btn);
		
		mainscreen_btn = new JButton("Back To Main Screen");
		mainscreen_btn.setBounds(20, 554, 185, 43);
		frame.getContentPane().add(mainscreen_btn);
		
		JLabel lblNewLabel_4 = new JLabel("Update Status of a Order:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(20, 236, 197, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		rdbtnNewRadioButton = new JRadioButton("Change Pay Status");
		rdbtnNewRadioButton.setBounds(129, 283, 161, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Delivering Status");
		rdbtnNewRadioButton_1.setBounds(316, 283, 161, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup group=new ButtonGroup();  
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(483, 283, 290, 36);
		frame.getContentPane().add(comboBox);
		
		updateordernumber = new JTextField();
		updateordernumber.setBounds(256, 351, 270, 36);
		frame.getContentPane().add(updateordernumber);
		updateordernumber.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Order Number:");
		lblNewLabel_5.setBounds(129, 362, 117, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		btnNewButton = new JButton("Perform Update");
		btnNewButton.setBounds(577, 358, 126, 21);
		frame.getContentPane().add(btnNewButton);
		
		ouput = new JTextArea();
		ouput.setBounds(828, 306, 229, 57);
		frame.getContentPane().add(ouput);
		
		Additem_btn.addActionListener(this);
		removeitem_btn.addActionListener(this);
		mainscreen_btn.addActionListener(this);
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton_1.addActionListener(this);
		btnNewButton.addActionListener(this);
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Additem_btn) {
			addnewitem();
		}else if(e.getSource() == removeitem_btn) {
			removeitem();
		}else if(e.getSource() == mainscreen_btn) {
			frame.dispose();
			Main_Dashboard window = new Main_Dashboard();
			window.frame.setVisible(true);
		}else if(e.getSource() == rdbtnNewRadioButton) {
			comboBox.removeAllItems();
			DefaultComboBoxModel<String> m = new DefaultComboBoxModel<String>();
			m.addElement("Paid");
			m.addElement("Unpaid");
			comboBox.setModel(m);
		}else if(e.getSource() == rdbtnNewRadioButton_1) {
			comboBox.removeAllItems();
			DefaultComboBoxModel<String> m = new DefaultComboBoxModel<String>();
			m.addElement("Delivering");
			m.addElement("Signed for");
			comboBox.setModel(m);
		}else if(e.getSource() == btnNewButton) { // can put in perform update order name function
			updateorders();
		}
	}
	
	public void addnewitem() {
		if(itemtype_cng.getText().equals("burrito")) {
			burritoitems(itemname_cng.getText(),itemprice_cng.getText(),iteminclude_cng.getText(),itemtype_cng.getText());
		}else if(itemtype_cng.getText().equals("drinks")) {
			drinksmenuitems(itemname_cng.getText(),itemprice_cng.getText(),iteminclude_cng.getText(),itemtype_cng.getText());
		}else if(itemtype_cng.getText().equals("salad")) {
			saladmenuitems(itemname_cng.getText(),itemprice_cng.getText(),iteminclude_cng.getText(),itemtype_cng.getText());
		}else {
			wrapmenuitems(itemname_cng.getText(),itemprice_cng.getText(),iteminclude_cng.getText(),itemtype_cng.getText());
		}	
	}
	
	public void removeitem() {
		if(itemtype_cng.getText().equals("burrito")) {
			Set<Integer> setOfKeys = burritodata.keySet();  
			Iterator<Integer> itr = setOfKeys.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				String item = (String) burritodata.get(key).get(0);
				System.out.println(item);
				
				if(item.contains(itemname_cng.getText())) {
					System.out.println("in cond remove name"+item+key);
					burritodata.remove(key);
					break;
				}
				
				/*String sub_string = item.substring(item.indexOf(':'), item.length() - 1);
				System.out.println("remove name"+sub_string+"_"+itemname_cng.getText()+"_");
				String first = itemname_cng.getText();
				System.out.println((sub_string).equals(first));
				if((itemname_cng.getText()).equals(sub_string.toString())) {
					System.out.println("in cond remove name"+sub_string+key);
					burritodata.remove(key);
				}*/
			}
		}else if(itemtype_cng.getText().equals("wrap")) {
			Set<Integer> setOfKeys = wrapdata.keySet();  
			Iterator<Integer> itr = setOfKeys.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				String item = (String) wrapdata.get(key).get(0);
				System.out.println(item);
				
				if(item.contains(itemname_cng.getText())) {
					System.out.println("in cond remove name"+item+key);
					wrapdata.remove(key);
					break;
				}
			}
		}else if(itemtype_cng.getText().equals("salad")) {
			Set<Integer> setOfKeys = saladdata.keySet();  
			Iterator<Integer> itr = setOfKeys.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				String item = (String) saladdata.get(key).get(0);
				System.out.println(item);
				
				if(item.contains(itemname_cng.getText())) {
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
				
				if(item.contains(itemname_cng.getText())) {
					System.out.println("in cond remove name"+item+key);
					drinksdata.remove(key);
					break;
				}
			}
		}
	}
	
	public void updateorders() {
		if(comboBox.isValid()) {
			String exceptionAsString_m = "";
			if(comboBox.getSelectedItem().equals("Paid")) { // perform update in order table and add new thing in order array list about delivering
				//DB storage of orders
				String name = "root";
		   	    String password = "password";
		   	    try{
		   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
				    int r = s.executeUpdate("UPDATE orders_tbl SET pay_status = '"+comboBox.getSelectedItem()+"' WHERE (orderid = '"+updateordernumber.getText()+"');");
		   	    }catch (SQLException e1) {
		   	    	StringWriter sw = new StringWriter();
		   	    	e1.printStackTrace(new PrintWriter(sw));
		   	    	exceptionAsString_m = sw.toString();
		   	    }
				System.out.println("sle paid");  // need to update 0 row of array list
			}else if(comboBox.getSelectedItem().equals("Unpaid")) {
				String name = "root";
		   	    String password = "password";
		   	    try{
		   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
				    int r = s.executeUpdate("UPDATE orders_tbl SET pay_status = '"+comboBox.getSelectedItem()+"' WHERE (orderid = '"+updateordernumber.getText()+"');");
		   	    }catch (SQLException e1) {
		   	    	StringWriter sw = new StringWriter();
		   	    	e1.printStackTrace(new PrintWriter(sw));
		   	    	exceptionAsString_m = sw.toString();
		   	    }
				System.out.println("sle unpaid");
			}else if(comboBox.getSelectedItem().equals("Delivering")) {
				String name = "root";
		   	    String password = "password";
		   	    try{
		   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
				    int r = s.executeUpdate("UPDATE orders_tbl SET delivery_status = '"+comboBox.getSelectedItem()+"' WHERE (orderid = '"+updateordernumber.getText()+"');");
		   	    }catch (SQLException e1) {
		   	    	StringWriter sw = new StringWriter();
		   	    	e1.printStackTrace(new PrintWriter(sw));
		   	    	exceptionAsString_m = sw.toString();
		   	    }
				System.out.println("del");
			}else if(comboBox.getSelectedItem().equals("Signed for")) {
				String name = "root";
		   	    String password = "password";
		   	    try{
		   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
				    int r = s.executeUpdate("UPDATE orders_tbl SET delivery_status = '"+comboBox.getSelectedItem()+"' WHERE (orderid = '"+updateordernumber.getText()+"');");
		   	    }catch (SQLException e1) {
		   	    	StringWriter sw = new StringWriter();
		   	    	e1.printStackTrace(new PrintWriter(sw));
		   	    	exceptionAsString_m = sw.toString();
		   	    }
				System.out.println("signed for");
			}
			if(exceptionAsString_m.equals("")) {
				ouput.setText("Order Updated Successfully");
	   	    }else {
	   	    	ouput.setText(exceptionAsString_m);
	   	    }
		}
	}
}
