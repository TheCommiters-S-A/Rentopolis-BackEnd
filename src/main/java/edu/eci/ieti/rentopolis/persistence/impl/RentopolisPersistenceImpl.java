package edu.eci.ieti.rentopolis.persistence.impl;

import edu.eci.ieti.rentopolis.entities.DatabaseSequence;
import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component("RentopolisPersistenceImpl")
public class RentopolisPersistenceImpl implements RentopolisPersistence {

    private MongoOperations mongoOperations;

    @Autowired
    public RentopolisPersistenceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String seqName) {

        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }

    @Override
    public void addUser(User user) throws RentopolisPersistenceException {
    }

    @Override
    public List<User> getAllUsers() throws RentopolisPersistenceException {
        return null;
    }

    @Override
    public User getUserById(int id) throws RentopolisPersistenceException {
        return null;
    }

    @Override
    public void addProperty(Property property) throws RentopolisPersistenceException {

    }

    @Override
    public Property getUserProperties(User user) throws RentopolisPersistenceException {
        return null;
    }

    @Override
    public void addLease(Lease lease) throws RentopolisPersistenceException {

    }

    @Override
    public Lease getUserLease(User user, Long leaseId) throws RentopolisPersistenceException {
        return null;
    }

    @Override
    public Lease getUserLeases(User user) throws RentopolisPersistenceException {
        return null;
    }
}
