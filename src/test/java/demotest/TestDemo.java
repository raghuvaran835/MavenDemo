package demotest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestDemo extends DriverLaunch {
	
	@Test
	public void test1() throws InterruptedException {
		
		WebDriver driver=launch("https://seleniumbase.io/demo_page/");
//		List<WebElement> ele=driver.findElements(By.xpath("//input[@type='checkbox']"));
//		for(WebElement i:ele)
//		{
//			i.click();
//		}
//		Select s=new Select(driver.findElement(By.name("selectName")));
//		s.selectByIndex(2);
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		driver.navigate().refresh();
//		driver.getTitle();
//		Thread.sleep(2000);
		String select_value=driver.findElement(By.id("mySelect")).getAttribute("value");
		if(select_value.equals("25%")) {
			System.out.println("Default Value 25%");
			
		}
		
		if("50".equals(driver.findElement(By.id("progressBar")).getAttribute("value")))
		{
			System.out.println("progess bar default value is 50%");
		}
		if(driver.findElement(By.id("checkBox5")).isSelected())
		{
			System.out.println("precheck box is selected");
		}
		if("Text...".equals(driver.findElement(By.id("myTextInput2")).getAttribute("value")))
		{
			System.out.println("The value in the text box is:Text...");
		}
		String btntext=driver.findElement(By.id("myButton")).getText();
		if(btntext.equals("Click Me (Green)"))
		{
			System.out.println("The Button has this same text click me (Green)");
		}
		driver.close();
	}
	@Test
	public void test2() throws InterruptedException
	{
		WebDriver driver=launch("https://seleniumbase.io/demo_page/");
		driver.findElement(By.id("myTextInput2")).clear();
		driver.findElement(By.id("myTextarea")).sendKeys("Raghuvaran");
		Select s=new Select(driver.findElement(By.name("selectName")));
		s.selectByValue("50%");
		driver.findElement(By.id("radioButton2")).click();
		driver.findElement(By.id("checkBox3")).click();
		if(!(driver.findElement(By.id("checkBox5")).isSelected()))
		{
			driver.findElement(By.id("checkBox5")).click();
		}
		
		String str=driver.findElement(By.id("myTextInput2")).getAttribute("value");
		if(str=="")
		{
			System.out.println("Validation Passed");
		}
		
		Thread.sleep(10000);
		driver.close();
	}
	@Test
public void test3() {
		WebDriver driver=launch("https://seleniumbase.io/demo_page/");
		driver.findElement(By.id("myLink1")).click();
		try {
			driver.findElement(By.name("selectName")).isDisplayed();
			System.out.println("Wrong,It should not be Displayed");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Test Case passed Because The element is not available in the Selenium Base");
		}
		//System.out.println(driver.findElement(By.xpath("//tr[4]/td[3]")).getText());
	driver.close();
	// //*[@id="tbodyId"]/tr[4]/td[3]
	//*[@id="tbodyId"]/tr[4]/td[3]
}
}
