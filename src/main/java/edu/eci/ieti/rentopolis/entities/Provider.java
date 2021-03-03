package edu.eci.ieti.rentopolis.entities;


import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Provider.
 */
@Document(collection = "Provider")
public class Provider {

    /**
     * The constant SEQUENCE_NAME.
     */
// <editor-fold defaulted="collapsed" desc="Attributes">
    @Transient
    public static final String SEQUENCE_NAME = "provider_sequence";
    //</editor-fold>

    // <editor-fold defaulted="collapsed" desc="Constructor">

    //</editor-fold>

    // <editor-fold defaulted="collapsed" desc="Getters">

    //</editor-fold>

    // <editor-fold defaulted="collapsed" desc="Setters">

    //</editor-fold>

}
