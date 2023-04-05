package demotest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenersPackage.Listener.class)
public class SpiceJetTest extends DriverLaunch {

	public WebDriver driver;
	
	By fromDropdown=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	By fromValue=By.xpath("//a[@value='AMD']");
	By toDropdown=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	By toValue=By.xpath("(//a[@value='BLR'])[2]");
	By departDate=By.id("ctl00$mainContent$view_date1");
	By returnDate=By.id("ctl00$mainContent$view_date2");
	By PassengerCount=By.id("ctl00_mainContent_ddl_Adult");
	By search=By.xpath("//*[@value='Search']");
	By next=By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span");
	
	@BeforeMethod
	public void openUrl()
	{
		driver= launch("https://rahulshettyacademy.com/dropdownsPractise/");
		
	}
	@Test
	public void spiceJetData() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals(driver.getCurrentUrl(),"https://rahulshettyacademy.com/dropdownsPractise/");
		//WebDriverWait wait=new WebDriverWait(driver,20);
		
//		Auto suggestive dropdown
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='India']")).click();
		
//		Dynamic dropdown
		
		driver.findElement(fromDropdown).click();
		driver.findElement(fromValue).click();
//		from1.sendKeys("amd");
		Thread.sleep(1000);
		driver.findElement(toValue).click();		
//		driver.findElement(By.xpath("(//div[@class='dropdownDiv']//li/a[contains(text(),'Bhopal')])[2]")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
		
		
//		Calendor automation(Date picker)
		String month=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText();
		String year=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[2]")).getText();
//		
		while(true)
		{
			if(month.equals("February"))
			{
				driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a[text()='28'])[1]")).click();
				break;
			}
			else {
				driver.findElement(next).click();
				month=driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']/div/div/div/span)[1]")).getText();
				
			}
		}
		driver.findElement(By.id("divpaxinfo")).click();
//		Select adult=new Select(driver.findElement(PassengerCount));
//		adult.selectByIndex(3);
		By adult_decrease=By.xpath("//*[@id='divAdult']/div[2]/span[1]");
		By adult_increase=By.xpath("//*[@id='divAdult']/div[2]/span[3]");
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(adult_increase).click();
		driver.findElement(adult_increase).click();
		driver.findElement(adult_decrease).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();
		
		Select currency=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currency.selectByIndex(3);
//		checkCheapTrain();
		
		Thread.sleep(2000);
		
	}
	
	public void checkCheapTrain() throws InterruptedException
	{
		driver.findElement(search).click();
		Thread.sleep(15);
		List<WebElement> spiceMaxValues=driver.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/tr[contains(@name,'0_0_0')]/td[5]"));
		
		String x=spiceMaxValues.get(0).getText().replace(" INR","").replace(",","");
		int small=Integer.parseInt(x);
		String cheapTrainName=driver.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/tr[contains(@name,'0_0_0')]/td[1]/span/a[contains(@id,'activateJourney_0_0_0')]")).get(0).getText();
		for(int i=0;i<spiceMaxValues.size();i++)
		{
			int val=Integer.parseInt(spiceMaxValues.get(i).getText().replace(" INR","").replace(",",""));
			if(val<small)
			{
				small=val;
				cheapTrainName=driver.findElements(By.xpath("//table[@id='availabilityTable0']/tbody/tr[contains(@name,'0_0_0')]/td[1]/span/a[contains(@id,'activateJourney_0_0_0')]")).get(i).getText();
			}
			//String small=spiceMaxValues.get(i).getText();
		}
		
		System.out.println("Cheapest_Train:"+cheapTrainName+"\n"+"Price :"+small);
	}
	
	@DataProvider(name="cities")
	public Object[][] setupData()
	{
		return new Object[][] {{"AMD","DEL"}};
		
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
