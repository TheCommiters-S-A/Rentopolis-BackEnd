package edu.eci.ieti.rentopolis.persistence;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.entities.Lease;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RentopolisPersistence {

    Optional<User> getUserById(Long userId) throws RentopolisPersistenceException ;
    List<User> getAllUsers() throws RentopolisPersistenceException;
    void addUser(User user);

    void addProperty(Property property);
    List<Property> getAllProperty() throws RentopolisPersistenceException;
    Optional<Property> getPropertyById(Long id) throws RentopolisPersistenceException;
    List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisPersistenceException;
    void deleteProperty(Property property) throws RentopolisPersistenceException;
    void addLease(Lease lease);
}
