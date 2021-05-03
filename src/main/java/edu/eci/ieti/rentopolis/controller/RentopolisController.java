package edu.eci.ieti.rentopolis.controller;


import edu.eci.ieti.rentopolis.dto.PropertyDTO;
import edu.eci.ieti.rentopolis.dto.UserDTO;
import edu.eci.ieti.rentopolis.dto.LeaseDTO;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;
import edu.eci.ieti.rentopolis.services.RentopolisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.eci.ieti.rentopolis.entities.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO userDTO, @PathVariable String id) {
        try {
            User user = userDTO.convertToEntity(userDTO);
            rentopolisServices.updateUser(user, id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id){
        try {
            rentopolisServices.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } 
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers() {
        try {
            return new ResponseEntity<>(rentopolisServices.getAllUsers(), HttpStatus.OK);
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

    @GetMapping("/user/email/{email}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email) throws RentopolisServicesException {
        return new ResponseEntity<>(rentopolisServices.getUserByEmail(email), HttpStatus.ACCEPTED);

    }

    @PostMapping("/property")
    public ResponseEntity<Object> addProperty(@RequestBody PropertyDTO propertyDTO) {
        Property property = propertyDTO.convertToEntity(propertyDTO);
        rentopolisServices.addProperty(property);
        return new ResponseEntity<>(property.getId(),HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<Object> getProperties() throws RentopolisServicesException {
            return new ResponseEntity<>(rentopolisServices.getAllProperty(), HttpStatus.ACCEPTED);
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


    @DeleteMapping("/property/{id}")
    public ResponseEntity<Object> deleteProperty(@PathVariable long id) {
        try {
            rentopolisServices.deleteProperty(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



   @PostMapping(value="/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   public ResponseEntity<Object> addPicture(@RequestParam("title") String title,@RequestParam("id") String id,@RequestParam("file") MultipartFile file) throws IOException {
       rentopolisServices.addPicture(id,title,file);
       return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @PostMapping(value="/property/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   public ResponseEntity<Object> addPictureToProperty(@RequestParam("propertyId") String propertyId,@RequestParam("title") String title,@RequestParam("id") String id,@RequestParam("file") MultipartFile file) throws IOException, RentopolisPersistenceException {
       rentopolisServices.addPictureToProperty(propertyId,id,title,file);
       return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @GetMapping("/picture/{id}")
   public ResponseEntity<Object> getPicture(@PathVariable String id, Model model){
       try{
           Picture picture = rentopolisServices.getImageById(id);
           model.addAttribute("Title", picture.getTitle());
           model.addAttribute("image",Base64.getEncoder().encodeToString(picture.getImage().getData()));
           return new ResponseEntity<>(picture, HttpStatus.OK);
        }catch (RentopolisServicesException e) {
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

    @GetMapping("/lease/{id}")
    public ResponseEntity<Object> getLeaseById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(rentopolisServices.getLeaseById(id), HttpStatus.ACCEPTED);
        } catch (RentopolisServicesException e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/lease/{id}")
    public ResponseEntity<Object> deleteLease(@PathVariable long id) {
        try {
            rentopolisServices.deleteLease(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(RentopolisController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}

