package SVG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///E:/selenium_Add/SVG.html");
		List<WebElement> allelements = driver.findElements(By.xpath("//*"));
		int count =0 ;
		Actions act = new Actions(driver);
		for(WebElement line : allelements)
		{
			String tname = line.getTagName();
			if(tname.equals("line"))
			{
				Thread.sleep(2000);
				count++;
				String bfcolor = line.getCssValue("stroke");
				System.out.println("Before placing cursor "+bfcolor);
				act.moveToElement(line).perform();
				
				String afcolor = line.getCssValue("stroke");
				System.out.println("After placing cursor "+afcolor);
				System.out.println("------------------------------------");
				WebElement tooltip = line.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
				String tooltipText = tooltip.getText();
				System.out.println("Tool Tip Text "+tooltipText);
				System.out.println("================================================");

			
			}
		}
		
		System.out.println("No of lines "+count);
		Thread.sleep(2000);
		driver.close();
	}

}
