package stepDefinition1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import demotest.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import runnerPackage.BabyHomePage;

public class BabyFeature {
	WebDriver driver;
	BabyHomePage hp;
	String uname;
	String pword;
	Actions act;
	Alert alert;
	String parentWindow;
	
	
	@Given("User open Browser, enter {string} and navigates to landing page")
	public void user_open_browser_enter_and_navigates_to_landing_page(String url) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		hp=new BabyHomePage(driver);
		
	   
	}
	@Given("User is on login pop")
	public void user_is_on_login_pop() {
	    // Write code here that turns the phrase above into concrete actions
		hp.loginBtn().click();
		Assert.assertEquals(hp.loginPopUp().isDisplayed(),true);
		System.out.println("User is on popup page");
	    
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		uname=username;
		pword=password;
		hp.username().sendKeys(username);
		hp.password().sendKeys(password);
		
	    
	}
	@When("click on Login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
	   hp.loginSubmit().click();
	}
	@Then("{string} Error should be displayed on the Popup")
	public void error_should_be_displayed_on_the_popup(String string) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(hp.errorText().isDisplayed(),true);
		
	    
	}
	@Then("{string} and {string} are retained")
	public void and_are_retained(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    String username=hp.username().getAttribute("value");
	    String password=hp.password().getAttribute("value");
	    Assert.assertEquals(username,uname);
	    Assert.assertEquals(password,pword);
	}
	
	
	
	@Then("{string} should be displayed on the POpup")
	public void should_be_displayed_on_the_p_opup(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login succesful is displayed");
	    
	}
	@Then("MyAccount should be displayed after redirecting from login pop up")
	public void my_account_should_be_displayed_after_redirecting_from_login_pop_up() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals( hp.myUser().isDisplayed(),true);
	   
	}
	@When("User mouse Hover on Maternity Service")
	public void user_mouse_hover_on_maternity_service() {
	    // Write code here that turns the phrase above into concrete actions
		act=new Actions(driver);
		act.moveToElement(hp.maternityService()).perform();
		
	    
	}
	@When("Select BabyShower")
	public void select_baby_shower() {
	    // Write code here that turns the phrase above into concrete actions
		act.moveToElement(hp.babyShower()).click().build().perform();
	    
	}
	@When("Select {string} Package")
	public void select_package(String string) {
	    // Write code here that turns the phrase above into concrete actions
		hp.babyShowerPackage().click();
	    
	}
	@Then("Package detail page should displayed")
	public void package_detail_page_should_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(),"https://awww.co.in/product/awww-mini-baby-shower-package/");
	    
	}
	@When("User enters BookingDate as\"{int}\\/{int}\\/{int}\" and click on AddtoCart button")
	public void user_enters_booking_date_as_and_click_on_addto_cart_button(Integer int1, Integer int2, Integer int3) {
	    // Write code here that turns the phrase above into concrete actions
		hp.bookingDate().sendKeys(int1+"/"+int2+"/"+int3);
		hp.addToCart().click();
	    
	}
	@Then("Alert pop up should displayed with text {string}")
	public void alert_pop_up_should_displayed_with_text(String alertText) {
	    // Write code here that turns the phrase above into concrete actions
		alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(),alertText);
	}
	@Then("After accepting that pop up User stays on same page")
	public void after_accepting_that_pop_up_user_stays_on_same_page() {
	    // Write code here that turns the phrase above into concrete actions
	    alert.accept();
	    Assert.assertEquals(driver.getCurrentUrl(),"https://awww.co.in/product/awww-mini-baby-shower-package/");
	    
	}
	@When("Select Baby Photoshoot")
	public void select_baby_photoshoot() {
	    // Write code here that turns the phrase above into concrete actions
		act.moveToElement(hp.babyPhotoShoot()).click().build().perform();
	    
	    
	}
	@When("Update the filter to {int}")
	public void update_the_filter_to(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("filter updated");
	    
	}
	@When("Click on image of the product")
	public void click_on_image_of_the_product() {
	    // Write code here that turns the phrase above into concrete actions
	    hp.babyPhotoShootImage().click();
	}
	@Then("Product detail page should displayed with View prop Button")
	public void product_detail_page_should_displayed_with_view_prop_button() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(hp.viewProps().isDisplayed());
	}
	@When("User clicks on View Prop button")
	public void user_clicks_on_view_prop_button() {
	    // Write code here that turns the phrase above into concrete actions
	    hp.viewProps().click();
	}
	@Then("new window will open with drive link")
	public void new_window_will_open_with_drive_link() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String w:windows)
		{
			if(!w.equals(parentWindow))
			{
				driver.switchTo().window(w);
			}
		}
		Thread.sleep(6000);
	   
	}
	@When("User close the second page and switch to parent page")
	public void user_close_the_second_page_and_switch_to_parent_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	    driver.switchTo().window(parentWindow);
	}
	@When("click on Add to cart")
	public void click_on_add_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		hp.addToCart().click();
	}
	@Then("Addtocart successful message will be displayed")
	public void addtocart_successful_message_will_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(hp.addToCartSuccess().isDisplayed());
	}
	@When("user clicks on view cart button")
	public void user_clicks_on_view_cart_button() {
	    // Write code here that turns the phrase above into concrete actions
		
	    hp.viewCart().click();
	}
	@Then("User navigates to cart and product is added with quantity {int}")
	public void user_navigates_to_cart_and_product_is_added_with_quantity(Integer q) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(hp.quantity().getAttribute("valueAsNumber"),Integer.toString(q));
	    
	}
	@When("user Increases the cart quantity to {string}")
	public void user_increases_the_cart_quantity_to(String qty) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		hp.quantity().clear();
		hp.quantity().sendKeys(qty);
		hp.updateCart().click();
		Thread.sleep(5000);
	    
	}
	@When("User click on Checkout")
	public void user_click_on_checkout() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wt=new WebDriverWait(driver,20);
		wt.until(ExpectedConditions.elementToBeClickable(hp.proceedToCheckOut()));
		driver.findElement(By.xpath("//a[contains(@class,'checkout')]")).click();
	   
	}
	@Then("Billing page should be displayed")
	public void billing_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(hp.billingDetails().isDisplayed());
	    
	}
	@When("User clicks on Proceed")
	public void user_clicks_on_proceed() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(hp.placeOrder()));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='payment']/div/noscript//following::input[@id='place_order']")).click();
	}
	@Then("User can see error message on the top of the page")
	public void user_can_see_error_message_on_the_top_of_the_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		hp.billingDetailsError().isDisplayed();
	    
	}
	@When("User clicks on Logout")
	public void user_clicks_on_logout() {
	    // Write code here that turns the phrase above into concrete actions
	  hp.logout().click();
	}
	@Then("User should be logged out and My Account button should not be displayed.")
	public void user_should_be_logged_out_and_my_account_button_should_not_be_displayed() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Assert.assertFalse(hp.myUser().isDisplayed());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not Found");
		}
	
	   
	
		
	}
	


	

}
