package SVG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoA 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///E:/selenium_Add/svgdemo.html");
		List<WebElement> allelements = driver.findElements(By.xpath("//*"));
		int count = 0;
		for(WebElement cir : allelements)
		{
			String tname = cir.getTagName();
			if(tname.equals("circle"))
			{
				count++;
				String att = cir.getCssValue("fill-opacity");
				System.out.println(att);
				System.out.println("-------------------");
			}
		}
		System.out.println(count);
		driver.close();
	}

}
