package edu.eci.ieti.rentopolis.controller;


import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;
import edu.eci.ieti.rentopolis.services.RentopolisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RentopolisController {


    @Autowired
    private RentopolisServices rentopolisServices;


    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            rentopolisServices.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(rentopolisServices.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(rentopolisServices.getUserById(id), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/property")
    public ResponseEntity<?> addProperty(@RequestBody Property property) {
        try {
            rentopolisServices.addProperty(property);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    
    @GetMapping("/Property")
    public ResponseEntity<?> getUserProperties(User user) {
        try {
            return new ResponseEntity<>(rentopolisServices.getUserProperties(user), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/lease")
    public ResponseEntity<?> addProperty(@RequestBody Lease lease) {
        try {
            rentopolisServices.addLease(lease);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    
    
    @GetMapping("/lease")
    public ResponseEntity<?> getUserLease(User user, Long leaseId) {
        try {
            return new ResponseEntity<>(rentopolisServices.getUserLease(user, leaseId), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/leases")
    public ResponseEntity<?> getUserLeases(User user) {
        try {
            return new ResponseEntity<>(rentopolisServices.getUserLeases(user), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
