package edu.eci.ieti.rentopolis.persistence.impl;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.repository.PropertyRepository;
import edu.eci.ieti.rentopolis.repository.UserRepository;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;
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

    @Override
    public Optional<User> getUserById(Long userId) throws RentopolisPersistenceException {
        if(userRepository.findById(userId).get() == null){
            throw new RentopolisPersistenceException("Usuario no existe");
        }
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() throws RentopolisPersistenceException{
        if(userRepository.findAll().size()==0){
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
        if(propertyRepository.findAll().size()==0){
            throw new RentopolisPersistenceException("No hay propiedades");
        }
        return propertyRepository.findAll();
    }

    @Override
    public Optional<Property> getPropertyById(Long id) throws RentopolisPersistenceException{
        if(propertyRepository.findById(id).get() == null){
            throw new RentopolisPersistenceException("Propiedad no existe");
        }
        return propertyRepository.findById(id) ;
    }

    @Override
    public List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisPersistenceException{
        List<Property> properties= getAllProperty();
        //TODO
        return properties;

    }

    @Override
    public void deleteProperty(Property property) throws RentopolisPersistenceException{
        if(propertyRepository.findById(property.getId()).get()==null){
            throw new RentopolisPersistenceException("Propiedad no existe");
        }
        propertyRepository.delete(property);
    }



}
