package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleDDT1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("C:\\Users\\ASUS\\Desktop\\automationpractice\\commandata.properties");
		Properties pObj =new Properties();
		pObj.load(fis);
		
	//or use Scanner
		
	String BROWSER=	pObj.getProperty("browser");
	WebDriver driver=null;
	if(BROWSER.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	if(BROWSER.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	
	String URL=pObj.getProperty("url");
     System.out.println(URL);
	String USERNAME=pObj.getProperty("username");
	System.out.println(USERNAME);
	
	String PASSWORD=pObj.getProperty("password");
	System.out.println(PASSWORD);
	 
	
	driver.get(URL);
	Thread.sleep(2000);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME.trim());
	Thread.sleep(2000);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	Thread.sleep(2000);
	
	
	driver.findElement(By.id("submitButton")).click();
//	//driver.findElement(By.linkText("Organizations")).click();
//	
	
		
		
		

	}

}
