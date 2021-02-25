package edu.eci.ieti.rentopolis.services.impl;

import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
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
    public void addUser(User user) throws RentopolisServicesException {
        this.rentopolisPersistence.insert(user);
    }

    @Override
    public List<User> getAllUsers() throws RentopolisServicesException {
        return rentopolisPersistence.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) throws RentopolisServicesException {
        return rentopolisPersistence.findById(id);
    }
    
   
}
