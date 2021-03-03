package edu.eci.ieti.rentopolis.repository;

import edu.eci.ieti.rentopolis.entities.Lessor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessorRepository extends MongoRepository<Lessor,Long> {
}
