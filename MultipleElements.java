package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		// WebElement myElement = driver.findElement(By.xpath("//a[@href]"));
		List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println(allLinks.get(i).getText() + " - " + allLinks.get(i).getAttribute("href"));
		}
		
		for (WebElement element: allLinks) {
			System.out.println(element.getText() + " - " + element.getAttribute("href"));
		}
		

		//assignment is do the above for loop in for each loop
		
		
		
		/*
		 * driver.findElements(By.cssSelector("a[href]"));
		 * driver.findElements(By.tagName("a"));
		 */

	}

}
