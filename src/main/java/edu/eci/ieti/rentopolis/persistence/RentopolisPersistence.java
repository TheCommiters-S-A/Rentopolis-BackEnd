package edu.eci.ieti.rentopolis.persistence;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentopolisPersistence {

    User getUserById(String userId) throws RentopolisPersistenceException;

    List<User> getAllUsers() throws RentopolisPersistenceException;

    void updateUser(User user, String id) throws RentopolisPersistenceException;

    void deleteUser(String id) throws RentopolisPersistenceException;

    void addUser(User user);

    void addProperty(Property property);

    List<Property> getAllProperty() throws RentopolisPersistenceException;

    Property getPropertyById(long id) throws RentopolisPersistenceException;

    List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisPersistenceException;

    void deleteProperty(Property property) throws RentopolisPersistenceException;

    void addLease(Lease lease);
}
