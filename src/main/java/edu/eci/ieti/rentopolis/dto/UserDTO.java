package edu.eci.ieti.rentopolis.dto;

import edu.eci.ieti.rentopolis.entities.User;

public class UserDTO {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String passwd;

    public UserDTO(String id, String name, String phoneNumber, String email, String passwd) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwd = passwd;

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User convertToEntity(UserDTO userDTO) {
        return new User(userDTO.getId(),
                userDTO.getName(),
                userDTO.getPhoneNumber(),
                userDTO.getEmail(),
                userDTO.getPasswd());
    }
}
