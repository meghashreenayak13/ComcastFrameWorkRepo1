package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_Dp_Test2 {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName, String lastName, long PhoneNumber)
	{
		System.out.println("FirstName :" +firstName  + "LastName:" +lastName +",phoneNumber :"+PhoneNumber);
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] objArr= new Object[3][2];
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		objArr[0][2]=9886126;
		
		objArr[1][0]="sam";
		objArr[1][1]="sh";
		objArr[1][2]=9980831;
		
		objArr[2][0]="Jhon";
		objArr[2][1]="smith";
		objArr[2][2]=961133;
		return objArr;
	}
	}

