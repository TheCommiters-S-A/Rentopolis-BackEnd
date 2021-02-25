package edu.eci.ieti.rentopolis.persistence;

import edu.eci.ieti.rentopolis.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RentopolisPersistence extends MongoRepository<User, Long> {
}
