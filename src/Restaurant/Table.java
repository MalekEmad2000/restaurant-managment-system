package Restaurant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

	
	
	@XmlElement(name="number")
	private int number ;
	@XmlElement(name="number_of_seats")
	private int numberOfSeats;
	
	@XmlElement(name="smoking")
	private boolean smoking;
	
	@XmlElement(name="available")
	private boolean available;
	
	
	
	
	int isAvailable(Table table) {
		
	if(table.getAvailable())
		return 1;
	else 
		return 0;
				
		
		
	}
	int isSmoking(Table table) {
		
		if(table.getSmoking())
			return 1;
		else 
			return 0;
					
			
			
		}
	
	
	
	public Table() {
		// TODO Auto-generated constructor stub
		available=true;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public boolean getSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}


	public boolean getAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}



}
