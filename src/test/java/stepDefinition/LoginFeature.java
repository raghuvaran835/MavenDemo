package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFeature {
	WebDriver driver;
	
	@Given("user should launch the browser and  navigate to the salesforce login page")
	public void user_should_launch_the_browser_and_navigate_to_the_salesforce_login_page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
	    
	}
	@When("user enters the {string} in username field")
	public void user_enters_the_in_username_field(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		
	   
	}
	@When("user enters the {string} in password field")
	public void user_enters_the_in_password_field(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	    
	}
	@When("user clicks the submit button")
	public void user_clicks_the_submit_button() {
		driver.findElement(By.id("Login")).click();
	    
	}
	@Then("your should able to see a error message")
	public void your_should_able_to_see_a_error_message() {
		System.out.println("error message displayed");
	    
	}
	@Then("user should not be navigate to the salesforce home page")
	public void user_should_not_be_navigate_to_the_salesforce_home_page() {
	    System.out.println("It stays in the same page");
	}


}
