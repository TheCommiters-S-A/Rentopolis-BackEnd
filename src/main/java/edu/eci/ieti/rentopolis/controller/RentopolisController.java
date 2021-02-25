package edu.eci.ieti.rentopolis.controller;


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
            System.out.println("OK---------------------------------------------------- "+user.Name);
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
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(rentopolisServices.getUserById(id), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}
