package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;
import Utillity.ScreenShot;

public class DashBoardPageTest extends TestBase {
	DashboardPage dp;
	public LoginPage lp;

	@BeforeMethod(groups = {"sanity","regression"})
	public void Setup() throws InterruptedException
	{
		OpenBrowser();
		dp=new DashboardPage(driver);
		lp=new LoginPage(driver);
		lp.setLogin();
	}

	@Test(priority = 1,groups = {"sanity","regression"})
	public void Tc_001_Dashboradid() throws InterruptedException
	{	
		
		 dp.dashboradid();
	}
	@Test(priority = 2,groups = {"sanity","regression"})
	public void Tc_002_Dashboradid() throws InterruptedException
	{
		dp.dashbordclick();
		
	}
	@Test(priority = 3,groups = {"sanity","regression"})
	public void Tc_003_Dashbordnicknam() throws InterruptedException
	{		
		
		dp.nicknm();
		
	}
	@Test(priority = 4,groups = {"sanity","regression"})
	public void Tc_004_DashbordUSerLable() throws InterruptedException
	{
		dp.dashbordclick();
		
		dp.usernm();
	}
	@Test(priority = 5,groups={"regression"})
	public void Tc_005_DashbordUSermail() throws InterruptedException
	{
		dp.dashbordclick();
		dp.usermail();
	}
	@Test(priority = 6,groups = {"sanity","regression"})
	public void Tc_005_Dashbordinvesting() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dp.investing();
	}
	@Test (groups = {"regression"},priority = 7)
	public void Tc_006_DashBoardInviteFrnd() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dp.inviteffrnd();
	}
	
	@AfterMethod (groups = {"sanity","regression"})
	public void close(ITestResult result)
	{
		if(result.FAILURE==result.getStatus())
		{
			ScreenShot.TakeScreenShot(driver, result.getName());
		}
		
		CloseBrowser();
	}

}
