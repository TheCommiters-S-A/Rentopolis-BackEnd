package edu.eci.ieti.rentopolis.exception;

import java.util.Date;

/**
 * The type Error details.
 */
public class ErrorDetails {
	// <editor-fold defaulted="collapsed" desc="Attributes">
	private Date timestamp;
	private String message;
	private String details;
	//</editor-fold>

	/**
	 * Instantiates a new Error details.
	 *
	 * @param timestamp the timestamp
	 * @param message   the message
	 * @param details   the details
	 */
// <editor-fold defaulted="collapsed" desc="Constructor">
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	//</editor-fold>

	/**
	 * Gets timestamp.
	 *
	 * @return the timestamp
	 */
// <editor-fold defaulted="collapsed" desc="Getters">
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Gets message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	//</editor-fold>
}
