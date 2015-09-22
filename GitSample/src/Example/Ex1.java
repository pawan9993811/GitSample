import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import static org.openqa.selenium.OutputType.*;

public class Comp_Details {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void Comp_Details() throws InterruptedException {
    	
    	//Nav to URL
        wd.get("http://www.lead411.com/");
        
        Thread.sleep(1000);
        if (!wd.findElement(By.tagName("html")).getText().contains("Login")) {
            System.out.println("verifyTextPresent failed");
        }
        
        //Click on Login Menu
        wd.findElement(By.id("login-trigger")).click();

        //Enter UserName
        wd.findElement(By.xpath(".//*[@id='username']")).sendKeys("gopiraghu321@gmail.com");
       
        //Enter Password
        wd.findElement(By.xpath(".//*[@id='password']")).sendKeys("Rithik981*");
        
        //Click on Submit
        wd.findElement(By.id("submit")).click();
        
        Thread.sleep(5000);
        //After Login Check gopi User name
        if (!wd.findElement(By.tagName("html")).getText().contains("Gopi")) {
            System.out.println("verifyTextPresent failed");
        }
        
      //Click on Folder icon
        wd.findElement(By.id("search_image")).click();
       
        // Click on Save Search 21st sep
        wd.findElement(By.linkText("21st sep")).click();
        
        Thread.sleep(5000);
        
    }
    
    
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
