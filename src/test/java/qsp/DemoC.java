package qsp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoC {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumhq.org/download/");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("No of links present in the web page "+alllinks.size());
		for(WebElement link : alllinks)
		{
			String href = link.getAttribute("href");
			String text = link.getText();
			System.out.println("Link text "+text);
			try
			{
			URL url = new URL(href);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int code = con.getResponseCode();
			if(code==200)
			{
				System.out.println("Link is not broken");
			}
			else
			{
				System.out.println("Link is broken1");
				String msg = con.getResponseMessage();
				System.out.println("Message "+msg);
			}
			
			}
			catch (Exception e) 
			{
				System.out.println("Link is broken2");
			}
			System.out.println("================================================");
		}
		Thread.sleep(5000);
		driver.close();
		
	}

}
