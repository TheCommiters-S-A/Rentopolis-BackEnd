/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The type Location.
 *
 * @author diego
 */
@Document(collection = "Location")
public class Location {

    /**
     * The constant SEQUENCE_NAME.
     */
// <editor-fold defaulted="collapsed" desc="Attributes">
    @Transient
    public static final String SEQUENCE_NAME = "location_sequence";

    /**
     * The Latitude.
     */
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    public float latitude;
    /**
     * The Longitude.
     */
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    public float longitude;

    //</editor-fold>

    /**
     * Instantiates a new Location.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
// <editor-fold defaulted="collapsed" desc="Constructors">
    public Location(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //</editor-fold>

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
// <editor-fold defaulted="collapsed" desc="Getters">
    public float getLatitude() {
        return latitude;
    }

    //</editor-fold>

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
// <editor-fold defaulted="collapsed" desc="Setters">
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    //</editor-fold>


    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
