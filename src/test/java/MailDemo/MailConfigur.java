package MailDemo;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailConfigur extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication p = new PasswordAuthentication("sri3665@gmail.com", "sri9738383665");
		return p;
	}

}
