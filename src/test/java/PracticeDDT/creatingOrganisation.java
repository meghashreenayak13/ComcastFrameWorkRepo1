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

public class creatingOrganisation {

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
		String orgName=row.getCell(2).toString()+randomInt;
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
driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//enter all the details and create new org
driver.findElement(By.name("accountname")).sendKeys(orgName);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();  //didnt take index
Thread.sleep(2000);
//verify header msg expected result
String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
System.out.println(headerinfo);
if(headerinfo.contains(orgName)) {
	System.out.println(orgName +"is created==PASS");
}
else {
	System.out.println(orgName + "is not created==FAIL");
}
String actorgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
System.out.println(actorgName);
if(actorgName.equals(orgName)) {
	System.out.println(orgName +"iscreated===pass");
	
}
else {
	System.out.println(orgName + "isnot created===fail");
}

	
		
	driver.quit();	
		

	}

}
