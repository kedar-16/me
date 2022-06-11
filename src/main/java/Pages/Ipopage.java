package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ipopage 
{
	
	@FindBy(xpath = "(//a[@href='/orders'])[1]") WebElement btnorder;
	@FindBy(xpath = "//span[text()='IPO']")WebElement btnIpo;
	@FindBy(xpath = "//a[text()='View IPOs on Console']")WebElement btnconsole;
	@FindBy(xpath = "(//span[@class='icon icon-chevron-left'])[1]") WebElement btnStatus;
	
	
	public Ipopage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
		
	}
	public Boolean ipoclick()
	{
		return btnorder.isDisplayed();
	}
}


