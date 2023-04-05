package listenersPackage;

import java.lang.reflect.Field;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.util.property.ReporterNG;

import demotest.Base;

public class Listener extends Base implements ITestListener {
	ExtentReports extent=ReporterNG.configReport();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The test Execustion Started");
		test=extent.createTest(result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success.................");
		test.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String path;
		WebDriver driver=null;
		try {
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver")
						.get(result.getInstance());
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			path=takeScreenshot(driver,result.getMethod().getMethodName());
			test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("Test Failed.....................");
		test.log(Status.FAIL,"Test Failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP,"Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Started!");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Finished");
		extent.flush();
		
		
	}

}
