package edu.eci.ieti.rentopolis.repository;

import edu.eci.ieti.rentopolis.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    //@Query("{'email' : ?0}")
    public User findByEmail(String email);
}
