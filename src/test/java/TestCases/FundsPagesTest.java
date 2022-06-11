package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.ScreenOrientation;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.FundsPage;
import Pages.LoginPage;
import Utillity.ScreenShot;

public class FundsPagesTest extends TestBase
{
	FundsPage fp;
	TestBase tb;
	LoginPage lp;
	@BeforeMethod
	public void Setup() throws InterruptedException
	{
		 OpenBrowser();
		 fp=new FundsPage(driver);
		 lp=new LoginPage(driver);
		 lp.setLogin();
	} 	
	@Test
	public void Tc_001_Fundspage() throws InterruptedException
	{
		fp.fundbtn();
	}
	@Test
	public void Tc_002_Fundspageclick() throws InterruptedException
	{
		fp.fundClick();
	}
	@Test
	public void Tc_003_FundEquityStatement() throws InterruptedException, EncryptedDocumentException, IOException
	{
		fp.equityStatement();

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
