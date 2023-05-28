package Gui;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;

import File.Read;
import Restaurant.Order;
import Restaurant.Restaurant;
import SystemUsers.Cook;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CookFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CookFrame frame = new CookFrame();
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
	public CookFrame() throws JAXBException {
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 649);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("View orders");
		Read r=new Read();
		Cook cook =new Cook();
		Restaurant restaurant=r.loadRestaurant();     //initialization
	 
		
		JLabel label = new JLabel(" ");
		label.setBounds(54, 0, 129, 33);
		contentPane.add(label);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 44, 730, 418);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order", "Table number"
			}
		));
		Object[] columns= {"name ","table number"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		Font font =new Font("",1,22);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			
			Object [] row=new Object[10];
			
	 
			
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				// delete everything in table in case user clicks on show again so that id doesnt duplicate the table
				
				table.setModel(new DefaultTableModel(null,new String[] {
						"Order", "Table number"
				}));
				
				if(restaurant.getOrders().getOrders().isEmpty()) {
					
					
					label.setText("no orders added");
					
				}
				else {
					
					label.setText(" orders available :");
					
					
				}
				
				
				
				// filling the table from list
				
				 DefaultTableModel model=(DefaultTableModel) table.getModel();
				List<Order> list=cook.viewOrders(restaurant);
				Object rowData[] =new Object[10];
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getIsValidOrder()==true) {
					rowData[0]=list.get(i).getOrder().getName();
					rowData[1]=list.get(i).getTableNumber();
					
					rowData[2]=list.get(i).getOrder().getName();
					rowData[3]=list.get(i).getTableNumber();
					
					rowData[4]=list.get(i).getOrder().getName();
					rowData[5]=list.get(i).getTableNumber();
					
					rowData[6]=list.get(i).getOrder().getName();
					rowData[7]=list.get(i).getTableNumber();
					
					rowData[8]=list.get(i).getOrder().getName();
					rowData[9]=list.get(i).getTableNumber();
					
					model.addRow(rowData);
					}
					else
						continue;
					
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(114, 493, 193, 48);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					RestaurantGui logout=new RestaurantGui();
					logout.frame.setVisible(true);
					
					
				}catch(JAXBException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(631, 558, 205, 41);
		contentPane.add(btnNewButton_1);
		
	 
		
		 
		
		
		
		
		
	}
}
