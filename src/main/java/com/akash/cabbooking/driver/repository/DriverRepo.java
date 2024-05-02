package com.akash.cabbooking.driver.repository;

import com.akash.cabbooking.driver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Integer> {
}
