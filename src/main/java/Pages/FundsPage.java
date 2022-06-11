package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Base.TestBase;

public class FundsPage extends TestBase {
 public WebDriver driver;
 public String [] win2;
	
	@FindBy(xpath = "//a[@href='/funds']")WebElement btnfunds;
	@FindBy(xpath = "//button[@class='button-green']") WebElement btnaddfunds;
	@FindBy(xpath = "//a[@class='button button-blue']")WebElement btnwithdraw;
	@FindBy(xpath = "//a[@href='https://console.zerodha.com/funds/statement?segment=equity']")WebElement linkequitystat;
	@FindBy(xpath = "//a[@href='https://console.zerodha.com/funds/statement?segment=commodity']")WebElement linkcommoditystat;
	@FindBy(xpath = "//input[@id='addfunds_amount']") WebElement txtfundamt;
	@FindBy(xpath = "//select[@id='segment_select']") WebElement txtfundsegment;
	@FindBy(xpath = "//input[@id='addfunds_vpa']") WebElement txtfundupiid;
	
	@FindBy(xpath="//select")WebElement drpcategory;
	@FindBy(xpath="//input[@name='date']") WebElement datepicker;
	@FindBy(xpath = "(//a[@class='mx-icon-last-month'])[1]")WebElement btnlastmonth1;
	@FindBy(xpath="(//a[@class='mx-current-month'])[1]") WebElement currentmonthname1;
	@FindBy(xpath="(//a[@class='mx-current-year'])[1]")WebElement currentyear1;
	@FindBy(xpath = "(//td[@title='2022-03-10'])[1]")WebElement currentdate1;
	@FindBy(xpath = "(//a[@class='mx-icon-last-month'])[2]")WebElement btnlastmonth2;
	@FindBy(xpath="(//a[@class='mx-current-month'])[2]") WebElement currentmonthname2;
	@FindBy(xpath="(//a[@class='mx-current-year'])[2]")WebElement currentyear2;
	@FindBy(xpath = "(//td[@title='2022-03-10'])[2]")WebElement currentdate2;
	@FindBy(xpath = "//button[@class='btn-blue']")WebElement submitbtn;
	@FindBy(xpath = "//button[@class='mx-shortcuts' and text()='last 7 days']")WebElement last7days;
	
	public FundsPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fundbtn()
	{
		if(btnfunds.isDisplayed())
		{
			Assert.assertTrue(true);
			btnfunds.getText();
		}
		else
		{Assert.assertTrue(false);}
	}
	public void fundClick() throws InterruptedException
	{
			btnfunds.click();
			Thread.sleep(2000);
			btnaddfunds.click();
			Thread.sleep(2000);
			String parent = driver.getWindowHandle();
			Set<String> statmentwindow = driver.getWindowHandles();
			System.out.println(statmentwindow);
			win2 =new String[5];
			Iterator<String> itr = statmentwindow.iterator();
			for (int i=0;i<statmentwindow.size();i++) 
			{
				win2[i]=itr.next();
				System.out.println(win2[i]);				
			}
				driver.switchTo().window(win2[1]);
				txtfundamt.sendKeys(pr.getProperty("amount"));
				Thread.sleep(2000);
				Select s=new Select(txtfundsegment);
				s.selectByIndex(1);
				Thread.sleep(2000);
				txtfundupiid.sendKeys(pr.getProperty("uipid"));
				Thread.sleep(2000);
				txtfundamt.clear();
				txtfundupiid.clear();
				driver.close();
				driver.switchTo().window(win2[0]);
	}
	
	public void equityStatement() throws InterruptedException, EncryptedDocumentException, IOException
		{
				btnfunds.click();
				Thread.sleep(2000);
				linkequitystat.click();
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				Set<String> win2 = driver.getWindowHandles();
				String[] win1=new String[5];
				Iterator<String> itr = win2.iterator();
				for(int i=0;i<win2.size();i++)
				{
					win1[i]=itr.next();
				}
				driver.switchTo().window(win1[1]);
				Thread.sleep(2000);
				

	//	**********************************************
				drpcategory.click();
				Select s=new Select(drpcategory);
				s.selectByIndex(2);
				Thread.sleep(2000);
				datepicker.click();
//				last7days.click();
				Thread.sleep(2000);
				String month="Apr";
				String year="2022";
				currentmonthname1.getText();
				currentyear1.getText();
				while(true)
				{
					Thread.sleep(2000);
					if(currentmonthname1.getText().equals(month) && currentyear1.getText().equals(year))
					{
						break;
					}
					else
					{
						btnlastmonth1.click();
					}
					currentdate1.click();
				}

//				String month2="Apr";
//				String year2="2022";
//
//				while(true)
//				{
//					Thread.sleep(2000);
//					if(currentmonthname2.getText().equals(month2) && currentyear2.getText().equals(year2))
//					{
//						break;
//					}
//					else
//					{
//						btnlastmonth2.click();
//					}
//					currentdate2.click();
//				}
				Thread.sleep(2000);
				submitbtn.click();
				driver.close();
				driver.switchTo().window(win1[0]);
		}
	public void statement() throws InterruptedException
		{	
		}
	
}
