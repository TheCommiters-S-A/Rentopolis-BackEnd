package edu.eci.ieti.rentopolis.services;

public class RentopolisServicesException extends Exception{

    public RentopolisServicesException(String message) {super(message);}

    public RentopolisServicesException(String message, Throwable cause) {
        super(message, cause);
    }

}