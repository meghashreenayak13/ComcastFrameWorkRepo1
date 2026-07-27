package PracticeDDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class flipkarttest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		// Disable notifications
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		
        driver.get("https://www.flipkart.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("lamps",Keys.ENTER);
   List<WebElement> product=     driver.findElements(By.xpath("//div[@class='hZ3P6w']/following-sibling::div[@class='HQe8jr']/child::span[translate(text(),'%,off','')<50]/parent::div/parent::div/parent::a/parent::div/descendant::a[@class='pIpigb']"));
	for(WebElement p:product) {
   System.out.println(p.getText());
	
	}

}
}