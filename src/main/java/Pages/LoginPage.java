package Pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {

	public  WebDriver driver;
	
	String Url="https://kite.zerodha.com/";
	@FindBy(xpath="//input[@id='userid']") WebElement usernametxt;
	@FindBy(xpath="//input[@id='password']") WebElement passtxt;
	@FindBy(xpath="//button[@type='submit']") WebElement loginbtn;
	@FindBy(xpath="//img[@alt='Kite']")WebElement logokite;
	@FindBy(xpath="//img[@alt='Zerodha']") WebElement logofooter;
	@FindBy(xpath="//div[@class='form-header text-center']") WebElement userlbl;
	@FindBy(xpath="//input[@id='pin']")WebElement pintxt;
	@FindBy(xpath="//button[@type='submit']") WebElement continuebtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void setLogin() throws InterruptedException
	{
		usernametxt.sendKeys(pr.getProperty("username"));
		Thread.sleep(1000);
		passtxt.sendKeys(pr.getProperty("password"));
		Thread.sleep(1000);
		loginbtn.click();
		Thread.sleep(1000);
		pintxt.sendKeys(pr.getProperty("pin"));
		Thread.sleep(1000);
		continuebtn.click();
		Thread.sleep(1000);

	}
	public boolean displaylogo1()
	{
		return logokite.isDisplayed();
	}
	public boolean displaylogo2()
	{
		return logofooter.isDisplayed();
	}
	public boolean userLble()
	{
		return userlbl.isDisplayed();
	}
	public void pintext()
	{
		pintxt.isDisplayed();
	}
}
