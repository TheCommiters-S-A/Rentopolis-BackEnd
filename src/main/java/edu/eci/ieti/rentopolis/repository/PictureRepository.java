package edu.eci.ieti.rentopolis.repository;

import edu.eci.ieti.rentopolis.entities.Picture;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends MongoRepository<Picture, String> {
}