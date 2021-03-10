/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import java.util.List;

/**
 * @author diego
 */
public class Lessor extends User {


    List<Property> properties;

    public Lessor() {
    }

    public Lessor(String id, String name, String phoneNumber, String email, String passwd) {
        super(id, name, phoneNumber, email, passwd);
    }

    public void addProperty(Property property) {
        properties.add(property);
    }


    public void removeProperty(Property property) {
        properties.removeIf(i -> (property.getId() == i.getId()));
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }


}
