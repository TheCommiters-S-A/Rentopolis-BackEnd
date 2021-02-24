/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

/**
 *
 * @author diego
 */
public class Lessee extends User{

    public Lessee() {
    }
    
    
    public Lessee(Long id, String Name, String phoneNumber, String Email, String passwd) {
        super(id,Name, phoneNumber, Email, passwd);
    }
    
}
