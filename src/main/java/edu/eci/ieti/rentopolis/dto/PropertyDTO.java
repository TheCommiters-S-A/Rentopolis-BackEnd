package edu.eci.ieti.rentopolis.dto;

import edu.eci.ieti.rentopolis.entities.Location;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.PropertyType;

public class PropertyDTO {

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

    public long getId() {
        return id;
    }

    public int getArea() {
        return area;
    }

    public int getNumberOfBathRooms() {
        return numberOfBathRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Location getLocation() {
        return location;
    }

    public long getPrice() {
        return price;
    }

    public PropertyType getType() {
        return type;
    }

    public float getReputation() {
        return reputation;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasElevator() {
        return elevator;
    }

    public boolean hasCommunityRoom() {
        return communityRoom;
    }

    public boolean hasFurniture() {
        return furniture;
    }

    public boolean hasGym() {
        return gym;
    }

    public boolean hasSurveillance() {
        return surveillance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setCommunityRoom(boolean communityRoom) {
        this.communityRoom = communityRoom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public void setFurniture(boolean furniture) {
        this.furniture = furniture;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setNumberOfBathRooms(int numberOfBathRooms) {
        this.numberOfBathRooms = numberOfBathRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setReputation(float reputation) {
        this.reputation = reputation;
    }

    public void setSurveillance(boolean surveillance) {
        this.surveillance = surveillance;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public Property convertToEntity(PropertyDTO propertyDTO){
        return new Property(propertyDTO.getId(),propertyDTO.getArea(),propertyDTO.getPrice(),
                propertyDTO.getLocation(),propertyDTO.getType(),propertyDTO.getNumberOfRooms(),
                propertyDTO.getNumberOfBathRooms(), propertyDTO.hasElevator(),propertyDTO.hasSurveillance(),
                propertyDTO.hasGym(),propertyDTO.hasCommunityRoom(), propertyDTO.hasFurniture(),
                propertyDTO.getDescription(),propertyDTO.getReputation());
    }
}


