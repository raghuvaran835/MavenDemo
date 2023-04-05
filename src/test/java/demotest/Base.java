package demotest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.property.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver launch() throws IOException {
		ReadPropertyFile rp = new ReadPropertyFile();
		String url = rp.getDataFromProperty("url");

		if (rp.getDataFromProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.get(url);
			return driver;

		} else if (rp.getDataFromProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.get(url);
			return driver;
		} else {
			System.out.println("Mention Chrome or Firefox");
			return null;
		}

	}

	// Verify Element Not Present
	public Boolean verifyElementNotPresent(WebDriver driver, By dropdown) {

		try {
			driver.findElement(dropdown);
			return false;

		} catch (NoSuchElementException e) {
			// TODO: handle exception
//			System.out.println(driver.getCurrentUrl());
//			System.out.println("No such Element");
			return true;
		}
	}

	// Function for Taking Screenshot

	public String takeScreenshot(WebDriver driver, String methodName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshots\\ss_" + methodName + ".png";
		FileUtils.copyFile(ss, new File(path));
		return path;

	}

	public void switchToWindow(WebDriver driver, String title) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		boolean flag=false;
		while(it.hasNext())
		{
			String handle=it.next();
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(title))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Driver Switched to"+title+" window");
		}
		else {
			System.out.println("No such window");
		}
	}
}
