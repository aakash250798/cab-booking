package com.akash.cabbooking.driver.controller;

import com.akash.cabbooking.driver.entity.Driver;
import com.akash.cabbooking.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/getAll")
    public List<Driver> findAll(){
        return driverService.findAll();
    }
    @PostMapping("/add_driver")
    public Driver addDriver(@RequestBody Driver driver){
        return driverService.addDriver(driver);
    }




}
