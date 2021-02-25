/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import edu.eci.ieti.rentopolis.dto.PropertyDTO;
import edu.eci.ieti.rentopolis.dto.UserDTO;
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
    public int numberOfBathRooms;
    public boolean Elevator;
    public boolean Surveillance;
    public boolean Gym;
    public boolean CommunityRoom;
    public boolean Furniture;
    public String description;
    public float reputation;

    public Property() {
    }
    

    public Property(long id,int area, long price, Location location, PropertyType type, int numberOfRooms, int numberOfBathRooms, boolean Elevator, boolean Surveillance, boolean Gym, boolean CommunityRoom, boolean Furniture, String description, float reputation) {
        this.id = id;
        this.area = area;
        this.price = price;
        this.location = location;
        this.type = type;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.Elevator = Elevator;
        this.Surveillance = Surveillance;
        this.Gym = Gym;
        this.CommunityRoom = CommunityRoom;
        this.Furniture = Furniture;
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

    public int getNumberOfBathRooms() {
        return numberOfBathRooms;
    }

    public void setNumberOfBathRooms(int numberOfBathRomms) {
        this.numberOfBathRooms = numberOfBathRomms;
    }


    public void setElevator(boolean Elevator) {
        this.Elevator = Elevator;
    }


    public void setSurveillance(boolean Surveillance) {
        this.Surveillance = Surveillance;
    }

    public void setGym(boolean Gym) {
        this.Gym = Gym;
    }

    public void setCommunityRoom(boolean CommunityRoom) {
        this.CommunityRoom = CommunityRoom;
    }

    public void setFurniture(boolean Furniture) {
        this.Furniture = Furniture;
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

    public long getId() {
        return id;
    }

    public boolean hasElevator() {
        return Elevator;
    }

    public boolean hasCommunityRoom() {
        return CommunityRoom;
    }

    public boolean hasFurniture() {
        return Furniture;
    }

    public boolean hasGym() {
        return Gym;
    }

    public boolean hasSurveillance() {
        return Surveillance;
    }

    public PropertyDTO convertToDTO(Property property){
        return new PropertyDTO(property.getId(),property.getArea(),property.getPrice(),
                property.getLocation(),property.getType(),property.getNumberOfRooms(),
                property.getNumberOfBathRooms(), property.hasElevator(),property.hasSurveillance(),
                property.hasGym(),property.hasCommunityRoom(), property.hasFurniture(),
                property.getDescription(),property.getReputation());
    }
}
