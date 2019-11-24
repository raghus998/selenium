package qsp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DemoA 
{
	public static void main(String[] args) throws IOException 
	{
		URL url = new URL("https://www.google.com/");
		
		HttpURLConnection con  = (HttpURLConnection) url.openConnection();
		
		int code = con.getResponseCode();//if code  is 200, then it is not broken link
		System.out.println(code);
		
		String mesg = con.getResponseMessage();//if msg  is Ok, then it is not broken link
		System.out.println(mesg);
		
	}

}
