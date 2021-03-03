/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Lessee.
 *
 * @author diego
 */
@Document(collection = "Lessee")
public class Lessee extends User{

    /**
     * The constant SEQUENCE_NAME.
     */
// <editor-fold defaulted="collapsed" desc="Attributes">
    @Transient
    public static final String SEQUENCE_NAME = "lessee_sequence";

    /**
     * Instantiates a new Lessee.
     */
//</editor-fold>
    public Lessee() {
    }

    /**
     * Instantiates a new Lessee.
     *
     * @param id          the id
     * @param Name        the name
     * @param phoneNumber the phone number
     * @param Email       the email
     * @param passwd      the passwd
     */
// <editor-fold defaulted="collapsed" desc="Constructor">
    public Lessee(Long id, String Name, String phoneNumber, String Email, String passwd) {
        super(id,Name, phoneNumber, Email, passwd);
    }
    //</editor-fold>

    // <editor-fold defaulted="collapsed" desc="Getters">
    //</editor-fold>

    // <editor-fold defaulted="collapsed" desc="Setters">
    //</editor-fold>


    @Override
    public String toString() {
        return "Lessee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", leases=" + leases +
                '}';
    }
}
