package SystemUsers;
import java.util.ArrayList;
import java.util.List;

import File.Write;
import Restaurant.Order;
import Restaurant.Orders;
import Restaurant.Reservation;
import Restaurant.Restaurant;
import Restaurant.User;

public class Cook extends User {

	public Cook() {
		 super();
	}
	Write writer=new Write();
	
	
	public List<Order> viewOrders(Restaurant restaurant) {
		
		List<Order> list=new ArrayList<>();
		
	for(Order order:restaurant.getOrders().getOrders()) {
		
		
		list.add(order);
	
		
		
	}	
		
		
 
		return list;
		
	}
	
	/*
void orderPrepared(Restaurant restaurant,int tableNumber) {
	
	
	
	for(Order temp:restaurant.getOrders().getOrders()) {
		
		if(temp.getTableNumber()==tableNumber) {
					
			temp.setIsValidOrder(false);
			//writer.orderFinished(Order order,Restaurant restaurant,Orders orders,int tableNumber);
			break;
	 
			
		}
		else {
			
			continue;
			}			 
		
	}
		
		
		
	}
	
	*/
	

}
