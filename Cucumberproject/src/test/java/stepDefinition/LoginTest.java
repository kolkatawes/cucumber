package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	public static WebDriver driver;
	PageObjects po;

	@Given("^when i am on home page$")
	public void wheniamonhomepage() {
		System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		po = new PageObjects(driver);
	}

	@When("^i enter uname and pwd$")
	public void ienterunamandpwd() {
		po.SignIn.click();
		po.userName.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.Login.click();
	}

	@Then("^i am able to login$")
	public void iamabletologin() {
		System.out.println("User login successfully");
	}
	
	@When("^Larry searches below products in the search box:$")
	public void larry_searches_below_products_in_the_search_box(DataTable dt) {
		List<String> product = dt.asList(String.class);
		for(String s : product) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.name("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
			driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		}
	}
	
	@Then("product should be added in the cart if available")
	public void product_should_be_added_in_the_cart_if_available() {
		System.out.println("Successfully Added");
	}
	
	@When("^i enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void entersunamepwd(String uname, String pwd) {
	po.SignIn.click();
	po.userName.sendKeys(uname);
	po.password.sendKeys(pwd);
	po.Login.click();
	}
}

