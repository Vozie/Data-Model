package app.model;

import org.springframework.data.annotation.Id;

public class Driver {
	
	@Id
	public String email;
	
	public String firstName;
	public String lastName;
	public int xCoordinate;
	public int yCoordinate;
	
	public Driver(){}
	
	public Driver(String email,String firstName, String lastName){
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override 
	public String toString(){
		return String.format("Customer[id=%s, firstName ='%s', lastName='%s']", 
				email,firstName,lastName);
	}
}
