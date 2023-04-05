package demotest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TableExercise extends DriverLaunch {
	
	@Test
	public void getTableData()
	{
		By td5=By.xpath("//table[@class='dataTable']/tbody/tr/td[5]");
		WebDriver driver=launch("http://demo.guru99.com/test/web-table-element.php");
		List<WebElement> changeValueElements=driver.findElements(td5);
		ArrayList<String> companies=new ArrayList<String>();
		ArrayList<Double> values=new ArrayList<Double>();
		for(int i=0;i<changeValueElements.size();i++)
		{
			Double value=Double.parseDouble(changeValueElements.get(i).getText().replace("+","").trim());
//			System.out.println(value);
			System.out.println(driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a")).get(i).getText() +"-->"+ value);
			if(value>9 && value<10)
			{
				values.add(value);
				String company= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a")).get(i).getText();
				companies.add(company);
			}
			
		}
		System.out.println("Companies List Change Values which are greater than 6 and Less than 9");
		System.out.println("...............................................................");
		for(int x=0;x<companies.size();x++)
		{
			System.out.println(companies.get(x)+" "+":"+values.get(x));
		}
		driver.close();
	}

}
