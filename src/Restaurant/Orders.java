package Restaurant;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {
	
	
	
	@XmlElement(name="order")
	private List<Order> orders;
	
	
	
	
	
	
	

	public List<Order> getOrders() {
		return orders;
	}








	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}








	public Orders() {
		// TODO Auto-generated constructor stub
	}

}
