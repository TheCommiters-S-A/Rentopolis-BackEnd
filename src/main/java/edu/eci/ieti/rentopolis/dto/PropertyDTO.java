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
    private boolean Elevator;
    private boolean Surveillance;
    private boolean Gym;
    private boolean CommunityRoom;
    private boolean Furniture;
    private String description;
    private float reputation;

    public PropertyDTO(long id,int area, long price, Location location, PropertyType type, int numberOfRooms, int numberOfBathRooms, boolean Elevator, boolean Surveillance, boolean Gym, boolean CommunityRoom, boolean Furniture, String description, float reputation) {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setCommunityRoom(boolean communityRoom) {
        CommunityRoom = communityRoom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElevator(boolean elevator) {
        Elevator = elevator;
    }

    public void setFurniture(boolean furniture) {
        Furniture = furniture;
    }

    public void setGym(boolean gym) {
        Gym = gym;
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
        Surveillance = surveillance;
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


