package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;

import File.Read;
import Restaurant.Reservation;
import Restaurant.Restaurant;
import Restaurant.User;
import SystemUsers.Customer;

import javax.swing.JTextArea;

public class CustomerFrame extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel orderPane;
	private JPanel reserve;
	private JPanel aboutUs;
	private JLabel lbReserve1;
	private JTextField textFieldSeats;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBoxMainCourse;
	private JComboBox comboBoxAppitizer;
	private JComboBox comboBoxDesert;
	private JTextArea txtrOurRestaurantHas;
	private JPanel Checkout;
	private JTable orderMenu;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JButton CheckoutBtn;
	public JLabel lblName;
	public Restaurant restaurant;
	public Customer cust;
	public Read read;
	//private JLabel displayTableNum;
	private JButton ActResrvation;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JPanel logout;
	private JButton btnLogOut;
	private JTextArea txtrWeAreGlad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	public CustomerFrame() throws JAXBException {
		restaurant=new Restaurant();
		read=new Read();
		restaurant=read.loadRestaurant();
		cust=new Customer();
		User clientName=new Customer();
		
		setTitle("Restaurant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 870, 498);
		contentPane.add(tabbedPane);
		
		//displayTableNum = new JLabel("New label");
	//	displayTableNum.setBounds(482, 94, 46, 27);
		
		reserve = new JPanel();
		tabbedPane.addTab("Reserve", null, reserve, null);
		reserve.setLayout(null);
		
		lbReserve1 = new JLabel("Reservation Menu");
		lbReserve1.setBounds(199, 11, 199, 27);
		lbReserve1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbReserve1.setForeground(Color.RED);
		reserve.add(lbReserve1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter number of seats:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 131, 160, 27);
		reserve.add(lblNewLabel_1);
		
		textFieldSeats = new JTextField();
		textFieldSeats.setBounds(190, 133, 30, 24);
		reserve.add(textFieldSeats);
		textFieldSeats.setColumns(10);
		
		JRadioButton rdbtnSmoking = new JRadioButton("Smoking");
		rdbtnSmoking.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnSmoking);
		rdbtnSmoking.setSelected(true);
		rdbtnSmoking.setBounds(10, 246, 109, 23);
		reserve.add(rdbtnSmoking);
		
		JRadioButton rdbtnNonSmoking = new JRadioButton("Nonsmoking");
		rdbtnNonSmoking.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rdbtnNonSmoking);
		rdbtnNonSmoking.setBounds(164, 246, 109, 23);
		reserve.add(rdbtnNonSmoking);
		
		JButton btnReserve = new JButton("Reserve");
		 
		btnReserve.addActionListener(new ActionListener() {
			int found=0;
			public void actionPerformed(ActionEvent arg0) {
				try {
				boolean isSmoking;
				int seatsNum;
			String tableNum;
			 
			
				String name=lblName.getText();
				clientName.setName(name);
			
					int y;
					
					for(Reservation temp: restaurant.getReservations().getReservations()) {
						if(temp.getClient().equalsIgnoreCase(name)&&temp.getIsValid()==true) {
							found++;
							y=1/0;
							
						}
					
						 
						
						
							}
					
				
				if(rdbtnNonSmoking.isSelected()) {
					
					isSmoking=false;
				}
				else {
					
					isSmoking=true;
				}
				
				seatsNum=Integer.parseInt(textFieldSeats.getText());
				
				
				cust.reserveTable(name, restaurant, seatsNum, isSmoking);
				tableNum=Integer.toString(cust.tableNumSearch(lblName.getText(), restaurant));
				lblNewLabel.setText(tableNum);
				lblNewLabel.setVisible(true);
				
				
				}catch(Exception e) {
					if(found!=0)
						JOptionPane.showMessageDialog(null, "You already reserved");
					else
					JOptionPane.showMessageDialog(null, "Please Fill Properly whole Fields Required");
					
				}	
				 
				}
		});
		
		btnReserve.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReserve.setBounds(10, 343, 220, 23);
		reserve.add(btnReserve);
		
		JLabel lblNewLabel_10 = new JLabel("logged in as:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 55, 137, 35);
		reserve.add(lblNewLabel_10);
		
		lblName = new JLabel("New label");
		//	lblName.setText(textField.getText());
				lblName.setBounds(122, 63, 67, 20);
				reserve.add(lblName);
				
				JLabel tableNum_1 = new JLabel("Your table Number:");
				tableNum_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				tableNum_1.setBounds(10, 94, 137, 35);
				reserve.add(tableNum_1);
				
				ActResrvation = new JButton("Activate Reservation");
				ActResrvation.addActionListener(new ActionListener() {
					boolean compare=false;
					public void actionPerformed(ActionEvent arg0) {
					 
						try {
						String name=lblName.getText();
	int z=0;
						for(Reservation temp: restaurant.getReservations().getReservations()) {
						if(temp.getClient().equalsIgnoreCase(name)&&temp.getIsValid()==true) {
							System.out.println("hi");
							lblNewLabel.setText(Integer.toString(temp.getTableNumber()));
							lblNewLabel.setVisible(true);
								compare =true;
							}
						
					
							}
						if(compare==false)
								 z=1/0; // making error if the reservation not found in the file meaning it is not found
						
						
						}
						catch(Exception q) {
							if(compare==false)
								JOptionPane.showMessageDialog(null, "You did not reserve yet");
							
							
						}
							
								
						
						
						
						
						
						
						
						
						
						
						
					}
				});
				ActResrvation.setFont(new Font("Tahoma", Font.BOLD, 12));
				ActResrvation.setBounds(307, 343, 199, 23);
				reserve.add(ActResrvation);
				
				lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(143, 104, 77, 14);
				lblNewLabel.setVisible(false);
				reserve.add(lblNewLabel);
				
				lblNewLabel_2 = new JLabel("If you reserved before please click this button");
				lblNewLabel_2.setBounds(272, 281, 319, 20);
				reserve.add(lblNewLabel_2);
				
		
		orderPane = new JPanel();
		tabbedPane.addTab("Order", null, orderPane, null);
		orderPane.setLayout(null);
		
		JLabel lblOrderPane = new JLabel("Order Menu");
		lblOrderPane.setBounds(281, 0, 139, 28);
		lblOrderPane.setForeground(Color.RED);
		lblOrderPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		orderPane.add(lblOrderPane);
		
		JLabel lblNewLabel_3 = new JLabel("Please choose your Dishes");
		lblNewLabel_3.setBounds(10, 104, 179, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		orderPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Choose Dish type:");
		lblNewLabel_4.setBounds(10, 147, 139, 28);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		orderPane.add(lblNewLabel_4);
		
		JComboBox DishcomboBox = new JComboBox();
		DishcomboBox.setBounds(128, 148, 128, 28);
		DishcomboBox.setEditable(true);
		DishcomboBox.addItem("appetizer");
		DishcomboBox.addItem("main_course");
		DishcomboBox.addItem("desert");
		DishcomboBox.setSelectedItem("Select Dish Type");
		DishcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(DishcomboBox.getSelectedItem().equals("main_course")) {
					comboBoxMainCourse.removeAllItems();
					comboBoxMainCourse.addItem("Grilled Chicken");
					comboBoxMainCourse.addItem("Mushroom Soup");
					comboBoxMainCourse.setSelectedItem("Select Your main course");
					
					//orderPane.add(comboBoxMainCourse);
				}
				else if(DishcomboBox.getSelectedItem().equals("appetizer")) {
					comboBoxMainCourse.removeAllItems();
					comboBoxMainCourse.addItem("Greek Salade");
					comboBoxMainCourse.addItem("Fried Potatos");
					comboBoxMainCourse.setSelectedItem("Select Your Appitizer");
					//orderPane.add(comboBoxAppitizer);
					
				}
				else if(DishcomboBox.getSelectedItem().equals("desert")) {
					comboBoxMainCourse.removeAllItems();
					comboBoxMainCourse.addItem("Apple Pie");
					comboBoxMainCourse.addItem("Molten Cake");
					comboBoxMainCourse.setSelectedItem("Select Your Desert");
									
				}
				
			}
		});
		orderPane.add(DishcomboBox);
		
		
		comboBoxMainCourse = new JComboBox();
		comboBoxMainCourse.setBounds(130, 203, 124, 33);
		comboBoxMainCourse.setEditable(true);
		
		orderPane.add(comboBoxMainCourse);
		
		
			
	
		JLabel lblNewLabel_5 = new JLabel("Dish name:");
		lblNewLabel_5.setBounds(10, 212, 97, 20);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		orderPane.add(lblNewLabel_5);
		
		JButton btnAddDish = new JButton("Add");
		btnAddDish.setBounds(344, 329, 305, 23);
		btnAddDish.setFont(new Font("Tahoma", Font.BOLD, 12));
		orderPane.add(btnAddDish);
		
		orderMenu = new JTable();
		orderMenu.setForeground(Color.MAGENTA);
		Object[] columns = {"Dish Type","Dish Name"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        orderMenu.setModel(model);
        Object[] row = new Object[2];
        
        
        btnAddDish.addActionListener(new ActionListener(){
        	
            @Override
            
            public void actionPerformed(ActionEvent e) {
            	int confirmationBox=0;
            	try {
            	
            	int flagOne=0;
            	
            	
      if(!DishcomboBox.getSelectedItem().equals("Select Dish Type")&&!((String) DishcomboBox.getSelectedItem()).trim().isEmpty()) {
                row[0] = DishcomboBox.getSelectedItem();
                flagOne++;
      }
       if(!comboBoxMainCourse.getSelectedItem().equals("Select Your Desert")&&!comboBoxMainCourse.getSelectedItem().equals("Select Your Appitizer")&&!comboBoxMainCourse.getSelectedItem().equals("Select Your main course")&&!comboBoxMainCourse.getSelectedItem().equals("")&&!DishcomboBox.getSelectedItem().equals("Select Dish Type")&&!((String) DishcomboBox.getSelectedItem()).trim().isEmpty()) {
                row[1] = comboBoxMainCourse.getSelectedItem();
          flagOne++;
       }
     confirmationBox=   JOptionPane.showConfirmDialog(btnAddDish, "Are you sure you want to save this dish");
       if(confirmationBox==0) {
    	flagOne++;   
       }
       
    // add row to the model
                if(flagOne==1||flagOne==2) {
                	int x=1/0;
                }
               if(flagOne==3) {
            	   int tableNumber=Integer.parseInt(lblNewLabel.getText());
            	 //  JOptionPane.showMessageDialog(btnAddDish, "Are you sure you want to add this dish");
               // JOptionPane.showConfirmDialog(btnAddDish, "Are you sure you want to save this dish");
                
                try {
					cust.orderDishes((String) comboBoxMainCourse.getSelectedItem(), tableNumber, restaurant,clientName.getName());
				} catch (JAXBException e1) {
					
					e1.printStackTrace();
				}
                model.addRow(row);
      
            	}	}
catch(Exception ex) {
					if(confirmationBox==1||confirmationBox==2) {
						JOptionPane.showMessageDialog(null, "Order not added");
					}
					else
				JOptionPane.showMessageDialog(null, "Please Fill Properly whole Fields Required");
}
				}	
            }
       );
        
        
        
        
        
        
        
        
        
        
        
        
        
        
		orderMenu.setCellSelectionEnabled(true);
		orderMenu.setBounds(390, 60, 346, 225);
		orderPane.add(orderMenu);
		
		Checkout = new JPanel();
		tabbedPane.addTab("Checkout", null, Checkout, null);
		Checkout.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Price before taxes:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 35, 125, 22);
		Checkout.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Price After Taxes:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 80, 125, 22);
		Checkout.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(206, 40, 63, 14);
		lblNewLabel_8.setVisible(false);
		Checkout.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(205, 85, 46, 14);
		lblNewLabel_9.setVisible(false);
		Checkout.add(lblNewLabel_9);
		
		CheckoutBtn = new JButton("Check Out");
		CheckoutBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		CheckoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flagOne=0;
				int validation;
				try {
				
				int tableNum=Integer.parseInt(lblNewLabel.getText());
				validation= JOptionPane.showConfirmDialog(null, "are u sure u want to checkout");
				
				if(validation==0) {
					
					
					
					
					flagOne++;
				}
				
				
				
				
				if(flagOne==1){
				String priceBeforeTax=Float.toString(cust.priceBeforeTax(restaurant, cust.tableNumSearch(lblName.getText(), restaurant)));
				//System.out.println()
				lblNewLabel_8.setText(priceBeforeTax);
				lblNewLabel_8.setVisible(true);
				
				String priceAfterTax=Float.toString(cust.checkOut(restaurant,cust.tableNumSearch(lblName.getText(), restaurant),lblName.getText()));
				lblNewLabel_9.setText(priceAfterTax);
				
				for(Reservation temp: restaurant.getReservations().getReservations()) {
					//compare =name.compareToIgnoreCase(temp.getClient());
				if(temp.getClient().equalsIgnoreCase(lblName.getText())&&temp.getIsValid()==true) {
					
					temp.setBill(cust.checkOut(restaurant,cust.tableNumSearch(lblName.getText(), restaurant),lblName.getText()));
			cust.saveBill(lblName.getText(), restaurant, temp.getTableNumber(),Float.parseFloat(lblNewLabel_9.getText()) );
					}
				}
				
				
				
				
				
				lblNewLabel_9.setVisible(true);
				}
				else {
					int z=1/0;
					
				}
				
				
				}
				catch(Exception one) {
					if(flagOne==0) {
						JOptionPane.showMessageDialog(null, "Didn't checkout");
						
					}
					
					
					else
						
					
					JOptionPane.showMessageDialog(null, "Please Fill Properly whole Fields Required");
					
					
					
				}
				
				
				
				
				
				
				
				
				
			}
		});
		CheckoutBtn.setBounds(10, 369, 125, 23);
		Checkout.add(CheckoutBtn);
		
		aboutUs = new JPanel();
		aboutUs.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("About us", null, aboutUs, null);
		//aboutUs.add(comp)
		aboutUs.setLayout(null);
		
		txtrOurRestaurantHas = new JTextArea();
		txtrOurRestaurantHas.setLineWrap(true);
		txtrOurRestaurantHas.setToolTipText("Our restaurant has a deep roots in the Egyptian history,It was established in 1940.\r\nsince then we are trying to enhace dining experiance in Egypt and hopefully we succeed.\r\nMany imprtant figures visited our restaurant including reputable poets and authors like naguib mahfouz and others.\r\n\r\nP.S\r\nWe don't take tips in our restaurant but, we appreciate bonus marks!\r\nAll rights are reserved\u00AE 2020");
		txtrOurRestaurantHas.setEditable(false);
		txtrOurRestaurantHas.setBackground(Color.WHITE);
		txtrOurRestaurantHas.setForeground(new Color(0, 0, 0));
		txtrOurRestaurantHas.setText("Our restaurant has a deep roots in the Egyptian history,It was established in 1940.\r\nsince then we are trying to enhace dining experiance in Egypt and hopefully we succeed.\r\nMany imprtant figures visited our restaurant including reputable poets and authors like naguib mahfouz and others.\r\n\r\nP.S\r\nWe don't take tips in our restaurant but, we appreciate bonus marks!\r\nMade by:\r\nMalek Emad eldin &&&&& Mahmoud Ahmed Khalil\r\nAll rights are reserved\u00AE 2020");
		txtrOurRestaurantHas.setWrapStyleWord(true);
		txtrOurRestaurantHas.setBounds(107, 0, 493, 259);
		aboutUs.add(txtrOurRestaurantHas);
		
		logout = new JPanel();
		tabbedPane.addTab("Log Out", null, logout, null);
		logout.setLayout(null);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
		int	flagOne=0;
			public void actionPerformed(ActionEvent e) {
				int z=0;
			try {

			if(lblNewLabel_8.getText().equalsIgnoreCase("0.0")||lblNewLabel_8.getText().trim().isEmpty()||lblNewLabel_8.getText().equalsIgnoreCase("New label"))
flagOne++;
			if(flagOne!=0) {
				z=1/0;
			}
				
				try {
					
					
					
					dispose();
					RestaurantGui logout=new RestaurantGui();
					logout.frame.setVisible(true);
					
					}
					
				catch(JAXBException e1) {
					
					e1.printStackTrace();
					
				}
				
			
				}
			catch(Exception ty) {
				if(lblNewLabel_8.getText().equalsIgnoreCase("0.0"))
					JOptionPane.showMessageDialog(null, "Cannot checkout with zero bill");	
				else
				JOptionPane.showMessageDialog(null, "Please check out before logging out");	
			}
				
				
				
				
				
			
		}});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnLogOut.setBackground(Color.RED);
		btnLogOut.setForeground(Color.YELLOW);
		btnLogOut.setBounds(84, 190, 365, 134);
		logout.add(btnLogOut);
		
		txtrWeAreGlad = new JTextArea();
		txtrWeAreGlad.setLineWrap(true);
		txtrWeAreGlad.setWrapStyleWord(true);
		txtrWeAreGlad.setText("We are glad to have you in our restaurant ,we hope that our services made you glad.\r\nIf you have any inqueries or complains do not hesitate to contact us on the phone number found in about us tab.\r\nP.S\r\nRemember to checkout before logging out!");
		txtrWeAreGlad.setEditable(false);
		txtrWeAreGlad.setBounds(10, 11, 662, 163);
		logout.add(txtrWeAreGlad);
	}
}
