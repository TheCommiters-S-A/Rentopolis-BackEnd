package edu.eci.ieti.rentopolis.persistence.impl;

import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;

import java.util.ArrayList;
import java.util.List;

public class RentopolisPersistenceImpl implements RentopolisPersistence {

    List<User> userList= new ArrayList<>();

    public RentopolisPersistenceImpl(){
        User carlos= new User(0,"Carlos", "12223", "carlos.gomez@correo.com", "hola");
        User diego = new User(1,"Diego", "22222", "diego.chinchilla@correo.com", "hola");
        userList.add(carlos);
        userList.add(diego);
    }

    @Override
    public void addUser(User user) throws RentopolisPersistenceException {
        
    }

    @Override
    public List<User> getAllUsers() throws RentopolisPersistenceException {
        return userList;
    }

    @Override
    public User getUserById(int userId) throws RentopolisPersistenceException {
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getId() == userId){
                return userList.get(i);
            }
        }
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
