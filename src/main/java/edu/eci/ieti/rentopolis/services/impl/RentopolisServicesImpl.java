package edu.eci.ieti.rentopolis.services.impl;

import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.services.RentopolisServices;
import edu.eci.ieti.rentopolis.exception.RentopolisServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RentopolisServicesImpl")
public class RentopolisServicesImpl implements RentopolisServices {

    @Autowired
    private RentopolisPersistence rentopolisPersistence;

    @Override
    public void addUser(User user) throws RentopolisServicesException {
        try {
            rentopolisPersistence.addUser(user);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
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
    public User getUserById(int id) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getUserById(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }
    
    @Override
    public void addProperty(Property property) throws RentopolisServicesException {
        try {
            rentopolisPersistence.addProperty(property);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }
    
    
    
    @Override
    public Property getUserProperties(User user) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getUserProperties(user);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }
    
    @Override
    public void addLease(Lease lease) throws RentopolisServicesException {
        try {
            rentopolisPersistence.addLease(lease);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }
    
    
    @Override
    public Lease getUserLease(User user,Long leaseId) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getUserLease(user,leaseId);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }
    
    
    @Override
    public Lease getUserLeases(User user) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getUserLeases(user);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }
}
