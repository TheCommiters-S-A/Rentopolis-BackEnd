package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * The type User.
 */
@Document(collection = "User")
public class User {

    /**
     * The constant SEQUENCE_NAME.
     */
// <editor-fold defaulted="collapsed" desc="Attributes">
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    /**
     * The Id.
     */

    @Id
    public long id;
    /**
     * The Name.
     */
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    public String Name;
    /**
     * The Phone number.
     */
    public String phoneNumber;
    /**
     * The Email.
     */
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    public String email;
    /**
     * The Passwd.
     */
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    public String passwd;
    /**
     * The Leases.
     */
    public List<Lease> leases;

    //</editor-fold>

    /**
     * Instantiates a new User.
     */
// <editor-fold defaulted="collapsed" desc="Constructors">
    public User(){
    }


    /**
     * Instantiates a new User.
     *
     * @param id          the id
     * @param Name        the name
     * @param phoneNumber the phone number
     * @param Email       the email
     * @param passwd      the passwd
     */
    public User(long id,String Name, String phoneNumber, String Email, String passwd) {
        this.Name = Name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwd = email;
    }

    //</editor-fold>

    /**
     * Gets name.
     *
     * @return the name
     */
// <editor-fold defaulted="collapsed" desc="Getters">
    public String getName() {
        return Name;
    }

    /**
     * Gets sequence name.
     *
     * @return the sequence name
     */
    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets passwd.
     *
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Gets leases.
     *
     * @return the leases
     */
    public List<Lease> getLeases() {
        return leases;
    }
    //</editor-fold>

    /**
     * Sets name.
     *
     * @param Name the name
     */
// <editor-fold defaulted="collapsed" desc="Setters">
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets passwd.
     *
     * @param passwd the passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * Sets leases.
     *
     * @param leases the leases
     */
    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }
    //</editor-fold>

}
