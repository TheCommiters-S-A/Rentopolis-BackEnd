package edu.eci.ieti.rentopolis.entities;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Usuarios")
public class User {
    @Id
    public Long id;
    public String Name;
    public String phoneNumber;
    public String email;
    public String passwd;
    public List<Lease> leases;
    

    /**
     *
     * @param Name
     * @param phoneNumber
     * @param Email
     * @param passwd
     * @param id
     */
    
    
    public User(){
    }
    

    public User(Long id,String Name, String phoneNumber, String Email, String passwd) {
        this.Name = Name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwd = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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


}
