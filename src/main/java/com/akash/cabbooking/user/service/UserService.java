package com.akash.cabbooking.user.service;
import com.akash.cabbooking.Location;
import com.akash.cabbooking.driver.entity.Driver;
import com.akash.cabbooking.driver.repository.DriverRepo;
import com.akash.cabbooking.exceptions.UserNotFound;
import com.akash.cabbooking.user.entity.User;
import com.akash.cabbooking.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.akash.cabbooking.exceptions.DriverNotFound;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    DriverRepo driverRepo;
    @Autowired
    UserRepo userRepo;

    public double calculateDistance(Location a, Location b){
        Double lon1=a.getLatitude();
        Double lon2=b.getLongitude();
        Double lat1=b.getLatitude();
        Double lat2=b.getLatitude();
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a1 = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a1));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 63;

        // calculate the result
        return(c * r);

    }

    public List<Driver> getRides(int  id) throws UserNotFound,DriverNotFound {
        Location l1=new Location();
        Optional<User> u1=userRepo.findById(id);
        if(u1.isEmpty())
            throw new UserNotFound("user not found with such id");
        User u=u1.get();
        Location loc=new Location(u.getLongitude(),
                u.getLatitude());
        List<Driver> drivers=driverRepo.findAll();
        drivers.removeIf(d -> calculateDistance(new Location(d.getLongitude(),d.getLatitude()), loc) > 20.0);

        return drivers;

    }

    public User addUser(User user) {
       return userRepo.save(user);
    }

    public String chooseRide(int uid, int did, Location destination) throws DriverNotFound {

        Optional<Driver> driver=driverRepo.findById(did);
        if(driver.isEmpty())
            throw new DriverNotFound("No Driver with such id found");

        Driver d=driver.get();
        d.setOccupied(true);
        driverRepo.save(d);
        User user=userRepo.findById(uid).get();
        Location source = new Location(user.getLongitude(), user.getLatitude());
       double d1= calculateDistance(source,destination);
        double f1=Math.round(d1*10);


        String out="Hi "+ user.getName()+",\nGet Ready for ride with "+
       d.getName()+" - "+d.getVehicleNumber()+" \n"+
       "Amount to be paid - "
        +f1;
       return out;
    }
}
