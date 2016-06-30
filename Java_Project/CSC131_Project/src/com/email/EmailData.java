package com.email;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.InputStream;
import java.util.*;

final class MailClient
{
	private class SMTPAuthenticator extends Authenticator
	{
		private PasswordAuthentication authentication;

		public SMTPAuthenticator(String login, String password)
		{
			authentication = new PasswordAuthentication(login, password);
		}

		@Override
		protected PasswordAuthentication getPasswordAuthentication()
		{
			return authentication;
		}
	}

	public void mail(String toEmailId, String date)
	{
		try
		{
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream("ApplicationResource.properties");

			Properties properties = new Properties();
			System.out.println("InputStream is: " + inputStream);
			properties.load(inputStream);
			String propValue = properties.getProperty("pass");

			String from = "snebhushan@gmail.com";
			String to = toEmailId;
			String subject = "Attendance Mark For Today Date -" + date;
			String message = "Attendance Mark For Today Date -" + date;
			String login = "snebhushan@gmail.com";
			String password = propValue;

			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			Authenticator auth = new SMTPAuthenticator(login, password);

			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);

			try
			{
				msg.setText(message);
				msg.setSubject(subject);
				msg.setFrom(new InternetAddress(from));
				msg.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
				Transport.send(msg);
			}
			catch (MessagingException ex)
			{
				Logger.getLogger(MailClient.class.getName()).
				log(Level.SEVERE, null, ex);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

public class EmailData
{
	public void sentEmail(String emailID,String Date){
		new MailClient().mail(emailID,Date);
	}

	public static void main(String...args)
	{

	}
}

/*
 Important links t solve some problems
 http://stackoverflow.com/questions/25341198/javax-mail-authenticationfailedexception-is-thrown-while-sending-email-in-java
 https://www.google.com/settings/security/lesssecureapps
 */
