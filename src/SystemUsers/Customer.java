package SystemUsers;


 import java.util.List;

import javax.xml.bind.JAXBException;

import File.Write;
import Restaurant.Dish;
import Restaurant.Order;
import Restaurant.Reservation;
import Restaurant.Restaurant;
import Restaurant.Table;
import Restaurant.User;

public class Customer extends User {

	
	private float bill;
	

	
	
	
	public Customer() {
		 super();
		 bill=0;
		 
	}
	
	Write writer=new Write();
	
	Dish[] showMenu(Restaurant restaurant){
		
		
		int i=0;
		Dish [] dishes=new Dish[7];
for(Dish dish:restaurant.getDishes().getDishes()) {
	
	dishes[i]=dish;

	i++;
	
}
		
		
		
		
		return dishes;
		
		
	}
	
	
	public float priceBeforeTax(Restaurant restaurant,int tableNumber) {
		float total=0;
for(Order temp: restaurant.getOrders().getOrders()) {
	if(tableNumber==temp.getTableNumber()&&temp.getIsValidOrder()==true) {
	switch(temp.getOrder().getType()) {
		case"appetizer":
			total=(float)(total+  ((float)(temp.getOrder().getPrice())));
			break;
		case "main_course":
			total=(float)(total+  ((float)(temp.getOrder().getPrice())));
			break;
		case"desert":
			total=(float)(total+  ((float)(temp.getOrder().getPrice())));
			break;
		}
	}
}
return total;
	}
	public int tableNumSearch(String name,Restaurant restaurant) {
		int tableNumber = 0;
		
		for(Reservation temp: restaurant.getReservations().getReservations()) {
			if(temp.getClient().equalsIgnoreCase(name)) {
			tableNumber=temp.getTableNumber();
			}
		}
		
		
		
	return tableNumber;
	}
	public float checkOut(Restaurant restaurant,int tableNumber,String name) {
		float total=0;
for(Order temp: restaurant.getOrders().getOrders()) {
	if(tableNumber==temp.getTableNumber()&&temp.getIsValidOrder()==true&&temp.getClientName().equalsIgnoreCase(name)) {
	switch(temp.getOrder().getType()) {
		case"appetizer":
			total=(float)(total+  ((float)(temp.getOrder().getPrice())*(1.1)));
			break;
		case "main_course":
			total=(float)(total+  ((float)(temp.getOrder().getPrice())*(1.15)));
			break;
		case"desert":
			total=(float)(total+  ((float)(temp.getOrder().getPrice())*(1.2)));
			break;
		}
	}
		
	}
return total;
	}
	
	public void reserveTable(String name,Restaurant restaurant,int seats,boolean smoking) throws JAXBException {
		
		
		
		
		
		Reservation reservation=new Reservation();
		
		
		
		for(Table table: restaurant.getTables().getTables()) {
			
			if(table.getAvailable()==true&&table.getNumberOfSeats()>seats&&table.getSmoking()==smoking) {
				
				
				reservation.setClient(name);
				reservation.setTableNumber(table.getNumber());
				reservation.setIsValid(true);
				table.setAvailable(false);
				writer.addReservation(reservation, restaurant, restaurant.getReservations());
				
				break;
		 
				
			}
			else {
				
				continue;
				}			 
			
		}
		
		
		}
	
	
	public void orderDishes(String dishName,int tableNumber,Restaurant restaurant,String name) throws JAXBException{
		Order order=new Order();
		boolean tableFound=false;
		boolean isAvailable=false; //if the table is available then user cannot order
		boolean dishIsFound=false;
		
		
		order.setClientName(name);
		for(Table table: restaurant.getTables().getTables()) {
			if(table.getNumber()==tableNumber) {
				isAvailable=table.getAvailable();
				tableFound=true;
			}
				
		}

	//if(tableFound==true&&isAvailable==false) {
		for(Dish dish:restaurant.getDishes().getDishes()) {
			if(dish.getName().equalsIgnoreCase(dishName)){
				order.setOrder(dish);
				order.setTableNumber(tableNumber);
				writer.addOrder(order, restaurant, restaurant.getOrders());
				System.out.println("Suceess");
				dishIsFound=true;
		}
	
	}
	}
	
	
	
	/*
public void saveBill(String name,Restaurant restaurant,int tableNumber,float bill) throws JAXBException {
		
		Reservation reservation=new Reservation();
		
		reservation.setBill(bill);
		reservation.setTableNumber(tableNumber);
		
		for(Reservation temp:restaurant.getReservations().getReservations()) {
			
			if(temp.getTableNumber()==tableNumber&&temp.getClient().equalsIgnoreCase(name)&&temp.getIsValid()==true) {
						
				writer.addReservation(reservation, restaurant, restaurant.getReservations(),false);
				
				break;
		 
				
			}
			else {
				
				continue;
				}			 
			
		}
		
		
		}
	*/
	
	
	
	public void saveBill(String name,Restaurant restaurant,int tableNumber,float bill) throws JAXBException{
		Reservation reservation=new Reservation();
		reservation.setBill(bill);
		reservation.setClient(name);
		reservation.setIsValid(true);
		reservation.setTableNumber(tableNumber);
		for(Reservation temp:restaurant.getReservations().getReservations()) {
			
			if(temp.getTableNumber()==reservation.getTableNumber()&&temp.getClient().equalsIgnoreCase(reservation.getClient())&&temp.getIsValid()==true) {
				
				temp.setBill(reservation.getBill());
				writer.addReservation(temp, restaurant, restaurant.getReservations(),false);
				
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
