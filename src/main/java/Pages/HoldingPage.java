package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class HoldingPage extends TestBase{

	@FindBy(xpath = "//a[@href='/holdings']")WebElement holding;
	@FindBy(xpath = "//select")WebElement drpallstock;
	
	public HoldingPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void drpstock() throws InterruptedException
	{
		if(holding.isDisplayed())
		{
			holding.click();
		}
		drpallstock.click();
		Select s=new Select(drpallstock);
		List<WebElement> list = s.getOptions();
		for(int i=0;i<list.size();i++)
		{
			System.out.println( list.get(i).getText());
			if(list.get(i).getText().equals(pr.getProperty("stocks")))
			{
				s.selectByIndex(i);
				break;
			}	
			
			Thread.sleep(5000);
		}
		
		
	}

}
