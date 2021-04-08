package edu.eci.ieti.rentopolis.entities;


import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Picture {

    @Id
    private String id;
    
    private String title;

    private Binary image;


    public Picture(String title) {
        this.title = title;
    }


    public String getId() {
    

    public void setImage(Binary image) {
        this.image = image;
    }
        
    

}