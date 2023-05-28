package Gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import File.Read;
import Restaurant.Order;
import Restaurant.Reservation;
import Restaurant.Restaurant;
import SystemUsers.Manager;
import SystemUsers.Waiter;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextArea;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JTabbedPane tabbedPane_1;
	private JPanel panel;
	private JButton btnNewButton_1;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JButton btnNewButton_2;
	private JTextArea txtrIfYouHave;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel displayEarned;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
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
	public ManagerFrame() throws JAXBException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		Read r=new Read();
		Manager manager =new Manager();
		Restaurant restaurant=r.loadRestaurant(); //load restaurant to work with it and update every time
		Object[] columns= {"name ","table number","bill"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		Font font =new Font("",1,22);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 811, 543);
		contentPane.add(tabbedPane_1);
		
		scrollPane = new JScrollPane();
		tabbedPane_1.addTab("reservations", null, scrollPane, null);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][][] {
			},
			new String[] {
				"Client", "Table number","Bill"
			}
		));
		
		JButton btnNewButton = new JButton("show reservations");
		scrollPane.setRowHeaderView(btnNewButton);
		
		
		JLabel label = new JLabel(" ");
		scrollPane.setColumnHeaderView(label);
		
		panel = new JPanel();
		tabbedPane_1.addTab("orders", null, panel, null);
		tabbedPane_1.setBackgroundAt(1, SystemColor.textHighlight);
		panel.setLayout(null);
		
		btnNewButton_1 = new JButton("show orders");
		btnNewButton_1.addActionListener(new ActionListener() {
			Object [] row=new Object[10];
				
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				

				// delete everything in table in case user clicks on show again so that id doesn't duplicate the table
				
				table_1.setModel(new DefaultTableModel(null,new String[] {
						"Client", "Table number","order"
				}));
				
				
				// if there are no reservations yet we display that there are no current reservations
				
		 			
				
				
				// filling the table from list
				
				 DefaultTableModel model=(DefaultTableModel) table_1.getModel();
				List<Order> list=manager.viewOrders(restaurant);
				Object rowData[] =new Object[30];
				for(int i=0;i<list.size();i++) {
					
					rowData[0]=list.get(i).getClientName();
					rowData[1]=list.get(i).getTableNumber();
					
					rowData[2]=list.get(i).getOrder().getName();
					
					
					 
					
					model.addRow(rowData);
					
				}
				if(list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty List");
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(0, 0, 119, 513);
		panel.add(btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(120, 0, 686, 513);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		panel_1 = new JPanel();
		tabbedPane_1.addTab("log out", null, panel_1, null);
		panel_1.setLayout(null);
		
		btnNewButton_2 = new JButton("log Out");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setForeground(Color.YELLOW);
		btnNewButton_2.setBounds(112, 149, 322, 46);
		panel_1.add(btnNewButton_2);
		
		txtrIfYouHave = new JTextArea();
		txtrIfYouHave.setLineWrap(true);
		txtrIfYouHave.setWrapStyleWord(true);
		txtrIfYouHave.setText("If you have any suggestions or problems,do not hesitate in contacting the development team!");
		txtrIfYouHave.setBounds(45, 11, 472, 112);
		panel_1.add(txtrIfYouHave);
		
		panel_2 = new JPanel();
		tabbedPane_1.addTab("Statistics", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("Total Money earned:");
		lblNewLabel.setBounds(10, 11, 174, 23);
		panel_2.add(lblNewLabel);
		
		displayEarned = new JLabel("New label");
		displayEarned.setBounds(211, 11, 102, 23);
		panel_2.add(displayEarned);
		
		btnNewButton_3 = new JButton("Show Dishes Stats");
		btnNewButton_3.addActionListener(new ActionListener() {
			float totalEarned=0;
			int chicken=0;
			int GreekSalade=0;
			int FriedPotatos=0;
			int ApplePie=0;
			int MoltenCake=0;
			int MushroomSoup=0;
			int BeefSteak=0;
			public void actionPerformed(ActionEvent arg0) {
				DefaultPieDataset pieDataset= new DefaultPieDataset();
				
				for(Order temp: restaurant.getOrders().getOrders()) {
					if(temp.getOrder().getName().equalsIgnoreCase("Grilled Chicken"))
					chicken++;
					
					else if(temp.getOrder().getName().equalsIgnoreCase("Greek Salade"))
						GreekSalade++;
					else if(temp.getOrder().getName().equalsIgnoreCase("Fried Potatos"))
						FriedPotatos++;
					else	if(temp.getOrder().getName().equalsIgnoreCase("Apple Pie"))
						ApplePie++;
					else if(temp.getOrder().getName().equalsIgnoreCase("Molten Cake"))
						MoltenCake++;
					else	if(temp.getOrder().getName().equalsIgnoreCase("Mushroom Soup"))
						MushroomSoup++;
					else if(temp.getOrder().getName().equalsIgnoreCase("Beef Steak"))
						BeefSteak++;
				}
				
				
				pieDataset.setValue("Grilled Chicken", chicken);
				pieDataset.setValue("Greek Salade", GreekSalade);
				pieDataset.setValue("Fried Potatos", FriedPotatos);
				pieDataset.setValue("Apple Pie", ApplePie);
				pieDataset.setValue("Molten Cake",MoltenCake);
				pieDataset.setValue("Mushroom Soup",MushroomSoup);
				pieDataset.setValue("Beef Steak", BeefSteak);
				JFreeChart chart=ChartFactory.createPieChart("Dishes Request",pieDataset,true,true,true);
				
				
			//	ChartFactory.
				
				
				PiePlot p=(PiePlot)chart.getPlot();
				//p.setForegroundAlpha(TOP_ALIGNMENT);
				ChartFrame frame=new ChartFrame("Pie Chart",chart);
				frame.setVisible(true);
				frame.setSize(450, 500);
				
				for(Reservation temp: restaurant.getReservations().getReservations()) {
					if(temp.getIsValid()==false) {
						
						totalEarned=totalEarned+temp.getBill();
						
					}
					
					
				
					
					
					
					
					
					
				}
				
				
				
				
				
				
				displayEarned.setText(Float.toString(totalEarned));
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_3.setBounds(10, 68, 174, 51);
		panel_2.add(btnNewButton_3);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			
			 
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				// delete everything in table in case user clicks on show again so that id doesn't duplicate the table
				
				table.setModel(new DefaultTableModel(null,new String[] {
						"Client", "Table number","Bill"
				}));
				
				
				// if there are no reservations yet we display that there are no current reservations
				
				
			if(restaurant.getReservations().getReservations().isEmpty()) {
				
				
				label.setText("no reservations added");
				
			}
			else {
				
				label.setText(" reservations available :");
				
				
			}
				
				
				
				// filling the table from list
				
				 DefaultTableModel model=(DefaultTableModel) table.getModel();
				List<Reservation> list=manager.viewReservations(restaurant);
				Object rowData[] =new Object[30];
				for(int i=0;i<list.size();i++) {
					
					rowData[0]=list.get(i).getClient();
					rowData[1]=list.get(i).getTableNumber();
					System.out.println(list.get(i).getBill());
					rowData[2]=list.get(i).getBill();
					//totalEarned=totalEarned+list.get(i).getBill();
										
					rowData[3]=list.get(i).getClient();
					rowData[4]=list.get(i).getTableNumber();
					rowData[5]=list.get(i).getBill();
				//	totalEarned=totalEarned+list.get(i).getBill();
					
					
					rowData[6]=list.get(i).getClient();
					rowData[7]=list.get(i).getTableNumber();
					rowData[8]=list.get(i).getBill();
			//		totalEarned=totalEarned+list.get(i).getBill();
					
					
					
					
					rowData[9]=list.get(i).getClient();
					rowData[10]=list.get(i).getTableNumber();
					rowData[11]=list.get(i).getBill();
					//totalEarned=totalEarned+list.get(i).getBill();
					
					rowData[12]=list.get(i).getClient();
					rowData[13]=list.get(i).getTableNumber();
					rowData[14]=list.get(i).getBill();
				//	totalEarned=totalEarned+list.get(i).getBill();
					
					model.addRow(rowData);
					
				}
				
			//	displayEarned.setText(Float.toString(totalEarned));
				if(list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Empty List");
				}
				
				
			}
		});
		
		
		
	 
		
		
		
	}
}
