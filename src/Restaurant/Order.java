package Restaurant;
 import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
	
	
	@XmlElement(name="order")
	private Dish order;
	
	
	
	@XmlElement(name="table_number")
	private int tableNumber;
	@XmlElement(name="valid_order")
	private boolean isValidOrder;
	@XmlElement(name="clientname")
	private String clientName;
	
	
	
	
	

	public Order() {
	 isValidOrder=true;
	}








	public Dish getOrder() {
		return order;
	}


public void setTableNumber(int tableNumber) {
	this.tableNumber=tableNumber;
}

public int getTableNumber() {
	return tableNumber;
}



	public void setOrder(Dish order) {
		this.order = order;
	}
	
	public void setIsValidOrder(boolean isValidOrder) {
		this.isValidOrder=isValidOrder;
		
		
	}
	
	public boolean getIsValidOrder() {
		return isValidOrder;
		
		
		
	}








 




	public String getClientName() {
		return clientName;
	}








	public void setClientName(String clientName) {
		this.clientName = clientName;
	}








	public void setValidOrder(boolean isValidOrder) {
		this.isValidOrder = isValidOrder;
	}
	
	
	

}

