package datamodel;

import app.controller.CustomerRepository;
import app.model.Car;
import app.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@ContextConfiguration
public class DataModelTest {
	
	private Car repository;

	private CustomerRepository repository2;
	
	@Before
	public void setUpMock(){
		repository = mock(Car.class);
		repository2 = mock(CustomerRepository.class);
	}
	@Test
	public void testMockCreation(){
		assertNotNull(repository);
		assertNotNull(repository2);
	}
	@Test 
	public void testSave(){
		when(repository2.findByFirstName("Alice")).thenReturn(new Customer("test@yahoo.com", "Alice", "Smith"));
		assertEquals("Smith",(repository2).findByFirstName("Alice").getLastName());
	}
	/*
	@Test
	public void test() {

		//repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("test@yahoo.com", "Alice", "Smith"));
		repository.save(new Customer("test2@yahoo.com", "Bob", "Smith"));

//		// save a couple of Drivers
//		repository2.save(new Driver("driver@gmail.com","Dan","Liang"));
//		repository2.save(new Driver("driver2@gmail.com","Goku","Liang"));
//		repository2.save(new Driver("driver3@gmail.com","Steve","Balmer"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Customer customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch all customers
//		System.out.println("Drivers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Driver driver : repository2.findAll()) {
//			System.out.println(driver);
//		}
//		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));
		
//		Assert.assertEquals("Smith", repository.findByFirstName("Alice").getLastName());
//		//get customers with the same last name
//		
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
//		
//		// fetch an individual driver
//		System.out.println("Driver found with findByFirstName('Goku'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository2.findByFirstName("Goku"));
//
//		//get all drivers with a certain last name
//		System.out.println("Driver found with findByLastName('Liang'):");
//		System.out.println("--------------------------------");
//		for (Driver driver : repository2.findByLastName("Liang")) {
//			System.out.println(driver);
//		}
	}
*/
}
