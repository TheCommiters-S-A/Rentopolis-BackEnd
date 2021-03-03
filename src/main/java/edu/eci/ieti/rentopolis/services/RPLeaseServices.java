package edu.eci.ieti.rentopolis.services;


import edu.eci.ieti.rentopolis.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Rp lease services.
 */
@Service
public interface RPLeaseServices {

    /**
     * Add lease.
     *
     * @param aLease the a lease
     */
    void addLease(Lease aLease);

    /**
     * Delete lease lease.
     *
     * @param aLeaseId the a lease id
     * @return the lease
     */
    Lease deleteLease(Long aLeaseId);

    /**
     * Update lease.
     *
     * @param aLease the a lease
     */
    void updateLease(Lease aLease);

    /**
     * Gets lease by lessor.
     *
     * @param aLessorId the a lessor id
     * @return the lease by lessor
     */
    List<Lease> getLeaseByLessor(Long aLessorId);

    /**
     * Add new lessee to lease.
     *
     * @param aLesseeId the a lessee id
     * @param aLeaseId  the a lease id
     */
    void addNewLesseeToLease(Long aLesseeId, Long aLeaseId);


}
