package TestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HoldingPage;
import Pages.LoginPage;
import Utillity.ScreenShot;

public class HoldingPageTest extends TestBase{
	HoldingPage hp;
	public LoginPage lp;
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		OpenBrowser();
		 hp=new HoldingPage(driver);
		 lp=new LoginPage(driver);
		 lp.setLogin();
	}
	@Test
	public void drpdown() throws InterruptedException
	{
		hp.drpstock();
	}
	@AfterMethod
	public void close(ITestResult result)
	{
		if(result.FAILURE==result.getStatus())
		{
			ScreenShot.TakeScreenShot(driver,result.getName());
		}
		CloseBrowser();
	}
	
	

}
