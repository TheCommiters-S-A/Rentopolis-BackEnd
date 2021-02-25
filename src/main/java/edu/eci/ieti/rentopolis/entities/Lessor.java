/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import java.util.List;

/**
 *
 * @author diego
 */
public class Lessor extends User{
    
    
    List<Property> properties;

    public Lessor() {
    }
    
    public Lessor(Long id, String Name, String phoneNumber, String Email, String passwd) {
        super(id,Name, phoneNumber, Email, passwd);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
    
    
    
    
    
}
