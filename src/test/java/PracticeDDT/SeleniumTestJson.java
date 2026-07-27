package PracticeDDT;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileReader;

public class SeleniumTestJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// step1:parse JSON physical fil;e into Java Object using Json parse class
		   JSONParser parser=new JSONParser();
		  Object obj= parser.parse(new FileReader("C:\\Users\\ASUS\\Desktop\\automationpractice\\appCommonData.json"));//parse convert one object to other obj here we are converting java obj to json obj
			
		  //step2 :convert java object into json object using downcasting
		  JSONObject map=(JSONObject)obj;
		  
		  //step 3: get the value from json using key
		 
		String URL=(String)map.get("url");
		String BROWSER=(String)	map.get("browser");
		String USERNAME=(String)	map.get("username");
		String PASSWORD=(String)	map.get("password");
		 	
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//driver.findElement(By.linkText("Organizations")).click();
		driver.quit();
		}

	}


