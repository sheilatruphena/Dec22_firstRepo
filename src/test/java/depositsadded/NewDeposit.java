package depositsadded;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class NewDeposit {
		
	WebDriver driver;
		By USER_NAME_FIELD = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By SIGN_IN_BUTTON_FIELD =By.xpath("//button[@name='login']");
	
		//options
		By TRANSACTIONS_FIELD = By.xpath("//span[text()='Transactions']");
		By NEW_DEPOSIT_BUTTON = By.xpath("//a[text()='New Deposit']");
		By ACCOUNT_DROPDOWN_FIELD = By.xpath("//span[@id='select2-account-container']");
		By DESCRIPTION_MENU_FIELD = By.xpath("//input[@id='description']");
		By AMOUNT_FIELD = By.xpath("//input[@id='amount']");
		By SUBMIT_FIELD = By.xpath("//button[@id='submit']");
		
		
		@Before
		public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		
		@Test
		public void LoginTest() {
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();
		
		}
	
		@After
		public void LoginTestpractice() {
			
			driver.findElement(TRANSACTIONS_FIELD).click();
			Assert.assertTrue("transactions page not found", driver.findElement(TRANSACTIONS_FIELD).isDisplayed());
			System.out.println("Transaction");
			
			driver.findElement(NEW_DEPOSIT_BUTTON).click();
			Assert.assertTrue("new deposit page not found", driver.findElement(NEW_DEPOSIT_BUTTON).isDisplayed());
			System.out.println("New deposit");
			
			Select sel = new Select(driver.findElement(ACCOUNT_DROPDOWN_FIELD));
			sel.selectByVisibleText("Sheila");
			Assert.assertTrue("Account dropdown page not found", driver.findElement(ACCOUNT_DROPDOWN_FIELD).isDisplayed());
			System.out.println("Account Dropdown");
			
			driver.findElement(DESCRIPTION_MENU_FIELD).sendKeys("Add Deposit");
			Assert.assertTrue("description page not found", driver.findElement(DESCRIPTION_MENU_FIELD).isDisplayed());
			System.out.println("Description");
			
			driver.findElement(AMOUNT_FIELD).sendKeys("1800");
			Assert.assertTrue("Amount page not found", driver.findElement(AMOUNT_FIELD).isDisplayed());
			System.out.println("Amount");
		
			driver.findElement(SUBMIT_FIELD).click();
			Assert.assertTrue("submit page not found", driver.findElement(SUBMIT_FIELD).isDisplayed());
			System.out.println("Submit");
			
		}
	
		
}