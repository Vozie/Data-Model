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


import app.controller.DriverRepository;
import app.model.Driver;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

	@Autowired
	DriverRepository driverAccessor;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Driver> getAllDrivers(){
		return driverAccessor.findAll();
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value="{email}",method=RequestMethod.GET)
	public ResponseEntity<Driver> getDriverByEmail(@PathVariable("email") String email){
		Driver driver = driverAccessor.findByEmail(email);
		if(driver == null){
			return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Driver>(driver,HttpStatus.OK);
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Driver createDriver(@Validated @RequestBody Driver driver){
		return driverAccessor.save(driver);
	}
	
	/**
	 * 
	 * @param driver
	 * @param email
	 * @return
	 */
	@RequestMapping(value="{email}",method=RequestMethod.PUT)
	public ResponseEntity<Driver> updateDriver(@Validated @RequestBody Driver driver, @PathVariable("email") String email){
		Driver driverData = driverAccessor.findByEmail(email);
		if(driverData == null){
			return new ResponseEntity<Driver>(HttpStatus.OK);
		}
		driverData.setFirstName(driver.getFirstName());
		driverData.setLastName(driver.getLastName());
		Driver updatedDriver = driverAccessor.save(driverData);
		return new ResponseEntity<Driver>(updatedDriver,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param email
	 */
	@RequestMapping(value="{email}",method=RequestMethod.DELETE)
	public void deleteDriver(@PathVariable("email") String email){
		driverAccessor.delete(email);
	}
}












