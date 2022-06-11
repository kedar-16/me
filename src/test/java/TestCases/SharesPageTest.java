package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Pages.SharesPage;

public class SharesPageTest extends TestBase
{
	LoginPage lp;
	SharesPage sp;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		OpenBrowser();
		 lp=new LoginPage(driver);
		 lp.setLogin();
		 sp=new SharesPage();
	}
	@Test
	public void Tc_001_verifyshare() throws InterruptedException
	{
		  sp.share();
	}
	@AfterMethod
	public void close()
	{
		CloseBrowser();
	}
}
