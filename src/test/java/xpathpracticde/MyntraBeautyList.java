package xpathpracticde;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraBeautyList {

	public static void main(String[] args) {
	
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement beauty=driver.findElement(By.xpath("//a[@data-group='beauty']"));
		Actions action=new Actions(driver);
		action.moveToElement(beauty).perform();
		List<WebElement>elements=driver.findElements(By.xpath("//div[@data-group='beauty']//a"));
		for(WebElement element:elements) {
		String text=	element.getText();
		if(text.contains("Body")) {
		System.out.println(text);
		if(text.contains("Body Mist")) {
			element.click();
			break;
		}
		}

	}

}
}
