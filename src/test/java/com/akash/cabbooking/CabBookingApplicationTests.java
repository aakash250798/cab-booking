package com.akash.cabbooking;
import static org.junit.Assert.*;

import com.akash.cabbooking.driver.controller.DriverController;
import com.akash.cabbooking.driver.entity.Driver;
import com.akash.cabbooking.driver.service.DriverService;
import com.akash.cabbooking.exceptions.DriverNotFound;
import com.akash.cabbooking.exceptions.UserNotFound;
import com.akash.cabbooking.user.controller.UserController;
import com.akash.cabbooking.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CabBookingApplicationTests {

	@Test
	void addUserTest() throws UserNotFound, DriverNotFound {
		Boolean a=userController.addUser(new User(1, "Akash",  9.9, 9.0)).getName().equals("Akash");

		assertEquals(a,true);

	}
	@Test
	void findRideTest() throws UserNotFound, DriverNotFound {
		User u=userController.addUser(new User(1, "Akash",  9.9, 9.0));

		List<Driver> b=userController.findRides(u.getId());

		assertFalse(b.isEmpty());

	}
	@Test
	void chooseRideTest() throws UserNotFound, DriverNotFound {
		String s=userController.chooseRide(1,1,new Location(2.5,3.5));
		assertNotNull(s);
	}
	@Test
	void createDriverTest() throws UserNotFound, DriverNotFound {
		assertFalse(driverController.findAll().isEmpty());
	}

	void addDriverTest() throws UserNotFound, DriverNotFound{
		Driver d=driverController.addDriver(new Driver());
		assertNotNull(d.getId());
	}
	@Autowired
	UserController userController;


	@Autowired
	DriverController driverController;
}
