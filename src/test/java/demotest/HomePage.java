package demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By close=By.className("ic-close-quickview");
	By searchBar=By.xpath("//input[@placeholder='Search AJIO']");
	By SearchButton=By.cssSelector("span.ic-search");
	
	public WebElement closePopup()
	{
		return driver.findElement(close);
	}
	public WebElement searchBox()
	{
		return driver.findElement(searchBar);
		
	}
	public WebElement SearchButton()
	{
		return driver.findElement(SearchButton);
		
	}
	
	

}
