package com.impetus.stockapp.mailutil;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public interface MailService {
    /**
     * Method sendMail.
     * @param from String
     * @param to String
     * @param subject String
     * @param msg String
     */
    void sendMail(String from, String to, String subject, String msg);
}
