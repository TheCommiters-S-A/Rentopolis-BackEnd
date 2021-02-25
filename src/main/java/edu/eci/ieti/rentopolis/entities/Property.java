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
    
    public long id;
    public int area;
    public long price;
    public Location location;
    public PropertyType type;
    public int numberOfRooms;
    public int numberOfBathRomms;
    public boolean Elevator;
    public boolean Surveillance;
    public boolean Gym;
    public boolean CommunityRoom;
    public boolean Furnature;
    public String description;
    public float reputation;

    public Property() {
    }
    

    public Property(long id,int area, long price, Location location, PropertyType type, int numberOfRooms, int numberOfBathRomms, boolean Elevator, boolean Surveillance, boolean Gym, boolean CommunityRoom, boolean Furnature, String description, float reputation) {
        this.id = id;
        this.area = area;
        this.price = price;
        this.location = location;
        this.type = type;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathRomms = numberOfBathRomms;
        this.Elevator = Elevator;
        this.Surveillance = Surveillance;
        this.Gym = Gym;
        this.CommunityRoom = CommunityRoom;
        this.Furnature = Furnature;
        this.description = description;
        this.reputation = reputation;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathRomms() {
        return numberOfBathRomms;
    }

    public void setNumberOfBathRomms(int numberOfBathRomms) {
        this.numberOfBathRomms = numberOfBathRomms;
    }

    public boolean isElevator() {
        return Elevator;
    }

    public void setElevator(boolean Elevator) {
        this.Elevator = Elevator;
    }

    public boolean isSurveillance() {
        return Surveillance;
    }

    public void setSurveillance(boolean Surveillance) {
        this.Surveillance = Surveillance;
    }

    public boolean isGym() {
        return Gym;
    }

    public void setGym(boolean Gym) {
        this.Gym = Gym;
    }

    public boolean isCommunityRoom() {
        return CommunityRoom;
    }

    public void setCommunityRoom(boolean CommunityRoom) {
        this.CommunityRoom = CommunityRoom;
    }

    public boolean isFurnature() {
        return Furnature;
    }

    public void setFurnature(boolean Furnature) {
        this.Furnature = Furnature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getReputation() {
        return reputation;
    }

    public void setReputation(float reputation) {
        this.reputation = reputation;
    }
    
    
    
}
