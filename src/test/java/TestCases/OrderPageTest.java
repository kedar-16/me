package TestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Pages.OrderPage;
import Utillity.ScreenShot;

public class OrderPageTest extends TestBase
{
	OrderPage op;
	public LoginPage lp;
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		OpenBrowser();
		 op=new OrderPage(driver);
		 lp=new LoginPage(driver);
		 lp.setLogin();
	}
	
	@Test
	public void Tc_001_Oredrveify() throws InterruptedException
	{
		op.CreateGtt();
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
