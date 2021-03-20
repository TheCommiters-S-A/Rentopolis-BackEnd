package edu.eci.ieti.rentopolis.controller;


import edu.eci.ieti.rentopolis.dto.PropertyDTO;
import edu.eci.ieti.rentopolis.dto.UserDTO;
import edu.eci.ieti.rentopolis.dto.LeaseDTO;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.entities.Lease;
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


    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody UserDTO userDTO) {
        User user = userDTO.convertToEntity(userDTO);
        rentopolisServices.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers() {
        try {
            return new ResponseEntity<>(rentopolisServices.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(rentopolisServices.getUserById(id), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/property")
    public ResponseEntity<Object> addProperty(@RequestBody PropertyDTO propertyDTO) {
        Property property = propertyDTO.convertToEntity(propertyDTO);
        rentopolisServices.addProperty(property);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<Object> getProperties() {
        try {
            return new ResponseEntity<>(rentopolisServices.getAllProperty(), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<Object> getPropertyById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(rentopolisServices.getPropertyById(id), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/lease")
    public ResponseEntity<Object> addLease(@RequestBody LeaseDTO leaseDTO) {
        Lease lease = leaseDTO.convertToEntity(leaseDTO);
        rentopolisServices.addLease(lease);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable long id) {
        try {
            rentopolisServices.deleteProperty(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

