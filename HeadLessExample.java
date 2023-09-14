package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;

public class HeadLessExample {
  WebDriver driver; 
  
  @Test (groups = "Regression")
  public void testTourismLogin() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		// Two steps -
		// 1. Tell Selenium Which element you want to take action on
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("stc123");		

		// findElement() returns an object of type WebElement
		// 2. Type.

		// Above way of writing is called method chaining
		// 4. Enter password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("12345");

		String name = "Infosys";
		name.toUpperCase().toLowerCase().toLowerCase().toUpperCase().toLowerCase().equals("infy");

		// 5. Click on Submit
		username.submit();
		// 6. Validate/verify
		Thread.sleep(5000); //synchronization
		String expectedPageTitle = "My account1";
		String actualPageTitle = driver.getTitle();
		System.out.println("Actual Title is " + actualPageTitle);
		
		//assertEquals(actualPageTitle,expectedPageTitle);
		assertEquals(actualPageTitle,expectedPageTitle, "Expected Title not matching with actual");
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
		// 1. Open browsers
	  
//	  	ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*"); 
//		options.addArguments("--headless=new");
//		driver = new ChromeDriver(options);
		FirefoxOptions optionFF = new FirefoxOptions();
		optionFF.addArguments("--headless");
		 driver = new FirefoxDriver(optionFF);
		//WebDriver driver = new FirefoxDriver();
		// WebDriver is an interface. WebDriver represents your browser
  }
  
  
  @Test (groups = "Smoke")
  public void googleTest() {
	  driver.get("http://www.google.com");
	  driver.findElement(By.name("q")).sendKeys("Selenium");
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("I am inside BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("I am inside AfterClass");
  }

}
