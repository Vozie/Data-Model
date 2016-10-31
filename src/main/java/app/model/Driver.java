package app.model;

import org.springframework.data.annotation.Id;

public class Driver {
	
	@Id
	public String email;
	
	private String firstName;
	private String lastName;
	private int xCoordinate;
	private int yCoordinate;
	
	public Driver(){}
	
	public Driver(String email,String firstName, String lastName){
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	@Override 
	public String toString(){
		return String.format("Customer[id=%s, firstName ='%s', lastName='%s']", 
				email,firstName,lastName);
	}
}
