package demotest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class AjioTest extends Base {
	WebDriver driver;
	HomePage hp;
	FootWearPage fp;
	
	@Test 
	public void homePageTest() throws IOException, InterruptedException
	{
		driver=launch();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		hp=new HomePage(driver);
		
		
		try {
		hp.closePopup().click();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Popup already closed");
		}
		hp.searchBox().sendKeys("shoes");
		hp.SearchButton().click();
		
		fp=new FootWearPage(driver);
		fp.gender().click();
		Thread.sleep(2000);
		fp.formalCategory().click();
		Thread.sleep(2000);
		
		fp.scrollWindow();
		Thread.sleep(2000);
		fp.brandTab().click();
		Thread.sleep(2000);
		fp.bataBrand().click();
		Thread.sleep(2000);
		fp.colorTab().click();
		Thread.sleep(2000);
		fp.maroonColor().click();
		Thread.sleep(2000);
		fp.ascendingFilter();
		fp.scrollWindow();
		Thread.sleep(5000);
		int n=fp.noOfProducts();
		 boolean b=fp.isSorted();
		Assert.assertEquals(b,true);
		Assert.assertEquals(n,3);
		
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
	
	
	
	
	
	
	

}
