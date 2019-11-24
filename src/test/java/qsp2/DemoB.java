package qsp2;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoB 
{
	public static void main(String[] args) throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com");
		 WebElement img = driver.findElement(By.xpath("(//div)[2]"));
		 
		 TakesScreenshot t= (TakesScreenshot) driver;
		 File src=t.getScreenshotAs(OutputType.FILE);
		 Files.copy(src, new File("./ScreenShots/demo.png"));
		 
		 //find the location ( x and y axis) and size(hight and width)
		 int x=img.getLocation().getX();
		 int y=img.getLocation().getY();
		 int h=img.getSize().getHeight();
		 int w=img.getSize().getWidth();
		 
		 System.out.println("x= "+x);
		 System.out.println("y= "+y);
		 System.out.println("h= "+h);
		 System.out.println("w= "+w);
		 
		 //crop the img
		 
		 BufferedImage orgimg = ImageIO.read(new FileInputStream("./ScreenShots/demo.png"));
		 BufferedImage subimg = orgimg.getSubimage(x, y, w, h);
		 
		 ImageIO.write(subimg, "png", new FileOutputStream("./ScreenShots/d.png"));
		 
		 
		 //read act
		 BufferedImage aimg = ImageIO.read(new FileInputStream("./ScreenShots/demo.png"));
		 BufferedImage eimg = ImageIO.read(new FileInputStream("./ScreenShots/d.png"));
		 
		 DataBuffer aimgpix = aimg.getData().getDataBuffer();
		 DataBuffer eimgpix = eimg.getData().getDataBuffer();
		 
		 
		 int apixcount=aimgpix.getSize();
		 int epixcount=eimgpix.getSize();
		 
				 
		 System.out.println("apix count "+apixcount);
		 System.out.println("epix count "+epixcount);
		 
		 int matchcount= 0;
		 int count=0;
		 if(apixcount>epixcount)
		 {
			 count=epixcount;
			 
			 
		 }
		 else
		 {
			 count=apixcount;
			 
		 }
		 for (int i = 0; i < count; i++)
		 {
			if(aimgpix.getElem(i)==eimgpix.getElem(i))
			{
				matchcount++;
			}
		}
		 
		 int percent=(matchcount*100)/epixcount;
		 System.out.println("percent: "+percent);
		 
		 
		 driver.close();
	}

}
