package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import File.Read;
import Restaurant.Restaurant;
import Restaurant.User;
import SystemUsers.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	public Restaurant restaurant;
	public Customer cust;
	public Read read;
	private JButton Register;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JAXBException 
	 */
	
	
	public boolean stringContainsNumber( String s )
	{
	    Pattern p = Pattern.compile( "[0-9]" );
	    Matcher m = p.matcher( s );

	    return m.find();
	}
	
	
	
	
	
	
	
	
	
	
	public Register() throws JAXBException {
		restaurant=new Restaurant();
		read=new Read();
		restaurant=read.loadRestaurant();
		User a=new User();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Your Name:");
		lblNewLabel.setBounds(10, 40, 164, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(227, 42, 164, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Please Enter Username:");
		lblNewLabel_1.setBounds(10, 87, 191, 26);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 89, 164, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Please Enter a password:");
		lblNewLabel_2.setBounds(10, 138, 191, 26);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 140, 164, 23);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("New Customer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 11, 381, 18);
		contentPane.add(lblNewLabel_3);
		
		Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			int flagOne=0;
			public void actionPerformed(ActionEvent arg0) {
			try {
				
				String name=	textField.getText();
			String userName=textField_1.getText();
			String password=passwordField.getText();
			
			if(name.trim().isEmpty()||stringContainsNumber(name)) {
				flagOne++;
				
			}
			
			
			if(userName.trim().isEmpty()||stringContainsNumber(userName)) {
				flagOne++;
				
			}
			
			for(User temp: restaurant.getUsers().getUsers()) {
				if(temp.getName()==name) {
					flagOne++;
					
				}
			
			
		}
			
			for(User temp: restaurant.getUsers().getUsers()) {
				if(temp.getUserName()==userName) {
					flagOne++;
					
				}
			
			
		}
			if(password.trim().isEmpty())
			flagOne++;
			
			if(flagOne!=0) {
				int x =1/0;
			}
				
		try {
			a.createUser(name, userName, password, restaurant);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			}
			catch(Exception q) {
				
				
				JOptionPane.showMessageDialog(null, "Please ensure that you entered data properly,username and name cannot contain numbers plus no duplicate of them is allowed");
				
		
			}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		Register.setBounds(10, 226, 164, 33);
		contentPane.add(Register);
		
		btnNewButton = new JButton("close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					
					
					dispose();
					RestaurantGui logout=new RestaurantGui();
					logout.frame.setVisible(true);
					
					}
					
				catch(JAXBException e1) {
					
					e1.printStackTrace();
					
				}
				
				
				
			}
		});
		btnNewButton.setBounds(237, 226, 130, 33);
		contentPane.add(btnNewButton);
	}
}
