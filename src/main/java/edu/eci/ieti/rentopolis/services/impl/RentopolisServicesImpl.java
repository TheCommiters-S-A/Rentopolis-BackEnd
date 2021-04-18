package edu.eci.ieti.rentopolis.services.impl;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.services.RentopolisServices;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import edu.eci.ieti.rentopolis.entities.Picture;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RentopolisServicesImpl implements RentopolisServices {

    @Autowired
    private RentopolisPersistence rentopolisPersistence;

    @Override
    public void addUser(User user) {
        this.rentopolisPersistence.addUser(user);
    }

    @Override
    public List<User> getAllUsers() throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getAllUsers();
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public User getUserById(String id) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getUserById(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }

    }

    @Override
    public void updateUser(User user, String id) throws RentopolisServicesException {
        try {
            rentopolisPersistence.updateUser( user, id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteUser(String id) throws RentopolisServicesException{
        try {
            rentopolisPersistence.deleteUser(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addProperty(Property property) {
        this.rentopolisPersistence.addProperty(property);
    }

    @Override
    public List<Property> getAllProperty() throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getAllProperty();
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }

    }

    @Override
    public Property getPropertyById(long id) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getPropertyById(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getPropertyByLessor(lessor);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteProperty(long property) throws RentopolisServicesException {
        try {
            rentopolisPersistence.deleteProperty(property);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addLease(Lease lease) {
        this.rentopolisPersistence.addLease(lease);
    }

   @Override
   public void addPicture(String id, String title,MultipartFile file) throws IOException{
       this.rentopolisPersistence.addPicture(id,title,file);
   }

   @Override
   public Picture getImageById(String id) throws RentopolisServicesException{
       try{
           return rentopolisPersistence.getPictureById(id);
        }catch(RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
   }

   @Override
   public void addPictureToProperty(String propertyId,String id,String title,MultipartFile file) throws IOException, RentopolisPersistenceException{
       this.rentopolisPersistence.addPictureToProperty(propertyId, id,title,file);
   }



    @Override
    public Lease getLeaseById(long id) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getLeaseById(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteLease(long id) throws RentopolisServicesException {
        try {
            rentopolisPersistence.deleteLease(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

   @Override
   public User getUserByEmail(String email) throws RentopolisServicesException{       
    try {
        return rentopolisPersistence.getUserByEmail(email);
    } catch (RentopolisPersistenceException e) {
        throw new RentopolisServicesException(e.getMessage(), e);
    }
   } 


}
