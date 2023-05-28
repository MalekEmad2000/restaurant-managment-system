package Gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;

import File.Read;
import File.Write;
import Restaurant.Reservation;
import Restaurant.Restaurant;
import SystemUsers.Waiter;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class WaiterFrame extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel panel;
	private JTable table;
	private JButton btnNewButton;
	private JLabel Label;
	private JPanel lblEnter;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterFrame frame = new WaiterFrame();
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
	public WaiterFrame() throws JAXBException {

		Read r=new Read();
		Write a=new Write();
		Waiter waiter =new Waiter();
		Restaurant restaurant=r.loadRestaurant(); 
		
		
		setTitle("Waiter");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 649);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 895, 610);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Show Reservations", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(48, 74, 625, 419);
		panel.add(table);
		
		btnNewButton = new JButton("Show Reservations");
		btnNewButton.setBounds(10, 515, 363, 56);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(new DefaultTableModel(null,new String[] {
						"Client", "Table number"
				}));
				
				
				
				
				
			if(restaurant.getReservations().getReservations().isEmpty()) {
				
				
				Label.setText("no reservations added");
				
			}
			else {
				
				Label.setText(" reservations available :");
				
				
			}
				
				
				
				// filling the table from list
				
				 DefaultTableModel model=(DefaultTableModel) table.getModel();
				List<Reservation> list=waiter.viewReservations(restaurant);
				Object rowData[] =new Object[10];
				for(int i=0;i<list.size();i++) {
				if(	list.get(i).getIsValid()==true) {
					
					rowData[0]=list.get(i).getClient();
					rowData[1]=list.get(i).getTableNumber();
					
					rowData[2]=list.get(i).getClient();
					rowData[3]=list.get(i).getTableNumber();
					
					rowData[4]=list.get(i).getClient();
					rowData[5]=list.get(i).getTableNumber();
					
					rowData[6]=list.get(i).getClient();
					rowData[7]=list.get(i).getTableNumber();
					
					rowData[8]=list.get(i).getClient();
					rowData[9]=list.get(i).getTableNumber();
					
					model.addRow(rowData);
				}
				
				else
					continue;
				}
				
				
				
				
				
			}
				
				
				
				
				
				
				
				
				
				
				
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(btnNewButton);
		
		Label = new JLabel("New label");
		Label.setBounds(25, 22, 165, 27);
		panel.add(Label);
		
		lblEnter = new JPanel();
		tabbedPane.addTab("Check out", null, lblEnter, null);
		lblEnter.setLayout(null);
		
		lblNewLabel = new JLabel("Please Enter Table Number to check out:");
		lblNewLabel.setBounds(10, 32, 285, 31);
		lblEnter.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(327, 37, 86, 20);
		lblEnter.add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Check Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
				try {
					waiter.tableCheckout(restaurant, Integer.parseInt(textField.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 29));
		btnNewButton_1.setBounds(0, 109, 456, 126);
		lblEnter.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("log out", null, panel_1, null);
		panel_1.setLayout(null);
		
		btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
				RestaurantGui logout=new RestaurantGui();
				logout.frame.setVisible(true);
				}catch(JAXBException e1) {
					
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_2.setForeground(Color.YELLOW);
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(181, 210, 397, 65);
		panel_1.add(btnNewButton_2);
		
		JTextArea txtrIfYouHave = new JTextArea();
		txtrIfYouHave.setText("If you have got any problems or suggestions ,do not hesitate in contacting the system manager");
		txtrIfYouHave.setEditable(false);
		txtrIfYouHave.setWrapStyleWord(true);
		txtrIfYouHave.setBounds(63, 21, 515, 150);
		panel_1.add(txtrIfYouHave);
		
		Object[] columns= {"name ","table number"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		Font font =new Font("",1,22);
		
	 
 
		
		
	}
}
