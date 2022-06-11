package Base;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase
{
	public static Properties pr;
	public static WebDriver driver;
	
	public TestBase()
	{
		try 
		{
			pr=new Properties();
			FileInputStream file=new FileInputStream("D:\\kp\\Automation\\Project\\myproject\\config\\config.properties");
			pr.load(file);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e);
		}	
	}
	public void OpenBrowser()
	{
		 ChromeOptions chrome_Profile = new ChromeOptions();
		 chrome_Profile.addArguments("chrome.switches","--disable-extensions"); 
		 System.setProperty("webdriver.chrome.driver","D:\\kp\\Automation\\Project\\myproject\\chromedriver.exe");
		 driver = new ChromeDriver(chrome_Profile);
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(pr.getProperty("url"));
		 driver.manage().window().maximize();
	}
	public void CloseBrowser()
	{
		driver.close();
	}
}
