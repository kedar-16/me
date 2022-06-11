package Utillity;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	
	public static void TakeScreenShot(WebDriver driver,String filename)
	{
		TakesScreenshot ss=(TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination=new File(".\\Screenshot\\ "+filename+".jpeg");
		
		try 
		{
			org.openqa.selenium.io.FileHandler.copy(source, destination);
		} catch (IOException e) 
		{
			e.getMessage();
		}
	}


}
