package extentreports.extentreports;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {

	public static   ExtentReports report;
	public static  ExtentTest logger;
	public static  WebDriver driver;
	
	 public static ExtentReports getInstance() {
	        if (report == null) {
	        	report =new ExtentReports("C:\\LearnAutomation.html",true);
	            
	            // optional
	        	report.config()
	                .documentTitle("Automation Report")
	                .reportName("Regression")
	                .reportHeadline("Pawan");
	               
	            // optional
	        	report
	                .addSystemInfo("Selenium Version", "2.46")
	                .addSystemInfo("Environment", "QA");
	        }
	        return report;
	    }

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{

			String screenshot_path=Utility.captureScreenshot(driver, result.getName());
			String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);


		}

		report.endTest(logger);
		report.flush();

		driver.get("C:\\LearnAutomation.html");
	}
}
