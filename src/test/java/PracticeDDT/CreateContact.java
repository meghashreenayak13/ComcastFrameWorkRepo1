package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\ASUS\\Desktop\\automationpractice\\commandata.properties");
		Properties pObj =new Properties();
		pObj.load(fis);
		
	//or use Scanner
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\ASUS\\Desktop\\automationpractice\\Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet1");
		Row row= sh.getRow(4);
		String lastName=row.getCell(2).toString()+randomInt;
		//System.out.println(orgName);
		wb.close();
		
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
	driver.findElement(By.linkText("Contacts")).click();
	Thread.sleep(1000);
	//click create contact button
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
Thread.sleep(1000);
driver.findElement(By.name("lastname")).sendKeys(lastName);
driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();



//verify lastname
String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
if (actLastName.equals(lastName))
{
	System.out.println(lastName+" contact is created====pass");
}
else
{
  System.out.println(lastName+" contact is not created====fail");
}  
	  

driver.quit();

}


	}


