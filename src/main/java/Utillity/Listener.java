package Utillity;



import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listener extends ExtentReport implements ITestListener {



	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}
	
	
	
}



