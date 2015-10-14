package extentreports.extentreports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility
{
	public static String captureScreenshot(WebDriver driver,  String screenshotName)
	{

		try
		{
			String workingDirectory = System.getProperty("user.dir");
			String fileName = workingDirectory + File.separator +"screenShots"+  File.separator + "().png";//filename
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
				FileUtils.copyFile(scrFile, new File(fileName ));
			System.out.println("Screenshot taken");
			return fileName ;
		}
		catch (Exception e)
		{

			System.out.println("Exception while taking screenshot "+e.getMessage());
			return e.getMessage();
		
		
		}
		
	
		
	}}