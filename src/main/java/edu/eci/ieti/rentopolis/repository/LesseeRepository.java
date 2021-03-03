package edu.eci.ieti.rentopolis.repository;

import edu.eci.ieti.rentopolis.entities.Lessee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LesseeRepository  extends MongoRepository<Lessee, Long> {
}
