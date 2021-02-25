package edu.eci.ieti.rentopolis.services;

import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.exception.RentopolisServicesException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RentopolisServices {

    /**
     * Registra un usuario en la DB
     *
     * @param user Usuario que se ingresa
     * @throws RentopolisServicesException
     */
    void addUser(User user) throws RentopolisServicesException;


    /**
     * Trae todos los usuarios registrados
     *
     * @return
     * @throws RentopolisServicesException
     */
    List<User> getAllUsers() throws RentopolisServicesException;


    /**
     * Trae un usuario por ID
     * @param id
     * @return Usuario
     * @throws RentopolisServicesException
     */
    User getUserById(int id) throws RentopolisServicesException;
    
    
    /**
     *
     * @param property
     * @throws RentopolisServicesException
     */
    void addProperty(Property property) throws RentopolisServicesException;
    
    /**
     *
     * @param user
     * @return Property
     * @throws RentopolisServicesException
     */
    Property getUserProperties(User user) throws RentopolisServicesException;
    
    /**
     *
     * @param lease
     * @throws RentopolisServicesException
     */
    void addLease(Lease lease) throws RentopolisServicesException;
    
    /**
     *
     * @param user
     * @param leaseId
     * @return
     * @throws RentopolisServicesException
     */
    Lease getUserLease(User user,Long leaseId) throws RentopolisServicesException;  
    
    /**
     *
     * @param user
     * @return
     * @throws RentopolisServicesException
     */
    Lease getUserLeases(User user) throws RentopolisServicesException;  

}