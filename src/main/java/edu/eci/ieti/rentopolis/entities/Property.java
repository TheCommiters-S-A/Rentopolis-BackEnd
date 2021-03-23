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

    public Property(int area, long price, Location location, PropertyType type, int numberOfRooms, boolean communityRoom, String description, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, String image, String address, String neighborhood, int stratum) {
        this.area = area;
        this.price = price;
        this.location = location;
        this.type = type;
        this.numberOfRooms = numberOfRooms;
        this.communityRoom = communityRoom;
        this.description = description;
        this.numberOfBathRooms = numberOfBathRooms;
        this.elevator = elevator;
        this.surveillance = surveillance;
        this.gym = gym;
        this.image = image;
        this.address = address;
        this.neighborhood = neighborhood;
        this.stratum = stratum;
    }

    public Property(long id, int area, long price, Location location, PropertyType typeProperty, int numberOfRooms, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, boolean communityRoom, boolean furniture, String description, String image, String address, String neighborhood, int stratum) {
        this.id = id;
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

    public Property( int area, long price, Location location, PropertyType typeProperty, int numberOfRooms, int numberOfBathRooms, boolean elevator, boolean surveillance, boolean gym, boolean communityRoom, boolean furniture, String description, String image, String address, String neighborhood, int stratum) {
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


    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }


    public void setSurveillance(boolean surveillance) {
        this.surveillance = surveillance;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public void setCommunityRoom(boolean communityRoom) {
        this.communityRoom = communityRoom;
    }

    public void setFurniture(boolean furniture) {
        this.furniture = furniture;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getStratum() {
        return stratum;
    }

    public void setStratum(int stratum) {
        this.stratum = stratum;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", area=" + area +
                ", price=" + price +
                ", location=" + location +
                ", type=" + type +
                ", numberOfRooms=" + numberOfRooms +
                ", communityRoom=" + communityRoom +
                ", furniture=" + furniture +
                ", description='" + description + '\'' +
                ", reputation=" + reputation +
                ", numberOfBathRooms=" + numberOfBathRooms +
                ", elevator=" + elevator +
                ", surveillance=" + surveillance +
                ", gym=" + gym +
                ", image='" + image + '\'' +
                ", address='" + address + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", stratum='" + stratum + '\'' +
                '}';
    }
}
