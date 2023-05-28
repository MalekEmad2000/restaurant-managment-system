package Restaurant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;











@XmlRootElement(name="restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {

	
 

	@XmlElement(name="users")
	private Users users;
	
	@XmlElement(name="tables")
	private Tables tables;
	
	
	@XmlElement(name="dishes")
	 private Dishes dishes;
	
	@XmlElement(name="reservations")
	private Reservations reservations;
	
	@XmlElement(name="orders")
	private Orders orders;
	
	
	
	
	

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

 
 
 


 




	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}

	public Tables getTables() {
		return tables;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}

	public Dishes getDishes() {
		return dishes;
	}

	public void setDishes(Dishes dishes) {
		this.dishes = dishes;
	}
	
	
	public Reservations getReservations() {
		return reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}











	public Orders getOrders() {
		return orders;
	}











	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
	

}
