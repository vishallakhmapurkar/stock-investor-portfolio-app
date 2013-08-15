package com.impetus.stockapp.exception;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public class StockApplicationException extends Exception {
    /**
     * Field serialVersionUID. (value is 289373261293190)
     */
    public static final long serialVersionUID = 289373261293190L;

    /**
     * Constructs a new exception
     */
    public StockApplicationException() {
	super();
    }

    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param message
     *            the specified detail message
     */
    public StockApplicationException(final String message) {
	super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause
     * 
     * @param message
     *            the specified detail message
     * @param cause
     *            the cause
     */
    public StockApplicationException(final String message, final Exception cause) {
	super(message, cause);
    }

    /**
     * Constructor for StockApplicationException.
     * @param cause Throwable
     */
    public StockApplicationException(final Throwable cause) {
	super(cause);
    }
}