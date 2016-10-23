package app.model;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	public String email;
	
	public String firstName;
	public String lastName;
	
	public Customer(){}
	
	public Customer(String email,String firstName, String lastName){
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail(){return email;}
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
