package Restaurant;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import File.Write;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	@XmlElement(name="name")
	private String name;
	
	
	
	
	@XmlElement(name="role")
	private String role;
	
	
	
	@XmlElement(name="password")
	private String PassWord;
	
	
	
	@XmlElement(name="username")
	private String UserName;
	
	
		
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
 public User identifyUser(String userName, String passWord,Restaurant restaurant) {
	 
	 
	 User identify=new User();
	 
	 for(User user:restaurant.getUsers().getUsers()) {
		 
		 
		 
		 
		 if(user.getUserName().compareTo(userName)==0&&user.getPassWord().compareTo(passWord)==0) {
			 
			 identify=user;
			 break;
			 
			 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 return identify;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }



 public void createUser(String name,String userName, String passWord,Restaurant restaurant) throws JAXBException {
	 Write writer=new Write();
	 User create =new User();
	create.setName(name);
	create.setUserName(userName);
	create.setPassWord(passWord);
	create.setRole("Client");
	writer.addUser(create, restaurant, restaurant.getUsers());
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }
 
 
 


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}



	public String getPassWord() {
		return PassWord;
	}


	public void setPassWord(String passWord) {
		PassWord = passWord;
	}



	public String getUserName() {
		return UserName;
	}





	public void setUserName(String userName) {
		UserName = userName;
	}
	
	
	

}
