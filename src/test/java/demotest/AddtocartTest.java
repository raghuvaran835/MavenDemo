package demotest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddtocartTest extends DriverLaunch{
	
	@Test
	public void addToCart() throws InterruptedException
	{
		WebDriver driver=launch("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products=driver.findElements(By.cssSelector(".product-name"));
		List<WebElement> addbtn=driver.findElements(By.cssSelector("div.product-action"));
		String[] items= {"Beetroot","Tomato","Beans","Brinjal","Carrot","Potato"};
		for(int k=0;k<items.length;k++)
		{
			String item=items[k];
		for(int i=0;i<products.size();i++)
		{
			String product=products.get(i).getText().split("-")[0].trim();
			if(product.equalsIgnoreCase(item))
			{
				addbtn.get(i).click();
				break;
			}
			
		}
		}
		driver.findElement(By.xpath("//a[@class=\"cart-icon\"]/img")).click();
		
		Thread.sleep(4000);
		driver.close();
		
		
	}
	

}
