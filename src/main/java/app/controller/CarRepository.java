package app.controller;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Car;

public interface CarRepository extends MongoRepository<Car,String> {

    public List<Car> findByMake(String make);
    public List<Car> findByModel(String model);
    public List<Car> findByYear(String year);
    
}