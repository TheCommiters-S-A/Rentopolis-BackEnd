package edu.eci.ieti.rentopolis.repository;

import edu.eci.ieti.rentopolis.entities.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {
}
