package com.impetus.stockapp.mailutil;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
public class MailServiceImpl implements MailService {

    private String host;
    /**
     * Method setHost.
     * @param host String
     */
    public void setHost(String host) {
	    this.host = host;
	}
    private String port;
    /**
     * Method setPort.
     * @param port String
     */
    public void setPort(String port) {
	    this.port = port;
	}
    private String username;
    /**
     * Method setUsername.
     * @param username String
     */
    public void setUsername(String username) {
	    this.username = username;
	}
    private String password;
    /**
     * Method setPassword.
     * @param password String
     */
    public void setPassword(String password) {
	    this.password = password;
	}
    
	/**
	 * Method sendMail.
	 * @param from1 String
	 * @param to String
	 * @param subject String
	 * @param txt String
	
	 * @see com.impetus.stockapp.mailutil.MailService#sendMail(String, String, String, String) */
	public void sendMail(final String from1, final String to, final String subject, final String txt) {
      String pwd = ""; 
   	      //System.out.println(password);
   	       pwd = HexStringConverter.getHexStringConverterInstance().hexToString(password);
   	    System.out.println(pwd);
	  Properties props = new Properties();
	   props.put("mail.smtp.host", host);
	   props.put("mail.stmp.user", username);
	  // props.put("mail.smtp.port", port);
	   //To use TLS
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	  // props.put("mail.smtp.password", pwd);
	   Session session = Session.getDefaultInstance(props, new Authenticator() {
	 @Override
	   protected PasswordAuthentication getPasswordAuthentication() {
	      
	       return new PasswordAuthentication(username,  HexStringConverter.getHexStringConverterInstance().hexToString(password));
	   }
	 });
	  

	
	  MimeMessage msg = new MimeMessage(session);
	  try {
	   msg.setFrom(new InternetAddress(username));
	   msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
	   msg.setSubject(subject);
	   msg.setText(txt);
	   Transport transport = session.getTransport("smtp");
	   transport.send(msg);
	
	 }  catch(Exception exc) {
	      System.out.println(exc);
	    }
	}

}
