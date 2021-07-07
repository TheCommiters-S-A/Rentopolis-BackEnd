package edu.eci.ieti.rentopolis.services.leaseServices;

import edu.eci.ieti.rentopolis.entities.Lease;
import edu.eci.ieti.rentopolis.services.RentopolisServicesException;

public interface LeaseServices {

    void addLease(Lease lease);

    Lease getLeaseById(long id) throws RentopolisServicesException;

    void deleteLease(long id) throws RentopolisServicesException;
}
