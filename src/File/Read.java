package File;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Restaurant.Order;
import Restaurant.Orders;
import Restaurant.Reservation;
import Restaurant.Reservations;
import Restaurant.Restaurant;

public class Read {
	
	 private Restaurant restaurant;
	
	
	

	public Read() throws JAXBException {
		 
        JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Unmarshaller unmarshaller=jaxbcontext.createUnmarshaller();
		restaurant=(Restaurant) unmarshaller.unmarshal(new File("input.xml"));
		
		}
	
	
	
	
	public	Restaurant loadRestaurant() throws JAXBException {
		
		

        JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Unmarshaller unmarshaller=jaxbcontext.createUnmarshaller();
		Restaurant restaurant=(Restaurant) unmarshaller.unmarshal(new File("input.xml"));
		
try {		
	 for(Reservation temp:restaurant.getReservations().getReservations()) {}
}catch(Exception e) {
	
	
	Reservations reservations=new Reservations();	 
	List<Reservation> reservationsList=new ArrayList<>();
	reservations.setReservations(reservationsList);
	restaurant.setReservations(reservations);
}
try {		
	 for(Order temp:restaurant.getOrders().getOrders()) {}
}catch(Exception e) {
	
	
	Orders orders=new Orders();	 
	List<Order> orderList=new ArrayList<>();
	orders.setOrders(orderList);
	restaurant.setOrders(orders);
}


          return restaurant;		
	}




	public Restaurant getRestaurant() {
		return restaurant;
	}




	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
