package qsp2;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoA 
{
	public static void main(String[] args) throws InterruptedException, IOException, AWTException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.findElement(By.xpath("(//div[@class='popup_menu_icon'])[3]")).click();
		driver.findElement(By.linkText("Contact actiTIME Support")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Drag and drop file here or click to upload']")).click();
		Thread.sleep(3000);
		Robot r= new Robot();
		//get the screen size 
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		//create object of rectangle class
		Rectangle rect= new Rectangle(d);
		BufferedImage img = r.createScreenCapture(rect);
		
		//store in prefered location
		ImageIO.write(img, "png", new File("./ScreenShots/img1.png"));
		
		Thread.sleep(3000);
		driver.close();
	}

}
