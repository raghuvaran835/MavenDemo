package runnerPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demotest.HomePage;

public class BabyHomePage {
	WebDriver driver;

	public BabyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-sign-in']")
	WebElement loginbtn;
	@FindBy(xpath="//div[@id='vpb_login_pop_up_box']")
	WebElement loginPopUp;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='login_btn']")
	WebElement loginSubmit;
	
	@FindBy(xpath="//a[@class='btn signupbtn']/i[@class='fa fa-user']")
	WebElement myUser;
	
	@FindBy(xpath = "//p[text()='Wrong username or password.']")
	WebElement errorText;
	
	@FindBy(xpath = "//a[text()='Maternity Services']")
	WebElement maternityService;
	
	@FindBy(xpath = "(//a[text()='Maternity Services']/following::li[2]/a[text()='Baby Shower'])[1]")
	WebElement babyShower;
	
	@FindBy(xpath = "//h2[text()='Awww Baby Shower Package']/preceding-sibling::img")
	WebElement babyShowerPackage;
	
	@FindBy(xpath = "//input[@name='attribute_pa_booking-date']")
	WebElement bookingDate;
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	WebElement addToCart;
	@FindBy(xpath = "(//a[text()='Maternity Services']/following::li[3]/a[text()='Baby Photoshoot'])[1]")
	WebElement babyPhotoShoot;
	
	@FindBy(xpath = "//h2[text()='Awww Baby Photoshoot- Mumbai, Delhi, Bangalore and Pune']/preceding-sibling::img")
	WebElement babyPhotoshootImage;
	
	@FindBy(xpath = "//a[@title='View Props']")
	WebElement viewProps;
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement successAddTocart;
	
	@FindBy(xpath = "//a[text()='View cart'][1]")
	WebElement viewCart;
	
	@FindBy(xpath="//input[@title='Qty']")
	WebElement quantity;
	
	@FindBy(xpath = "//input[@name='update_cart']")
	WebElement updateCart;
	
	@FindBy(xpath = "//a[contains(@class,'checkout')]")
	WebElement proceedToCheckOut;
	
	@FindBy(xpath = "//h3[text()='Billing details']")
	WebElement billingDetail;
	
	@FindBy(xpath = "//div[@id='payment']/div/noscript//following::input[@id='place_order']")
	WebElement placeOrder;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']")
	WebElement billingDetailError;
	
	@FindBy(xpath = "//i[@class='fa fa-power-off']")
	WebElement logout;
	public WebElement loginBtn()
	{
		return loginbtn;
	}
	public WebElement loginPopUp()
	{
		return loginPopUp;
	}
	public WebElement username()
	{
		return username;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement loginSubmit()
	{
		return loginSubmit;
	}
	public WebElement errorText()
	{
		return errorText;
	}
	public WebElement myUser()
	{
		return myUser;
	}
	public WebElement maternityService()
	{
		return maternityService;
	}
	public WebElement babyShower()
	{
		return babyShower;
	}
	public WebElement babyShowerPackage()
	{
		return babyShowerPackage;
	}
	//scroll window
	public void scrollWindow()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public WebElement bookingDate()
	{
		return bookingDate;
	}
	public WebElement addToCart()
	{
		return addToCart;
	}
	public WebElement babyPhotoShoot()
	{
		return babyPhotoShoot;
	}
	public WebElement babyPhotoShootImage()
	{
		return babyPhotoshootImage;
		
	}
	public WebElement viewProps()
	{
		return viewProps;
	}
	public WebElement addToCartSuccess()
	{
		return successAddTocart;
	}
	public WebElement viewCart()
	{
		return viewCart;
	}
	
	public WebElement quantity()
	{
		return quantity;
	}
	public WebElement updateCart()
	{
		return updateCart;
	}
	public WebElement proceedToCheckOut()
	{
		return proceedToCheckOut;
	}
	public WebElement billingDetails()
	{
		return billingDetail;
	}
	
	public WebElement placeOrder()
	{
		return placeOrder;
	}
	public WebElement billingDetailsError()
	{
		return billingDetailError;
	}
	public WebElement logout()
	{
		return logout;
	}
}
