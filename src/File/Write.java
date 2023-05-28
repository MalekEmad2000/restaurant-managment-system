package File;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Restaurant.Order;
import Restaurant.Orders;
import Restaurant.Reservation;
import Restaurant.Reservations;
import Restaurant.Restaurant;
import Restaurant.Table;
import Restaurant.User;
import Restaurant.Users;

public class Write {
	//used by waiter to make reservation status invalid when checking out
	public void InvalidReservation(Reservation reservation,Restaurant restaurant,Reservations reservations,int tableNumber) throws JAXBException {
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<Reservation> reservationsList=new ArrayList<>();
		for(Reservation temp: restaurant.getReservations().getReservations()) {
			if(reservation.getTableNumber()==temp.getTableNumber()&&reservation.getIsValid()==true&&temp.getClient().equalsIgnoreCase(reservation.getClient())) {
				reservation.setClient(temp.getClient());
				reservation.setIsValid(false);
				
				for(Table table :restaurant.getTables().getTables()) {
					if(reservation.getTableNumber()==table.getNumber()) {
						
						table.setAvailable(true);
			}
					
					
					
				}
				
				
				
				
				reservationsList.add(reservation);
			
			}
			else		
	 reservationsList.add(temp);
		}
		
		
	//	reservationsList.add(reservation);
		reservations.setReservations(reservationsList);
		restaurant.setReservations(reservations);
		marshaller.marshal(restaurant, new File ("input.xml"));
		
	}
		
		
		
		
		
		
		
		
		
	
	
	//used by waiter to make order associated to certain reservation  invalid when checking out
	
	public void InvalidOrder(Order order ,Restaurant restaurant,int tableNumber,Orders orders) throws JAXBException {
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<Order> orderList=new ArrayList<>();
for(Order temp: restaurant.getOrders().getOrders()) {
			if(tableNumber==temp.getTableNumber()&&temp.getIsValidOrder()==true) {
				temp.setIsValidOrder(false);
			orderList.add(temp);
		}
else {
	orderList.add(temp);
	
}
		
}	
		

orders.setOrders(orderList);
restaurant.setOrders(orders);

marshaller.marshal(restaurant, new File ("input.xml"));
	
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	/*
	
	
	public void addReservation(Reservation reservation,Restaurant restaurant,Reservations reservations,boolean reserved) throws JAXBException {
		
		
		
		 
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<Reservation> reservationsList=new ArrayList<>();
		
for(Reservation temp: restaurant.getReservations().getReservations()) {
			if(reservation.getTableNumber()==temp.getTableNumber()&&temp.getIsValid()==true) {
				reservation.setClient(temp.getClient());
				//reservation.setIsValid(false);
				
				//for(Table table :restaurant.getTables().getTables()) {
				//	if(reservation.getTableNumber()==table.getNumber()) {
						
				//		table.setAvailable(true);
			//		}
					
					
					
				//}
				
				
				
				
				reservationsList.add(reservation);
			
			}
			else		
	 reservationsList.add(temp);
		}
		
		
	//	reservationsList.add(reservation);
		reservations.setReservations(reservationsList);
		restaurant.setReservations(reservations);
		marshaller.marshal(restaurant, new File ("input.xml"));
		
	}
	
	
	*/
	
	
	
	
	//used when reserving
	
	public void addReservation(Reservation reservation,Restaurant restaurant,Reservations reservations) throws JAXBException {
		
		
		
		 
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<Reservation> reservationsList=new ArrayList<>();
		
for(Reservation temp: restaurant.getReservations().getReservations()) {
			
	 reservationsList.add(temp);
		}
		
		
		reservationsList.add(reservation);
		reservations.setReservations(reservationsList);
		restaurant.setReservations(reservations);
		marshaller.marshal(restaurant, new File ("input.xml"));
		
	}
	
	
	//called at savebill to save new information in the order
	public void addReservation(Reservation reservation,Restaurant restaurant,Reservations reservations,boolean one) throws JAXBException {
		
		
		
		 
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<Reservation> reservationsList=new ArrayList<>();
		
for(Reservation temp: restaurant.getReservations().getReservations()) {
	reservationsList.add(temp);
		}
		
		
		//reservationsList.add(reservation);
		reservations.setReservations(reservationsList);
		restaurant.setReservations(reservations);
		marshaller.marshal(restaurant, new File ("input.xml"));
		
	}
	
 
	
	
	
	
	
	
	
	
	
	//used when registering a new user
	public void addUser(User user,Restaurant restaurant,Users users)throws JAXBException {
		
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<User> userList=new ArrayList<>();
		
for(User temp: restaurant.getUsers().getUsers()) {
			
			userList.add(temp);
		}
		
userList.add(user);
users.setUsers(userList);
restaurant.setUsers(users);
		
marshaller.marshal(restaurant, new File ("input.xml"));	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//used in adding orders 
	
	public void addOrder(Order order,Restaurant restaurant,Orders orders) throws JAXBException {
		
		
	
		 
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<Order> orderList=new ArrayList<>();
for(Order temp: restaurant.getOrders().getOrders()) {
			
			orderList.add(temp);
		}
		
		
		orderList.add(order);
		orders.setOrders(orderList);
		restaurant.setOrders(orders);
		
		marshaller.marshal(restaurant, new File ("input.xml"));
		
	}
	
	/*
	
	public void orderFinished(Order order,Restaurant restaurant,Orders orders,int tableNumber) throws JAXBException {
		JAXBContext jaxbcontext=JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller=jaxbcontext.createMarshaller();
		List<Order> orderList=new ArrayList<>();
		
for(Order temp: restaurant.getOrders().getOrders()) {
	if(temp.getTableNumber()==tableNumber)	
		order.setIsValidOrder(false);
		
		
		
		
		
			orderList.add(temp);
		}
		
		
orderList.add(order);
orders.setOrders(orderList);
restaurant.setOrders(orders);

marshaller.marshal(restaurant, new File ("input.xml"));
		
		
		
		
		
	}
	
	
	
*/	
	
	
	
	
	

	public Write() {
		// TODO Auto-generated constructor stub
	}

}
