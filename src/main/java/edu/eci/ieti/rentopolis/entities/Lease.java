package edu.eci.ieti.rentopolis.entities;



public class Lease {
    private long id;
    private Property property;
    private Lessee lessee;
    private Lessor lessor;
    private String startDate;
    private String endDate;

    public Lease() {
    }

    public Lease(long id, Property property, Lessee lessee, Lessor lessor, String startDate, String endDate) {
        this.id = id;
        this.property = property;
        this.lessee = lessee;
        this.lessor = lessor;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public long getId() {
        return id;
    }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
