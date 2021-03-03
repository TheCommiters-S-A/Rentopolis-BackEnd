/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Property.
 *
 * @author diego
 */
@Document(collection = "Properties")
public class Property {


// <editor-fold defaulted="collapsed" desc="Attributes">
    /**
     * The constant SEQUENCE_NAME.
     */
    @Transient
    public static final String SEQUENCE_NAME = "property_sequence";

    /**
     * The Id.
     */
    @Id
    public long id;
    /**
     * The Area.
     */
    public int area;
    /**
     * The Price.
     */
    public long price;
    /**
     * The Location.
     */
    public Location location;
    /**
     * The Type.
     */
    public PropertyType type;
    /**
     * The Number of rooms.
     */
    public int numberOfRooms;
    /**
     * The Number of bath romms.
     */
    public int numberOfBathRomms;
    /**
     * The Elevator.
     */
    public boolean Elevator;
    /**
     * The Surveillance.
     */
    public boolean Surveillance;
    /**
     * The Gym.
     */
    public boolean Gym;
    /**
     * The Community room.
     */
    public boolean CommunityRoom;
    /**
     * The Furnature.
     */
    public boolean Furnature;
    /**
     * The Description.
     */
    public String description;
    /**
     * The Reputation.
     */
    public float reputation;

    //</editor-fold>

    /**
     * Instantiates a new Property.
     */
// <editor-fold defaulted="collapsed" desc="Constructors">
    public Property() {
    }


    /**
     * Instantiates a new Property.
     *
     * @param id                the id
     * @param area              the area
     * @param price             the price
     * @param location          the location
     * @param type              the type
     * @param numberOfRooms     the number of rooms
     * @param numberOfBathRomms the number of bath romms
     * @param Elevator          the elevator
     * @param Surveillance      the surveillance
     * @param Gym               the gym
     * @param CommunityRoom     the community room
     * @param Furnature         the furnature
     * @param description       the description
     * @param reputation        the reputation
     */
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
    //</editor-fold>

    /**
     * Gets area.
     *
     * @return the area
     */
// <editor-fold defaulted="collapsed" desc="Getters">
    public int getArea() {
        return area;
    }

    /**
     * Gets sequence name.
     *
     * @return the sequence name
     */
    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public long getPrice() {
        return price;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public PropertyType getType() {
        return type;
    }

    /**
     * Gets number of rooms.
     *
     * @return the number of rooms
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Gets number of bath romms.
     *
     * @return the number of bath romms
     */
    public int getNumberOfBathRomms() {
        return numberOfBathRomms;
    }

    /**
     * Is elevator boolean.
     *
     * @return the boolean
     */
    public boolean isElevator() {
        return Elevator;
    }

    /**
     * Is surveillance boolean.
     *
     * @return the boolean
     */
    public boolean isSurveillance() {
        return Surveillance;
    }

    /**
     * Is gym boolean.
     *
     * @return the boolean
     */
    public boolean isGym() {
        return Gym;
    }

    /**
     * Is community room boolean.
     *
     * @return the boolean
     */
    public boolean isCommunityRoom() {
        return CommunityRoom;
    }

    /**
     * Is furnature boolean.
     *
     * @return the boolean
     */
    public boolean isFurnature() {
        return Furnature;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets reputation.
     *
     * @return the reputation
     */
    public float getReputation() {
        return reputation;
    }
    //</editor-fold>

    /**
     * Sets area.
     *
     * @param area the area
     */
// <editor-fold defaulted="collapsed" desc="Setters">
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(PropertyType type) {
        this.type = type;
    }

    /**
     * Sets number of rooms.
     *
     * @param numberOfRooms the number of rooms
     */
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    /**
     * Sets number of bath romms.
     *
     * @param numberOfBathRomms the number of bath romms
     */
    public void setNumberOfBathRomms(int numberOfBathRomms) {
        this.numberOfBathRomms = numberOfBathRomms;
    }

    /**
     * Sets elevator.
     *
     * @param elevator the elevator
     */
    public void setElevator(boolean elevator) {
        Elevator = elevator;
    }

    /**
     * Sets surveillance.
     *
     * @param surveillance the surveillance
     */
    public void setSurveillance(boolean surveillance) {
        Surveillance = surveillance;
    }

    /**
     * Sets gym.
     *
     * @param gym the gym
     */
    public void setGym(boolean gym) {
        Gym = gym;
    }

    /**
     * Sets community room.
     *
     * @param communityRoom the community room
     */
    public void setCommunityRoom(boolean communityRoom) {
        CommunityRoom = communityRoom;
    }

    /**
     * Sets furnature.
     *
     * @param furnature the furnature
     */
    public void setFurnature(boolean furnature) {
        Furnature = furnature;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets reputation.
     *
     * @param reputation the reputation
     */
    public void setReputation(float reputation) {
        this.reputation = reputation;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", area=" + area +
                ", price=" + price +
                ", location=" + location +
                ", type=" + type +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfBathRomms=" + numberOfBathRomms +
                ", Elevator=" + Elevator +
                ", Surveillance=" + Surveillance +
                ", Gym=" + Gym +
                ", CommunityRoom=" + CommunityRoom +
                ", Furnature=" + Furnature +
                ", description='" + description + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}
