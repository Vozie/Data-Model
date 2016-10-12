package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import app.controller.CustomerRepository;
import app.controller.DriverRepository;
import app.model.Customer;
import app.model.Driver;

@SpringBootApplication
@ComponentScan("controller.CustomerRespository")
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private DriverRepository repository2;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("test@yahoo.com", "Alice", "Smith"));
		repository.save(new Customer("test2@yahoo.com", "Bob", "Smith"));

		// save a couple of Drivers
		repository2.save(new Driver("driver@gmail.com","Dan","Liang"));
		repository2.save(new Driver("driver2@gmail.com","Goku","Liang"));
		repository2.save(new Driver("driver3@gmail.com","Steve","Balmer"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch all customers
		System.out.println("Drivers found with findAll():");
		System.out.println("-------------------------------");
		for (Driver driver : repository2.findAll()) {
			System.out.println(driver);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));
		
		//get customers with the same last name
		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
		// fetch an individual driver
		System.out.println("Driver found with findByFirstName('Goku'):");
		System.out.println("--------------------------------");
		System.out.println(repository2.findByFirstName("Goku"));

		//get all drivers with a certain last name
		System.out.println("Driver found with findByLastName('Liang'):");
		System.out.println("--------------------------------");
		for (Driver driver : repository2.findByLastName("Liang")) {
			System.out.println(driver);
		}
	}

}