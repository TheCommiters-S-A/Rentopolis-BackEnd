package edu.eci.ieti.rentopolis.entities;

import java.util.Date;



public class Lease {
    public long id;
    public Property propety;
    public Lessee lessee;
    public Lessor lessor;
    public Date startDate;
    public Date endDate;

    public Lease() {
    }

    public Lease(long id, Property propety, Lessee lessee, Lessor lessor, Date startDate, Date endDate) {
        this.id = id;
        this.propety = propety;
        this.lessee = lessee;
        this.lessor = lessor;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
    
    public Property getPropety() {
        return propety;
    }

    public void setPropety(Property propety) {
        this.propety = propety;
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
