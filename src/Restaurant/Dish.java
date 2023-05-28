package Restaurant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dish")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dish {

	
	@XmlElement(name="name")
	 private String name;
	
	@XmlElement(name="type")
	 private String type;
	
	@XmlElement(name="price")
	 private float price;
	
	public Dish() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
}
