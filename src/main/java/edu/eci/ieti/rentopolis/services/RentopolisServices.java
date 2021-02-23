package edu.eci.ieti.rentopolis.services;

import edu.eci.ieti.rentopolis.entities.User;
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

}