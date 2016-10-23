package app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.controller.CustomerRepository;
import app.model.Customer;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

	@Autowired
	private CustomerRepository accessor;
	
	@RequestMapping(value="/findAllCustomers", method=RequestMethod.POST)
	public List<Customer> getAllCustomers(){
		return accessor.findAll();
	}

	@RequestMapping(value="/createCustomer",method = RequestMethod.POST)
	public Customer createUser(@RequestBody Customer c){
		return accessor.save(c);
	}
	
	@RequestMapping(value="{email}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email){
		Customer customer = accessor.findSelected(email);
		if(customer == null){
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
	}
}
