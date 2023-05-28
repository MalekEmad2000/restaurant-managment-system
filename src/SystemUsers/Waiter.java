package SystemUsers;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBException;

import File.Write;
import Restaurant.Order;
import Restaurant.Reservation;
import Restaurant.Restaurant;
import Restaurant.User;

 

public class Waiter extends User {

	public Waiter() {
		 super();
	}

	
	Write a=new Write();
	
	
	
	public List<Reservation> viewReservations(Restaurant restaurant) {
		
		List<Reservation> list=new ArrayList<>();
		
	for(Reservation reservation:restaurant.getReservations().getReservations()) {
		
		
		list.add(reservation);
	
		
		
	}	
		
		
 
		return list;
		
	}
	
	
	public void tableCheckout(Restaurant restaurant,int tableNumber) throws JAXBException {
		
for(Reservation temp:restaurant.getReservations().getReservations()) {
			
			if(temp.getTableNumber()==tableNumber&&temp.getIsValid()==true) {
						
				a.InvalidReservation(temp, restaurant, restaurant.getReservations(),tableNumber);
				
				break;
		 
				
			}
			else {
				
				continue;
				}			 
			
		}

for(Order order: restaurant.getOrders().getOrders()) {

	if(order.getTableNumber()==tableNumber&&order.getIsValidOrder()==true) {
				
		a.InvalidOrder(order, restaurant,tableNumber,restaurant.getOrders());
		
		break;
 
		
	}
	else {
		
		continue;
		}			 
	
	
	
}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
