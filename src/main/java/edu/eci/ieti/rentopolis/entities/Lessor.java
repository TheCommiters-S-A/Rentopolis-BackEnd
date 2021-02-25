/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * The type Lessor.
 *
 * @author diego
 */
@Document(collection = "Lessor")
public class Lessor extends User{

    /**
     * The constant SEQUENCE_NAME.
     */
// <editor-fold defaulted="collapsed" desc="Attributes">
    @Transient
    public static final String SEQUENCE_NAME = "lessor_sequence";

    /**
     * The Properties.
     */
    List<Property> properties;

    //</editor-fold>

    /**
     * Instantiates a new Lessor.
     */
// <editor-fold defaulted="collapsed" desc="Constructors">
    public Lessor() {
    }

    /**
     * Instantiates a new Lessor.
     *
     * @param id          the id
     * @param Name        the name
     * @param phoneNumber the phone number
     * @param Email       the email
     * @param passwd      the passwd
     */
    public Lessor(long id, String Name, String phoneNumber, String Email, String passwd) {
        super(id,Name, phoneNumber, Email, passwd);
    }

    //</editor-fold>

    /**
     * Gets properties.
     *
     * @return the properties
     */
// <editor-fold defaulted="collapsed" desc="Getters">
    public List<Property> getProperties() {
        return properties;
    }

    //</editor-fold>

    /**
     * Sets properties.
     *
     * @param properties the properties
     */
// <editor-fold defaulted="collapsed" desc="Setters">
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    //</editor-fold>


    @Override
    public String toString() {
        return "Lessor{" +
                "properties=" + properties +
                ", id=" + id +
                ", Name='" + Name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", leases=" + leases +
                '}';
    }
}
