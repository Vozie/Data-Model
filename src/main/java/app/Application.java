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

public class Application  {

	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



}