package extentreports.extentreports;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test1_VerifyTitle extends Base
{



	@Test
	public void verifyBlogTitle()
	{
		
		logger=report.startTest("VerifyBlogTitle");
		logger.assignCategory("test1");
		driver=new FirefoxDriver();

		driver.manage().window().maximize();

		logger.log(LogStatus.INFO, "Browser started ");

		driver.get("http://www.learn-automation.com");

		logger.log(LogStatus.INFO, "Application is up and running");

		String title=driver.getTitle();

		Assert.assertTrue(title.contains("Google"));

		logger.log(LogStatus.PASS, "Title verified");
	}




}