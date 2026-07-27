package com.crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void configBs() {
		System.out.println("coonect db report config");
	}
	
	@BeforeClass
	public void configClass() {
		System.out.println("lauch browser");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("==login==");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("==logout==");}
	
	@AfterClass
	public void configClass1() {
		System.out.println("close browser");
	}
 @AfterSuite
public void configAs() {
System.out.println("close db report backup");
		}
}

