package edu.eci.ieti.rentopolis.services;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface RentopolisServices {

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
    Optional<User>  getUserById(Long id) throws RentopolisServicesException;


    void addProperty(Property property);

    List<Property> getAllProperty() throws RentopolisServicesException;

    Optional<Property> getPropertyById(Long id) throws RentopolisServicesException;

    List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisServicesException;

    void deleteProperty(Property property) throws RentopolisServicesException;

}