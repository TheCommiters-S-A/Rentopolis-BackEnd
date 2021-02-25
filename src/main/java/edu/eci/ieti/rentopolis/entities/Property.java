/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author diego
 */
@Document(collection = "Properties")
public class Property {
    
    private long id;
    private int area;
    private long price;
    private Location location;
    private PropertyType type;
    private int numberOfRooms;
    private int numberOfBathRooms;
    private boolean elevator;
    private boolean surveillance;
    private boolean gym;
    private boolean communityRoom;
    private boolean furniture;
    private String description;
    private float reputation;

    public Property() {
    }
    

    public Property(long id,int area, long price, Location location, PropertyType type, int numberOfRooms, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, boolean communityRoom, boolean furniture, String description, float reputation) {
        this.id = id;
        this.area = area;
        this.price = price;
        this.location = location;
        this.type = type;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.elevator = elevator;
        this.surveillance = surveillance;
        this.gym = gym;
        this.communityRoom = communityRoom;
        this.furniture = furniture;
        this.description = description;
        this.reputation = reputation;
    }

    public long getId() {
        return id;
    }



}
