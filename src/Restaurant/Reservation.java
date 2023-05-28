package Restaurant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {

	@XmlElement(name="client")
	private String client;
	
	
	@XmlElement(name="table_number")
	private int tableNumber;
	
	
	@XmlElement(name="bill")
	private float bill;
	
	@XmlElement(name="valid_reservation")
	private boolean isValid;
	

	public Reservation() {
		// TODO Auto-generated constructor stub
		isValid=true;
	}




	public String getClient() {
		return client;
	}
	
	
public void setBill(float bill) {
	this.bill=bill;
}

public float getBill() {
	return bill;
}



	public void setClient(String client) {
		this.client = client;
	}




	public int getTableNumber() {
		return tableNumber;
	}




	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
 
public void setIsValid(boolean isValid) {
	
	this.isValid=isValid;
}

public boolean getIsValid() {
	
	return isValid;
}




 

}
