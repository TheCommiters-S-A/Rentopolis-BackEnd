package edu.eci.ieti.rentopolis.persistence.impl;

import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;

import java.util.List;

public class RentopolisPersistenceImpl implements RentopolisPersistence {

    @Override
    public void addUser(User user) throws RentopolisPersistenceException {
    }

    @Override
    public List<User> getAllUsers() throws RentopolisPersistenceException {
        return null;
    }

    @Override
    public User getUserById(int id) throws RentopolisPersistenceException {
        return null;
    }
}
