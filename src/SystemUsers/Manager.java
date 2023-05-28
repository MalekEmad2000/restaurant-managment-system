 package SystemUsers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import File.Read;
import Restaurant.Order;
import Restaurant.Reservation;
import Restaurant.Restaurant;
import Restaurant.User;

public class Manager extends User{

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Reservation> viewReservations(Restaurant restaurant) {
		
		List<Reservation> list=new ArrayList<>();
		
	for(Reservation reservation:restaurant.getReservations().getReservations()) {
		
		
		list.add(reservation);
	
		
		
	}	
		
		
 
		return list;
		
	}
	
	public List<Order> viewOrders(Restaurant restaurant) {
		
		List<Order> list=new ArrayList<>();
		
	for(Order order:restaurant.getOrders().getOrders()) {
		
		
		list.add(order);
	
		
		
	}	
		
		
 
		return list;
		
	}
	
	
	
	
	
	
 
	}


