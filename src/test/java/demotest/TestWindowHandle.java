package demotest;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestWindowHandle extends Base {

	//Test window handle test
	@Test
	public void testWindow() throws InterruptedException, IOException
	{
		WebDriver driver=launch();
		String pw=driver.getWindowHandle();
		Set<String> cw=driver.getWindowHandles();
		for(String w:cw)
		{
			if(!w.equals(pw))
			{	driver.switchTo().window(w);
				driver.close();
				driver.switchTo().window(pw);
			}
			
		}
		Thread.sleep(2000);
		driver.close();
	}
	//switch window function
	public void switchWindow(WebDriver driver,String id)
	{
		driver.switchTo().window(id);
	}
	
	
	//Switch multiple tabs Exercise
	
	@Test
	public void testSwitchTab() throws IOException {
		By cognizant=By.xpath("//img[@alt='Cognizant']");
		
		WebDriver driver=launch();
		String parentWindow=driver.getWindowHandle();
		Set<String> childWindows=driver.getWindowHandles();
		for(String w:childWindows)
		{
			if(!w.equals(parentWindow))
			{
				String cw=w;
				switchWindow(driver,cw);
				if(driver.getTitle().equals("Cognizant"))
				{
					driver.findElement(cognizant).click();
					break;
					
				}
				
			}	
		}
		
		Set<String> nw=driver.getWindowHandles();
		for(String i:nw)
		{
			switchWindow(driver, i);
			if(driver.getTitle().equals("Cognizant Technology Solutions"))
			{
				driver.findElement(By.xpath("//td[text()='Azure Architect']/following::td[2]/a")).click();
				
				
			}
		}
		
		driver.quit();
		
	
		
	}
}
