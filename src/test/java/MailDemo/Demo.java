package MailDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class Demo 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, MessagingException 
	{
				// load the properties
				Properties p= new Properties();
				p.load(new FileInputStream("./setting.properties"));
				
				// create session
				Session session = Session.getInstance(p, new MailConfigur());
				
				// create a mail
				MimeMessage mail= new MimeMessage(session);
				
				// add recipient
				InternetAddress to= new InternetAddress("sri3665@gmail.com");
				mail.addRecipient(RecipientType.TO, to);
				
				// add subject
				mail.setSubject("sending form cod");
				
				//add body
				mail.setText("my firest mail");
				// add attachment
				Multipart multipart= new MimeMultipart();
				MimeBodyPart bp= new MimeBodyPart();
				
				FileDataSource ds = new FileDataSource(new File("C:\\Users\\APM-SYSTEM\\Desktop\\img.png"));
				
				bp.setDataHandler(new DataHandler(ds));
				bp.setFileName("my photo");
				multipart.addBodyPart(bp);
				mail.setContent(multipart);
				//send mail
				Transport.send(mail);
				System.out.println("done");
		
	}

}
