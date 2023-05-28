package Gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.xml.bind.JAXBException;

import File.Read;
import Restaurant.Restaurant;
import Restaurant.User;
import SystemUsers.Cook;
import SystemUsers.Customer;
import SystemUsers.Manager;
import SystemUsers.Waiter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RestaurantGui {

	public JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantGui window = new RestaurantGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws JAXBException 
	 */
	public RestaurantGui() throws JAXBException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws JAXBException 
	 */
	private void initialize() throws JAXBException {
		
		
		Read reader=new Read();
		
		Restaurant restaurant=reader.loadRestaurant();
		
		
		User customer=new Customer();
		User manager=new Manager();
		User Cook=new Cook();
		User waiter=new Waiter();
		
		CustomerFrame customerFrame = new CustomerFrame();
		ManagerFrame managerFrame = new ManagerFrame();
		CookFrame cookFrame = new CookFrame();
		WaiterFrame waiterFrame = new WaiterFrame();
		Register registerFrame =new Register();
		
		
		
		frame = new JFrame();
		frame.setForeground(SystemColor.textHighlight);
		frame.getContentPane().setForeground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 822, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 295, 294, 31);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(214, 202, 294, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User name :");
		lblNewLabel.setBounds(65, 191, 120, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(73, 289, 129, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Restaurant");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(265, 44, 262, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			
			
		 
			
			 
			String test;
			User a=new User();
			
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
		
				
		try {		
			String userName=textField.getText();
			String passWord=passwordField.getText();
	
		
			test= a.identifyUser(userName,passWord, restaurant).getRole();
			 
			
			
		 switch(test) {
		 
		 case "Client" :
			    JOptionPane.showMessageDialog(null,"login successful");
				customerFrame.setVisible(true);
				customerFrame.lblName.setText(textField.getText());
		 break;
		 
		 case "Manager":
			 managerFrame.setVisible(true);
			 JOptionPane.showMessageDialog(null,"login successful");
			 break;
		 case "Waiter":
			 waiterFrame.setVisible(true);
			 JOptionPane.showMessageDialog(null,"login successful");
			 break;
		 case "Cooker":
			 cookFrame.setVisible(true);
			 JOptionPane.showMessageDialog(null,"login successful");
			 break;
		 
		 
		 
		 
		 }
				
				
		}catch(Exception e) {
			
			
			JOptionPane.showMessageDialog(null, "user not found enter valid user name password or create account");
			
		}
				
				
				
			}
		});
		btnNewButton.setBounds(73, 415, 165, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register as a new customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	dispose();
				registerFrame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(461, 415, 262, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
