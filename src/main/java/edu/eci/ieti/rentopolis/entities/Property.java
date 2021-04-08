/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author diego
 */
@Document(collection = "Properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int area;
    private long price;
    private Location location;
    private PropertyType type;
    private int numberOfRooms;
    private boolean communityRoom;
    private boolean furniture;
    private String description;
    private float reputation;
    private int numberOfBathRooms;
    private boolean elevator;
    private boolean surveillance;
    private boolean gym;
    private String image;
    private String address;
    private String neighborhood;
    private int stratum;


    public Property() {
    }


    public Property(long id, int area, long price, Location location, PropertyType type, int numberOfRooms, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, boolean communityRoom, boolean furniture, String description, float reputation) {
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

    public Property(long id, int area, long price, Location location, PropertyType typeProperty, int numberOfRooms, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, boolean communityRoom, boolean furniture, String description, String image, String address, String neighborhood, int stratum) {
        this.neighborhood = neighborhood;
        this.stratum = stratum;
        this.image = image;
        this.location = location;
        this.type = typeProperty;
        this.address = address;
        this.gym = gym;
        this.furniture = furniture;
        this.elevator = elevator;
        this.surveillance = surveillance;
        this.description = description;
        this.numberOfBathRooms = numberOfBathRooms;
        this.numberOfRooms = numberOfRooms;
        this.communityRoom = communityRoom;
        this.area = area;
        this.price = price;
        this.id = id;
    }

    public Property(int area, long price, Location location, PropertyType typeProperty, int numberOfRooms, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, boolean communityRoom, boolean furniture, String description, String image, String address, String neighborhood, int stratum) {
        this.area = area;
        this.price = price;
        this.location = location;
        this.type = typeProperty;
        this.numberOfRooms = numberOfRooms;
        this.communityRoom = communityRoom;
        this.description = description;
        this.numberOfBathRooms = numberOfBathRooms;
        this.elevator = elevator;
        this.surveillance = surveillance;
        this.gym = gym;
        this.furniture = furniture;
        this.image = image;
        this.address = address;
        this.neighborhood = neighborhood;
        this.stratum = stratum;
    }


    public int getArea() {
        return area;
    }

    public long getPrice() {
        return price;
    }


    public Location getLocation() {
        return location;
    }


    public PropertyType getType() {
        return type;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfBathRooms() {
        return numberOfBathRooms;
    }

    public String getDescription() {
        return description;
    }

    public float getReputation() {
        return reputation;
    }

    public long getId() {
        return id;
    }

    public boolean isGym() {
        return gym;
    }

    public boolean isFurniture() {
        return furniture;
    }

    public boolean isCommunityRoom() {
        return communityRoom;
    }

    public boolean isElevator() {
        return elevator;
    }

    public boolean isSurveillance() {
        return surveillance;
    }


}
