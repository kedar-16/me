package Pages;

import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {
	WebDriver driver;
	
	@FindBy(xpath = "(//a[@href='/orders'])[1]")WebElement btnorder;
	@FindBy(xpath = "//a[@href='/orders/gtt']") WebElement btngtt;
	@FindBy(xpath = "//button[@class='button-blue']")WebElement btnnewgtt;
	@FindBy(xpath = "(//input[@placeholder='Search eg: infy bse, nifty fut weekly, gold mcx'])[2]")WebElement serchstock;
	@FindBy(xpath = "//span[@class='tradingsymbol']") List<WebElement> alllist1;
	@FindBy(xpath = "//button[text()='Create GTT ']")WebElement btncreategtt;
	@FindBy(xpath = "(//input[@type='number'])[3]") WebElement txtqty;
	@FindBy(xpath = "(//input[@type='number'])[4]") WebElement txtprice;
	@FindBy(xpath = "//div[text()='Place']") WebElement btnplace;
	@FindBy(xpath="//span[@class='exchange text-xxsmall dim']")WebElement btnoption;
	@FindBy(xpath =" //a[@href='#']" ) WebElement btndelete;
	@FindBy(xpath = "//button[@class='button-blue']") WebElement btndelete1;
	
	public  OrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CreateGtt() throws InterruptedException
	{
		Assert.assertTrue(btnorder.isDisplayed());
		btnorder.click();
		Thread.sleep(2000);

		Assert.assertTrue(btngtt.isDisplayed());
		btngtt.click();
		Thread.sleep(2000);

		Assert.assertTrue(btnnewgtt.isEnabled());
		btnnewgtt.click();
		Thread.sleep(2000);

		serchstock.sendKeys("INFY");
		Thread.sleep(2000);

		for(int i=0;i<alllist1.size();i++)
		{
			System.out.println(alllist1.get(i).getText());
			if(alllist1.get(i).getText().equals("INFY APR FUT"))
			{
				alllist1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		btncreategtt.click();
		txtqty.clear();
		txtqty.sendKeys("600");
		Thread.sleep(2000);
		txtprice.clear();
		txtprice.sendKeys("100");
		Thread.sleep(2000);
		btnplace.click();
		Actions Act=new Actions(driver);
		Act.click(btnoption).build().perform();
		Thread.sleep(2000);
		 btndelete.click();
		 driver.switchTo().alert();
		 driver.switchTo().alert().accept();
		 btndelete1.click();
	}
}
