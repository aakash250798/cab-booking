package com.akash.cabbooking.driver.service;

import com.akash.cabbooking.driver.entity.Driver;
import com.akash.cabbooking.driver.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {
    @Autowired
    DriverRepo driverRepo;
    public Driver addDriver(Driver driver) {
        return driverRepo.save(driver);
    }
    public List<Driver> findAll() {
        return driverRepo.findAll();
    }
}
