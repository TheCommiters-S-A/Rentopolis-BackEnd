/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author diego
 */
@Document(collection = "PropertyType")
public enum PropertyType {
    CASA,CABANA,OFICINA,APARTAMENTO,CUARTO,APARTAESTUDIO,EDIFICIO,LOTE;
    
    
    
}
