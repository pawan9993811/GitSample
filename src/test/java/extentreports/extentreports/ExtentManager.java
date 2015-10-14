package extentreports.extentreports;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager {
	//public static ExtentReports extent = ExtentManager.getInstance();
	 SoftAssert softAssert = new SoftAssert();
	public static ExtentTest test;
	public static WebDriver driver;

	static String reportLocation = "C:\\";
	static String imageLocation = "images/";
	public  static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			extent = new ExtentReports("C:\\ReportTestNg.html", true);

			// optional
			extent.config()
			.documentTitle("Automation Report")
			.reportName("Regression")
			.reportHeadline("");

			// optional
			extent
			.addSystemInfo("Selenium Version", "2.46")
			.addSystemInfo("Environment", "QA");
		}
		return extent;
	}
	
	
	
	
	
	
	  @AfterMethod
	    public void tearDown(ITestResult result)
	    {
	    if(result.getStatus()==ITestResult.FAILURE)
	    {
	     
	    String screenshot_path=Utility.captureScreenshot(driver, result.getName());
	    String image= test.addScreenCapture(screenshot_path);
	    test.log(LogStatus.FAIL, "Title verification", image);
	     
	    driver.quit();
	    extent.endTest(test);
	    extent.flush();
	    }
	    }
}
