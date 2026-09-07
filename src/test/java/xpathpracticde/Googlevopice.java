package xpathpracticde;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlevopice {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("chrome:newtab");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	//WebElement element=driver.findElement(By.xpath("//*[local-name()='svg' and @class='ByCvB']"));
//element.click();
	
	}

}
