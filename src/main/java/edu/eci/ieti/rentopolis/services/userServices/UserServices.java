package edu.eci.ieti.rentopolis.services.userServices;

import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;

import java.util.List;

public interface UserServices {

    /**
     * Registra un usuario en la DB
     *
     * @param user Usuario que se ingresa
     * @throws RentopolisServicesException
     */
    void addUser(User user);


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
    User getUserById(String id) throws RentopolisServicesException;

    /**
     * Actualiza un usuario por ID
     * @param id
     * @param user
     * @throws RentopolisServicesException
     */
    void updateUser(User user, String id) throws RentopolisServicesException;

    /**
     * Borra un usuario por ID
     * @param id
     * @throws RentopolisServicesException
     */
    void deleteUser(String id) throws RentopolisServicesException;

}
