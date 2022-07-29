package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utillity.Log;
import Utillity.ScreenShot;

public class LoginPageTest extends TestBase  {
	
	public  LoginPage lp;
	
	
	@BeforeMethod (groups = {"sanity"})
	public void setup()
	{
		OpenBrowser();
		lp=new LoginPage(driver);
		
	}
	@Test//(groups = {"sanity"})
	public void TC_001_loginTest() throws InterruptedException
	{	Log.startTestCase("verifySetLogin");
		lp.setLogin();
		Log.endTestCase("verifySetLogin");
	}
	@Test//(groups = {"sanity"})
	public void Tc_002_displaylogo1()
	{	Log.startTestCase("verifySetLogo");
		boolean value = lp.displaylogo1();
		Assert.assertEquals(value,true);
		Reporter.log("Logo kite Is display"+value);
		Log.endTestCase("verifySetLogo");
		
	}
	@Test//(groups = {"sanity"})
	public void Tc_003_displaylogo2()
	{
		Log.startTestCase("verifyDisplayLogo");
		boolean value = lp.displaylogo2();
		Assert.assertEquals(value, true);
		Reporter.log("Logo Footer is display "+value);
		Log.endTestCase("verifyDisplayLogo");
	}
	@Test//(groups = {"sanity"})
	public void Tc_004_UserText()
	{	Log.startTestCase("verifySetLogin");
		boolean value = lp.userLble();
		Assert.assertEquals(value,true);
		Reporter.log("User Id Display"+value);
		Log.endTestCase("verifySetLogin");
	}
	@Test(groups = {"sanity"})
	public void Tc_006_TitleVerify()
	{
		Log.startTestCase("verifySetLogin");
		if(driver.getTitle().equals(pr.getProperty("title")))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);;
		}
		Log.endTestCase("verifyTitle");

	}
	@AfterMethod (groups = {"sanity"})
	public void exit()
	{
		
		CloseBrowser();
	}
	


}
