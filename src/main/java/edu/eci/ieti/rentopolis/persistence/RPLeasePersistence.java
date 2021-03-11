package edu.eci.ieti.rentopolis.persistence;

import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Lessee;
import edu.eci.ieti.rentopolis.entities.Lessor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Rp lease persistence.
 */
@Service
public interface RPLeasePersistence {

    // <editor-fold defaulted="collapsed" desc="Methods">
    /**
     * Add lease.
     *
     * @param aLease the a lease
     */
    void addLease(Lease aLease);


    /**
     * Delete lease lease.
     *
     * @param aLease the a lease
     * @return the lease
     */
    Lease deleteLease(Lease aLease) throws RentopolisPersistenceException;

    /**
     * Update lease.
     *
     * @param aLease the a lease
     */
    void updateLease(Lease aLease);


    /**
     * Gets lease by lessor.
     *
     * @param aLessor the a lessor
     * @return the lease by lessor
     */
    List<Lease> getLeaseByLessor(Lessor aLessor);


    /**
     * Add new lessee to lease.
     *
     * @param aLessee the a lessee
     * @param aLease  the a lease
     */
    void addNewLesseeToLease(Lessee aLessee, Lease aLease);
    // </editor-fold>
}
