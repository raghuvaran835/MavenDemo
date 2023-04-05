package demotest;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(listenersPackage.Listener.class)
public class TestActionFunctions extends Base{
	//ActionsFuctions Test case
	@Test 
	public void testActions()
	{
		By dropdown2=By.id("dropOption2");
		By hoverOption=By.id("myDropdown");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://seleniumbase.io/demo_page/");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(hoverOption)).perform();
		if(driver.findElement(dropdown2).isDisplayed())
		{
			driver.findElement(dropdown2).click();
		}
		if(driver.findElement(By.xpath("//h3")).getText().equals("Link Two Selected"))
		{
			System.out.println("Test case pass");
			
		}
		WebElement sliderele=driver.findElement(By.name("sliderName"));
		act.clickAndHold(sliderele)
		.dragAndDropBy(sliderele,60, 0).build().perform();
		act.sendKeys(driver.findElement(By.id("myTextInput")),"hello raghuvaran")
		.sendKeys(Keys.TAB)
		.sendKeys("Testing")
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		
		.sendKeys(Keys.ENTER)
		.build()
		.perform();
		
		
//		driver.close();
		
		
	}
	//Alert box Testcase
	@Test(priority = 0)
	public void alertTest() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		takeScreenshot(driver,"guru_customer_page");
		driver.findElement(By.name("cusid")).sendKeys("12345");
		driver.findElement(By.name("submit")).click();
		Alert alert=driver.switchTo().alert();
		//takeScreenshot(driver,"AlertDialog");
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
		//takeScreenshot(driver,"Alert2");
		alert.accept();
		Thread.sleep(2000);
		takeScreenshot(driver,"Alert2");
		
		driver.close();
		
	}

	//Exception Handling
	@Test
	public void TestException()
	{
		By dropdown=By.id("mySelect");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://seleniumbase.io/demo_page/");
		driver.findElement(By.id("myLink1")).click();
		
			Boolean present=verifyElementNotPresent(driver,dropdown);
			System.out.println(present);
			System.out.println("Test Case Executed success");
			driver.close();
		}
}
