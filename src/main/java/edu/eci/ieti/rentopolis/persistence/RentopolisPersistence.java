package edu.eci.ieti.rentopolis.persistence;

import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentopolisPersistence {

    /**
     * Registra un usuario en la DB
     *
     * @param user Usuario que se ingresa
     * @throws RentopolisPersistenceException
     */
    void addUser(User user) throws RentopolisPersistenceException;


    /**
     * Trae todos los usuarios registrados
     *
     * @return
     * @throws RentopolisPersistenceException
     */
    List<User> getAllUsers() throws RentopolisPersistenceException;


    /**
     * Trae un usuario por ID
     * @param id
     * @return Usuario
     * @throws RentopolisPersistenceException
     */
    User getUserById(int id) throws RentopolisPersistenceException;

    /**
     *
     * @param property
     * @throws RentopolisPersistenceException
     */
    void addProperty(Property property) throws RentopolisPersistenceException;
    
    
    Property getUserProperties(User user) throws RentopolisPersistenceException;
}
