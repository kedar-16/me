package Pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class SharesPage extends TestBase
{
	@FindBy(xpath = "//span[@class='nice-name']")WebElement nameshares;
	@FindBy(xpath = "//button[@class='button-blue buy']") WebElement btnbuy;
	
	@FindBy(xpath = "//form[@class='order-window layer-2 place buy']") WebElement frmaebushares;
	@FindBy(xpath = "(//label[@class='su-radio-label'])[7]") WebElement rdintraday;
	
	public SharesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void share() throws InterruptedException
	{
		Actions act=new Actions(driver);
	 	act.moveToElement(nameshares).click(btnbuy).build().perform();
	 	driver.switchTo().frame(frmaebushares);
	 	Thread.sleep(2000);
	 	rdintraday.click();
	 	
	}
	
	
	
}


