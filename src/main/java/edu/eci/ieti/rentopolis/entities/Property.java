/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author diego
 */
@Document(collection = "Properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
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

    private List<String> images;



    public Property() {
    }



    public Property(String id, int area, long price, Location location, PropertyType typeProperty, int numberOfRooms, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, boolean communityRoom, boolean furniture, String description, String image, String address, String neighborhood, int stratum) {
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


    public void setId(String id) {
        this.id = id;
    }
    public int getArea() {
        return area;
    }

    public long getPrice() {
        return this.price;
    }


    public Location getLocation() {
        return this.location;
    }


    public PropertyType getType() {
        return this.type;
    }

    public int getNumberOfRooms() {
        return this.numberOfRooms;
    }


    public int getNumberOfBathRooms() {
        return numberOfBathRooms;
    }


    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isCommunityRoom() {
        return this.communityRoom;
    }

    public boolean getCommunityRoom() {
        return this.communityRoom;
    }

    public void setCommunityRoom(boolean communityRoom) {
        this.communityRoom = communityRoom;
    }

    public boolean isFurniture() {
        return this.furniture;
    }

    public boolean getFurniture() {
        return this.furniture;
    }

    public void setFurniture(boolean furniture) {
        this.furniture = furniture;
    }


    public String getDescription() {
        return this.description;
    }

    public float getReputation() {
        return this.reputation;
    }

    public String getId() {
        return this.id;
    }

    public void setReputation(float reputation) {
        this.reputation = reputation;
    }

    public void setNumberOfBathRooms(int numberOfBathRooms) {
        this.numberOfBathRooms = numberOfBathRooms;
    }

    public boolean isElevator() {
        return this.elevator;
    }

    public boolean getElevator() {
        return this.elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isSurveillance() {
        return this.surveillance;
    }

    public boolean getSurveillance() {
        return this.surveillance;
    }

    public void setSurveillance(boolean surveillance) {
        this.surveillance = surveillance;
    }


    public boolean isGym() {
        return this.gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public  void addImages(String imageId){
        try {
            this.images.add(imageId);
        } catch (Exception e) {
            this.images = new ArrayList<>();
            this.images.add(imageId);
        }
        
    }

}
