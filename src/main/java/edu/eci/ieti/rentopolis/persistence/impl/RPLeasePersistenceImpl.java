package edu.eci.ieti.rentopolis.persistence.impl;

import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.entities.Lessee;
import edu.eci.ieti.rentopolis.entities.Lessor;
import edu.eci.ieti.rentopolis.persistence.RPLeasePersistence;
import edu.eci.ieti.rentopolis.persistence.RentopolisPersistenceException;
import edu.eci.ieti.rentopolis.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Rp lease persistence.
 */
@Component("RPLeasePersistenceImpl")
public class RPLeasePersistenceImpl implements RPLeasePersistence {


    // <editor-fold defaulted="collapsed" desc="Attributes">
    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private LessorRepository lessorRepository;

    @Autowired
    private LeaseRepository leaseRepository;
    // </editor-fold>

    // <editor-fold defaulted="collapsed" desc="Methods">
    @Override
    public void addLease(Lease aLease) {
        leaseRepository.insert(aLease);
    }

    @Override
    public Lease deleteLease(Lease aLease) throws RentopolisPersistenceException {
        leaseRepository.delete(aLease);
        if(leaseRepository.existsById(aLease.getId())){
            throw new RentopolisPersistenceException("Error");
        };
        return aLease;
    }

    @Override
    public void updateLease(Lease aLease) {

    }

    @Override
    public List<Lease> getLeaseByLessor(Lessor aLessor) {
        return null;
    }

    @Override
    public void addNewLesseeToLease(Lessee aLessee, Lease aLease) {

    }
    // </editor-fold>
}
