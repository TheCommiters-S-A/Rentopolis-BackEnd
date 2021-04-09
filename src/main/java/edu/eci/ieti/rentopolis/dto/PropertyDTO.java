package edu.eci.ieti.rentopolis.dto;

import edu.eci.ieti.rentopolis.entities.Location;
import edu.eci.ieti.rentopolis.entities.Property;
import edu.eci.ieti.rentopolis.entities.PropertyType;

public class PropertyDTO {

    private long id;
    private int area;
    private long price;
    private Location location;
    private PropertyType typeProperty;
    private int numberOfRooms;
    private int numberOfBathRooms;
    private boolean elevator;
    private boolean surveillance;
    private boolean gym;
    private boolean communityRoom;
    private boolean furniture;
    private String description;
    private float reputation;
    private String image;
    private String address;
    private String neighborhood;
    private int stratum;


    public PropertyDTO() {
        // Se necesita para las pruebas
    }

    public PropertyDTO(Property property) {
        this.id = property.getId();
        this.area = property.getArea();
        this.price = property.getPrice();
        this.location = property.getLocation();
        this.typeProperty = property.getType();
        this.numberOfRooms = property.getNumberOfRooms();
        this.numberOfBathRooms = property.getNumberOfBathRooms();
        this.elevator = property.isElevator();
        this.surveillance = property.isSurveillance();
        this.gym = property.isGym();
        this.communityRoom = property.isCommunityRoom();
        this.furniture = property.isFurniture();
        this.description = property.getDescription();
        this.reputation = property.getReputation();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public PropertyType getTypeProperty() {
        return typeProperty;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfBathRooms() {
        return numberOfBathRooms;
    }

    public boolean isElevator() {
        return elevator;
    }

    public boolean isSurveillance() {
        return surveillance;
    }

    public boolean isGym() {
        return gym;
    }

    public boolean isCommunityRoom() {
        return communityRoom;
    }

    public boolean isFurniture() {
        return furniture;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public int getStratum() {
        return stratum;
    }


    public Property convertToEntity(PropertyDTO propertyDTO) {
        return new Property(propertyDTO.getId(), propertyDTO.getArea(), propertyDTO.getPrice(),
                propertyDTO.getLocation(), propertyDTO.getTypeProperty(), propertyDTO.getNumberOfRooms(),
                propertyDTO.getNumberOfBathRooms(), propertyDTO.isElevator(), propertyDTO.isSurveillance(),
                propertyDTO.isGym(), propertyDTO.isCommunityRoom(), propertyDTO.isFurniture(),
                propertyDTO.getDescription(), propertyDTO.getImage(), propertyDTO.getAddress(), propertyDTO.getNeighborhood()
                , propertyDTO.getStratum());
    }
}


