import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class food_menu implements MouseListener,ActionListener {

	JFrame frame;
	JTextField search_field;
	JList<String> burritos_menu,search_result,order_list,wrapsmenu,saladsmenu,drinksmenu;
	JScrollPane scrollPane_1,scrollPane_2;
	JLabel lblNewLabel_3;
	
	DefaultListModel<String> final_item_list = new DefaultListModel<String>();
	JButton checkout_btn;
	
	int totalprice = 0;
	String pay_status = "";
	String delivery_status = "";
	String Location = "";
	String phonenumber = "";
	private JLabel lblNewLabel_4;
	private JTextField location_input;
	private JLabel lblNewLabel_5;
	private JTextField number_input;
	private JButton back_btn;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane_5;
	private JLabel lblNewLabel_8;
	/**
	 * Create the application.
	 */
	public food_menu() {
		manager_view v = new manager_view();
		initialize();  // make sure to use return of functions else we need to initialize the data structure here before using it
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1084, 794);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		search_field = new JTextField();
		search_field.setBounds(131, 33, 337, 32);
		search_field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchimplement(search_field.getText());
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(search_field);
		search_field.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search Item here:");
		lblNewLabel.setBounds(18, 42, 103, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Todays Menu:");
		lblNewLabel_1.setBounds(18, 165, 103, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Burritos:");
		lblNewLabel_2.setBounds(62, 228, 59, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(131, 188, 337, 90);
		frame.getContentPane().add(scrollPane_2);
		burritos_menu = new JList<String>();
		scrollPane_2.setViewportView(burritos_menu);
		setburritomenu(); // this should be after declaration
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 75, 337, 76);
		frame.getContentPane().add(scrollPane);
		search_result = new JList<String>();
		scrollPane.setViewportView(search_result);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(579, 40, 420, 368);
		frame.getContentPane().add(scrollPane_1);
		order_list = new JList<String>();
		scrollPane_1.setViewportView(order_list);
		
		lblNewLabel_3 = new JLabel("Order_List:");
		lblNewLabel_3.setBounds(499, 42, 103, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		checkout_btn = new JButton("Proceed To Checkout");
		checkout_btn.setBounds(727, 624, 204, 42);
		frame.getContentPane().add(checkout_btn);
		
		lblNewLabel_4 = new JLabel("Please Enter Delivery Location:");
		lblNewLabel_4.setBounds(499, 459, 179, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		location_input = new JTextField();
		location_input.setBounds(688, 445, 311, 42);
		frame.getContentPane().add(location_input);
		location_input.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Please Enter Phone Number:");
		lblNewLabel_5.setBounds(499, 555, 179, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		number_input = new JTextField();
		number_input.setBounds(688, 541, 311, 42);
		frame.getContentPane().add(number_input);
		number_input.setColumns(10);
		
		back_btn = new JButton("Back To Main Screen");
		back_btn.setBounds(18, 690, 179, 32);
		frame.getContentPane().add(back_btn);
		
		lblNewLabel_6 = new JLabel("Wraps:");
		lblNewLabel_6.setBounds(63, 356, 45, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(131, 318, 337, 90);
		frame.getContentPane().add(scrollPane_3);
		
		wrapsmenu = new JList<String>();
		scrollPane_3.setViewportView(wrapsmenu);
		setwrapmenu();
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(131, 444, 337, 90);
		frame.getContentPane().add(scrollPane_4);
		
		saladsmenu = new JList<String>();
		scrollPane_4.setViewportView(saladsmenu);
		setsaladmenu();
		
		JLabel lblNewLabel_7 = new JLabel("Salads:");
		lblNewLabel_7.setBounds(62, 474, 59, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(131, 570, 337, 90);
		frame.getContentPane().add(scrollPane_5);
		
		drinksmenu = new JList<String>();
		scrollPane_5.setViewportView(drinksmenu);
		setdrinksmenu();
		
		lblNewLabel_8 = new JLabel("Drinks:");
		lblNewLabel_8.setBounds(62, 610, 59, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		checkout_btn.addActionListener(this);
		back_btn.addActionListener(this);
		
		burritos_menu.addMouseListener(this); // Listeners
		search_result.addMouseListener(this);
		wrapsmenu.addMouseListener(this);
		saladsmenu.addMouseListener(this);
		drinksmenu.addMouseListener(this);
		
	}
	
	public void searchimplement(String item_searched) {
		
		DefaultListModel<String> model1 = new DefaultListModel<String>();
		Collection<ArrayList<String>> collec_wrap =  manager_view.wrapdata.values();  
		Collection<ArrayList<String>> collec_burrito = manager_view.burritodata.values(); 
		Collection<ArrayList<String>> collec_salad = manager_view.saladdata.values(); 
		Collection<ArrayList<String>> collec_drinks = manager_view.drinksdata.values(); 
	    ArrayList<String> getwraplist = new ArrayList<String>();
	    String adder = "";
	    
	    for(ArrayList<String> l : collec_wrap) {
	    	adder = "";
	    	for(int i= 0; i < l.size(); i++) {
	    		adder = adder + l.get(i)+" ";
	    	}
	    	getwraplist.add(adder);
	    }
	    for(ArrayList<String> l2 : collec_burrito) {
	    	adder = "";
	    	for(int i= 0; i < l2.size(); i++) {
	    		adder = adder + l2.get(i)+" ";
	    	}
	    	getwraplist.add(adder);
	    }
	    for(ArrayList<String> l2 : collec_salad) {
	    	adder = "";
	    	for(int i= 0; i < l2.size(); i++) {
	    		adder = adder + l2.get(i)+" ";
	    	}
	    	getwraplist.add(adder);
	    }
	    for(ArrayList<String> l2 : collec_drinks) {
	    	adder = "";
	    	for(int i= 0; i < l2.size(); i++) {
	    		adder = adder + l2.get(i)+" ";
	    	}
	    	getwraplist.add(adder);
	    }
	    
		for(String wrapitem : getwraplist){
			if(wrapitem.equals("")){
				model1.clear();
			}else if(wrapitem.toString().toLowerCase().contains(item_searched.toLowerCase())) {
				model1.addElement(wrapitem);
			}
		}
		search_result.setModel(model1);
	}
	
	public void setburritomenu() {
		DefaultListModel<String> model3 = new DefaultListModel<String>();
		Collection<ArrayList<String>> collec_burrito = manager_view.burritodata.values(); 
		String adder = "";
		for(ArrayList<String> l2 : collec_burrito) {
	    	adder = "";
	    	for(int i= 0; i < l2.size(); i++) {
	    		adder = adder + l2.get(i)+" ";
	    	}
	    	model3.addElement(adder);
	    }
		burritos_menu.setModel(model3);
	}
	
	public void setwrapmenu() {
		DefaultListModel<String> model4 = new DefaultListModel<String>();
		Collection<ArrayList<String>> collec_wrap = manager_view.wrapdata.values(); 
		String adder = "";
		for(ArrayList<String> l2 : collec_wrap) {
	    	adder = "";
	    	for(int i= 0; i < l2.size(); i++) {
	    		adder = adder + l2.get(i)+" ";
	    	}
	    	model4.addElement(adder);
	    }
		wrapsmenu.setModel(model4);
	}
	
	public void setsaladmenu() {
		DefaultListModel<String> model4 = new DefaultListModel<String>();
		Collection<ArrayList<String>> collec_wrap = manager_view.saladdata.values(); 
		String adder = "";
		for(ArrayList<String> l2 : collec_wrap) {
	    	adder = "";
	    	for(int i= 0; i < l2.size(); i++) {
	    		adder = adder + l2.get(i)+" ";
	    	}
	    	model4.addElement(adder);
	    }
		saladsmenu.setModel(model4);
	}
	
	public void setdrinksmenu() {
		DefaultListModel<String> model4 = new DefaultListModel<String>();
		Collection<ArrayList<String>> collec_wrap = manager_view.drinksdata.values(); 
		String adder = "";
		for(ArrayList<String> l2 : collec_wrap) {
	    	adder = "";
	    	for(int i= 0; i < l2.size(); i++) {
	    		adder = adder + l2.get(i)+" ";
	    	}
	    	model4.addElement(adder);
	    }
		drinksmenu.setModel(model4);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == search_result) {
			Object[] possibleValues = { "Small", "Medium", "Large" };
			Object selectedValue = JOptionPane.showInputDialog(null,
			        "Please Select Size Of The Item", "Input",
			        JOptionPane.INFORMATION_MESSAGE, null,
			        possibleValues, possibleValues[1]);
			final_item_list.addElement(search_result.getSelectedValue()+" [Size Selected:"+selectedValue+"]");
		}else if(e.getSource() == burritos_menu) {
			Object[] possibleValues = { "Small", "Medium", "Large" };
			Object selectedValue = JOptionPane.showInputDialog(null,
			        "Please Select Size Of The Item", "Input",
			        JOptionPane.INFORMATION_MESSAGE, null,
			        possibleValues, possibleValues[1]);
			final_item_list.addElement(burritos_menu.getSelectedValue()+" [Size Selected:"+selectedValue+"]");
		}else if(e.getSource() == wrapsmenu) {
			Object[] possibleValues = { "Small", "Medium", "Large" };
			Object selectedValue = JOptionPane.showInputDialog(null,
			        "Please Select Size Of The Item", "Input",
			        JOptionPane.INFORMATION_MESSAGE, null,
			        possibleValues, possibleValues[1]);
			final_item_list.addElement(wrapsmenu.getSelectedValue()+" [Size Selected:"+selectedValue+"]");
		}else if(e.getSource() == saladsmenu) {
			Object[] possibleValues = { "Small", "Medium", "Large" };
			Object selectedValue = JOptionPane.showInputDialog(null,
			        "Please Select Size Of The Item", "Input",
			        JOptionPane.INFORMATION_MESSAGE, null,
			        possibleValues, possibleValues[1]);
			final_item_list.addElement(saladsmenu.getSelectedValue()+" [Size Selected:"+selectedValue+"]");
		}else if(e.getSource() == drinksmenu) {
			Object[] possibleValues = { "Small", "Medium", "Large" };
			Object selectedValue = JOptionPane.showInputDialog(null,
			        "Please Select Size Of The Item", "Input",
			        JOptionPane.INFORMATION_MESSAGE, null,
			        possibleValues, possibleValues[1]);
			final_item_list.addElement(drinksmenu.getSelectedValue()+" [Size Selected:"+selectedValue+"]");
		}
		order_list.setModel(final_item_list);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == checkout_btn) {
			createorder();
		}else if(e.getSource() == back_btn) {
			frame.dispose();
			Main_Dashboard window = new Main_Dashboard();
			window.frame.setVisible(true);
		}
	}
	
	public void createorder() {
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
		Location = Location + location_input.getText();
		phonenumber = phonenumber + number_input.getText(); 
		pay_status = pay_status + "paid";
		delivery_status = delivery_status + "delivering";
		frame.dispose();
		checkout window = new checkout();
		checkout.frame.setVisible(true);
		checkout.totalbalance(totalprice,final_item_list); // print price
		checkout.addorders(final_item_list, totalprice, Location, phonenumber,pay_status,delivery_status);
	}
}
