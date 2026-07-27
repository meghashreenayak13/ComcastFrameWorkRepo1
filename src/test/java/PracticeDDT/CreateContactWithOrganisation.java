package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrganisation {
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
	Row row= sh.getRow(1);
	String orgName=row.getCell(3).toString()+randomInt;
	String lastName=row.getCell(4).toString()+randomInt;
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
driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.name("accountname")).sendKeys(orgName);
driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();
		
//verify header message Expected Result
String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if (headerInfo.contains(orgName))
{
	System.out.println(orgName+" in header is created====pass");
}
else
{
  System.out.println(orgName+"in header is not created====fail");
}  
//verify header org name Expected Result

String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
if (actOrgName.equals(orgName))
{
	System.out.println(orgName+" is created====pass");
}
else
{
  System.out.println(orgName+" is not created====fail");
}  

// Creation of contact
//Creating the contacts
driver.findElement(By.linkText("Contacts")).click();
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
driver.findElement(By.name("lastname")).sendKeys(lastName);
driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();

//adding organization after switching window
String parentId=driver.getWindowHandle();
Set<String> allIds = driver.getWindowHandles();
for(String eachId:allIds)
{
	  if(!eachId.equals(parentId))
	  {
		  driver.switchTo().window(eachId);
		  break;
	  }
}

driver.findElement(By.name("search_text")).sendKeys(orgName);
driver.findElement(By.name("search")).click();
//creating dynamic xpath to get runtime orgname beacuse it is attached to random integer
driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
driver.switchTo().window(parentId);
driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();



//verify header message Expected Result
String contactHeaderInfo=driver.findElement(By.className("dvHeaderText")).getText();
if (contactHeaderInfo.contains(lastName))
{
	System.out.println(lastName+" contact is created====pass");
}
else
{
  System.out.println(lastName+" contact is not created====fail");
}  
//
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

