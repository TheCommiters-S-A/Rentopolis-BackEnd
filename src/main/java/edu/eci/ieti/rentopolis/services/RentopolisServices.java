package edu.eci.ieti.rentopolis.services;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.entities.Lease;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import edu.eci.ieti.rentopolis.entities.Picture;

import java.util.List;


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
    List<User> getAllUsers() throws RentopolisServicesException, RentopolisPersistenceException;

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

    void addProperty(Property property);

    List<Property> getAllProperty() throws RentopolisServicesException, RentopolisPersistenceException;

    Property getPropertyById(String id) throws RentopolisServicesException;

    List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisServicesException;

    void deleteProperty(String property) throws RentopolisServicesException;

    void modifyPropertyReputation(Property updatedProperty)throws RentopolisServicesException;

    void addLease(Lease lease);

    void addPicture(String id,String title,MultipartFile file) throws IOException;
    Picture getImageById (String id) throws RentopolisServicesException;
    void addPictureToProperty(String propertyId,String id,String title,MultipartFile file) throws IOException, RentopolisPersistenceException;

    Lease getLeaseById(long id) throws RentopolisServicesException;

    void deleteLease(long id) throws RentopolisServicesException;

    User getUserByEmail(String email) throws RentopolisServicesException, RentopolisPersistenceException;

}