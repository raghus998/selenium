package Reports;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportsDemo 
{
	static ExtentReports reports;
	static ExtentTest test;
	@BeforeTest
	public void reportsExp()
	{
		reports = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = reports.startTest("Test Method");
	}
	
	@Test
	public void DemoA() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		if(driver.getTitle().equals("Googles"))
		{
			test.log(LogStatus.PASS, "Navigate to right web page");
			Reporter.log("test method is passs...........",true);
		}
		else
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(getScreenShots(driver))+" Title is not matching");
			Reporter.log("Test method is faiuled.......",true);
		}
		Thread.sleep(2000);
		driver.close();
		
	}
	public static  String getScreenShots(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./"+System.currentTimeMillis()+".png");
		String efile = dest.getAbsolutePath();
		try 
		{
			Files.copy(src, dest);
		}
		catch (IOException e)
		{
		}
		return efile;
	}
	@Test(dependsOnMethods = "DemoA")
	public void DemoB()
	{
		test.log(LogStatus.SKIP, "This method is skiped");
	}
	
	@Test
	public void DemoC()
	{
		test.log(LogStatus.FATAL, "Test method failed");
		Assert.fail();
	}
	
	@Test
	public void DemoD() 
	{
		test.log(LogStatus.INFO, "Test method infomation");
	}
	@Test
	public void DemoE()
	{
		test.log(LogStatus.PASS, "Test Method pass");
	}
	
	
	@AfterTest
	public void endTest()
	{
		reports.endTest(test);
		reports.flush();
	}
	

}
