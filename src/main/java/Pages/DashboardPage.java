package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.TestBase;

public class DashboardPage extends TestBase
{
	public String[] window2;
	
@FindBy(xpath = "//span[@class='user-id']")WebElement dashuserid ;
@FindBy(xpath = "//span[@class='nickname']") WebElement nicknametxt;
@FindBy(tagName = "a") WebElement link ;
@FindBy(xpath = "//h4[@class='username']")WebElement lblusername;
@FindBy(xpath = "//div[@class='email']")WebElement lblusrmail;
@FindBy(xpath = "//span[@class='text-lightest']")WebElement lblsetting;
@FindBy(xpath = "(//a[@href='/profile'])[2]")WebElement lblprofile;
@FindBy(xpath = "//a[@href='https://console.zerodha.com/dashboard/']") WebElement lblconsole;

@FindBy(xpath = "(//button[@type='button'])[2]")WebElement btngetstart;
@FindBy(xpath ="(//input[@icon='search'])[2]" )WebElement searchbx;
@FindBy(xpath = "//link[@href]")List<WebElement> alllist;
@FindBy(xpath = "(//button[@class='button-outline button-blue'])[2]")WebElement btnbuy;
@FindBy(xpath="//input[@label='Qty.']")WebElement qtybx;
@FindBy(xpath = "//input[@label='Price']")WebElement pricebx;
@FindBy(xpath="//button[@class='button-outline cancel']") WebElement cancelbtn;
@FindBy(xpath = "//a[@href='https://console.zerodha.com/refer']")WebElement btninvitefrnd;

@FindBy(xpath="//input[@placeholder='Name']") WebElement txtnamereward;
@FindBy(xpath = "//input[@placeholder='Mobile']") WebElement txtphonereward;
@FindBy(xpath="//input[@placeholder='Email (optional)']") WebElement txtemialreward;

	public DashboardPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void dashboradid()
	{
		//if(dashuserid.isDisplayed())
			Assert.assertTrue(dashuserid.isDisplayed());
			
			Assert.assertEquals(pr.getProperty("username"), "UC9302");
			Reporter.log("Id IS Displayed"+dashuserid.getText());
		
	}
	public void dashbordclick() throws InterruptedException
	{
		
			Assert.assertTrue(dashuserid.isDisplayed());
			dashuserid.click();
			Thread.sleep(2000);
			Reporter.log("Id Is Display And Clicked");
	}
	public void nicknm()
	{
		//if (nicknametxt.isDisplayed())
		Assert.assertTrue(nicknametxt.isDisplayed());
			if(nicknametxt.getText().equals(pr.getProperty("nickname")))
			{
			System.out.println(nicknametxt.getText());
			Assert.assertTrue(true);
			Reporter.log("nickname Is Display"+nicknametxt.getText());
			}
			else
			{
				Assert.assertTrue(false);
			}
	}
	
	public  void usernm()
	{
		Assert.assertTrue(lblusername.isDisplayed());
			if(lblusername.getText().equals(pr.getProperty("userlable")))
			{
			Assert.assertTrue(true);
			Reporter.log("User Lable Is Display");
			System.out.println(lblusername.getText());
			}
		else
		{
			Assert.assertTrue(false);
		}
	}
	public void usermail()
	{
			Assert.assertTrue(lblusrmail.isDisplayed());
		if(lblusrmail.getText().equals(pr.getProperty("useremail")))
		{
			Assert.assertTrue(true);
			Reporter.log("User Lable Is Display");
			System.out.println(lblusrmail.getText());

		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	public void investing() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Assert.assertTrue(btngetstart.isDisplayed());
			btngetstart.click();
			Thread.sleep(2000);
			Reporter.log("Get Start Button Is Clicked");
				Assert.assertTrue(searchbx.isDisplayed());
					searchbx.sendKeys(Utillity.Util.readExcell(0, 0));
					Reporter.log("Serachbox Working");
					for(int  i=0;i<alllist.size();i++)
					{
							System.out.println(alllist.get(i).getText());
							if(alllist.get(i).getText().equals("TCS APR FUT"))
							{
								alllist.get(i).click();
								break;
							}
					}
						Thread.sleep(2000);
						btnbuy.click();
						qtybx.sendKeys(Utillity.Util.readExcell(0,1));
						Thread.sleep(2000);
						pricebx.sendKeys(Utillity.Util.readExcell(0,2));
						Thread.sleep(2000);
						cancelbtn.click();
	}
	
	public void inviteffrnd() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dashuserid.click();
		btninvitefrnd.click();
		Set<String> window = driver.getWindowHandles();
		window2 =new String[5];
		Iterator<String> itr = window.iterator();
		for (int i=0;i<window.size();i++) 
		{
			window2[i]=itr.next();
			System.out.println(window2[i]);				
		}
				driver.switchTo().window(window2[1]);
				Assert.assertTrue(txtnamereward.isDisplayed());
				txtnamereward.sendKeys(Utillity.Util.readreadExcell2(0, 0));
				Thread.sleep(2000);
				
				Assert.assertTrue(txtemialreward.isDisplayed());
				txtemialreward.sendKeys(Utillity.Util.readreadExcell2(0, 1));
				Thread.sleep(2000);
			
				Assert.assertTrue(txtphonereward.isDisplayed());
				txtphonereward.sendKeys(Utillity.Util.readreadExcell2(0, 2));
				Thread.sleep(2000);
			
				driver.close();
				driver.switchTo().window(window2[0]);	
	}
	
	public void getlink()
	{
		int size = alllist.size();
		System.out.println("Total link are "+size);
		for(int i=0;i<alllist.size();i++)
		{
			String links = alllist.get(i).getText();
			System.out.println(i+" "+links);
		}
	}

		
}
