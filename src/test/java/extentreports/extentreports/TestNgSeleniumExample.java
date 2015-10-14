package extentreports.extentreports;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestNgSeleniumExample extends ExtentManager {
	
   
    
    @Test
    public void googleWithoutAssert() throws InterruptedException {
    	
    	
    	
        test = extent
            .startTest("Google Search Without Assert", "Verifies if Google search button is displayed")
            .assignCategory("NoAssert", "ExtentAPI");

        test.log(LogStatus.INFO, "Launching browser");
        driver = new FirefoxDriver();

        test.log(LogStatus.INFO, "Navigating to google.com");
        driver.get("http://google.com");

        driver.findElement(By.cssSelector("input[value*='Google Search']"));
        test.log(LogStatus.PASS, "Search button displayed");
    
        
        
       /* try
        {
            driver.findElement(By.cssSelector("input[value*='Google Search']"));
            test.log(LogStatus.PASS, "Search button displayed");
        //    test.log(LogStatus.INFO, "Check error message" + test.addScreenCapture(createScreenshot(driver)));
        }
        catch (NoSuchElementException e)
        {
            test.log(LogStatus.FAIL, "<pre>" + e.toString() + "</pre>");
            
         // createScreenshot returns path of the image
        	//test.log(LogStatus.INFO, "Check error message" + test.addScreenCapture(createScreenshot(driver)));

        	
           // extent.log(LogStatus.FAIL, "Check error message","View details below:",createScreenshot(driver));
            
            
            
            throw e;
        }*/
    }

    @Test
    public void googleWithAssert() {
        test = extent
            .startTest("Google Search With Assert", "Verifies if Google search button is displayed")
            .assignCategory("NoAssert", "ExtentAPI");

        test.log(LogStatus.INFO, "Launching browser");
        driver = new FirefoxDriver();

        test.log(LogStatus.INFO, "Navigating to google.com");
        driver.get("http://google.com");

        Boolean isFound = IsElementPresent(driver, By.cssSelector("input[value*='Googl Search']"));

   
        
        softAssert.assertTrue(isFound, "googleWithAssert->IsFound");
        softAssert.assertAll();
        test.log(LogStatus.PASS, "Search button displayed");
        
        
        
        /*  try
        {
            softAssert.assertTrue(isFound, "googleWithAssert->IsFound");
            softAssert.assertAll();
            test.log(LogStatus.PASS, "Search button displayed");
        }
        catch (AssertionError e)
        {
            test.log(LogStatus.FAIL, "<pre>" + e.getMessage() + "</pre>");
         
         // createScreenshot returns path of the image
        	//test.log(LogStatus.INFO, "Check error message" + test.addScreenCapture(createScreenshot(driver)));

            test.log(LogStatus.INFO, "Check error message" );
           // extent.log(LogStatus.FAIL, "Check error message","View details below:",createScreenshot(driver))
            
            
            throw e;
        }*/
    }

    private Boolean IsElementPresent(WebDriver driver, By by) {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) { return false; }
    }

    
    
/*    public static String createScreenshot(WebDriver driver) {
   	 
        UUID uuid = UUID.randomUUID();
     
        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
            FileUtils.copyFile(scrFile, new File(reportLocation + imageLocation + uuid + ".png"));
        } catch (IOException e) {
            System.out.println("Error while generating screenshot:\n" + e.toString());
        }
        return imageLocation + uuid + ".png";
    }
    */
    
  
    
 
}