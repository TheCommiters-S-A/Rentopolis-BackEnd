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


    public Picture() {
    }

    public Picture(String id, String title, Binary image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public Picture(String title) {
        this.title = title;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return this.image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }
        
    

}