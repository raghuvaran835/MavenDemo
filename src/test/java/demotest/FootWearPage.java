package demotest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.util.Assert;

public class FootWearPage {
	public WebDriver driver;

	public FootWearPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@id='Men']//following::label[@for='Men']")
	WebElement menCBox;
	@FindBy(xpath = "//input[@id='Men - Formal Shoes']//following::label")
	WebElement formalShoesCbox;
	@FindBy(xpath = "//span[text()='brands']")
	WebElement brands;
	@FindBy(xpath = "//input[@id='Bata']//following::label[1]")
	WebElement bataBrand;
	@FindBy(xpath = "//span[text()='colors']")
	WebElement colorTab;
	@FindBy(xpath = "//input[@id='Maroon']//following::label[1]")
	WebElement maroon;
	@FindBy(xpath = "//div[@class='contentHolder'] //div[@class='brand']")
	List<WebElement> products;
	@FindBy(xpath = "//div[@class='filter-dropdown']/select")
	WebElement select;
	
	@FindBy(xpath = "//div[@class='contentHolder']//following-sibling::div[2]/span")
	List<WebElement> prices;
	public WebElement gender()
	{
		return menCBox;
	}
	public WebElement formalCategory()
	{
		return formalShoesCbox;
	}
	public WebElement brandTab()
	{
		return brands;
	}
	public WebElement bataBrand()
	{
		return bataBrand;
	}
	public WebElement colorTab()
	{
		return colorTab;
	}
	public WebElement maroonColor()
	{
		return maroon;
	}
	public void ascendingFilter()
	{
		Select s=new Select(driver.findElement(By.xpath("//div[@class='filter-dropdown']/select")));
		s.selectByValue("prce-asc");
	}
	public void scrollWindow()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	public int noOfProducts()
	{
		int n=products.size();
		System.out.println("No of Shoes in Bata Brand with Color Blue:"+n);
		return n;
		
	}
	public Boolean isSorted()
	{
		ArrayList<Integer> prices1=new ArrayList<>();
		ArrayList<Integer> sortedPrice=new ArrayList<>();
		boolean flag=false;
		String s;
		for(int i=0;i<prices.size();i++)
		{
			 s=prices.get(i).getText().replaceAll("[^0-9]", "");

			 
			 Integer v=Integer.parseInt(s);
			 prices1.add(v);
			
		}
		sortedPrice=prices1;
		Collections.sort(sortedPrice);
		System.out.println(prices1);
		if(prices1.equals(sortedPrice))
		{
			flag=true;
		}
		return flag;
	}
	
	
	
	
	

}
