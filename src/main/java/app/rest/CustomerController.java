package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.controller.CustomerRepository;
import app.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerAccessor;
	
	/**
	 * GET request that will return all customers in the database.
	 * @return
	 */
	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return customerAccessor.findAll();
	}

	/**
	 * POST request that will create a customer in the database if payload is correct
	 * @param c
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Customer createUser(@RequestBody Customer c){
		return customerAccessor.save(c);
	}
	
	/**
	 * GET request that will return one customer by their unique id
	 * @param email
	 * @return
	 */
	@RequestMapping(value="{email}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email){
		Customer customer = customerAccessor.findByEmail(email);
		if(customer == null){
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
	}
	
	/**
	 * PUT request that will update via replace the old data with the new data
	 * @param updateCustomer
	 * @param email
	 * @return
	 */
	@RequestMapping(value="email}", method=RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@Validated @RequestBody Customer updateCustomer, @PathVariable("email") String email){
		Customer customerData = customerAccessor.findByEmail(email);
		if(customerData == null){
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		customerData.setFirstName(updateCustomer.getFirstName());
		customerData.setLastName(updateCustomer.getLastName());
		Customer updatedObject = customerAccessor.save(customerData);
		
		return new ResponseEntity<Customer>(updatedObject,HttpStatus.OK);
	}
	
	/**
	 * DELETE request. Finds Data Object by email and if it exists will delete it.
	 * @param email
	 */
	@RequestMapping(value="email}",method=RequestMethod.DELETE)
	public void deleteTodo(@PathVariable("email") String email){
		customerAccessor.delete(email);
	}
	
	
}
