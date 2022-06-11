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
import Utillity.ScreenShot;

public class LoginPageTest extends TestBase  {
	
	public  LoginPage lp;
	
	
	@BeforeMethod (groups = {"sanity","regression"})
	public void setup()
	{
		OpenBrowser();
		lp=new LoginPage(driver);
	}
	@Test(groups = {"sanity"})
	public void TC_001_loginTest() throws InterruptedException
	{
		lp.setLogin();
	}
	@Test
	public void Tc_002_displaylogo1()
	{	
		boolean value = lp.displaylogo1();
		Assert.assertEquals(value,true);
		Reporter.log("Logo kite Is display"+value);
		
	}
	@Test
	public void Tc_003_displaylogo2()
	{
		boolean value = lp.displaylogo2();
		Assert.assertEquals(value, true);
		Reporter.log("Logo Footer is display "+value);

	}
	@Test
	public void Tc_004_UserText()
	{	
		boolean value = lp.userLble();
		Assert.assertEquals(value,true);
		Reporter.log("User Id Display"+value);
	}
	@Test(groups = {"regression"})
	public void Tc_006_TitleVerify()
	{
		if(driver.getTitle().equals(pr.getProperty("title")))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);;
		}
	}
	@AfterMethod (groups = {"sanity","regression"})
	public void exit(ITestResult result)
	{

		if(result.FAILURE==result.getStatus())
		{
			ScreenShot.TakeScreenShot(driver,result.getName());
		}
		CloseBrowser();
	}
	


}
