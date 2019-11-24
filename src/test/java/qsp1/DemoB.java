package qsp1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoB
{
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///E:/Add_Selenium/Add_Selenium/HtmlProg/img.html");
		
		WebElement img = driver.findElement(By.id("i2"));
		String src = img.getAttribute("src");
		String imgname = img.getAttribute("value");
		System.out.println("img address "+src);
		System.out.println("Img name "+imgname);
		try
		{
			URL url = new URL(src);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int code = con.getResponseCode();
			if(code==200)
			{
				System.out.println("Img is not broken");
			}
			else
			{
				System.out.println("Img is broken1");
			}
		}
		catch (Exception e)
		{
			System.out.println("Img is broken2");
		}
		driver.close();
		
	}

}
