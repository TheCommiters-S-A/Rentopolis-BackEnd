package edu.eci.ieti.rentopolis.repository;

import edu.eci.ieti.rentopolis.entities.Lease;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends MongoRepository<Lease, Long> {

}
