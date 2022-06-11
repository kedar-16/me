package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Ipopage;
import Pages.LoginPage;
import Utillity.ScreenShot;

public class IpoTest  extends TestBase
{
	LoginPage lp;
	Ipopage ip;
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		OpenBrowser();
		ip=new Ipopage(driver);
		lp=new LoginPage(driver);
		lp.setLogin();
	}
	@Test
	public void TC_001_Ipo_click() throws InterruptedException
	{
		Boolean value = ip.ipoclick();
		Assert.assertTrue(true);
		Reporter.log("ipo clickSuccesfull");
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
