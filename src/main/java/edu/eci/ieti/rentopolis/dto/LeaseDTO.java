package edu.eci.ieti.rentopolis.dto;

import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.entities.Lessee;
import edu.eci.ieti.rentopolis.entities.User;
import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Property;

import java.util.Date;



public class LeaseDTO {
    public long id;
    public Property property;
    public Lessee lessee;
    public Lessor lessor;
    public Date startDate;
    public Date endDate;

    public LeaseDTO(Lease lease) {
        this.id = lease.getId();
        this.property = lease.getPropety();
        this.lessee= (Lessee) lease.getLessee();
        this.lessor = (Lessor) lease.getLessor();
        this.startDate = lease.getStartDate();
        this.endDate = lease.getEndDate();

    }

    public LeaseDTO() {
    }

    public Property getProperty(){
        return property;
    }

    public long getId(){
        return id;
    }

    public void setPropety(Property property) {
        this.property = property;
    }

    public Lessee getLessee() {
        return lessee;
    }

    public void setLessee(Lessee lessee) {
        lessee = lessee;
    }

    public Lessor getLessor() {
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

    public  Lease convertToEntity(LeaseDTO leaseDTO){
        return new Lease(leaseDTO.getId(),leaseDTO.getProperty(),leaseDTO.getLessee(),
                leaseDTO.getLessor(),leaseDTO.getStartDate(),leaseDTO.getEndDate());
    }
}