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

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RentopolisServicesImpl implements RentopolisServices {

    @Autowired
    private RentopolisPersistence rentopolisPersistence;

    @Override
    public void addUser(User user)  {
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
    public Optional<User> getUserById(Long id) throws RentopolisServicesException {
        try {
            return rentopolisPersistence.getUserById(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }

    }

    @Override
    public void addProperty(Property property){
        this.rentopolisPersistence.addProperty(property);
    }

    @Override
    public List<Property> getAllProperty() throws RentopolisServicesException{
        try{
            return rentopolisPersistence.getAllProperty();
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }

    }

    @Override
    public Optional<Property> getPropertyById(Long id) throws RentopolisServicesException{
        try {
            return rentopolisPersistence.getPropertyById(id);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisServicesException{
        try {
            return rentopolisPersistence.getPropertyByLessor(lessor);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteProperty(Property property) throws RentopolisServicesException{
        try {
            rentopolisPersistence.deleteProperty(property);
        } catch (RentopolisPersistenceException e) {
            throw new RentopolisServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void addLease(Lease lease){
        this.rentopolisPersistence.addLease(lease);
    }
}
