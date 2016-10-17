package app.model;

import org.springframework.data.annotation.Id;

public class Car {
	
	@Id
	private String id;
	
	private String make;
	private String model;
	private String year;
	
	private Driver driver; //Car can have one driver
	
	public Car(){
		
	}
	public Car(String make, String model, String year, Driver driver){
		this.make  = make;
		this.model = model;
		this.year = year;
		this.driver = driver;
	}
	
	@Override
	public String toString(){
		return String.format("Make[id=%s, Model ='%s', Year='%s', Driver = '%s']", 
				make,model,year,driver.toString());
	}
	
}
