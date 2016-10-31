package app.model;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	private String email;

	private String firstName;
	private String lastName;

	public Customer() {
	}

	
	public Customer(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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
	
	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName ='%s', lastName='%s']", email, firstName, lastName);
	}
}
