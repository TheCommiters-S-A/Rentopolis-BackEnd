package edu.eci.ieti.rentopolis.services.impl;

import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.services.RentopolisServices;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
