package com.akash.cabbooking.user.controller;

import com.akash.cabbooking.Location;
import com.akash.cabbooking.driver.entity.Driver;
import com.akash.cabbooking.exceptions.DriverNotFound;
import com.akash.cabbooking.exceptions.UserNotFound;
import com.akash.cabbooking.user.entity.User;
import com.akash.cabbooking.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)throws UserNotFound, DriverNotFound{

        return userService.addUser(user);
    }

    @GetMapping("/findRides/{id}")
    public List<Driver> findRides(@PathVariable int id ) throws UserNotFound, DriverNotFound {

        return userService.getRides(id);
    }


    @GetMapping("/choose_ride/{uid}/{did}")
    public String chooseRide(@PathVariable int uid, @PathVariable int did, @RequestBody Location destination) throws UserNotFound, DriverNotFound{

        return userService.chooseRide(uid,did,destination);
    }
}
