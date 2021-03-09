package edu.eci.ieti.rentopolis.entities;

import java.util.Date;



public class Lease {
    private long id;
    private Property property;
    private Lessee lessee;
    private Lessor lessor;
    private Date startDate;
    private Date endDate;

    public Lease() {
    }

    public Lease(long id, Property property, Lessee lessee, Lessor lessor, Date startDate, Date endDate) {
        this.id = id;
        this.property = property;
        this.lessee = lessee;
        this.lessor = lessor;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    

    public long getId(){return id;}
    
    public Property getPropety() {
        return property;
    }

    public void setPropety(Property propety) {
        this.property = propety;
    }

    public User getLessee() {
        return lessee;
    }

    public void setLessee(Lessee lessee) {
        this.lessee = lessee;
    }

    public User getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
