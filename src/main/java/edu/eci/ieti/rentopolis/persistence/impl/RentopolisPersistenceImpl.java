package edu.eci.ieti.rentopolis.persistence.impl;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.repository.PropertyRepository;
import edu.eci.ieti.rentopolis.repository.LeaseRepository;
import edu.eci.ieti.rentopolis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RentopolisPersistenceImpl implements RentopolisPersistence {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private LeaseRepository leaseRepository;

    @Override
    public User getUserById(String userId) throws RentopolisPersistenceException {
        if(!userRepository.findById(userId).isPresent()){
            throw new RentopolisPersistenceException("Usuario no existe");
        }
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() throws RentopolisPersistenceException{
        if(userRepository.findAll().isEmpty()){
            throw new RentopolisPersistenceException("No hay usuarios");
        }
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user){
        userRepository.insert(user);
    }

    @Override
    public void addProperty(Property property){
        propertyRepository.insert(property);
    }

    @Override
    public List<Property> getAllProperty() throws RentopolisPersistenceException{
        if(propertyRepository.findAll().isEmpty()){
            throw new RentopolisPersistenceException("No hay propiedades");
        }
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(long id) throws RentopolisPersistenceException{
        if(propertyRepository.findById(id).isPresent()){
            throw new RentopolisPersistenceException("Propiedad no existe");
        }
        return propertyRepository.findById(id).get() ;
    }

    @Override
    public List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisPersistenceException{
        return getAllProperty();


    }

    @Override
    public void deleteProperty(Property property) throws RentopolisPersistenceException{
        if(propertyRepository.findById(property.getId()).isPresent()){
            throw new RentopolisPersistenceException("Propiedad no existe");
        }
        propertyRepository.delete(property);
    }

    @Override
    public void addLease(Lease lease){
        leaseRepository.insert(lease);
    }



}
