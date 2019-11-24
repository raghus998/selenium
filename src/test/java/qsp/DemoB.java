package qsp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoB 
{
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///E:/Add_Selenium/Add_Selenium/HtmlProg/link.html");
		WebElement link = driver.findElement(By.linkText("Qsp"));
		String href = link.getAttribute("href");
		String text =  link.getText();
		System.out.println("href "+href);
		
		
		
		System.out.println("link text "+text);
		try
		{
		URL url = new URL(href);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int code  = con.getResponseCode();
		if(code==200)
		{
			System.out.println("Link is not broken");
		}
		else
		{
			System.out.println("link is broken1");
			String msg  = con.getResponseMessage();
			System.out.println(msg);
		}
		
		}
		catch (Exception e) 
		{
			System.out.println("link is broken2");
		}
		driver.close();
		
		
		
		
		
		
		
		
		
		
	}

}
