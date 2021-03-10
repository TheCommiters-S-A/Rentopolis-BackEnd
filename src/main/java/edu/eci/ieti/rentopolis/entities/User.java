package edu.eci.ieti.rentopolis.entities;

import java.util.List;

import edu.eci.ieti.rentopolis.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")
public class User {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String passwd;


    public User() {
    }

    public User(String id, String name, String phoneNumber, String email, String passwd) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwd = passwd;
    }

    public User(String name, String phoneNumber, String email, String passwd) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwd = passwd;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getId() {
        return id;
    }


    public UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(),
                user.getName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getPasswd());
    }
}
