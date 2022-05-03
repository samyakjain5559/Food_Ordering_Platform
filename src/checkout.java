import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class checkout implements ActionListener {

	static JFrame frame;
	static JList<String> order_total;
	JButton payment_btn;
	JLabel lblNewLabel;
	food_menu m;
	static Hashtable<Integer, ArrayList<String>> orders = new Hashtable<Integer, ArrayList<String>>();
	static String adder = "";
	static int inc = 20;
	static int order_id = 0;
	/**
	 * Create the application.
	 */
	public checkout() {
		// generate orderslist with unique number
		/*orders = new Hashtable<Integer, ArrayList<String>>();
		food_menu m = new food_menu();
		int inc = 20;
		Object[] items = (Object[]) food_menu.final_item_list.toArray();
		for(int i = 0; i < items.length; i++) {
            // 1 identifier for whole order
			String item = (String) items[i];
			adder = adder + item + " ";
		}
		orders.put(inc, new ArrayList<String>(){
            {
                add(adder);  // item list
                add(new Integer(food_menu.totalprice).toString());       // price total get from food menu
                add(food_menu.pay_status);
                add(food_menu.Location);
                add(food_menu.phonenumber);
            }
        });
		inc++; // only increment for new order 
		System.out.println(orders);*/
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 933, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 21, 549, 267);
		frame.getContentPane().add(scrollPane);
		
		order_total = new JList<String>();
		scrollPane.setViewportView(order_total);
		
		lblNewLabel = new JLabel("Order Total and Summary:");
		lblNewLabel.setBounds(33, 23, 179, 13);
		frame.getContentPane().add(lblNewLabel);
		
		payment_btn = new JButton("Make Payment");
		payment_btn.setBounds(363, 518, 237, 38);
		frame.getContentPane().add(payment_btn);
		
		payment_btn.addActionListener(this); // Listeners
	}
	
	public static void totalbalance(int total, DefaultListModel<String> list) {
		
		DefaultListModel<String> model4 = new DefaultListModel<String>();
		Integer y = new Integer(total);
		model4.addElement("Total Amount To Be Payed : $"+y.toString());
		model4.addElement(" ");
		model4.addElement("List of Items Ordered : ");
		Object[] items = (Object[]) list.toArray();
		for(int i = 0; i < items.length; i++) {
            // 1 identifier for whole order
			String item = (String) items[i];
			model4.addElement(item);
		}
		
		order_total.setModel(model4);
	}
	
	public static void addorders(DefaultListModel<String> list, int total , String loc, String num, String pay_status, String delivery_status) {
		//int inc = 20;
		adder = "";
		Object[] items = (Object[]) list.toArray();
		for(int i = 0; i < items.length; i++) {
            // 1 identifier for whole order
			String item = (String) items[i];
			adder = adder + item + " ";
		}
		orders.put(inc, new ArrayList<String>(){    // This should be replaced by db so extract order info from db
            {
                add(adder);  // item list
                add(new Integer(total).toString());       // price total get from food menu
                add(pay_status);
                add(loc);
                add(num);
                add(delivery_status);
            }
        });
		
		//DB storage of orders
		String name = "root";
   	    String password = "password";
   	    order_id = (int)Math.floor(Math.random()*(999-100+1)+100);
   	    try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
		    int r = s.executeUpdate("INSERT INTO orders_tbl values ('"+order_id+"','"+adder+"','"+new Integer(total).toString()+"','"+pay_status+"','"+loc+"','"+num+"','"+delivery_status+"');");
   	    }catch (SQLException e) {
   	         e.printStackTrace();
   	    }
		
   	    inc++; // only increment for new order 
		
		System.out.println(orders.size());
		/*Collection<ArrayList<String>> collec = orders.values(); 
		for(ArrayList<String> l : collec) {
	         //System.out.println(l.get(0));
	         System.out.println(l.get(2));
	    }*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == payment_btn) {
			handle_payment();
			//System.out.println(order_id);
			frame.dispose();
			Main_Dashboard window = new Main_Dashboard();
			window.frame.setVisible(true);
		}
	}
	
	public void handle_payment() {
		JOptionPane.showMessageDialog(frame, "Thank You For Shopping With Us \n Your Order will be Deliveried Soon \n Your order number is : " +order_id +"\n You can cancel this order in next 20 minutes ","information", JOptionPane.INFORMATION_MESSAGE);
		String hour = java.time.LocalTime.now().toString().substring(0 , java.time.LocalTime.now().toString().indexOf(':'));
		String minutes = java.time.LocalTime.now().toString().substring(java.time.LocalTime.now().toString().indexOf(':')+1, java.time.LocalTime.now().toString().indexOf(':')+3);
		String month = java.time.LocalDate.now().toString().substring(java.time.LocalDate.now().toString().indexOf('-') + 1 , java.time.LocalDate.now().toString().indexOf('-')+3);
		String day = java.time.LocalDate.now().toString().substring(java.time.LocalDate.now().toString().indexOf('-') + 4 , java.time.LocalDate.now().toString().indexOf('-')+6);
		//DB storage of orders
		System.out.println(month+" here is checkout "+day);
		String name = "root";
   	    String password = "password";
   	    try{
   	    	Statement s = DriverManager.getConnection("jdbc:mysql://127.0.0.1/4321_lab1",name, password).createStatement();
		    int r = s.executeUpdate("INSERT INTO deliverytime_tbl values ('"+order_id+"','"+hour+"','"+minutes+"','"+month+"','"+day+"');");
   	    }catch (SQLException e1) {
   	         e1.printStackTrace();
   	    }
	}

}
