package edu.eci.ieti.rentopolis.persistence.impl;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.repository.PropertyRepository;
import edu.eci.ieti.rentopolis.repository.LeaseRepository;
import edu.eci.ieti.rentopolis.repository.PictureRepository;
import edu.eci.ieti.rentopolis.repository.UserRepository;
import java.io.IOException;



import org.bson.BsonBinarySubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.rentopolis.entities.Picture;

import java.util.List;
import java.util.Optional;

import javax.print.event.PrintEvent;


@Service
public class RentopolisPersistenceImpl implements RentopolisPersistence {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private LeaseRepository leaseRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public User getUserById(String userId) throws RentopolisPersistenceException {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RentopolisPersistenceException("Usuario no existe");
        }
    }

    @Override
    public List<User> getAllUsers() throws RentopolisPersistenceException {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user, String id) throws RentopolisPersistenceException {
        if (user.getId().equals(id)) {
            User userToReplace= getUserById(id);
            userToReplace.setEmail(user.getEmail());
            userToReplace.setName(user.getName());
            userToReplace.setPasswd(user.getPasswd());
            userToReplace.setPhoneNumber(user.getPhoneNumber());
            userRepository.save(userToReplace);
        }else {
            throw new RentopolisPersistenceException("El id no concuerda con el usuario");
        }
    }

    @Override
    public void deleteUser(String id) throws RentopolisPersistenceException {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.delete(optional.get());
        } else {
            throw new RentopolisPersistenceException("Usuario no existe");
        }
    }

    @Override
    public void addUser(User user) {
        userRepository.insert(user);
    }

    @Override
    public void addProperty(Property property) {
        propertyRepository.insert(property);
    }

    @Override
    public List<Property> getAllProperty() throws RentopolisPersistenceException {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(long id) throws RentopolisPersistenceException {

        Optional<Property> optional = propertyRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RentopolisPersistenceException("Propiedad no existe");
        }
    }

    @Override
    public List<Property> getPropertyByLessor(Lessor lessor) throws RentopolisPersistenceException {
        return getAllProperty();


    }

    @Override
    public void deleteProperty(long id) throws RentopolisPersistenceException {
        Property property = getPropertyById(id);
        if (!propertyRepository.findById(property.getId()).isPresent()) {
            throw new RentopolisPersistenceException("Propiedad no existe");
        } else {
            propertyRepository.delete(property);
        }

    }

    @Override
    public void addLease(Lease lease) {
        leaseRepository.insert(lease);
    }

   @Override
   public void addPicture(String id, String title, MultipartFile file) throws IOException{
       Picture picture = null;
       if(id.equals("null")){
        picture = new Picture(null,title,new Binary(BsonBinarySubType.BINARY, file.getBytes()));
       }else{
        picture = new Picture(id,title,new Binary(BsonBinarySubType.BINARY, file.getBytes()));
       }
       pictureRepository.insert(picture);
   }

   @Override
   public Picture getPictureById(String id) throws RentopolisPersistenceException{
    Optional<Picture> picture = pictureRepository.findById(id);
       if(picture.isPresent()){
           return picture.get();
        }
        else{
            throw new RentopolisPersistenceException("La fotografia no existe");
       }
    } 

    @Override
   public void addPictureToProperty(String propertyId, String id, String title, MultipartFile file) throws IOException, RentopolisPersistenceException{
       Picture picture = null;
       Property property = null;
       try {
        System.out.println("1fucckkkkkkk";propertyId);
        property = getPropertyById(Long.parseLong(propertyId));
        System.out.println("1fucckkkkkkk");

        if(id.equals("null")){
            System.out.println("1fucckkkkkkk");
            picture = new Picture(null,title,new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            System.out.println("2fucckkkkkkk");
           }else{
            System.out.println("3fucckkkkkkk");
            picture = new Picture(id,title,new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            System.out.println("4fucckkkkkkk");
           }
           System.out.println("5fucckkkkkkk");
           pictureRepository.insert(picture);    
           System.out.println("6fucckkkkkkk");
           property.addImages(picture.getId());
           System.out.println("7fucckkkkkkk");
    
           propertyRepository.save(property);
    } catch (NumberFormatException e) {
        throw new NumberFormatException("No se covertio el numero");
    } catch (RentopolisPersistenceException e) {
        System.out.println(e.getStackTrace());
        throw new RentopolisPersistenceException("Error al buscar la propiedad");
    }
       
   }


    @Override
    public Lease getLeaseById(long id) throws RentopolisPersistenceException {
        Optional<Lease> optional = leaseRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RentopolisPersistenceException("Lease no existe");
        }
    }
    @Override
    public void deleteLease(long id) throws RentopolisPersistenceException {
        Lease lease = getLeaseById(id);
        if (!leaseRepository.findById(lease.getId()).isPresent()) {
            throw new RentopolisPersistenceException("Alquiler no existe");
        } else {
            leaseRepository.delete(lease);
        }

    }

   @Override
   public User getUserByEmail(String email) throws RentopolisPersistenceException{
       return userRepository.findByEmail(email);
   } 

}