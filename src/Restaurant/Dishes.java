package Restaurant;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dishes {

	
	
	
	
	
	@XmlElement(name="dish")
	private List<Dish> dishes;
	
	public Dishes() {
		// TODO Auto-generated constructor stub
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	
	

}
