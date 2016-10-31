package app.controller;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import app.model.Driver;

public interface DriverRepository extends MongoRepository<Driver,String> {
	
    public Driver findByFirstName(String firstName);
    public List<Driver> findByLastName(String lastName);
	public Driver save(Driver driver);
	public List<Driver> findAll();
	public Driver findByEmail(String email);
	public Driver update(Driver driver);
	public void delete(Driver driver);
    
}
