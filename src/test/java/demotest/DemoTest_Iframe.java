package demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(listenersPackage.Listener.class)

public class DemoTest_Iframe extends DriverLaunch {
	public WebDriver driver;
	
	@Test 
	public void iframeTest() throws InterruptedException
	{
		driver=launch("https://seleniumbase.io/demo_page/");
		driver.switchTo().frame("myFrame3");
		driver.findElement(By.id("checkBox6")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
//		String x="3,046 INR".replace(" INR","").replace(",","");
//		int small=Integer.parseInt(x);
//		System.out.println(small);
		
		driver.close();
		
	}

}
