import java.lang.System;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail
{
	public static void main(String [] args)
	{
		// Recipient's email ID needs to be mentioned.
		String to = "dezso.varga.vd@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "dezso.varga.vd@gmail.com";

		// Assuming you are sending email from localhost
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.user", "dezso.varga.vd");
		properties.setProperty("mail.password", "v@rg@d3zs05");
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
		System.out.println("It works");
	}
}