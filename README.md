## Cab Booking App 


Clone the project

```bash
git clone -b master https://github.com/aakash250798/cab-booking.git

```

Install dependencies

```bash
mvn clean install -U
mvn eclipse:eclipse
mvn eclipse:clean
```

Start the server

```bash
  mvn install
  and then find the jar file from the target folder and run that har as java -jar [jar name]
  --------------------------------------------------------------------------------------
  
```
  
  
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


  API Documentations
-----------------------
  
http://localhost:port/swagger-ui/index.html  
  
Adding User->

uri - http://localhost:8080/user/addUser
<br />
RequestBody parameter-
<br />
{  
    "name":"Akash",  
    "longitude":3.0,  
    "latitude":2.5  
}  
-----------------------------

Finding Rides->

uri - http://localhost:8080/user/findRides/1  
RequestBody parameter-  
{  
   "longitude":3.5,  
   "latitude":3.2  
   }  
     
--------------------------------


Choose Ride->  

uri - http://localhost:8080/user/choose_ride/1/5  
RequestBody parameter-  
  
{  
    "longitude":20.5,  
    "latitude":30.5  
}  

-------------------------------

Add Driver->  
  
uri - localhost:8080/driver/add_driver  
RequestBody parameter-  
{  
    "name":"Vineet",  
    "vehicleNumber":"KA-42-AJ-9178",  
    "longitude":20.5,  
    "latitude":62  
}  
---------------------------
  
Get All Drivers List  
  
uri - localhost:8080/driver/getAll  

