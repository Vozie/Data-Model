package app.controller;

import app.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
	public Customer save(Customer customer);
	public List<Customer> findAll();
	public Customer findSelected(String email);
	public Customer update(Customer customer);
	public void delete(Customer customer);
}
