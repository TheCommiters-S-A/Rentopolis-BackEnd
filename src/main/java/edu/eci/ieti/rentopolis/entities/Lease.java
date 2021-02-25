package edu.eci.ieti.rentopolis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;


/**
 * The type Lease.
 */
@Document(collection = "Lease")
public class Lease {

    /**
     * The constant SEQUENCE_NAME.
     */
// <editor-fold defaulted="collapsed" desc="Attributes">
    @Transient
    public static final String SEQUENCE_NAME = "lease_sequence";

    /**
     * The Id.
     */
    @Id
    public long id;

    /**
     * The Propety.
     */
    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    public Property propety;
    /**
     * The Lessee.
     */
    public Lessee lessee;
    /**
     * The Lessor.
     */
    public Lessor lessor;
    public Date startDate;
    public Date endDate;

    /**
     * Instantiates a new Lease.
     */
    public Lease() {
    }
    //</editor-fold>

    /**
     * Instantiates a new Lease.
     *
     * @param id        the id
     * @param propety   the propety
     * @param lessee    the lessee
     * @param lessor    the lessor
     * @param startDate the start date
     * @param endDate   the end date
     */
// <editor-fold defaulted="collapsed" desc="Constructor">
    public Lease(long id, Property propety, Lessee lessee, Lessor lessor, Date startDate, Date endDate) {
        this.id = id;
        this.propety = propety;
        this.lessee = lessee;
        this.lessor = lessor;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    //</editor-fold>

    // <editor-fold defaulted="collapsed" desc="Getters">

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
     * Gets propety.
     *
     * @return the propety
     */
    public Property getPropety() {
        return propety;
    }

    /**
     * Gets lessee.
     *
     * @return the lessee
     */
    public Lessee getLessee() {
        return lessee;
    }

    /**
     * Gets lessor.
     *
     * @return the lessor
     */
    public Lessor getLessor() {
        return lessor;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    //</editor-fold>
    // <editor-fold defaulted="collapsed" desc="Setters">

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets propety.
     *
     * @param propety the propety
     */
    public void setPropety(Property propety) {
        this.propety = propety;
    }

    /**
     * Sets lessee.
     *
     * @param lessee the lessee
     */
    public void setLessee(Lessee lessee) {
        this.lessee = lessee;
    }

    /**
     * Sets lessor.
     *
     * @param lessor the lessor
     */
    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //</editor-fold>

    @Override
    public String toString() {
        return "Lease{" +
                "id=" + id +
                ", propety=" + propety +
                ", lessee=" + lessee +
                ", lessor=" + lessor +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
