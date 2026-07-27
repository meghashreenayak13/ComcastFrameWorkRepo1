package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws IOException, InterruptedException {
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
Thread.sleep(1000); driver.findElement(By.name("lastname")).sendKeys(lastName);

//getting currentdate and end date
Date dateObj=new Date();
	System.out.println(dateObj);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String currentDate = sdf.format(dateObj);
	System.out.println(currentDate);
	Calendar cal = sdf.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, 30);
	String endDate = sdf.format(cal.getTime());
	System.out.println(endDate);
driver.findElement(By.name("support_start_date")).clear();
driver.findElement(By.name("support_start_date")).sendKeys(currentDate);
driver.findElement(By.name("support_end_date")).clear();
driver.findElement(By.name("support_end_date")).sendKeys(endDate);


driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();



//verifying
String actCurrentDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
if (actCurrentDate.equals(currentDate))
{
	System.out.println(currentDate+"  is added====pass");
}
else
{
  System.out.println(currentDate+"  is not added====fail");
}  

String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
if (actEndDate.equals(endDate))
{
	System.out.println(endDate+"  is added====pass");
}
else
{
  System.out.println(endDate+"  is not added====fail");
}  
	  

driver.quit();


	}

}
